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
		crow = root.getChild("crow");
		body = crow.getChild("body");
		head = crow.getChild("head");
		tail = crow.getChild("tail");
		leftWing = crow.getChild("left_wing");
		rightWing = crow.getChild("right_wing");
		leftLeg = crow.getChild("left_leg");
		rightLeg = crow.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition crow = partdefinition.addOrReplaceChild("crow", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition head = crow.addOrReplaceChild("head", CubeListBuilder.create().texOffs(19, 11).addBox(-2.0F, -2.25F, -3.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -3.0F));

		PartDefinition beak_bottom_r1 = head.addOrReplaceChild("beak_bottom_r1", CubeListBuilder.create().texOffs(20, 18).addBox(-1.0F, -0.2619F, -1.3413F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.2509F, -3.5867F, -0.0436F, 0.0F, 0.0F));

		PartDefinition beak_top_r1 = head.addOrReplaceChild("beak_top_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, -0.7807F, -1.5555F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2509F, -3.5867F, 0.3491F, 0.0F, 0.0F));

		PartDefinition body = crow.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 1.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.6742F, -3.1283F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0863F, -1.5587F, -0.7418F, 0.0F, 0.0F));

		PartDefinition left_leg = crow.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 4).addBox(-0.75F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(2, 12).addBox(-0.25F, 1.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(5, 1).addBox(-0.25F, 4.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -3.0F, 0.5F));

		PartDefinition left_wing = crow.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(2.5F, -8.0F, -2.0F));

		PartDefinition cube_r2 = left_wing.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 15).addBox(2.5F, -1.9481F, -2.5595F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.9137F, 1.4413F, -0.5236F, 0.0F, 0.0F));

		PartDefinition right_wing = crow.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-2.5F, -8.0F, -2.0F));

		PartDefinition cube_r3 = right_wing.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 12).addBox(-3.5F, -1.9481F, -2.5595F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.9137F, 1.4413F, -0.5236F, 0.0F, 0.0F));

		PartDefinition tail = crow.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -5.5F, 4.0F));

		PartDefinition cube_r4 = tail.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0863F, 3.5587F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5863F, -4.5587F, -0.2182F, 0.0F, 0.0F));

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
		applyHeadRotation(netHeadYaw, headPitch, state);
		applyLimbSwing(state, limbSwing, limbSwingAmount, ageInTicks);
	}

	private void applyLimbSwing(CrowModel.State state, float limbSwing, float limbSwingAmount, float ageInTicks) {
		switch (state) {
			case STANDING:
				leftLeg.xRot += Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				rightLeg.xRot += Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
				break;
			case FLYING:
				tail.xRot += Mth.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
				leftWing.zRot = -ageInTicks;
				rightWing.zRot = ageInTicks;
				break;
		}
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch, State state) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);

		head.yRot = netHeadYaw * ((float) Math.PI / 100f);
		if (!(state == State.FLYING))
			head.xRot = headPitch * ((float) Math.PI / 100f);
	}

	private void prepare(CrowModel.State state) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		switch (state) {
			case STANDING:
				break;
			case FLYING:
				crow.xRot += (float) (Math.PI / 8.0);
				head.xRot -= (float) (Math.PI / 8.0);
				tail.xRot -= (float) (Math.PI * 3.0 / 32.0);
				leftLeg.xRot += (float) (Math.PI * 2.0 / 9.0);
				rightLeg.xRot += (float) (Math.PI * 2.0 / 9.0);
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