package org.eu.awesomekalin.pufferfishapi.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.network.HashedStack;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.game.ServerboundContainerClickPacket;
import net.minecraft.world.inventory.ContainerInput;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerboundContainerClickPacket.class)
abstract class UpdateMaxAmountOfItemsInPacket {

    @Shadow
    @Mutable
    @Final
    private static StreamCodec<@NotNull RegistryFriendlyByteBuf, @NotNull Int2ObjectMap<HashedStack>> SLOTS_STREAM_CODEC;

    @Shadow
    @Mutable
    @Final
    public static StreamCodec<RegistryFriendlyByteBuf, ServerboundContainerClickPacket> STREAM_CODEC;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onClassInit(CallbackInfo ci) {
        // Increase slot limit
        SLOTS_STREAM_CODEC = ByteBufCodecs.map(
                Int2ObjectOpenHashMap::new,
                ByteBufCodecs.SHORT.map(Short::intValue, Integer::shortValue),
                HashedStack.STREAM_CODEC,
                256
        );

        // Rebuild STREAM_CODEC using updated SLOTS_STREAM_CODEC
        STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.CONTAINER_ID,
                ServerboundContainerClickPacket::containerId,
                ByteBufCodecs.VAR_INT,
                ServerboundContainerClickPacket::stateId,
                ByteBufCodecs.SHORT,
                ServerboundContainerClickPacket::slotNum,
                ByteBufCodecs.BYTE,
                ServerboundContainerClickPacket::buttonNum,
                ContainerInput.STREAM_CODEC,
                ServerboundContainerClickPacket::containerInput,
                SLOTS_STREAM_CODEC,
                ServerboundContainerClickPacket::changedSlots,
                HashedStack.STREAM_CODEC,
                ServerboundContainerClickPacket::carriedItem,
                ServerboundContainerClickPacket::new
        );
    }
}