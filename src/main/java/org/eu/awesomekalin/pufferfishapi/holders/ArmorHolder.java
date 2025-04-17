package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.util.Util;
import org.eu.awesomekalin.pufferfishapi.util.Identifier;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ArmorHolder {
    public final int durability;
    public final Map<ArmorItem.Type, Integer> defense;
    public final int enchantmentValue;
    public final SoundEventsHolder equipSound;
    public final float toughness;
    public final float knockbackResistance;
    public final Identifier repairIngredient;
    public final List<ArmorMaterial.Layer> assetId;

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
        this.defense = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, helmetArmorPoints);
            map.put(ArmorItem.Type.CHESTPLATE, chestplateArmorPoints);
            map.put(ArmorItem.Type.LEGGINGS, leggingsArmorPoints);
            map.put(ArmorItem.Type.BOOTS, bootsArmorPoints);
            map.put(ArmorItem.Type.BODY, animalArmorPoints);
        });
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
        this.assetId = List.of(
                new ArmorMaterial.Layer(
                        net.minecraft.util.Identifier.of(assetId.namespace, assetId.path)
                )
        );
    }
}