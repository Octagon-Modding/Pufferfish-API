package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.sounds.BlockSoundSet;
import net.minecraft.world.level.block.sounds.BlockSoundSets;
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
    DRIED_GHAST,
    COPPER_GOLEM_STATUE,
    SHELF;

    public static ResourceKey<BlockSoundSet> getSoundType(SoundTypeHolder BlockSoundSetsHolder) {
        switch (BlockSoundSetsHolder) {
            case WOOD -> {
                return BlockSoundSets.WOOD;
            }
            case GRAVEL -> {
                return BlockSoundSets.GRAVEL;
            }
            case GRASS -> {
                return BlockSoundSets.GRASS;
            }
            case LILY_PAD -> {
                return BlockSoundSets.LILY_PAD;
            }
            case STONE -> {
                return BlockSoundSets.STONE;
            }
            case METAL -> {
                return BlockSoundSets.METAL;
            }
            case GLASS -> {
                return BlockSoundSets.GLASS;
            }
            case WOOL -> {
                return BlockSoundSets.WOOL;
            }
            case SAND -> {
                return BlockSoundSets.SAND;
            }
            case SNOW -> {
                return BlockSoundSets.SNOW;
            }
            case POWDER_SNOW -> {
                return BlockSoundSets.POWDER_SNOW;
            }
            case LADDER -> {
                return BlockSoundSets.LADDER;
            }
            case ANVIL -> {
                return BlockSoundSets.ANVIL;
            }
            case SLIME_BLOCK -> {
                return BlockSoundSets.SLIME_BLOCK;
            }
            case HONEY_BLOCK -> {
                return BlockSoundSets.HONEY_BLOCK;
            }
            case WET_GRASS -> {
                return BlockSoundSets.WET_GRASS;
            }
            case CORAL_BLOCK -> {
                return BlockSoundSets.CORAL_BLOCK;
            }
            case BAMBOO -> {
                return BlockSoundSets.BAMBOO;
            }
            case BAMBOO_SAPLING -> {
                return BlockSoundSets.BAMBOO_SAPLING;
            }
            case SCAFFOLDING -> {
                return BlockSoundSets.SCAFFOLDING;
            }
            case SWEET_BERRY_BUSH -> {
                return BlockSoundSets.SWEET_BERRY_BUSH;
            }
            case CROP -> {
                return BlockSoundSets.CROP;
            }
            case HARD_CROP -> {
                return BlockSoundSets.HARD_CROP;
            }
            case VINE -> {
                return BlockSoundSets.VINE;
            }
            case NETHER_WART -> {
                return BlockSoundSets.NETHER_WART;
            }
            case LANTERN -> {
                return BlockSoundSets.LANTERN;
            }
            case STEM -> {
                return BlockSoundSets.STEM;
            }
            case NYLIUM -> {
                return BlockSoundSets.NYLIUM;
            }
            case FUNGUS -> {
                return BlockSoundSets.FUNGUS;
            }
            case ROOTS -> {
                return BlockSoundSets.ROOTS;
            }
            case SHROOMLIGHT -> {
                return BlockSoundSets.SHROOMLIGHT;
            }
            case WEEPING_VINES, TWISTING_VINES -> {
                return BlockSoundSets.WEEPING_VINES;
            }
            case SOUL_SAND -> {
                return BlockSoundSets.SOUL_SAND;
            }
            case SOUL_SOIL -> {
                return BlockSoundSets.SOUL_SOIL;
            }
            case BASALT -> {
                return BlockSoundSets.BASALT;
            }
            case WART_BLOCK -> {
                return BlockSoundSets.WART_BLOCK;
            }
            case NETHERRACK -> {
                return BlockSoundSets.NETHERRACK;
            }
            case NETHER_BRICKS -> {
                return BlockSoundSets.NETHER_BRICKS;
            }
            case NETHER_SPROUTS -> {
                return BlockSoundSets.NETHER_SPROUTS;
            }
            case NETHER_ORE -> {
                return BlockSoundSets.NETHER_ORE;
            }
            case BONE_BLOCK -> {
                return BlockSoundSets.BONE_BLOCK;
            }
            case NETHERITE_BLOCK -> {
                return BlockSoundSets.NETHERITE_BLOCK;
            }
            case ANCIENT_DEBRIS -> {
                return BlockSoundSets.ANCIENT_DEBRIS;
            }
            case LODESTONE -> {
                return BlockSoundSets.LODESTONE;
            }
            case CHAIN -> {
                return BlockSoundSets.CHAIN;
            }
            case NETHER_GOLD_ORE -> {
                return BlockSoundSets.NETHER_GOLD_ORE;
            }
            case GILDED_BLACKSTONE -> {
                return BlockSoundSets.GILDED_BLACKSTONE;
            }
            case CANDLE -> {
                return BlockSoundSets.CANDLE;
            }
            case AMETHYST -> {
                return BlockSoundSets.AMETHYST_BLOCK;
            }
            case AMETHYST_CLUSTER -> {
                return BlockSoundSets.AMETHYST_CLUSTER;
            }
            case SMALL_AMETHYST_BUD -> {
                return BlockSoundSets.SMALL_AMETHYST_BUD;
            }
            case MEDIUM_AMETHYST_BUD -> {
                return BlockSoundSets.MEDIUM_AMETHYST_BUD;
            }
            case LARGE_AMETHYST_BUD -> {
                return BlockSoundSets.LARGE_AMETHYST_BUD;
            }
            case TUFF -> {
                return BlockSoundSets.TUFF;
            }
            case TUFF_BRICKS -> {
                return BlockSoundSets.TUFF_BRICKS;
            }
            case POLISHED_TUFF -> {
                return BlockSoundSets.POLISHED_TUFF;
            }
            case CALCITE -> {
                return BlockSoundSets.CALCITE;
            }
            case DRIPSTONE_BLOCK -> {
                return BlockSoundSets.DRIPSTONE_BLOCK;
            }
            case POINTED_DRIPSTONE -> {
                return BlockSoundSets.POINTED_DRIPSTONE;
            }
            case COPPER -> {
                return BlockSoundSets.COPPER;
            }
            case COPPER_BULB -> {
                return BlockSoundSets.COPPER_BULB;
            }
            case COPPER_GRATE -> {
                return BlockSoundSets.COPPER_GRATE;
            }
            case CAVE_VINES -> {
                return BlockSoundSets.CAVE_VINES;
            }
            case SPORE_BLOSSOM -> {
                return BlockSoundSets.SPORE_BLOSSOM;
            }
            case CACTUS_FLOWER -> {
                return BlockSoundSets.CACTUS_FLOWER;
            }
            case AZALEA -> {
                return BlockSoundSets.AZALEA;
            }
            case FLOWERING_AZALEA -> {
                return BlockSoundSets.FLOWERING_AZALEA;
            }
            case MOSS_CARPET -> {
                return BlockSoundSets.MOSS_CARPET;
            }
            case PINK_PETALS -> {
                return BlockSoundSets.PINK_PETALS;
            }
            case LEAF_LITTER -> {
                return BlockSoundSets.LEAF_LITTER;
            }
            case MOSS -> {
                return BlockSoundSets.MOSS;
            }
            case BIG_DRIPLEAF -> {
                return BlockSoundSets.BIG_DRIPLEAF;
            }
            case SMALL_DRIPLEAF -> {
                return BlockSoundSets.SMALL_DRIPLEAF;
            }
            case ROOTED_DIRT -> {
                return BlockSoundSets.ROOTED_DIRT;
            }
            case HANGING_ROOTS -> {
                return BlockSoundSets.HANGING_ROOTS;
            }
            case AZALEA_LEAVES -> {
                return BlockSoundSets.AZALEA_LEAVES;
            }
            case SCULK_SENSOR -> {
                return BlockSoundSets.SCULK_SENSOR;
            }
            case SCULK_CATALYST -> {
                return BlockSoundSets.SCULK_CATALYST;
            }
            case SCULK -> {
                return BlockSoundSets.SCULK;
            }
            case SCULK_VEIN -> {
                return BlockSoundSets.SCULK_VEIN;
            }
            case SCULK_SHRIEKER -> {
                return BlockSoundSets.SCULK_SHRIEKER;
            }
            case GLOW_LICHEN -> {
                return BlockSoundSets.GLOW_LICHEN;
            }
            case DEEPSLATE -> {
                return BlockSoundSets.DEEPSLATE;
            }
            case DEEPSLATE_BRICKS -> {
                return BlockSoundSets.DEEPSLATE_BRICKS;
            }
            case DEEPSLATE_TILES -> {
                return BlockSoundSets.DEEPSLATE_TILES;
            }
            case POLISHED_DEEPSLATE -> {
                return BlockSoundSets.POLISHED_DEEPSLATE;
            }
            case FROGLIGHT -> {
                return BlockSoundSets.FROGLIGHT;
            }
            case FROGSPAWN -> {
                return BlockSoundSets.FROGSPAWN;
            }
            case MANGROVE_ROOTS -> {
                return BlockSoundSets.MANGROVE_ROOTS;
            }
            case MUDDY_MANGROVE_ROOTS -> {
                return BlockSoundSets.MUDDY_MANGROVE_ROOTS;
            }
            case MUD -> {
                return BlockSoundSets.MUD;
            }
            case MUD_BRICKS -> {
                return BlockSoundSets.MUD_BRICKS;
            }
            case PACKED_MUD -> {
                return BlockSoundSets.PACKED_MUD;
            }
            case HANGING_SIGN -> {
                return BlockSoundSets.HANGING_SIGN;
            }
            case NETHER_WOOD_HANGING_SIGN -> {
                return BlockSoundSets.NETHER_WOOD_HANGING_SIGN;
            }
            case BAMBOO_WOOD_HANGING_SIGN -> {
                return BlockSoundSets.BAMBOO_WOOD_HANGING_SIGN;
            }
            case BAMBOO_WOOD -> {
                return BlockSoundSets.BAMBOO_WOOD;
            }
            case NETHER_WOOD -> {
                return BlockSoundSets.NETHER_WOOD;
            }
            case CHERRY_WOOD -> {
                return BlockSoundSets.CHERRY_WOOD;
            }
            case CHERRY_SAPLING -> {
                return BlockSoundSets.CHERRY_SAPLING;
            }
            case CHERRY_LEAVES -> {
                return BlockSoundSets.CHERRY_LEAVES;
            }
            case CHERRY_WOOD_HANGING_SIGN -> {
                return BlockSoundSets.CHERRY_WOOD_HANGING_SIGN;
            }
            case CHISELED_BOOKSHELF -> {
                return BlockSoundSets.CHISELED_BOOKSHELF;
            }
            case SUSPICIOUS_SAND -> {
                return BlockSoundSets.SUSPICIOUS_SAND;
            }
            case SUSPICIOUS_GRAVEL -> {
                return BlockSoundSets.SUSPICIOUS_GRAVEL;
            }
            case DECORATED_POT -> {
                return BlockSoundSets.DECORATED_POT;
            }
            case DECORATED_POT_CRACKED -> {
                return BlockSoundSets.DECORATED_POT_CRACKED;
            }
            case TRIAL_SPAWNER -> {
                return BlockSoundSets.TRIAL_SPAWNER;
            }
            case SPONGE -> {
                return BlockSoundSets.SPONGE;
            }
            case WET_SPONGE -> {
                return BlockSoundSets.WET_SPONGE;
            }
            case VAULT -> {
                return BlockSoundSets.VAULT;
            }
            case CREAKING_HEART -> {
                return BlockSoundSets.CREAKING_HEART;
            }
            case HEAVY_CORE -> {
                return BlockSoundSets.HEAVY_CORE;
            }
            case COBWEB -> {
                return BlockSoundSets.COBWEB;
            }
            case SPAWNER -> {
                return BlockSoundSets.SPAWNER;
            }
            case RESIN -> {
                return BlockSoundSets.RESIN;
            }
            case RESIN_BRICKS -> {
                return BlockSoundSets.RESIN_BRICKS;
            }
            case IRON -> {
                return BlockSoundSets.IRON;
            }
            case DRIED_GHAST -> {
                return BlockSoundSets.DRIED_GHAST;
            }
            case COPPER_GOLEM_STATUE -> {
                return BlockSoundSets.COPPER_GOLEM_STATUE;
            }
            case SHELF -> {
                return BlockSoundSets.SHELF;
            }
            default -> {
                PufferfishAPI.LOGGER.warn("Mod attempted to use sound type that is not available in " + PufferfishAPI.getMinecraftVersion() + ". This may cause issues.");
                return null;
            }
        }
    }
}