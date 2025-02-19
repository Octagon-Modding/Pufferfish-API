package org.eu.awesomekalin.pufferfishapi.holders;

import org.eu.awesomekalin.pufferfishapi.util.ToolMaterial;

public class ToolHolder {
    public final ToolMaterial material;
    public final float attackDamage;
    public final float attackSpeed;
    public final String name;

    public ToolHolder(ToolMaterial material, float attackDamage, float attackSpeed, String name) {
        this.material = material;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.name = name;
    }
}
