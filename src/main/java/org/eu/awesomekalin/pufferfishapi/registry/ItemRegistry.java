package org.eu.awesomekalin.pufferfishapi.registry;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ItemRegistry {
    private final DeferredRegister<Item> register;

    public ItemRegistry(String modId) {
        register = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
    }

    public void register() {
        register.register(PufferfishAPI.context.getModEventBus());
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
    }

    private Holder<ArmorMaterial> getArmorMaterial(ArmorHolder armorHolder) {
        return new Holder<ArmorMaterial> () {
            @Override
            public ArmorMaterial value() {
                return new ArmorMaterial(
                        armorHolder.defense,
                        armorHolder.enchantmentValue,
                        new Holder<SoundEvent>() {
                            @Override
                            public SoundEvent value() {
                                return SoundEventsHolder.getSoundEvent(armorHolder.equipSound);
                            }

                            @Override public boolean isBound() {return false;}
                            @Override public boolean is(ResourceLocation resourceLocation) {return false;}
                            @Override public boolean is(ResourceKey<SoundEvent> resourceKey) {return false;}
                            @Override public boolean is(Predicate<ResourceKey<SoundEvent>> predicate) {return false;}
                            @Override public boolean is(TagKey<SoundEvent> tagKey) {return false;}
                            @Override public boolean is(Holder<SoundEvent> holder) {return false;}
                            @Override public Stream<TagKey<SoundEvent>> tags() {return Stream.empty();}
                            @Override public Either<ResourceKey<SoundEvent>, SoundEvent> unwrap() {return null;}
                            @Override public Optional<ResourceKey<SoundEvent>> unwrapKey() {return Optional.empty();}
                            @Override public Kind kind() {return null;}
                            @Override public boolean canSerializeIn(HolderOwner<SoundEvent> holderOwner) {return false;}
                        },
                        () -> Ingredient.of(ItemTags.create(
                                ResourceLocation.fromNamespaceAndPath(
                                        armorHolder.repairIngredient.namespace,
                                        armorHolder.repairIngredient.path)
                        )),
                        armorHolder.assetId,
                        armorHolder.toughness,
                        armorHolder.knockbackResistance
                );
            }

            @Override public boolean isBound() {return false;}
            @Override public boolean is(ResourceLocation resourceLocation) {return false;}
            @Override public boolean is(ResourceKey<ArmorMaterial> resourceKey) {return false;}
            @Override public boolean is(Predicate<ResourceKey<ArmorMaterial>> predicate) {return false;}
            @Override public boolean is(TagKey<ArmorMaterial> tagKey) {return false;}
            @Override public boolean is(Holder<ArmorMaterial> holder) {return false;}
            @Override public Stream<TagKey<ArmorMaterial>> tags() {return Stream.empty();}
            @Override public Either<ResourceKey<ArmorMaterial>, ArmorMaterial> unwrap() {return null;}
            @Override public Optional<ResourceKey<ArmorMaterial>> unwrapKey() {return Optional.empty();}
            @Override public Kind kind() {return null;}
            @Override public boolean canSerializeIn(HolderOwner<ArmorMaterial> holderOwner) {return false;}
        };
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        final Tier tier = getTier(toolHolder);

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new SwordItem(tier,
                new Item.Properties().attributes(SwordItem.createAttributes(tier, (int) toolHolder.attackDamage, toolHolder.attackSpeed))
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

    public ItemRegistryHolder registerShovel(ToolHolder toolHolder) {
        final Tier tier = getTier(toolHolder);

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new ShovelItem(tier,
                new Item.Properties().attributes(ShovelItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
        )));
    }

    public ItemRegistryHolder registerHoe(ToolHolder toolHolder) {
        final Tier tier = getTier(toolHolder);

        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new HoeItem(tier,
                new Item.Properties().attributes(HoeItem.createAttributes(tier, toolHolder.attackDamage, toolHolder.attackSpeed))
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
        return new ItemRegistryHolder(register.register(name, () -> new Item(itemProperties)));
    }

    public ItemRegistryHolder registerHelmet(String name, ArmorHolder armorHolder) {
        return new ItemRegistryHolder(
                register.register(
                        name,
                        () -> new ArmorItem(
                                getArmorMaterial(armorHolder),
                                ArmorItem.Type.HELMET,
                                new Item.Properties()
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
                                ArmorItem.Type.CHESTPLATE,
                                new Item.Properties()
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
                                ArmorItem.Type.LEGGINGS,
                                new Item.Properties()
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
                                ArmorItem.Type.BOOTS,
                                new Item.Properties()
                        )
                )
        );
    }
}
