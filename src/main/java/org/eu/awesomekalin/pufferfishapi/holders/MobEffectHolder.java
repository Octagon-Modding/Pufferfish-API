package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

    public MobEffectInstance getEffectFromEnum() {
        switch (effect) {
            case SWIFTNESS -> {
                return new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration, amplifier);
            }

            case SLOWNESS -> {
                return new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, amplifier);
            }

            case HASTE -> {
                return new MobEffectInstance(MobEffects.DIG_SPEED, duration, amplifier);
            }

            case MINING_FATIGUE -> {
                return new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, amplifier);
            }

            case HARMING -> {
                return new MobEffectInstance(MobEffects.HARM, duration, amplifier);
            }

            case HEALING -> {
                return new MobEffectInstance(MobEffects.HEAL, duration, amplifier);
            }

            case INSTANT_DAMAGE -> {
                return new MobEffectInstance(MobEffects.DAMAGE_BOOST, duration, amplifier);
            }

            case JUMP_BOOST -> {
                return new MobEffectInstance(MobEffects.JUMP, duration, amplifier);
            }

            case NAUSEA -> {
                return new MobEffectInstance(MobEffects.CONFUSION, duration, amplifier);
            }

            case REGENERATION -> {
                return new MobEffectInstance(MobEffects.REGENERATION, duration, amplifier);
            }

            case RESISTANCE -> {
                return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration, amplifier);
            }

            case FIRE_RESISTANCE -> {
                return new MobEffectInstance(MobEffects.FIRE_RESISTANCE, duration, amplifier);
            }

            case WATER_BREATHING -> {
                return new MobEffectInstance(MobEffects.WATER_BREATHING, duration, amplifier);
            }

            case INVISIBILITY -> {
                return new MobEffectInstance(MobEffects.INVISIBILITY, duration, amplifier);
            }

            case BLINDNESS -> {
                return new MobEffectInstance(MobEffects.BLINDNESS, duration, amplifier);
            }

            case NIGHT_VISION -> {
                return new MobEffectInstance(MobEffects.NIGHT_VISION, duration, amplifier);
            }

            case HUNGER -> {
                return new MobEffectInstance(MobEffects.HUNGER, duration, amplifier);
            }

            case WEAKNESS -> {
                return new MobEffectInstance(MobEffects.WEAKNESS, duration, amplifier);
            }

            case POISON -> {
                return new MobEffectInstance(MobEffects.POISON, duration, amplifier);
            }

            case WITHER -> {
                return new MobEffectInstance(MobEffects.WITHER, duration, amplifier);
            }

            case ABSORPTION -> {
                return new MobEffectInstance(MobEffects.ABSORPTION, duration, amplifier);
            }

            case SATURATION -> {
                return new MobEffectInstance(MobEffects.SATURATION, duration, amplifier);
            }

            case GLOWING -> {
                return new MobEffectInstance(MobEffects.GLOWING, duration, amplifier);
            }

            case LEVITATION -> {
                return new MobEffectInstance(MobEffects.LEVITATION, duration, amplifier);
            }

            case LUCK -> {
                return new MobEffectInstance(MobEffects.LUCK, duration, amplifier);
            }

            case UNLUCK -> {
                return new MobEffectInstance(MobEffects.UNLUCK, duration, amplifier);
            }

            case SLOW_FALLING -> {
                return new MobEffectInstance(MobEffects.SLOW_FALLING, duration, amplifier);
            }

            case CONDUIT -> {
                return new MobEffectInstance(MobEffects.CONDUIT_POWER, duration, amplifier);
            }

            case DOLPHINS_GRACE -> {
                return new MobEffectInstance(MobEffects.DOLPHINS_GRACE, duration, amplifier);
            }

            case BAD_OMEN -> {
                return new MobEffectInstance(MobEffects.BAD_OMEN, duration, amplifier);
            }

            case HERO_OF_THE_VILLAGE -> {
                return new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, duration, amplifier);
            }

            case DARKNESS -> {
                return new MobEffectInstance(MobEffects.DARKNESS, duration, amplifier);
            }

            case TRIAL_OMEN -> {
                return new MobEffectInstance(MobEffects.TRIAL_OMEN, duration, amplifier);
            }

            case RAID_OMEN -> {
                return new MobEffectInstance(MobEffects.RAID_OMEN, duration, amplifier);
            }

            case WIND_CHARGED -> {
                return new MobEffectInstance(MobEffects.WIND_CHARGED, duration, amplifier);
            }

            case WEAVING -> {
                return new MobEffectInstance(MobEffects.WEAVING, duration, amplifier);
            }

            case OOZING -> {
                return new MobEffectInstance(MobEffects.OOZING, duration, amplifier);
            }

            case INFESTED -> {
                return new MobEffectInstance(MobEffects.INFESTED, duration, amplifier);
            }
        }

        PufferfishAPI.LOGGER.warn("Mod tried to use a non-existent effect. Issues may occur");
        return null;
    }
}