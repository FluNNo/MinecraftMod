package com.example.examplemod.world.gen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class PhoesisHugeFungusConfig implements IFeatureConfig {
    public static final Codec<PhoesisHugeFungusConfig> CODEC = RecordCodecBuilder.create((p_236309_0_) -> {
        return p_236309_0_.group(BlockState.CODEC.fieldOf("valid_base_block").forGetter((p_236313_0_) -> {
            return p_236313_0_.valid_base_block_state;
        }), BlockState.CODEC.fieldOf("stem_state").forGetter((p_236312_0_) -> {
            return p_236312_0_.stem_state;
        }), BlockState.CODEC.fieldOf("hat_state").forGetter((p_236311_0_) -> {
            return p_236311_0_.hat_state;
        }), BlockState.CODEC.fieldOf("decor_state").forGetter((p_236310_0_) -> {
            return p_236310_0_.decor_state;
        }), Codec.BOOL.fieldOf("planted").orElse(false).forGetter((p_236308_0_) -> {
            return p_236308_0_.planted;
        })).apply(p_236309_0_, PhoesisHugeFungusConfig::new);
    });

    public final BlockState valid_base_block_state;
    public final BlockState stem_state;
    public final BlockState hat_state;
    public final BlockState decor_state;
    public final boolean planted;

    public PhoesisHugeFungusConfig(BlockState valid_base_block_state, BlockState stem_state, BlockState hat_state, BlockState decor_state, boolean planted) {
        this.valid_base_block_state = valid_base_block_state;
        this.stem_state = stem_state;
        this.hat_state = hat_state;
        this.decor_state = decor_state;
        this.planted = planted;
    }
}
