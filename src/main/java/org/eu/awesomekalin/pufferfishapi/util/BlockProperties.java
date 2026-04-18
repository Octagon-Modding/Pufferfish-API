package org.eu.awesomekalin.pufferfishapi.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.eu.awesomekalin.pufferfishapi.holders.SoundTypeHolder;

import javax.annotation.Nullable;

public class BlockProperties {
    private final float destroyTime;
    private final float explosionResistance;
    private final SoundType sound;
    private final int lightLevel;
    private final float friction;

    public BlockProperties(float destroyTime, float explosionResistance, @Nullable SoundTypeHolder soundType, int lightLevel) {
        this.destroyTime = destroyTime;
        this.explosionResistance = explosionResistance;
        this.sound = soundType != null ? SoundTypeHolder.getSoundType(soundType) : SoundType.STONE;
        this.lightLevel = lightLevel;
        this.friction = 0.6f;
    }

    public BlockProperties(float destroyTime, float explosionResistance, @Nullable SoundTypeHolder soundType, int lightLevel, float friction) {
        this.destroyTime = destroyTime;
        this.explosionResistance = explosionResistance;
        this.sound = soundType != null ? SoundTypeHolder.getSoundType(soundType) : SoundType.STONE;
        this.lightLevel = lightLevel;
        this.friction = friction;
    }

    public BlockBehaviour.Properties getProperties(ResourceLocation registryName) {
        return BlockBehaviour.Properties.of()
                .destroyTime(destroyTime)
                .explosionResistance(explosionResistance)
                .sound(sound)
                .lightLevel(state -> lightLevel)
                .friction(friction);
    }
}