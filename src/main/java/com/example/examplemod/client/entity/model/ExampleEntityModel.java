package com.example.examplemod.client.entity.model;

// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.example.examplemod.entities.ExampleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ExampleEntityModel<T extends ExampleEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer head;

    public ExampleEntityModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 5.0F, 12.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(leg1);
        leg1.setTextureOffset(8, 0).addBox(-4.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(leg2);
        leg2.setTextureOffset(0, 6).addBox(3.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(leg3);
        leg3.setTextureOffset(4, 4).addBox(-4.0F, -5.0F, 7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(leg4);
        leg4.setTextureOffset(0, 0).addBox(3.0F, -5.0F, 7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(head);
        head.setTextureOffset(0, 17).addBox(-2.0F, -12.0F, -8.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
    }

    public ModelRenderer getBody() {
        return body;
    }

    public ModelRenderer getHead() {
        return head;
    }

    public ModelRenderer getLeg1() {
        return leg1;
    }

    public ModelRenderer getLeg2() {
        return leg2;
    }

    public ModelRenderer getLeg3() {
        return leg3;
    }

    public ModelRenderer getLeg4() {
        return leg4;
    }
}