package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.eu.awesomekalin.pufferfishapi.holders.*;
import java.util.List;

public class ItemRegistry {
    private final String modId;

    public ItemRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    private Tier getToolMaterial(ToolHolder toolHolder) {
        return new Tier() {
            @Override
            public int getUses() {
                return toolHolder.material.durability;
            }

            @Override
            public float getSpeed() {
                return toolHolder.material.speed;
            }

            @Override
            public float getAttackDamageBonus() {
                return toolHolder.material.attackDamageBonus;
            }

            @Override
            public TagKey<Block> getIncorrectBlocksForDrops() {
                return TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.tryBuild(
                                toolHolder.material.incorrectForBlocksTag.namespace,
                                toolHolder.material.incorrectForBlocksTag.path
                        )
                );
            }

            @Override
            public int getEnchantmentValue() {
                return toolHolder.material.enchantValue;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(TagKey.create(
                        Registries.ITEM,
                        ResourceLocation.tryBuild(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                ));
            }
        };
    }

    private ArmorMaterial getArmorMaterial(ArmorHolder armorHolder) {
        return new ArmorMaterial(
                armorHolder.defense,
                armorHolder.enchantmentValue,
                BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEventsHolder.getSoundEvent(armorHolder.equipSound)),
                () -> Ingredient.of(TagKey.create(
                        Registries.ITEM,
                        ResourceLocation.tryBuild(
                                armorHolder.repairIngredient.namespace,
                                armorHolder.repairIngredient.path)
                )),
                armorHolder.assetId,
                armorHolder.toughness,
                armorHolder.knockbackResistance
        );
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        final Tier tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(this.modId, toolHolder.name), new SwordItem(tier,
                new Item.Properties().attributes(SwordItem.createAttributes(tier, ((int) toolHolder.attackDamage), toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        final Tier tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(this.modId, toolHolder.name), new PickaxeItem(tier,
                new Item.Properties().attributes(PickaxeItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        final Tier tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(this.modId, toolHolder.name), new AxeItem(tier,
                new Item.Properties().attributes(AxeItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        final Tier tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(this.modId, toolHolder.name), new ShovelItem(tier,
                new Item.Properties().attributes(ShovelItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        final Tier tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(this.modId, toolHolder.name), new HoeItem(tier,
                new Item.Properties().attributes(HoeItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        FoodProperties.Builder foodBuilder = new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation);

        if (alwaysEat) foodBuilder.alwaysEdible();

        effects.forEach((effect) -> {
            foodBuilder.effect(effect.getEffectFromEnum(), effect.probability);
        });

        Item.Properties itemProperties = new Item.Properties().food(foodBuilder.build());
        return new ItemRegistryHolder(Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(this.modId, name), new Item(itemProperties)));
    }

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        BuiltInRegistries.ITEM,
                        ResourceLocation.tryBuild(modId, name),
                        new ArmorItem(
                                Holder.direct(getArmorMaterial(armorHolder)),
                                ArmorItem.Type.HELMET,
                                new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        BuiltInRegistries.ITEM,
                        ResourceLocation.tryBuild(modId, name),
                        new ArmorItem(
                                Holder.direct(getArmorMaterial(armorHolder)),
                                ArmorItem.Type.CHESTPLATE,
                                new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        BuiltInRegistries.ITEM,
                        ResourceLocation.tryBuild(modId, name),
                        new ArmorItem(
                                Holder.direct(getArmorMaterial(armorHolder)),
                                ArmorItem.Type.LEGGINGS,
                                new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        BuiltInRegistries.ITEM,
                        ResourceLocation.tryBuild(modId, name),
                        new ArmorItem(
                                Holder.direct(getArmorMaterial(armorHolder)),
                                ArmorItem.Type.BOOTS,
                                new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(armorHolder.durability))
                        )
                )
        );
    }
}
