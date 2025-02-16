package org.eu.awesomekalin.pufferfishapi.holders;

import org.eu.awesomekalin.pufferfishapi.util.Identifier;
import org.eu.awesomekalin.pufferfishapi.util.ToolMaterial;

public class ToolHolder {
    public final ToolMaterial material;
    public final float attackDamage;
    public final float attackSpeed;
    public final Identifier identifier;

    public ToolHolder(ToolMaterial material, float attackDamage, float attackSpeed, Identifier identifier) {
        this.material = material;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.identifier = identifier;
    }
}
