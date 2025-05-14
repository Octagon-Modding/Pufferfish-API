package org.eu.awesomekalin.pufferfishapi.registry;

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
import net.minecraft.util.Identifier;
import org.eu.awesomekalin.pufferfishapi.holders.*;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

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
                Registries.SOUND_EVENT.getEntry(SoundEventsHolder.getSoundEvent(armorHolder.equipSound)),
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
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new SwordItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new PickaxeItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new AxeItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new ShovelItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new HoeItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
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
                        new ArmorItem(
                                getArmorMaterial(armorHolder),
                                EquipmentType.HELMET,
                                getBasicProperties(name).maxDamage(EquipmentType.HELMET.getMaxDamage(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new ArmorItem(
                                getArmorMaterial(armorHolder),
                                EquipmentType.CHESTPLATE,
                                getBasicProperties(name).maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new ArmorItem(
                                getArmorMaterial(armorHolder),
                                EquipmentType.LEGGINGS,
                                getBasicProperties(name).maxDamage(EquipmentType.LEGGINGS.getMaxDamage(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new ArmorItem(
                                getArmorMaterial(armorHolder),
                                EquipmentType.BOOTS,
                                getBasicProperties(name).maxDamage(EquipmentType.BOOTS.getMaxDamage(armorHolder.durability))
                        )
                )
        );
    }
}
