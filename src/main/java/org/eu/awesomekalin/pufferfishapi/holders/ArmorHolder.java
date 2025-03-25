package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.eu.awesomekalin.pufferfishapi.util.Identifier;

import java.util.EnumMap;
import java.util.Map;

public class ArmorHolder {
    public final int durability;
    public final Map<ArmorType, Integer> defense;
    public final int enchantmentValue;
    public final SoundEventsHolder equipSound;
    public final float toughness;
    public final float knockbackResistance;
    public final Identifier repairIngredient;
    public final ResourceKey<EquipmentAsset> assetId;

    public ArmorHolder(int durability,
                       int helmetArmorPoints,
                       int chestplateArmorPoints,
                       int leggingsArmorPoints,
                       int bootsArmorPoints,
                       int animalArmorPoints,
                       int enchantmentValue,
                       SoundEventsHolder equipSound,
                       float toughness,
                       float knockbackResistance,
                       Identifier repairIngredient,
                       Identifier assetId) {
        this.durability = durability;
        this.defense = Util.make(new EnumMap<>(ArmorType.class), map -> {
            map.put(ArmorType.HELMET, helmetArmorPoints);
            map.put(ArmorType.CHESTPLATE, chestplateArmorPoints);
            map.put(ArmorType.LEGGINGS, leggingsArmorPoints);
            map.put(ArmorType.BOOTS, bootsArmorPoints);
            map.put(ArmorType.BODY, animalArmorPoints);
        });
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
        this.assetId = ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(assetId.namespace, assetId.path));
    }
}