package com.example.examplemod.entities;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.setup.ModEntityTypes;
import com.example.examplemod.setup.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class MutzenSheep extends AnimalEntity implements IShearable, net.minecraftforge.common.IForgeShearable {

    private EatGrassGoal eatGrassGoal;
    private int exampleTimer;
    private boolean sheared = false;

    public MutzenSheep(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return ModEntityTypes.MUTZEN_SHEEP.get().create(p_241840_1_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(ModItems.MUTZEN.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this,1.1D));
        this.goalSelector.addGoal(5, this.eatGrassGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Override
    protected void updateAITasks() {
        this.exampleTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        if(this.world.isRemote) {
            this.exampleTimer = Math.max(0, this.exampleTimer - 1);
        }
        super.livingTick();
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SHEEP_AMBIENT;
    }


    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SHEEP_DEATH;
    }


    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SHEEP_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.23F);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.exampleTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationPointY(float p_70894_1_) {
        if (this.exampleTimer <= 0) {
            return 0.0F;
        } else if (this.exampleTimer >= 4 && this.exampleTimer <= 36) {
            return 1.0F;
        } else {
            return this.exampleTimer < 4 ? ((float)this.exampleTimer - p_70894_1_) / 4.0F : -((float)(this.exampleTimer - 40) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationAngleX(float p_70890_1_) {
        if (this.exampleTimer > 4 && this.exampleTimer <= 36) {
            float f = ((float)(this.exampleTimer - 4) - p_70890_1_) / 32.0F;
            return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.exampleTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * ((float)Math.PI / 180F);
        }
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ModItems.MUTZEN.get();
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.95F * sizeIn.height;
    }

    //WTF Warum du KACK DING!
    @Override
    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        if (false && itemstack.getItem() == Items.SHEARS) { //Forge: Moved to onSheared
            if (!this.world.isRemote && this.isShearable()) {
                this.shear(SoundCategory.PLAYERS);
                itemstack.damageItem(1, p_230254_1_, (p_213613_1_) -> {
                    p_213613_1_.sendBreakAnimation(p_230254_2_);
                });
                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.CONSUME;
            }
        } else {
            return super.func_230254_b_(p_230254_1_, p_230254_2_);
        }
    }

    public void eatGrassBonus() {
        this.sheared = false;
        if (this.isChild()) {
            this.addGrowth(60);
        }
    }

    @Override
    public void shear(SoundCategory category) {

    }

    public boolean isShearable() {
        return this.isAlive() && !sheared && !this.isChild();
    }

    @javax.annotation.Nonnull
    @Override
    public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
        if (!world.isRemote && !sheared) {
            world.playMovingSound(null, this, SoundEvents.ENTITY_SHEEP_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
            this.sheared = true;
            int i = 1 + this.rand.nextInt(2);

            java.util.List<ItemStack> items = new java.util.ArrayList<>();
            for (int j = 0; j < i; ++j) {
                items.add(new ItemStack(ModItems.MUTZEN.get()));
            }
            return items;
        }
        return java.util.Collections.emptyList();
    }

}