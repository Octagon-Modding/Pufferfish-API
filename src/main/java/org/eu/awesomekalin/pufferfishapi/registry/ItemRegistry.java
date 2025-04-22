package org.eu.awesomekalin.pufferfishapi.registry;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ItemRegistry {
    private final DeferredRegister<Item> register;
    private final String modId;

    public ItemRegistry(String modId) {
        register = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
        this.modId = modId;
    }

    public void register() {
        register.register(PufferfishAPI.context.getModEventBus());
    }

    private ToolMaterial getToolMaterial(ToolHolder toolHolder) {
        return new ToolMaterial(
                TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.incorrectForBlocksTag.namespace,
                                toolHolder.material.incorrectForBlocksTag.path
                        )
                ),
                toolHolder.material.durability,
                toolHolder.material.speed,
                toolHolder.material.attackDamageBonus,
                toolHolder.material.enchantValue,
                ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                )
        );
    }

    private ArmorMaterial getArmorMaterial(ArmorHolder armorHolder) {
        return new ArmorMaterial(
                armorHolder.durability,
                armorHolder.defense,
                armorHolder.enchantmentValue,
                new Holder<SoundEvent>() {
                    @Override
                    public SoundEvent value() {
                        return SoundEventsHolder.getSoundEvent(armorHolder.equipSound);
                    }

                    @Override public boolean isBound() {return false;}
                    @Override public boolean is(ResourceLocation resourceLocation) {return false;}
                    @Override public boolean is(ResourceKey<SoundEvent> resourceKey) {return false;}
                    @Override public boolean is(Predicate<ResourceKey<SoundEvent>> predicate) {return false;}
                    @Override public boolean is(TagKey<SoundEvent> tagKey) {return false;}
                    @Override public boolean is(Holder<SoundEvent> holder) {return false;}
                    @Override public Stream<TagKey<SoundEvent>> tags() {return Stream.empty();}
                    @Override public Either<ResourceKey<SoundEvent>, SoundEvent> unwrap() {return null;}
                    @Override public Optional<ResourceKey<SoundEvent>> unwrapKey() {return Optional.empty();}
                    @Override public Kind kind() {return null;}
                    @Override public boolean canSerializeIn(HolderOwner<SoundEvent> holderOwner) {return false;}
                },
                armorHolder.toughness,
                armorHolder.knockbackResistance,
                ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                armorHolder.repairIngredient.namespace,
                                armorHolder.repairIngredient.path)
                ), armorHolder.assetId);
    }

    private Item.Properties getBasicProperties(String name) {
        return new Item.Properties().setId(
                ResourceKey.create(
                        Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath(
                                modId, name
                        )
                )
        );
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new SwordItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new PickaxeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new AxeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new ShovelItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackDamage,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new HoeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackDamage,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        Consumable.Builder builder = Consumable.builder();

        effects.forEach((effect) -> {
            builder.onConsume(effect.getEffectFromEnum());
        });

        Item.Properties itemProperties = getBasicProperties(name).food(new FoodProperties(nutrition, saturation, alwaysEat)).component(
                DataComponents.CONSUMABLE,
                builder.build()
        );
        return new ItemRegistryHolder(register.register(name, () -> new Item(itemProperties)));
    }

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.HELMET,
                                getBasicProperties(name)
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.CHESTPLATE,
                                getBasicProperties(name)
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.LEGGINGS,
                                getBasicProperties(name)
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.BOOTS,
                                getBasicProperties(name)
                        )
                )
        );
    }
}
