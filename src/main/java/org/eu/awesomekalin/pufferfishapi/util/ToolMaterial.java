package org.eu.awesomekalin.pufferfishapi.util;

public class ToolMaterial {
    public final Identifier incorrectForBlocksTag;
    public final int durability;
    public final float speed;
    public final float attackDamageBonus;
    public final int enchantValue;
    public final Identifier repairTag;

    public ToolMaterial(Identifier incorrectForBlocksTag, int durability, float speed, float attackDamageBonus, int enchantValue, Identifier repairTag) {
        this.incorrectForBlocksTag = incorrectForBlocksTag;
        this.durability = durability;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantValue = enchantValue;
        this.repairTag = repairTag;
    }
}
