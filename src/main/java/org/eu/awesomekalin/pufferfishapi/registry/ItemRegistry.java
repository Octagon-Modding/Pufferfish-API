package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.MobEffectHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ToolHolder;

import java.util.List;

public class ItemRegistry {
    private final DeferredRegister<Item> register;
    private final String modId;

    public ItemRegistry(String modId) {
        register = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
        this.modId = modId;
    }

    public void register() {
        register.register(PufferfishAPI.context.getModEventBus());
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
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new SwordItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
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

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        Consumable.Builder builder = Consumable.builder();

        effects.forEach((effect) -> {
            builder.onConsume(effect.getEffectFromEnum());
        });

        Item.Properties itemProperties = new Item.Properties().food(new FoodProperties(nutrition, saturation, alwaysEat)).component(
                DataComponents.CONSUMABLE,
                builder.build()
        );
        return new ItemRegistryHolder(register.register(name, () -> new Item(itemProperties)));
    }
}
