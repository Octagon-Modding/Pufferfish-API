package org.eu.awesomekalin.pufferfishapi.registry;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
                BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEventsHolder.getSoundEvent(armorHolder.equipSound)),
                armorHolder.toughness,
                armorHolder.knockbackResistance,
                ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                armorHolder.repairIngredient.namespace,
                                armorHolder.repairIngredient.path)
                ), armorHolder.assetId);
    }

    private Item.Properties getToolProperties(ToolHolder toolHolder) {
        return new Item.Properties().setId(
                ResourceKey.create(
                        Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath(
                                modId, toolHolder.name
                        )
                )
        );
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new SwordItem(getToolMaterial(toolHolder), toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new PickaxeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new AxeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new ShovelItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new HoeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        Consumable.Builder builder = Consumable.builder();

        effects.forEach((effect) -> {
            builder.onConsume(effect.getEffectFromEnum());
        });

        Item.Properties itemProperties = new Item.Properties().food(new FoodProperties(nutrition, saturation, alwaysEat)).component(
                DataComponents.CONSUMABLE,
                builder.build()
        ).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(modId, name)));

        return new ItemRegistryHolder(register.registerSimpleItem(name, itemProperties));
    }

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.registerItem(
                        name,
                        props -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.HELMET,
                                props
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.registerItem(
                        name,
                        props -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.CHESTPLATE,
                                props
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.registerItem(
                        name,
                        props -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.LEGGINGS,
                                props
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.registerItem(
                        name,
                        props -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.BOOTS,
                                props
                        )
                )
        );
    }
}
