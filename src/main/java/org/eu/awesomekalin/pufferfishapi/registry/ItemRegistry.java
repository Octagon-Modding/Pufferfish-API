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
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.*;

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

    private ArmorMaterial getArmorMaterial(ArmorHolder armorHolder) {
        return new ArmorMaterial(
                armorHolder.durability,
                armorHolder.defense,
                armorHolder.enchantmentValue,
                ForgeRegistries.SOUND_EVENTS.getHolder(SoundEventsHolder.getSoundEvent(armorHolder.equipSound)).get(),
                armorHolder.toughness,
                armorHolder.knockbackResistance,
                ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                armorHolder.repairIngredient.namespace,
                                armorHolder.repairIngredient.path)
                ), armorHolder.assetId);
    }

    private Item.Properties getBasicProperties(String name) {
        return new Item.Properties().setId(
                ResourceKey.create(
                        Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath(
                                modId, name
                        )
                )
        );
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new SwordItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new PickaxeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new AxeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new ShovelItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackDamage,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new HoeItem(getToolMaterial(toolHolder),
                toolHolder.attackDamage,
                toolHolder.attackDamage,
                getBasicProperties(toolHolder.name)
        )));
    }

    public ItemRegistryHolder registerFoodWithEffects(String name, int nutrition, float saturation, boolean alwaysEat, List<MobEffectHolder> effects) {
        Consumable.Builder builder = Consumable.builder();

        effects.forEach((effect) -> {
            builder.onConsume(effect.getEffectFromEnum());
        });

        Item.Properties itemProperties = getBasicProperties(name).food(new FoodProperties(nutrition, saturation, alwaysEat)).component(
                DataComponents.CONSUMABLE,
                builder.build()
        );
        return new ItemRegistryHolder(register.register(name, () -> new Item(itemProperties)));
    }

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.HELMET,
                                getBasicProperties(name).durability(ArmorType.HELMET.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.CHESTPLATE,
                                getBasicProperties(name).durability(ArmorType.CHESTPLATE.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.LEGGINGS,
                                getBasicProperties(name).durability(ArmorType.LEGGINGS.getDurability(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorType.BOOTS,
                                getBasicProperties(name).durability(ArmorType.BOOTS.getDurability(armorHolder.durability))
                        )
                )
        );
    }
}
