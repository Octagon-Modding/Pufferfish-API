package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import org.eu.awesomekalin.pufferfishapi.util.Identifier;

import java.util.Map;

public class ArmorHolder {
    public final int durability;
    public final Map<EquipmentType, Integer> defense;
    public final int enchantmentValue;
    public final SoundEventsHolder equipSound;
    public final float toughness;
    public final float knockbackResistance;
    public final Identifier repairIngredient;
    public final RegistryKey<EquipmentAsset> assetId;

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
        this.defense = Map.of(
            EquipmentType.HELMET, helmetArmorPoints,
            EquipmentType.CHESTPLATE, chestplateArmorPoints,
            EquipmentType.LEGGINGS, leggingsArmorPoints,
            EquipmentType.BOOTS, bootsArmorPoints,
            EquipmentType.BODY, animalArmorPoints
        );
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
        this.assetId = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, net.minecraft.util.Identifier.of(assetId.namespace, assetId.path));
    }
}