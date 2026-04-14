package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.level.block.SoundType;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;

public enum SoundTypeHolder {
    EMPTY,
    WOOD,
    GRAVEL,
    GRASS,
    LILY_PAD,
    STONE,
    METAL,
    GLASS,
    WOOL,
    SAND,
    SNOW,
    POWDER_SNOW,
    LADDER,
    ANVIL,
    SLIME_BLOCK,
    HONEY_BLOCK,
    WET_GRASS,
    CORAL_BLOCK,
    BAMBOO,
    BAMBOO_SAPLING,
    SCAFFOLDING,
    SWEET_BERRY_BUSH,
    CROP,
    HARD_CROP,
    VINE,
    NETHER_WART,
    LANTERN,
    STEM,
    NYLIUM,
    FUNGUS,
    ROOTS,
    SHROOMLIGHT,
    WEEPING_VINES,
    TWISTING_VINES,
    SOUL_SAND,
    SOUL_SOIL,
    BASALT,
    WART_BLOCK,
    NETHERRACK,
    NETHER_BRICKS,
    NETHER_SPROUTS,
    NETHER_ORE,
    BONE_BLOCK,
    NETHERITE_BLOCK,
    ANCIENT_DEBRIS,
    LODESTONE,
    CHAIN,
    NETHER_GOLD_ORE,
    GILDED_BLACKSTONE,
    CANDLE,
    AMETHYST,
    AMETHYST_CLUSTER,
    SMALL_AMETHYST_BUD,
    MEDIUM_AMETHYST_BUD,
    LARGE_AMETHYST_BUD,
    TUFF,
    TUFF_BRICKS,
    POLISHED_TUFF,
    CALCITE,
    DRIPSTONE_BLOCK,
    POINTED_DRIPSTONE,
    COPPER,
    COPPER_BULB,
    COPPER_GRATE,
    CAVE_VINES,
    SPORE_BLOSSOM,
    CACTUS_FLOWER,
    AZALEA,
    FLOWERING_AZALEA,
    MOSS_CARPET,
    PINK_PETALS,
    LEAF_LITTER,
    MOSS,
    BIG_DRIPLEAF,
    SMALL_DRIPLEAF,
    ROOTED_DIRT,
    HANGING_ROOTS,
    AZALEA_LEAVES,
    SCULK_SENSOR,
    SCULK_CATALYST,
    SCULK,
    SCULK_VEIN,
    SCULK_SHRIEKER,
    GLOW_LICHEN,
    DEEPSLATE,
    DEEPSLATE_BRICKS,
    DEEPSLATE_TILES,
    POLISHED_DEEPSLATE,
    FROGLIGHT,
    FROGSPAWN,
    MANGROVE_ROOTS,
    MUDDY_MANGROVE_ROOTS,
    MUD,
    MUD_BRICKS,
    PACKED_MUD,
    HANGING_SIGN,
    NETHER_WOOD_HANGING_SIGN,
    BAMBOO_WOOD_HANGING_SIGN,
    BAMBOO_WOOD,
    NETHER_WOOD,
    CHERRY_WOOD,
    CHERRY_SAPLING,
    CHERRY_LEAVES,
    CHERRY_WOOD_HANGING_SIGN,
    CHISELED_BOOKSHELF,
    SUSPICIOUS_SAND,
    SUSPICIOUS_GRAVEL,
    DECORATED_POT,
    DECORATED_POT_CRACKED,
    TRIAL_SPAWNER,
    SPONGE,
    WET_SPONGE,
    VAULT,
    CREAKING_HEART,
    HEAVY_CORE,
    COBWEB,
    SPAWNER,
    RESIN,
    RESIN_BRICKS,
    IRON,
    DRIED_GHAST;

    public static SoundType getSoundType(SoundTypeHolder soundTypeHolder) {
        switch (soundTypeHolder) {
            case EMPTY -> {
                return SoundType.EMPTY;
            }
            case WOOD -> {
                return SoundType.WOOD;
            }
            case GRAVEL -> {
                return SoundType.GRAVEL;
            }
            case GRASS -> {
                return SoundType.GRASS;
            }
            case LILY_PAD -> {
                return SoundType.LILY_PAD;
            }
            case STONE -> {
                return SoundType.STONE;
            }
            case METAL -> {
                return SoundType.METAL;
            }
            case GLASS -> {
                return SoundType.GLASS;
            }
            case WOOL -> {
                return SoundType.WOOL;
            }
            case SAND -> {
                return SoundType.SAND;
            }
            case SNOW -> {
                return SoundType.SNOW;
            }
            case POWDER_SNOW -> {
                return SoundType.POWDER_SNOW;
            }
            case LADDER -> {
                return SoundType.LADDER;
            }
            case ANVIL -> {
                return SoundType.ANVIL;
            }
            case SLIME_BLOCK -> {
                return SoundType.SLIME_BLOCK;
            }
            case HONEY_BLOCK -> {
                return SoundType.HONEY_BLOCK;
            }
            case WET_GRASS -> {
                return SoundType.WET_GRASS;
            }
            case CORAL_BLOCK -> {
                return SoundType.CORAL_BLOCK;
            }
            case BAMBOO -> {
                return SoundType.BAMBOO;
            }
            case BAMBOO_SAPLING -> {
                return SoundType.BAMBOO_SAPLING;
            }
            case SCAFFOLDING -> {
                return SoundType.SCAFFOLDING;
            }
            case SWEET_BERRY_BUSH -> {
                return SoundType.SWEET_BERRY_BUSH;
            }
            case CROP -> {
                return SoundType.CROP;
            }
            case HARD_CROP -> {
                return SoundType.HARD_CROP;
            }
            case VINE -> {
                return SoundType.VINE;
            }
            case NETHER_WART -> {
                return SoundType.NETHER_WART;
            }
            case LANTERN -> {
                return SoundType.LANTERN;
            }
            case STEM -> {
                return SoundType.STEM;
            }
            case NYLIUM -> {
                return SoundType.NYLIUM;
            }
            case FUNGUS -> {
                return SoundType.FUNGUS;
            }
            case ROOTS -> {
                return SoundType.ROOTS;
            }
            case SHROOMLIGHT -> {
                return SoundType.SHROOMLIGHT;
            }
            case WEEPING_VINES -> {
                return SoundType.WEEPING_VINES;
            }
            case TWISTING_VINES -> {
                return SoundType.TWISTING_VINES;
            }
            case SOUL_SAND -> {
                return SoundType.SOUL_SAND;
            }
            case SOUL_SOIL -> {
                return SoundType.SOUL_SOIL;
            }
            case BASALT -> {
                return SoundType.BASALT;
            }
            case WART_BLOCK -> {
                return SoundType.WART_BLOCK;
            }
            case NETHERRACK -> {
                return SoundType.NETHERRACK;
            }
            case NETHER_BRICKS -> {
                return SoundType.NETHER_BRICKS;
            }
            case NETHER_SPROUTS -> {
                return SoundType.NETHER_SPROUTS;
            }
            case NETHER_ORE -> {
                return SoundType.NETHER_ORE;
            }
            case BONE_BLOCK -> {
                return SoundType.BONE_BLOCK;
            }
            case NETHERITE_BLOCK -> {
                return SoundType.NETHERITE_BLOCK;
            }
            case ANCIENT_DEBRIS -> {
                return SoundType.ANCIENT_DEBRIS;
            }
            case LODESTONE -> {
                return SoundType.LODESTONE;
            }
            case CHAIN -> {
                return SoundType.CHAIN;
            }
            case NETHER_GOLD_ORE -> {
                return SoundType.NETHER_GOLD_ORE;
            }
            case GILDED_BLACKSTONE -> {
                return SoundType.GILDED_BLACKSTONE;
            }
            case CANDLE -> {
                return SoundType.CANDLE;
            }
            case AMETHYST -> {
                return SoundType.AMETHYST;
            }
            case AMETHYST_CLUSTER -> {
                return SoundType.AMETHYST_CLUSTER;
            }
            case SMALL_AMETHYST_BUD -> {
                return SoundType.SMALL_AMETHYST_BUD;
            }
            case MEDIUM_AMETHYST_BUD -> {
                return SoundType.MEDIUM_AMETHYST_BUD;
            }
            case LARGE_AMETHYST_BUD -> {
                return SoundType.LARGE_AMETHYST_BUD;
            }
            case TUFF -> {
                return SoundType.TUFF;
            }
            case TUFF_BRICKS -> {
                return SoundType.TUFF_BRICKS;
            }
            case POLISHED_TUFF -> {
                return SoundType.POLISHED_TUFF;
            }
            case CALCITE -> {
                return SoundType.CALCITE;
            }
            case DRIPSTONE_BLOCK -> {
                return SoundType.DRIPSTONE_BLOCK;
            }
            case POINTED_DRIPSTONE -> {
                return SoundType.POINTED_DRIPSTONE;
            }
            case COPPER -> {
                return SoundType.COPPER;
            }
            case COPPER_BULB -> {
                return SoundType.COPPER_BULB;
            }
            case COPPER_GRATE -> {
                return SoundType.COPPER_GRATE;
            }
            case CAVE_VINES -> {
                return SoundType.CAVE_VINES;
            }
            case SPORE_BLOSSOM -> {
                return SoundType.SPORE_BLOSSOM;
            }
            case CACTUS_FLOWER -> {
                return SoundType.CACTUS_FLOWER;
            }
            case AZALEA -> {
                return SoundType.AZALEA;
            }
            case FLOWERING_AZALEA -> {
                return SoundType.FLOWERING_AZALEA;
            }
            case MOSS_CARPET -> {
                return SoundType.MOSS_CARPET;
            }
            case PINK_PETALS -> {
                return SoundType.PINK_PETALS;
            }
            case LEAF_LITTER -> {
                return SoundType.LEAF_LITTER;
            }
            case MOSS -> {
                return SoundType.MOSS;
            }
            case BIG_DRIPLEAF -> {
                return SoundType.BIG_DRIPLEAF;
            }
            case SMALL_DRIPLEAF -> {
                return SoundType.SMALL_DRIPLEAF;
            }
            case ROOTED_DIRT -> {
                return SoundType.ROOTED_DIRT;
            }
            case HANGING_ROOTS -> {
                return SoundType.HANGING_ROOTS;
            }
            case AZALEA_LEAVES -> {
                return SoundType.AZALEA_LEAVES;
            }
            case SCULK_SENSOR -> {
                return SoundType.SCULK_SENSOR;
            }
            case SCULK_CATALYST -> {
                return SoundType.SCULK_CATALYST;
            }
            case SCULK -> {
                return SoundType.SCULK;
            }
            case SCULK_VEIN -> {
                return SoundType.SCULK_VEIN;
            }
            case SCULK_SHRIEKER -> {
                return SoundType.SCULK_SHRIEKER;
            }
            case GLOW_LICHEN -> {
                return SoundType.GLOW_LICHEN;
            }
            case DEEPSLATE -> {
                return SoundType.DEEPSLATE;
            }
            case DEEPSLATE_BRICKS -> {
                return SoundType.DEEPSLATE_BRICKS;
            }
            case DEEPSLATE_TILES -> {
                return SoundType.DEEPSLATE_TILES;
            }
            case POLISHED_DEEPSLATE -> {
                return SoundType.POLISHED_DEEPSLATE;
            }
            case FROGLIGHT -> {
                return SoundType.FROGLIGHT;
            }
            case FROGSPAWN -> {
                return SoundType.FROGSPAWN;
            }
            case MANGROVE_ROOTS -> {
                return SoundType.MANGROVE_ROOTS;
            }
            case MUDDY_MANGROVE_ROOTS -> {
                return SoundType.MUDDY_MANGROVE_ROOTS;
            }
            case MUD -> {
                return SoundType.MUD;
            }
            case MUD_BRICKS -> {
                return SoundType.MUD_BRICKS;
            }
            case PACKED_MUD -> {
                return SoundType.PACKED_MUD;
            }
            case HANGING_SIGN -> {
                return SoundType.HANGING_SIGN;
            }
            case NETHER_WOOD_HANGING_SIGN -> {
                return SoundType.NETHER_WOOD_HANGING_SIGN;
            }
            case BAMBOO_WOOD_HANGING_SIGN -> {
                return SoundType.BAMBOO_WOOD_HANGING_SIGN;
            }
            case BAMBOO_WOOD -> {
                return SoundType.BAMBOO_WOOD;
            }
            case NETHER_WOOD -> {
                return SoundType.NETHER_WOOD;
            }
            case CHERRY_WOOD -> {
                return SoundType.CHERRY_WOOD;
            }
            case CHERRY_SAPLING -> {
                return SoundType.CHERRY_SAPLING;
            }
            case CHERRY_LEAVES -> {
                return SoundType.CHERRY_LEAVES;
            }
            case CHERRY_WOOD_HANGING_SIGN -> {
                return SoundType.CHERRY_WOOD_HANGING_SIGN;
            }
            case CHISELED_BOOKSHELF -> {
                return SoundType.CHISELED_BOOKSHELF;
            }
            case SUSPICIOUS_SAND -> {
                return SoundType.SUSPICIOUS_SAND;
            }
            case SUSPICIOUS_GRAVEL -> {
                return SoundType.SUSPICIOUS_GRAVEL;
            }
            case DECORATED_POT -> {
                return SoundType.DECORATED_POT;
            }
            case DECORATED_POT_CRACKED -> {
                return SoundType.DECORATED_POT_CRACKED;
            }
            case TRIAL_SPAWNER -> {
                return SoundType.TRIAL_SPAWNER;
            }
            case SPONGE -> {
                return SoundType.SPONGE;
            }
            case WET_SPONGE -> {
                return SoundType.WET_SPONGE;
            }
            case VAULT -> {
                return SoundType.VAULT;
            }
            case CREAKING_HEART -> {
                return SoundType.CREAKING_HEART;
            }
            case HEAVY_CORE -> {
                return SoundType.HEAVY_CORE;
            }
            case COBWEB -> {
                return SoundType.COBWEB;
            }
            case SPAWNER -> {
                return SoundType.SPAWNER;
            }
            case RESIN -> {
                return SoundType.RESIN;
            }
            case RESIN_BRICKS -> {
                return SoundType.RESIN_BRICKS;
            }
            case IRON -> {
                return SoundType.IRON;
            }
            case DRIED_GHAST -> {
                PufferfishAPI.LOGGER.warn("Mod attempted to use sound type that is not available in " + PufferfishAPI.getMinecraftVersion() + ". This may cause issues.");
                return null;
            }
        }

        PufferfishAPI.LOGGER.warn("Mod tried to use a non-existent sound. Issues may occur");
        return null;
    }
}