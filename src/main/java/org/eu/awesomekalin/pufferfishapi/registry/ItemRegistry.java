package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.MobEffectHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ToolHolder;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

public class ItemRegistry {
    private final String modId;

    public ItemRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    private ToolMaterial getToolMaterial(ToolHolder toolHolder) {
        return new ToolMaterial() {
            @Override
            public int getDurability() {
                return toolHolder.material.durability;
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return toolHolder.material.speed;
            }

            @Override
            public float getAttackDamage() {
                return toolHolder.material.attackDamageBonus;
            }

            @Override
            public TagKey<Block> getInverseTag() {
                return TagKey.of(
                        RegistryKeys.BLOCK,
                        Identifier.of(
                                toolHolder.material.incorrectForBlocksTag.namespace,
                                toolHolder.material.incorrectForBlocksTag.path
                        )
                );
            }

            @Override
            public int getEnchantability() {
                return toolHolder.material.enchantValue;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.fromTag(TagKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                ));
            }
        };
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        final ToolMaterial tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new SwordItem(tier,
                new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(tier, ((int) toolHolder.attackDamage), toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        final ToolMaterial tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new PickaxeItem(tier,
                new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        final ToolMaterial tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new AxeItem(tier,
                new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        final ToolMaterial tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new ShovelItem(tier,
                new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        final ToolMaterial tier = getToolMaterial(toolHolder);

        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new HoeItem(tier,
                new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        FoodComponent.Builder foodBuilder = new FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturation);

        if (alwaysEat) foodBuilder.alwaysEdible();

        effects.forEach((effect) -> {
            foodBuilder.statusEffect(effect.getEffectFromEnum(), effect.probability);
        });

        Item.Settings itemProperties = new Item.Settings().food(foodBuilder.build());
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, name), new Item(itemProperties)));
    }
}
