package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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

    public StatusEffectInstance getEffectFromEnum() {
        switch (effect) {
            case SWIFTNESS -> {
                return new StatusEffectInstance(StatusEffects.SPEED, duration, amplifier);
            }

            case SLOWNESS -> {
                return new StatusEffectInstance(StatusEffects.SLOWNESS, duration, amplifier);
            }

            case HASTE -> {
                return new StatusEffectInstance(StatusEffects.HASTE, duration, amplifier);
            }

            case MINING_FATIGUE -> {
                return new StatusEffectInstance(StatusEffects.MINING_FATIGUE, duration, amplifier);
            }

            case HARMING -> {
                return new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, duration, amplifier);
            }

            case HEALING -> {
                return new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, duration, amplifier);
            }

            case INSTANT_DAMAGE -> {
                return new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, duration, amplifier);
            }

            case JUMP_BOOST -> {
                return new StatusEffectInstance(StatusEffects.JUMP_BOOST, duration, amplifier);
            }

            case NAUSEA -> {
                return new StatusEffectInstance(StatusEffects.NAUSEA, duration, amplifier);
            }

            case REGENERATION -> {
                return new StatusEffectInstance(StatusEffects.REGENERATION, duration, amplifier);
            }

            case RESISTANCE -> {
                return new StatusEffectInstance(StatusEffects.RESISTANCE, duration, amplifier);
            }

            case FIRE_RESISTANCE -> {
                return new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, duration, amplifier);
            }

            case WATER_BREATHING -> {
                return new StatusEffectInstance(StatusEffects.WATER_BREATHING, duration, amplifier);
            }

            case INVISIBILITY -> {
                return new StatusEffectInstance(StatusEffects.INVISIBILITY, duration, amplifier);
            }

            case BLINDNESS -> {
                return new StatusEffectInstance(StatusEffects.BLINDNESS, duration, amplifier);
            }

            case NIGHT_VISION -> {
                return new StatusEffectInstance(StatusEffects.NIGHT_VISION, duration, amplifier);
            }

            case HUNGER -> {
                return new StatusEffectInstance(StatusEffects.HUNGER, duration, amplifier);
            }

            case WEAKNESS -> {
                return new StatusEffectInstance(StatusEffects.WEAKNESS, duration, amplifier);
            }

            case POISON -> {
                return new StatusEffectInstance(StatusEffects.POISON, duration, amplifier);
            }

            case WITHER -> {
                return new StatusEffectInstance(StatusEffects.WITHER, duration, amplifier);
            }

            case ABSORPTION -> {
                return new StatusEffectInstance(StatusEffects.ABSORPTION, duration, amplifier);
            }

            case SATURATION -> {
                return new StatusEffectInstance(StatusEffects.SATURATION, duration, amplifier);
            }

            case GLOWING -> {
                return new StatusEffectInstance(StatusEffects.GLOWING, duration, amplifier);
            }

            case LEVITATION -> {
                return new StatusEffectInstance(StatusEffects.LEVITATION, duration, amplifier);
            }

            case LUCK -> {
                return new StatusEffectInstance(StatusEffects.LUCK, duration, amplifier);
            }

            case UNLUCK -> {
                return new StatusEffectInstance(StatusEffects.UNLUCK, duration, amplifier);
            }

            case SLOW_FALLING -> {
                return new StatusEffectInstance(StatusEffects.SLOW_FALLING, duration, amplifier);
            }

            case CONDUIT -> {
                return new StatusEffectInstance(StatusEffects.CONDUIT_POWER, duration, amplifier);
            }

            case DOLPHINS_GRACE -> {
                return new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, duration, amplifier);
            }

            case BAD_OMEN -> {
                return new StatusEffectInstance(StatusEffects.BAD_OMEN, duration, amplifier);
            }

            case HERO_OF_THE_VILLAGE -> {
                return new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, duration, amplifier);
            }

            case DARKNESS -> {
                return new StatusEffectInstance(StatusEffects.DARKNESS, duration, amplifier);
            }

            case TRIAL_OMEN -> {
                return new StatusEffectInstance(StatusEffects.TRIAL_OMEN, duration, amplifier);
            }

            case RAID_OMEN -> {
                return new StatusEffectInstance(StatusEffects.RAID_OMEN, duration, amplifier);
            }

            case WIND_CHARGED -> {
                return new StatusEffectInstance(StatusEffects.WIND_CHARGED, duration, amplifier);
            }

            case WEAVING -> {
                return new StatusEffectInstance(StatusEffects.WEAVING, duration, amplifier);
            }

            case OOZING -> {
                return new StatusEffectInstance(StatusEffects.OOZING, duration, amplifier);
            }

            case INFESTED -> {
                return new StatusEffectInstance(StatusEffects.INFESTED, duration, amplifier);
            }
        }

        PufferfishAPI.LOGGER.warn("Mod tried to use a non-existent effect. Issues may occur");
        return null;
    }
}