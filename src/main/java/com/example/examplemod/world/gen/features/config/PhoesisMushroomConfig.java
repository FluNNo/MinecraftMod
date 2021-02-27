package com.example.examplemod.world.gen.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class PhoesisMushroomConfig implements IFeatureConfig {
    public static final Codec<PhoesisMushroomConfig> field_236298_a_ = RecordCodecBuilder.create((p_236309_0_) -> {
        return p_236309_0_.group(BlockState.CODEC.fieldOf("valid_base_block").forGetter((p_236313_0_) -> {
            return p_236313_0_.field_236303_f_;
        }), BlockState.CODEC.fieldOf("stem_state").forGetter((p_236312_0_) -> {
            return p_236312_0_.field_236304_g_;
        }), BlockState.CODEC.fieldOf("hat_state").forGetter((p_236311_0_) -> {
            return p_236311_0_.field_236305_h_;
        }), BlockState.CODEC.fieldOf("decor_state").forGetter((p_236310_0_) -> {
            return p_236310_0_.field_236306_i_;
        }), Codec.BOOL.fieldOf("planted").orElse(false).forGetter((p_236308_0_) -> {
            return p_236308_0_.field_236307_j_;
        })).apply(p_236309_0_, PhoesisMushroomConfig::new);
    });
    public static final PhoesisMushroomConfig field_236299_b_ = new PhoesisMushroomConfig(Blocks.CRIMSON_NYLIUM.getDefaultState(), Blocks.CRIMSON_STEM.getDefaultState(), Blocks.NETHER_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
    public static final PhoesisMushroomConfig field_236300_c_;
    public static final PhoesisMushroomConfig field_236301_d_ = new PhoesisMushroomConfig(Blocks.WARPED_NYLIUM.getDefaultState(), Blocks.WARPED_STEM.getDefaultState(), Blocks.WARPED_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
    public static final PhoesisMushroomConfig field_236302_e_;
    public final BlockState field_236303_f_;
    public final BlockState field_236304_g_;
    public final BlockState field_236305_h_;
    public final BlockState field_236306_i_;
    public final boolean field_236307_j_;

    public PhoesisMushroomConfig(BlockState p_i231958_1_, BlockState p_i231958_2_, BlockState p_i231958_3_, BlockState p_i231958_4_, boolean p_i231958_5_) {
        this.field_236303_f_ = p_i231958_1_;
        this.field_236304_g_ = p_i231958_2_;
        this.field_236305_h_ = p_i231958_3_;
        this.field_236306_i_ = p_i231958_4_;
        this.field_236307_j_ = p_i231958_5_;
    }

    static {
        field_236300_c_ = new PhoesisMushroomConfig(field_236299_b_.field_236303_f_, field_236299_b_.field_236304_g_, field_236299_b_.field_236305_h_, field_236299_b_.field_236306_i_, false);
        field_236302_e_ = new PhoesisMushroomConfig(field_236301_d_.field_236303_f_, field_236301_d_.field_236304_g_, field_236301_d_.field_236305_h_, field_236301_d_.field_236306_i_, false);
    }
}
