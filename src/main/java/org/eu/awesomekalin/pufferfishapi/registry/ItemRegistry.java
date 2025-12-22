package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import org.eu.awesomekalin.pufferfishapi.holders.*;
import java.util.List;

public class ItemRegistry {
    private final String modId;

    public ItemRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    private ToolMaterial getToolMaterial(ToolHolder toolHolder) {
        return new ToolMaterial(TagKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath(
                        toolHolder.material.incorrectForBlocksTag.namespace,
                        toolHolder.material.incorrectForBlocksTag.path
                )
        ),
                toolHolder.material.durability,
                toolHolder.material.speed,
                toolHolder.material.attackDamageBonus,
                toolHolder.material.enchantValue,
                TagKey.create(
                        Registries.ITEM,
                        Identifier.fromNamespaceAndPath(
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
                BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEventsHolder.getSoundEvent(armorHolder.equipSound)),
                armorHolder.toughness,
                armorHolder.knockbackResistance,
                TagKey.create(
                        Registries.ITEM,
                        Identifier.fromNamespaceAndPath(
                                armorHolder.repairIngredient.namespace,
                                armorHolder.repairIngredient.path)
                ), armorHolder.assetId);
    }

    private Item.Properties getBasicProperties(String name) {
        return new Item.Properties().setId(
                ResourceKey.create(
                        Registries.ITEM,
                        Identifier.fromNamespaceAndPath(
                                modId, name
                        )
                )
        );
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).sword(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).pickaxe(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).axe(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).shovel(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(this.modId, toolHolder.name), new Item(
                getBasicProperties(toolHolder.name).hoe(
                    getToolMaterial(toolHolder),
                    toolHolder.attackDamage,
                    toolHolder.attackSpeed
                )
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        Consumable.Builder effectsComponent = Consumables.defaultFood();

        effects.forEach((effect) -> {
            effectsComponent.onConsume(effect.getEffectFromEnum());
        });

        Item.Properties itemProperties = getBasicProperties(name).food(new FoodProperties(nutrition, saturation, alwaysEat), effectsComponent.build());
        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(this.modId, name), new Item(itemProperties)));
    }

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        BuiltInRegistries.ITEM,
                        Identifier.fromNamespaceAndPath(modId, name),
                        new Item(
                                getBasicProperties(name).humanoidArmor(
                                    getArmorMaterial(armorHolder),
                                    ArmorType.HELMET
                                ).durability(ArmorType.HELMET.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        BuiltInRegistries.ITEM,
                        Identifier.fromNamespaceAndPath(modId, name),
                        new Item(
                                getBasicProperties(name).humanoidArmor(
                                    getArmorMaterial(armorHolder),
                                    ArmorType.CHESTPLATE
                                ).durability(ArmorType.CHESTPLATE.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        BuiltInRegistries.ITEM,
                        Identifier.fromNamespaceAndPath(modId, name),
                        new Item(
                                getBasicProperties(name).humanoidArmor(
                                    getArmorMaterial(armorHolder),
                                    ArmorType.LEGGINGS
                                ).durability(ArmorType.LEGGINGS.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        BuiltInRegistries.ITEM,
                        Identifier.fromNamespaceAndPath(modId, name),
                        new Item(
                                getBasicProperties(name).humanoidArmor(
                                    getArmorMaterial(armorHolder),
                                    ArmorType.BOOTS
                                ).durability(ArmorType.BOOTS.getDurability(armorHolder.durability))
                        )
                )
        );
    }
}
