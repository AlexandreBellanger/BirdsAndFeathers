package net.aelion.birds_and_feathers.entity.client;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.aelion.birds_and_feathers.entity.custom.Crow;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class CrowModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart crow;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart leftWing;
	private final ModelPart rightWing;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;

	public CrowModel(ModelPart root) {
		this.crow = root.getChild("crow");
		this.body = crow.getChild("body");
		this.head = crow.getChild("head");
		this.tail = crow.getChild("tail");
		this.leftWing = crow.getChild("left_wing");
		this.rightWing = crow.getChild("right_wing");
		this.leftLeg = crow.getChild("left_leg");
		this.rightLeg = crow.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition crow = partdefinition.addOrReplaceChild("crow", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition head = crow.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 12).addBox(-2.0F, -1.25F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(20, 18).addBox(-1.0F, 0.4F, -5.3F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -7.0F, -3.0F));

		PartDefinition beak_top_r1 = head.addOrReplaceChild("beak_top_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, -3.4624F, -7.372F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9137F, 2.4413F, 0.3927F, 0.0F, 0.0F));

		PartDefinition body = crow.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 1.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.6742F, -3.1283F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0863F, -1.5587F, -0.4363F, 0.0F, 0.0F));

		PartDefinition left_leg = crow.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 4).addBox(-0.75F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(2, 12).addBox(-0.25F, 1.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(5, 1).addBox(-0.25F, 4.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -3.0F, 0.5F));

		PartDefinition left_wing = crow.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(2.5F, -8.0F, -2.0F));

		PartDefinition left_wing_r1 = left_wing.addOrReplaceChild("left_wing_r1", CubeListBuilder.create().texOffs(10, 15).addBox(2.5F, -1.9481F, -2.5595F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.9137F, 1.4413F, -0.2182F, 0.0F, 0.0F));

		PartDefinition right_wing = crow.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-2.5F, -8.0F, -2.0F));

		PartDefinition right_wing_r1 = right_wing.addOrReplaceChild("right_wing_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-3.5F, -1.9481F, -2.5595F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.9137F, 1.4413F, -0.2182F, 0.0F, 0.0F));

		PartDefinition tail = crow.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, 4.0F));

		PartDefinition right_leg = crow.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-0.75F, 1.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(5, 0).addBox(-0.75F, 4.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -3.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void prepareMobModel(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
		prepare(getState((Crow) pEntity));
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks,
						  float netHeadYaw, float headPitch) {

		CrowModel.State state = getState((Crow) entity);
		applyHeadRotation(netHeadYaw, headPitch);
		applyLimbSwing(state, limbSwing, limbSwingAmount, ageInTicks);
	}

	private void applyLimbSwing(CrowModel.State state, float limbSwing, float limbSwingAmount, float ageInTicks) {
		switch (state) {
			case STANDING:
				this.leftLeg.xRot += Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.rightLeg.xRot += Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
				break;
			case FLYING:
				this.tail.xRot = 1.015F + Mth.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
				this.leftWing.zRot = -0.0873F - ageInTicks;
				this.rightWing.zRot = 0.0873F + ageInTicks;
				break;
		}
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);

		this.head.yRot = netHeadYaw * ((float) Math.PI / 100f);
		this.head.xRot = headPitch * ((float) Math.PI / 100f);
	}

	private void prepare(CrowModel.State state) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		switch (state) {
			case STANDING:
				break;
			case FLYING:
				this.leftLeg.xRot += (float) (Math.PI * 2.0 / 9.0);
				this.rightLeg.xRot += (float) (Math.PI * 2.0 / 9.0);
				break;
		}
	}

	private static CrowModel.State getState(Crow crowEntity) {
		return crowEntity.isFlying() ? State.FLYING : State.STANDING;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
							   float red, float green, float blue, float alpha) {
		crow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return crow;
	}

	@OnlyIn(Dist.CLIENT)
	public enum State {
		FLYING,
		STANDING
    }
}