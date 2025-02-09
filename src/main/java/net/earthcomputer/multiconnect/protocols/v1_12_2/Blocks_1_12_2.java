package net.earthcomputer.multiconnect.protocols.v1_12_2;

import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.util.registry.Registry;

public class Blocks_1_12_2 {
    public static final Block FLOWING_WATER = new DummyBlock(Blocks.WATER);
    public static final Block FLOWING_LAVA = new DummyBlock(Blocks.LAVA);
    public static final Block DOUBLE_STONE_SLAB = new DummyBlock(Blocks.SMOOTH_STONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
    public static final Block LIT_FURNACE = new DummyBlock(Blocks.FURNACE.getDefaultState().with(FurnaceBlock.LIT, true));
    public static final Block LIT_REDSTONE_ORE = new DummyBlock(Blocks.REDSTONE_ORE.getDefaultState().with(RedstoneOreBlock.LIT, true));
    public static final Block UNLIT_REDSTONE_TORCH = new DummyBlock(Blocks.REDSTONE_TORCH.getDefaultState().with(RedstoneTorchBlock.LIT, false));
    public static final Block POWERED_REPEATER = new DummyBlock(Blocks.REPEATER.getDefaultState().with(RepeaterBlock.POWERED, true));
    public static final Block LIT_REDSTONE_LAMP = new DummyBlock(Blocks.REDSTONE_LAMP.getDefaultState().with(RedstoneLampBlock.LIT, true));
    public static final Block DOUBLE_WOODEN_SLAB = new DummyBlock(Blocks.OAK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
    public static final Block POWERED_COMPARATOR = new DummyBlock(Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, true));
    public static final Block DAYLIGHT_DETECTOR_INVERTED = new DummyBlock(Blocks.DAYLIGHT_DETECTOR.getDefaultState().with(DaylightDetectorBlock.INVERTED, true));
    public static final Block DOUBLE_STONE_SLAB2 = new DummyBlock(Blocks.RED_SANDSTONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
    public static final Block PURPUR_DOUBLE_SLAB = new DummyBlock(Blocks.PURPUR_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));

    // :thonkjang: made block states have 2 different IDs in 1.12
    // we use the one used in chunks as our actual IDs for efficiency,
    // but we have to convert the rest

    public static int convertToStateRegistryId(int id) {
        int blockId = id & 4095;
        int meta = id >> 12 & 15;
        return blockId << 4 | meta;
    }

    public static int convertFromStateRegistryId(int id) {
        int blockId = id >> 4 & 4095;
        int meta = id & 15;
        return meta << 12 | blockId;
    }

    public static void register() {
        Registry.register(Registry.BLOCK, "multiconnect:flowing_water", FLOWING_WATER);
        Registry.register(Registry.BLOCK, "multiconnect:flowing_lava", FLOWING_LAVA);
        Registry.register(Registry.BLOCK, "multiconnect:double_stone_slab", DOUBLE_STONE_SLAB);
        Registry.register(Registry.BLOCK, "multiconnect:lit_furnace", LIT_FURNACE);
        Registry.register(Registry.BLOCK, "multiconnect:lit_redstone_ore", LIT_REDSTONE_ORE);
        Registry.register(Registry.BLOCK, "multiconnect:unlit_redstone_torch", UNLIT_REDSTONE_TORCH);
        Registry.register(Registry.BLOCK, "multiconnect:powered_repeater", POWERED_REPEATER);
        Registry.register(Registry.BLOCK, "multiconnect:lit_redstone_lamp", LIT_REDSTONE_LAMP);
        Registry.register(Registry.BLOCK, "multiconnect:double_wooden_slab", DOUBLE_WOODEN_SLAB);
        Registry.register(Registry.BLOCK, "multiconnect:powered_comparator", POWERED_COMPARATOR);
        Registry.register(Registry.BLOCK, "multiconnect:daylight_detector_inverted", DAYLIGHT_DETECTOR_INVERTED);
        Registry.register(Registry.BLOCK, "multiconnect:double_stone_slab2", DOUBLE_STONE_SLAB2);
        Registry.register(Registry.BLOCK, "multiconnect:purpur_double_slab", PURPUR_DOUBLE_SLAB);
    }
}
