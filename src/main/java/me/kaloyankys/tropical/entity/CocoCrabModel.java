// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package me.kaloyankys.tropical.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class CocoCrabModel extends EntityModel<CocoCrabEntity> {
private final ModelPart l_leg;
	private final ModelPart cube_r1;
	private final ModelPart r_leg;
	private final ModelPart cube_r2;
	private final ModelPart body;
	private final ModelPart r_pincer;
	private final ModelPart r_pincer_1;
	private final ModelPart l_pincer;
	private final ModelPart l_pincer_2;
	private final ModelPart head;
	private final ModelPart cube_r3;
public CocoCrabModel() {
		textureWidth = 64;
		textureHeight = 64;
		l_leg = new ModelPart(this);
		l_leg.setPivot(5.0F, 21.0F, 0.0F);
		setRotationAngle(l_leg, 0.0F, 1.5708F, 0.0F);
		

		cube_r1 = new ModelPart(this);
		cube_r1.setPivot(4.0F, 1.0F, 0.0F);
		l_leg.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.4363F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(33, 20).addCuboid(-8.0F, -1.0F, -1.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 28).addCuboid(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r1.setTextureOffset(27, 34).addCuboid(-5.0F, -1.0F, -1.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);

		r_leg = new ModelPart(this);
		r_leg.setPivot(-5.0F, 21.0F, 0.0F);
		setRotationAngle(r_leg, 0.0F, 1.5708F, 0.0F);
		

		cube_r2 = new ModelPart(this);
		cube_r2.setPivot(4.0F, 1.0F, -4.0F);
		r_leg.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.4363F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(9, 30).addCuboid(-8.0F, 1.0F, 0.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r2.setTextureOffset(29, 27).addCuboid(-2.0F, 1.0F, 0.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r2.setTextureOffset(18, 32).addCuboid(-5.0F, 1.0F, 0.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);

		body = new ModelPart(this);
		body.setPivot(0.0F, 20.0F, 0.0F);
		setRotationAngle(body, 0.0F, 1.5708F, 0.0F);
		body.setTextureOffset(0, 0).addCuboid(-5.0F, -3.0F, -6.0F, 10.0F, 6.0F, 12.0F, 0.0F, false);

		r_pincer = new ModelPart(this);
		r_pincer.setPivot(8.0F, 18.0F, -5.0F);
		setRotationAngle(r_pincer, 0.0F, 1.5708F, 0.0F);
		r_pincer.setTextureOffset(18, 25).addCuboid(2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		r_pincer_1 = new ModelPart(this);
		r_pincer_1.setPivot(8.0F, 21.0F, -5.0F);
		setRotationAngle(r_pincer_1, 0.0F, 1.5708F, 0.0F);
		r_pincer_1.setTextureOffset(32, 5).addCuboid(2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		l_pincer = new ModelPart(this);
		l_pincer.setPivot(0.0F, -3.0F, 10.0F);
		r_pincer_1.addChild(l_pincer);
		l_pincer.setTextureOffset(22, 18).addCuboid(1.0F, 0.0F, -25.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		l_pincer_2 = new ModelPart(this);
		l_pincer_2.setPivot(8.0F, 21.0F, 5.0F);
		setRotationAngle(l_pincer_2, 0.0F, 1.5708F, 0.0F);
		l_pincer_2.setTextureOffset(32, 0).addCuboid(11.0F, 0.0F, -15.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setPivot(0.0F, 19.0F, -5.0F);
		setRotationAngle(head, 0.0F, 1.5708F, 0.0F);
		head.setTextureOffset(0, 18).addCuboid(-2.0F, -1.0F, -3.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(6, 4).addCuboid(3.0F, -4.0F, -3.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 4).addCuboid(3.0F, -4.0F, 1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addCuboid(3.0F, 1.0F, -1.0F, 4.0F, 0.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelPart(this);
		cube_r3.setPivot(3.0F, 1.0F, 0.0F);
		head.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.5708F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 2).addCuboid(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, 0.0F, false);
}

	@Override
	public void setAngles(CocoCrabEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		l_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		r_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		r_pincer.render(matrixStack, buffer, packedLight, packedOverlay);
		r_pincer_1.render(matrixStack, buffer, packedLight, packedOverlay);
		l_pincer_2.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}