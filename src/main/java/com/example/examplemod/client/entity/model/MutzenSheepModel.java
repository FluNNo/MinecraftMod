package com.example.examplemod.client.entity.model;

// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.example.examplemod.entities.MutzenSheep;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class MutzenSheepModel<T extends MutzenSheep> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer legFrontRight;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer legBackRight;
    private final ModelRenderer legBackLeft;
    private final ModelRenderer head;
    private final ModelRenderer earLeft;
    private final ModelRenderer earRight;
    private final ModelRenderer tail;

    public MutzenSheepModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-4.0F, -15.0F, -8.0F, 8.0F, 7.0F, 16.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(-2.0F, 15.0F, -4.0F);
        legFrontRight.setTextureOffset(32, 32).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);
        legFrontRight.setTextureOffset(8, 35).addBox(-1.25F, 5.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(2.0F, 15.0F, -4.0F);
        legFrontLeft.setTextureOffset(0, 0).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);
        legFrontLeft.setTextureOffset(0, 35).addBox(-0.75F, 5.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(-2.0F, 15.0F, 6.0F);
        legBackRight.setTextureOffset(22, 23).addBox(-1.75F, 0.0F, -2.25F, 3.0F, 5.0F, 4.0F, 0.0F, false);
        legBackRight.setTextureOffset(32, 10).addBox(-1.25F, 5.0F, -1.25F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(2.0F, 15.0F, 6.0F);
        legBackLeft.setTextureOffset(18, 32).addBox(-1.25F, 0.0F, -2.25F, 3.0F, 5.0F, 4.0F, 0.0F, false);
        legBackLeft.setTextureOffset(32, 4).addBox(-0.75F, 5.0F, -1.25F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 10.0F, -6.0F);
        head.setTextureOffset(0, 23).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 7.0F, 5.0F, 0.0F, false);
        head.setTextureOffset(0, 9).addBox(-2.5F, -3.5F, -6.0F, 5.0F, 6.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(32, 0).addBox(-2.0F, -0.5F, -7.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);

        earLeft = new ModelRenderer(this);
        earLeft.setRotationPoint(3.0F, -1.0F, -3.0F);
        head.addChild(earLeft);
        earLeft.setTextureOffset(32, 23).addBox(-8.5F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        earLeft.setTextureOffset(28, 32).addBox(-8.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        earLeft.setTextureOffset(28, 34).addBox(-7.5F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        earLeft.setTextureOffset(0, 2).addBox(-6.5F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        earRight = new ModelRenderer(this);
        earRight.setRotationPoint(-3.0F, -1.0F, -3.0F);
        head.addChild(earRight);
        earRight.setTextureOffset(17, 25).addBox(5.5F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        earRight.setTextureOffset(17, 23).addBox(5.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        earRight.setTextureOffset(32, 25).addBox(5.5F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        earRight.setTextureOffset(0, 0).addBox(5.5F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 10.0F, 8.0F);
        tail.setTextureOffset(10, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public ModelRenderer getBody() {
        return body;
    }

    public ModelRenderer getHead() {
        return head;
    }

    public ModelRenderer getLegFrontRight() {
        return legFrontRight;
    }

    public ModelRenderer getLegFrontLeft() {
        return legFrontLeft;
    }

    public ModelRenderer getLegBackRight() {
        return legBackRight;
    }

    public ModelRenderer getLegBackLeft() {
        return legBackLeft;
    }

    public ModelRenderer getTail() {
        return tail;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
    }

}