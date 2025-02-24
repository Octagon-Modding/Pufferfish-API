package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
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

    public ApplyStatusEffectsConsumeEffect getEffectFromEnum() {
        switch (effect) {
            case SWIFTNESS -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration, amplifier), probability);
            }

            case SLOWNESS -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, amplifier), probability);
            }

            case HASTE -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DIG_SPEED, duration, amplifier), probability);
            }

            case MINING_FATIGUE -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, amplifier), probability);
            }

            case HARMING -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HARM, duration, amplifier), probability);
            }

            case HEALING -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEAL, duration, amplifier), probability);
            }

            case INSTANT_DAMAGE -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, duration, amplifier), probability);
            }

            case JUMP_BOOST -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.JUMP, duration, amplifier), probability);
            }

            case NAUSEA -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, duration, amplifier), probability);
            }

            case REGENERATION -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, amplifier), probability);
            }

            case RESISTANCE -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration, amplifier), probability);
            }

            case FIRE_RESISTANCE -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, duration, amplifier), probability);
            }

            case WATER_BREATHING -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, duration, amplifier), probability);
            }

            case INVISIBILITY -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INVISIBILITY, duration, amplifier), probability);
            }

            case BLINDNESS -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.BLINDNESS, duration, amplifier), probability);
            }

            case NIGHT_VISION -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, duration, amplifier), probability);
            }

            case HUNGER -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, duration, amplifier), probability);
            }

            case WEAKNESS -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, amplifier), probability);
            }

            case POISON -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, duration, amplifier), probability);
            }

            case WITHER -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WITHER, duration, amplifier), probability);
            }

            case ABSORPTION -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.ABSORPTION, duration, amplifier), probability);
            }

            case SATURATION -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION, duration, amplifier), probability);
            }

            case GLOWING -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, duration, amplifier), probability);
            }

            case LEVITATION -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, duration, amplifier), probability);
            }

            case LUCK -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LUCK, duration, amplifier), probability);
            }

            case UNLUCK -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.UNLUCK, duration, amplifier), probability);
            }

            case SLOW_FALLING -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, duration, amplifier), probability);
            }

            case CONDUIT -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, duration, amplifier), probability);
            }

            case DOLPHINS_GRACE -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, duration, amplifier), probability);
            }

            case BAD_OMEN -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.BAD_OMEN, duration, amplifier), probability);
            }

            case HERO_OF_THE_VILLAGE -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, duration, amplifier), probability);
            }

            case DARKNESS -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DARKNESS, duration, amplifier), probability);
            }

            case TRIAL_OMEN -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.TRIAL_OMEN, duration, amplifier), probability);
            }

            case RAID_OMEN -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RAID_OMEN, duration, amplifier), probability);
            }

            case WIND_CHARGED -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WIND_CHARGED, duration, amplifier), probability);
            }

            case WEAVING -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WEAVING, duration, amplifier), probability);
            }

            case OOZING -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.OOZING, duration, amplifier), probability);
            }

            case INFESTED -> {
                return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INFESTED, duration, amplifier), probability);
            }
        }

        PufferfishAPI.LOGGER.warn("Mod tried to use a non-existent effect. Issues may occur");
        return null;
    }
}