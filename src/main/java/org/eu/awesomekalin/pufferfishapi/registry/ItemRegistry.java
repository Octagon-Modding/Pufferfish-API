package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
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

    public ToolMaterial getToolMaterial(ToolHolder toolHolder) {
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

    public Item.Settings getToolProperties(ToolHolder toolHolder) {
        return new Item.Settings().registryKey(
                RegistryKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(
                                modId, toolHolder.name
                        )
                )
        );
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new SwordItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new PickaxeItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new AxeItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new ShovelItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, toolHolder.name), new HoeItem(
                getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getToolProperties(toolHolder)
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        ConsumableComponent.Builder effectsComponent = ConsumableComponents.food();

        effects.forEach((effect) -> {
            effectsComponent.consumeEffect(effect.getEffectFromEnum());
        });

        Item.Settings itemProperties = new Item.Settings().food(new FoodComponent(nutrition, saturation, alwaysEat), effectsComponent.build());
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, name), new Item(itemProperties)));
    }
}
