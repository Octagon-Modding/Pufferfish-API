package org.eu.awesomekalin.pufferfishapi.registry;

import com.mojang.datafixers.util.Either;
import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryOwner;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.eu.awesomekalin.pufferfishapi.holders.*;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

    private ArmorMaterial getArmorMaterial(ArmorHolder armorHolder) {
        return new ArmorMaterial(
                armorHolder.defense,
                armorHolder.enchantmentValue,
                new RegistryEntry<SoundEvent>() {
                    @Override
                    public SoundEvent value() {
                        return SoundEventsHolder.getSoundEvent(armorHolder.equipSound);
                    }

                    @Override public boolean hasKeyAndValue() {return false;}
                    @Override public boolean matchesId(Identifier id) {return false;}
                    @Override public boolean matchesKey(RegistryKey<SoundEvent> key) {return false;}
                    @Override public boolean matches(Predicate<RegistryKey<SoundEvent>> predicate) {return false;}
                    @Override public boolean isIn(TagKey<SoundEvent> tag) {return false;}
                    @Override public boolean matches(RegistryEntry<SoundEvent> entry) {return false;}
                    @Override public Stream<TagKey<SoundEvent>> streamTags() {return Stream.empty();}
                    @Override public Either<RegistryKey<SoundEvent>, SoundEvent> getKeyOrValue() {return null;}
                    @Override public Optional<RegistryKey<SoundEvent>> getKey() {return Optional.empty();}
                    @Override public Type getType() {return null;}
                    @Override public boolean ownerEquals(RegistryEntryOwner<SoundEvent> owner) {return false;}
                },
                () -> Ingredient.fromTag(TagKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(
                                armorHolder.repairIngredient.namespace,
                                armorHolder.repairIngredient.path)
                )),
                armorHolder.assetId,
                armorHolder.toughness,
                armorHolder.knockbackResistance
        );
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

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new ArmorItem(
                                RegistryEntry.of(getArmorMaterial(armorHolder)),
                                ArmorItem.Type.HELMET,
                                new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerChestplate(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new ArmorItem(
                                RegistryEntry.of(getArmorMaterial(armorHolder)),
                                ArmorItem.Type.CHESTPLATE,
                                new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerLeggings(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new ArmorItem(
                                RegistryEntry.of(getArmorMaterial(armorHolder)),
                                ArmorItem.Type.LEGGINGS,
                                new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(armorHolder.durability))
                        )
                )
        );
    }

    public ItemRegistryHolder registerBoots(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                Registry.register(
                        Registries.ITEM,
                        Identifier.of(modId, name),
                        new ArmorItem(
                                RegistryEntry.of(getArmorMaterial(armorHolder)),
                                ArmorItem.Type.BOOTS,
                                new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(armorHolder.durability))
                        )
                )
        );
    }
}
