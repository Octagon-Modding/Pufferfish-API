package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ToolHolder;
import net.minecraft.registry.tag.TagKey;

public class ItemRegistry {
    private final String modId;

    public ItemRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        final ToolMaterial tier = new ToolMaterial() {
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

        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new SwordItem(tier,
                new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(tier, ((int) toolHolder.attackDamage), toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        final ToolMaterial tier = new ToolMaterial() {
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

        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new PickaxeItem(tier,
                new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        final ToolMaterial tier = new ToolMaterial() {
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

        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new AxeItem(tier,
                new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }
}
