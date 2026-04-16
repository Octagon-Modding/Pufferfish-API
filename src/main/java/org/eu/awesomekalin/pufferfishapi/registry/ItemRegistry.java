package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.*;

import java.util.List;

public class ItemRegistry {
    private final DeferredRegister.Items register;
    private final String modId;

    public ItemRegistry(String modId) {
        register = DeferredRegister.createItems(modId);
        this.modId = modId;
    }

    public void register() {
        register.register(PufferfishAPI.eventBus);
    }

    private ToolMaterial getToolMaterial(ToolHolder toolHolder) {
        return new ToolMaterial(
                TagKey.create(
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
                ItemTags.create(
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
                ItemTags.create(
                        Identifier.fromNamespaceAndPath(
                                armorHolder.repairIngredient.namespace,
                                armorHolder.repairIngredient.path)
                ), armorHolder.assetId);
    }

    private Item.Properties addIdToProperties(String name, Item.Properties properties) {
        return properties.setId(
                ResourceKey.create(
                        Registries.ITEM,
                        Identifier.fromNamespaceAndPath(
                                modId, name
                        )
                )
        );
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new Item(addIdToProperties(
                toolHolder.name, new Item.Properties().sword(
                    getToolMaterial(toolHolder), toolHolder.attackDamage,
                    toolHolder.attackSpeed
            )
        ))));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new Item(addIdToProperties(
                toolHolder.name, new Item.Properties().pickaxe(
                        getToolMaterial(toolHolder), toolHolder.attackDamage,
                        toolHolder.attackSpeed
                )
        ))));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new Item(addIdToProperties(
                toolHolder.name, new Item.Properties().axe(
                        getToolMaterial(toolHolder), toolHolder.attackDamage,
                        toolHolder.attackSpeed
                )
        ))));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new Item(addIdToProperties(
                toolHolder.name, new Item.Properties().shovel(
                        getToolMaterial(toolHolder), toolHolder.attackDamage,
                        toolHolder.attackSpeed
                )
        ))));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new Item(addIdToProperties(
                toolHolder.name, new Item.Properties().hoe(
                        getToolMaterial(toolHolder), toolHolder.attackDamage,
                        toolHolder.attackSpeed
                )
        ))));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        Consumable.Builder builder = Consumable.builder();

        effects.forEach((effect) -> {
            builder.onConsume(effect.getEffectFromEnum());
        });

        Item.Properties itemProperties = addIdToProperties(name, new Item.Properties().food(new FoodProperties(nutrition, saturation, alwaysEat)).component(
                DataComponents.CONSUMABLE,
                builder.build()
        ));
        return new ItemRegistryHolder(register.registerSimpleItem(name, itemProperties));
    }

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new Item(
                                addIdToProperties(name, new Item.Properties().humanoidArmor(
                                    getArmorMaterial(armorHolder),
                                    ArmorType.HELMET
                                ))
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new Item(
                                addIdToProperties(name, new Item.Properties().humanoidArmor(
                                        getArmorMaterial(armorHolder),
                                        ArmorType.CHESTPLATE
                                ))
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new Item(
                                addIdToProperties(name, new Item.Properties().humanoidArmor(
                                        getArmorMaterial(armorHolder),
                                        ArmorType.LEGGINGS
                                ))
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new Item(
                                addIdToProperties(name, new Item.Properties().humanoidArmor(
                                        getArmorMaterial(armorHolder),
                                        ArmorType.BOOTS
                                ))
                        )
                )
        );
    }
}
