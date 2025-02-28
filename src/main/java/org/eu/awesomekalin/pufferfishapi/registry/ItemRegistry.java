package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.MobEffectHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ToolHolder;

import java.util.List;

public class ItemRegistry {
    private final DeferredRegister.Items register;

    public ItemRegistry(String modId) {
        register = DeferredRegister.createItems(modId);
    }

    public void register() {
        register.register(PufferfishAPI.eventBus);
    }

    private Tier getTier(ToolHolder toolHolder) {
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
                        new ResourceLocation(
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
                        new ResourceLocation(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                ));
            }
        };
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        final Tier tier = getTier(toolHolder);

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new SwordItem(tier,
                new Item.Properties().attributes(SwordItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        final Tier tier = getTier(toolHolder);

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new PickaxeItem(tier,
                new Item.Properties().attributes(PickaxeItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        final Tier tier = getTier(toolHolder);

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new AxeItem(tier,
                new Item.Properties().attributes(AxeItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        FoodProperties.Builder foodProperties = new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation);

        if (alwaysEat) {
            foodProperties.alwaysEdible();
        }

        effects.forEach((effect) -> {
            foodProperties.effect(effect.getEffectFromEnum(), effect.probability);
        });

        Item.Properties itemProperties = new Item.Properties().food(foodProperties.build());
        return new ItemRegistryHolder(register.registerSimpleItem(name, itemProperties));
    }
}
