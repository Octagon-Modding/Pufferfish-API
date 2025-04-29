package org.eu.awesomekalin.pufferfishapi.registry;

import com.mojang.datafixers.util.Either;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryOwner;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.eu.awesomekalin.pufferfishapi.holders.*;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ItemRegistry {
    private final String modId;

    public ItemRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    private ToolMaterial getToolMaterial(ToolHolder toolHolder) {
        return new ToolMaterial(TagKey.of(
                RegistryKeys.BLOCK,
                Identifier.of(
                        toolHolder.material.incorrectForBlocksTag.namespace,
                        toolHolder.material.incorrectForBlocksTag.path
                )
        ),
                toolHolder.material.durability,
                toolHolder.material.speed,
                toolHolder.material.attackDamageBonus,
                toolHolder.material.enchantValue,
                TagKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(
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
                new RegistryEntry<SoundEvent>() {
                    @Override
                    public SoundEvent value() {
                        return SoundEventsHolder.getSoundEvent(armorHolder.equipSound);
                    }

                    @Override public boolean hasKeyAndValue() {return false;}
                    @Override public boolean matchesId(Identifier id) {return false;}
                    @Override public boolean matchesKey(RegistryKey<SoundEvent> key) {return false;}
                    @Override public boolean matches(Predicate<RegistryKey<SoundEvent>> predicate) {return false;}
                    @Override public boolean isIn(TagKey<SoundEvent> tag) {return false;}
                    @Override public boolean matches(RegistryEntry<SoundEvent> entry) {return false;}
                    @Override public Stream<TagKey<SoundEvent>> streamTags() {return Stream.empty();}
                    @Override public Either<RegistryKey<SoundEvent>, SoundEvent> getKeyOrValue() {return null;}
                    @Override public Optional<RegistryKey<SoundEvent>> getKey() {return Optional.empty();}
                    @Override public Type getType() {return null;}
                    @Override public boolean ownerEquals(RegistryEntryOwner<SoundEvent> owner) {return false;}
                },
                armorHolder.toughness,
                armorHolder.knockbackResistance,
                TagKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(
                                armorHolder.repairIngredient.namespace,
                                armorHolder.repairIngredient.path)
                ), armorHolder.assetId);
    }

    private Item.Settings getBasicProperties(String name) {
        return new Item.Settings().registryKey(
                RegistryKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(
                                modId, name
                        )
                )
        );
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).sword(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).pickaxe(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).axe(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).shovel(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).hoe(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        ConsumableComponent.Builder effectsComponent = ConsumableComponents.food();

        effects.forEach((effect) -> {
            effectsComponent.consumeEffect(effect.getEffectFromEnum());
        });

        Item.Settings itemProperties = getBasicProperties(name).food(new FoodComponent(nutrition, saturation, alwaysEat), effectsComponent.build());
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, name), new Item(itemProperties)));
    }

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new Item(
                                getBasicProperties(name).armor(
                                    getArmorMaterial(armorHolder),
                                    EquipmentType.HELMET
                                )
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new Item(
                                getBasicProperties(name).armor(
                                    getArmorMaterial(armorHolder),
                                    EquipmentType.CHESTPLATE
                                )
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new Item(
                                getBasicProperties(name).armor(
                                    getArmorMaterial(armorHolder),
                                    EquipmentType.LEGGINGS
                                )
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new Item(
                                getBasicProperties(name).armor(
                                    getArmorMaterial(armorHolder),
                                    EquipmentType.BOOTS
                                )
                        )
                )
        );
    }
}
