package com.example.examplemod.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;

public class MatterGloveItem extends Item implements IAnimatable {

    public AnimationFactory factory = new AnimationFactory(this);
    private String controllerName = "matter_glove_animation_controller";

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        return PlayState.CONTINUE;
    }

    public MatterGloveItem(Properties properties) {
        super(properties);
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, controllerName, 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand hand) {
        if (!worldIn.isRemote) {
            return super.onItemRightClick(worldIn, player, hand);
        }

        ItemStack stack = player.getHeldItem(hand);

        AnimationController controller = GeckoLibUtil.getControllerForStack(this.factory, stack, controllerName);

        if (controller.getAnimationState() == AnimationState.Stopped) {
            player.sendStatusMessage(new StringTextComponent("Initializing..."), true);

            controller.markNeedsReload();

            controller.setAnimation(new AnimationBuilder().addAnimation("animation_matter_glove_equip", false));
        }
        return super.onItemRightClick(worldIn, player, hand);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(new StringTextComponent("Matter Glove go BOOM BOOM"));
        }
        else {
            tooltip.add(new TranslationTextComponent("tooltip.advanced_item.hold_shift"));
        }
    }

    //event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.matter_glove.equip", true));

    //@Override
    //public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    //    playerIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 200, 5));
    //    return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    //}

}

