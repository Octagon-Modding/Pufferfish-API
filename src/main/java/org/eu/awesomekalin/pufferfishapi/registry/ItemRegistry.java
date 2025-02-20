package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ToolHolder;

public class ItemRegistry {
    private final DeferredRegister.Items register;

    public ItemRegistry(String modId) {
        register = DeferredRegister.createItems(modId);
    }

    public void register() {
        register.register(PufferfishAPI.eventBus);
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        final Tier tier = new Tier() {
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
                        ResourceLocation.fromNamespaceAndPath(
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
                return Ingredient.of(ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                ));
            }
        };

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new SwordItem(tier,
                new Item.Properties().attributes(SwordItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        final Tier tier = new Tier() {
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
                        ResourceLocation.fromNamespaceAndPath(
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
                return Ingredient.of(ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                ));
            }
        };

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new PickaxeItem(tier,
                new Item.Properties().attributes(PickaxeItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        final Tier tier = new Tier() {
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
                        ResourceLocation.fromNamespaceAndPath(
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
                return Ingredient.of(ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                ));
            }
        };

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new AxeItem(tier,
                new Item.Properties().attributes(AxeItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }
}
