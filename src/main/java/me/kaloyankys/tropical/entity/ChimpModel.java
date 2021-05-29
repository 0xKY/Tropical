// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package me.kaloyankys.tropical.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ChimpModel extends BipedEntityModel<ChimpEntity> {
private final ModelPart body;
	private final ModelPart head;
	private final ModelPart arm0;
	private final ModelPart arm1;
	private final ModelPart leg0;
	private final ModelPart leg1;
public ChimpModel() {
	super(1.0f);
	textureWidth = 128;
		textureHeight = 128;
		body = new ModelPart(this);
		body.setPivot(0.0F, -7.0F, 0.0F);
		body.setTextureOffset(0, 0).addCuboid(-7.0F, -1.0F, -6.0F, 14.0F, 20.0F, 8.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setPivot(0.0F, -7.0F, -2.0F);
		head.setTextureOffset(0, 28).addCuboid(-5.0F, -11.0F, -4.5F, 10.0F, 10.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(17, 47).addCuboid(-4.0F, -6.0F, -5.5F, 8.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(36, 0).addCuboid(5.0F, -9.0F, -1.5F, 4.0F, 5.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(28, 28).addCuboid(-9.0F, -9.0F, -1.5F, 4.0F, 5.0F, 1.0F, 0.0F, false);

		arm0 = new ModelPart(this);
		arm0.setPivot(0.0F, -7.0F, 0.0F);
		arm0.setTextureOffset(44, 0).addCuboid(7.0F, 0.0F, -5.0F, 5.0F, 22.0F, 6.0F, 0.0F, false);

		arm1 = new ModelPart(this);
		arm1.setPivot(0.0F, -7.0F, 0.0F);
		arm1.setTextureOffset(36, 28).addCuboid(-12.0F, 0.0F, -5.0F, 5.0F, 22.0F, 6.0F, 0.0F, false);

		leg0 = new ModelPart(this);
		leg0.setPivot(4.0F, 11.0F, 0.0F);
		leg0.setTextureOffset(53, 51).addCuboid(-3.5F, 1.0F, -5.0F, 6.0F, 12.0F, 5.0F, 0.0F, false);

		leg1 = new ModelPart(this);
		leg1.setPivot(-5.0F, 11.0F, 0.0F);
		leg1.setTextureOffset(0, 46).addCuboid(-1.5F, 1.0F, -5.0F, 6.0F, 12.0F, 5.0F, 0.0F, false);
}
	public void setAngles(ChimpEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.arm0.pitch = -0.5F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
		this.arm1.pitch = 0.5F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
		this.leg0.pitch = -0.5F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
		this.leg1.pitch = 0.5F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
		this.body.yaw = 0.7F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
		this.head.pitch = -1.2F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
	}

	@Override
	public void animateModel(ChimpEntity entity, float limbAngle, float limbDistance, float tickDelta) {
		this.head.pitch = (-0.2F + 1.5F * MathHelper.method_24504(limbAngle, 13.0F)) * limbDistance;
	}

@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		arm0.render(matrixStack, buffer, packedLight, packedOverlay);
		arm1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg0.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}