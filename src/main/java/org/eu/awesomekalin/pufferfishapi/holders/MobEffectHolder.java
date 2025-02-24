package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;

public class MobEffectHolder {
    public final EFFECTS effect;
    public final int duration;
    public final int amplifier;
    public final float probability;

    public MobEffectHolder(EFFECTS effect, int duration, int amplifier, float probability) {
        this.effect = effect;
        this.duration = duration;
        this.amplifier = amplifier;
        this.probability = probability;
    }

    public enum EFFECTS {
        SWIFTNESS,
        SLOWNESS,
        HASTE,
        MINING_FATIGUE,
        HARMING,
        HEALING,
        INSTANT_DAMAGE,
        JUMP_BOOST,
        NAUSEA,
        REGENERATION,
        RESISTANCE,
        FIRE_RESISTANCE,
        WATER_BREATHING,
        INVISIBILITY,
        BLINDNESS,
        NIGHT_VISION,
        HUNGER,
        WEAKNESS,
        POISON,
        WITHER,
        ABSORPTION,
        SATURATION,
        GLOWING,
        LEVITATION,
        LUCK,
        UNLUCK,
        SLOW_FALLING,
        CONDUIT,
        DOLPHINS_GRACE,
        BAD_OMEN,
        HERO_OF_THE_VILLAGE,
        DARKNESS,
        TRIAL_OMEN,
        RAID_OMEN,
        WIND_CHARGED,
        WEAVING,
        OOZING,
        INFESTED;
    }

    public ApplyEffectsConsumeEffect getEffectFromEnum() {
        switch (effect) {
            case SWIFTNESS -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, duration, amplifier), probability);
            }

            case SLOWNESS -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, duration, amplifier), probability);
            }

            case HASTE -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, duration, amplifier), probability);
            }

            case MINING_FATIGUE -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, duration, amplifier), probability);
            }

            case HARMING -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, duration, amplifier), probability);
            }

            case HEALING -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, duration, amplifier), probability);
            }

            case INSTANT_DAMAGE -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, duration, amplifier), probability);
            }

            case JUMP_BOOST -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, duration, amplifier), probability);
            }

            case NAUSEA -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, duration, amplifier), probability);
            }

            case REGENERATION -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, duration, amplifier), probability);
            }

            case RESISTANCE -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, duration, amplifier), probability);
            }

            case FIRE_RESISTANCE -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, duration, amplifier), probability);
            }

            case WATER_BREATHING -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, duration, amplifier), probability);
            }

            case INVISIBILITY -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, duration, amplifier), probability);
            }

            case BLINDNESS -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, duration, amplifier), probability);
            }

            case NIGHT_VISION -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, duration, amplifier), probability);
            }

            case HUNGER -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, duration, amplifier), probability);
            }

            case WEAKNESS -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, duration, amplifier), probability);
            }

            case POISON -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, duration, amplifier), probability);
            }

            case WITHER -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WITHER, duration, amplifier), probability);
            }

            case ABSORPTION -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, duration, amplifier), probability);
            }

            case SATURATION -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SATURATION, duration, amplifier), probability);
            }

            case GLOWING -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.GLOWING, duration, amplifier), probability);
            }

            case LEVITATION -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LEVITATION, duration, amplifier), probability);
            }

            case LUCK -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LUCK, duration, amplifier), probability);
            }

            case UNLUCK -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.UNLUCK, duration, amplifier), probability);
            }

            case SLOW_FALLING -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, duration, amplifier), probability);
            }

            case CONDUIT -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, duration, amplifier), probability);
            }

            case DOLPHINS_GRACE -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, duration, amplifier), probability);
            }

            case BAD_OMEN -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, duration, amplifier), probability);
            }

            case HERO_OF_THE_VILLAGE -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, duration, amplifier), probability);
            }

            case DARKNESS -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.DARKNESS, duration, amplifier), probability);
            }

            case TRIAL_OMEN -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.TRIAL_OMEN, duration, amplifier), probability);
            }

            case RAID_OMEN -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RAID_OMEN, duration, amplifier), probability);
            }

            case WIND_CHARGED -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WIND_CHARGED, duration, amplifier), probability);
            }

            case WEAVING -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WEAVING, duration, amplifier), probability);
            }

            case OOZING -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.OOZING, duration, amplifier), probability);
            }

            case INFESTED -> {
                return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INFESTED, duration, amplifier), probability);
            }
        }

        PufferfishAPI.LOGGER.warn("Mod tried to use a non-existent effect. Issues may occur");
        return null;
    }
}