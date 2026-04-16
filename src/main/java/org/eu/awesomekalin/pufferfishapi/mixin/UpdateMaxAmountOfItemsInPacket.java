package org.eu.awesomekalin.pufferfishapi.mixin;

import net.minecraft.network.protocol.game.ServerboundContainerClickPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerboundContainerClickPacket.class)
abstract class UpdateMaxAmountOfItemsInPacket {

    @Shadow
    @Mutable
    @Final
    private static final int MAX_SLOT_COUNT = 256;
}