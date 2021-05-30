// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package me.kaloyankys.tropical.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ToucanModel extends EntityModel<ToucanEntity> {
private final ModelPart body;
	private final ModelPart cube_r1;
	private final ModelPart head;
	private final ModelPart wing;
	private final ModelPart wing2;
	private final ModelPart legs;
	private final ModelPart tail;
public ToucanModel() {
	textureWidth = 64;
	textureHeight = 64;
	body = new ModelPart(this);
	body.setPivot(0.0F, 16.6679F, -0.204F);
	setRotationAngle(body, 0.1745F, 3.1416F, 0.0F);


	cube_r1 = new ModelPart(this);
	cube_r1.setPivot(0.0F, 0.2561F, 3.9277F);
	body.addChild(cube_r1);
	setRotationAngle(cube_r1, 1.0472F, 0.0F, 0.0F);
	cube_r1.setTextureOffset(0, 0).addCuboid(-3.0F, -6.0F, -7.0F, 6.0F, 5.0F, 10.0F, 0.0F, false);

	head = new ModelPart(this);
	head.setPivot(0.0F, 11.0F, -2.0F);
	setRotationAngle(head, 0.0F, 3.1416F, 0.0F);
	head.setTextureOffset(0, 15).addCuboid(-2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
	head.setTextureOffset(22, 0).addCuboid(-1.0F, -2.0F, 1.0F, 2.0F, 3.0F, 5.0F, 0.0F, false);
	head.setTextureOffset(12, 15).addCuboid(-1.0F, 1.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

	wing = new ModelPart(this);
	wing.setPivot(4.0F, 12.4626F, 0.6237F);
	setRotationAngle(wing, -0.3491F, 3.1416F, 0.0F);
	wing.setTextureOffset(23, 23).addCuboid(0.0F, -0.342F, -0.0603F, 1.0F, 8.0F, 5.0F, 0.0F, false);

	wing2 = new ModelPart(this);
	wing2.setPivot(-4.0F, 12.684F, 0.8794F);
	setRotationAngle(wing2, -0.3491F, 3.1416F, 0.0F);
	wing2.setTextureOffset(16, 15).addCuboid(-1.0F, -0.342F, -0.0603F, 1.0F, 8.0F, 5.0F, 0.0F, false);

	legs = new ModelPart(this);
	legs.setPivot(0.0F, 21.0F, 2.0F);
	setRotationAngle(legs, 0.0F, 3.1416F, 0.0F);
	legs.setTextureOffset(0, 5).addCuboid(1.05F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
	legs.setTextureOffset(0, 0).addCuboid(-3.05F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
	legs.setTextureOffset(23, 15).addCuboid(-3.05F, 2.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
	legs.setTextureOffset(22, 8).addCuboid(1.05F, 2.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

	tail = new ModelPart(this);
	tail.setPivot(1.0F, 17.8519F, 2.9239F);
	setRotationAngle(tail, -1.1781F, 3.1416F, 0.0F);
	tail.setTextureOffset(0, 26).addCuboid(-2.0F, -2.9239F, 0.3827F, 6.0F, 7.0F, 0.0F, 0.0F, false);
}
	@Override
	public void setAngles(ToucanEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch)
	{
		this.head.pitch = -1.2F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
		this.wing.pitch = -1.2F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
		this.wing2.pitch = -1.2F * MathHelper.method_24504(limbAngle, 13.0F) * limbDistance;
		this.wing.roll = -2.0F + 1.5F * MathHelper.method_24504(1.0F, 13.0F);
		this.wing2.roll = 2.0F * MathHelper.method_24504(1.0F, 13.0F);
	}
	@Override
	public void animateModel(ToucanEntity entity, float limbAngle, float limbDistance, float tickDelta)
	{
		this.wing.pitch = 2.0F + 1.5F * MathHelper.method_24504(1.0F, 13.0F);
		this.wing2.pitch = 2.0F + 1.5F * MathHelper.method_24504(1.0F, 13.0F);
		this.wing.roll = -2.0F + 1.5F * MathHelper.method_24504(1.0F, 13.0F);
		this.wing2.roll = 2.0F * MathHelper.method_24504(1.0F, 13.0F);
		this.legs.pitch = (-0.2F + 1.5F * MathHelper.method_24504(limbAngle, 13.0F)) * limbDistance;
		this.head.pitch = (-0.2F + 1.5F * MathHelper.method_24504(limbAngle, 13.0F)) * limbDistance;
		this.body.pitch = (-0.2F + 0.5F * MathHelper.method_24504(limbAngle, 13.0F)) * limbDistance;
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		wing2.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		wing.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		legs.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}}