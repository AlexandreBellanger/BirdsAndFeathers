package net.aelion.birds_and_feathers.entity.custom;

import net.aelion.birds_and_feathers.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public abstract class SmallBird extends Animal implements FlyingAnimal {
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    private float flapping = 1.0F;
    private float nextFlap = 1.0F;

    public SmallBird(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 10, false);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
    }

    // TODO: Add a BirdTemptGoal: bird is interested but keeps distance

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));

        this.goalSelector.addGoal(6, new SmallBird.BirdWanderGoal(this, 1.0));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean isFlying() {
        return !this.onGround();
    }

    @Override
    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    @Override
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * 0.6F;
    }

    @Override
    public Vec3 getLeashOffset() {
        return new Vec3(0.0, 0.5F * this.getEyeHeight(), this.getBbWidth() * 0.4F);
    }

    @Override
    protected Vector3f getPassengerAttachmentPoint(Entity pEntity, EntityDimensions pDimensions, float pScale) {
        return new Vector3f(0.0F, pDimensions.height - 0.4375F * pScale, 0.0F);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.calculateFlapping();
    }

    private void calculateFlapping() {
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed += (float)(!this.onGround() && !this.isPassenger() ? 4 : -1) * 0.3F;
        this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.onGround() && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping *= 0.9F;
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && vec3.y < 0.0) {
            this.setDeltaMovement(vec3.multiply(1.0, 0.6, 1.0));
        }

        this.flap += this.flapping * 2.0F;
    }

    @Override
    protected boolean isFlapping() {
        return this.flyDist > this.nextFlap;
    }

    @Override
    protected void onFlap() {
        this.playSound(ModSounds.CROW_FlY.get(), 0.15F, 1.0F);
        this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
    }

    static class BirdWanderGoal extends WaterAvoidingRandomFlyingGoal {
        public BirdWanderGoal(PathfinderMob p_186224_, double p_186225_) {
            super(p_186224_, p_186225_);
        }

        @javax.annotation.Nullable
        @Override
        protected Vec3 getPosition() {
            Vec3 vec3 = null;
            if (this.mob.isInWater()) {
                vec3 = LandRandomPos.getPos(this.mob, 15, 15);
            }

            if (this.mob.getRandom().nextFloat() >= this.probability) {
                vec3 = this.getTreePos();
            }

            return vec3 == null ? super.getPosition() : vec3;
        }

        @javax.annotation.Nullable
        private Vec3 getTreePos() {
            BlockPos blockpos = this.mob.blockPosition();
            BlockPos.MutableBlockPos blockPos$mutableBlockPos = new BlockPos.MutableBlockPos();
            BlockPos.MutableBlockPos blockPos$mutableBlockPos1 = new BlockPos.MutableBlockPos();

            for(BlockPos blockPos1 : BlockPos.betweenClosed(
                    Mth.floor(this.mob.getX() - 3.0),
                    Mth.floor(this.mob.getY() - 6.0),
                    Mth.floor(this.mob.getZ() - 3.0),
                    Mth.floor(this.mob.getX() + 3.0),
                    Mth.floor(this.mob.getY() + 6.0),
                    Mth.floor(this.mob.getZ() + 3.0)
            )) {
                if (!blockpos.equals(blockPos1)) {
                    BlockState blockstate = this.mob.level().getBlockState(
                            blockPos$mutableBlockPos1.setWithOffset(blockPos1, Direction.DOWN));
                    boolean flag = blockstate.getBlock() instanceof LeavesBlock || blockstate.is(BlockTags.LOGS);
                    if (flag
                            && this.mob.level().isEmptyBlock(blockPos1)
                            && this.mob.level().isEmptyBlock(
                            blockPos$mutableBlockPos.setWithOffset(blockPos1, Direction.UP))) {
                        return Vec3.atBottomCenterOf(blockPos1);
                    }
                }
            }

            return null;
        }
    }

    static class BirdTemptGoal extends TemptGoal {

        private final double speedModifier;
        private boolean isFlyingAway;

        public BirdTemptGoal(PathfinderMob pMob, double pSpeedModifier, Ingredient pItems) {
            super(pMob, pSpeedModifier, pItems, false);
            speedModifier = pSpeedModifier;
            isFlyingAway = false;
        }

        @Override
        public void tick() {
            // Look at player
            this.mob.getLookControl().setLookAt(this.player,
                    (float)(this.mob.getMaxHeadYRot() + 20), (float)this.mob.getMaxHeadXRot());


            PathNavigation mobPathNavigation = this.mob.getNavigation();
            double playerDistance = this.mob.distanceToSqr(this.player);
            if (isFlyingAway) {
                // nothing ?
                if (mobPathNavigation.isDone()) {
                    isFlyingAway = false;
                    mobPathNavigation.stop();
                }
            }
            else if (playerDistance < 4) {
                if (!this.player.isCrouching()) {
                    // Player too close, they are scary
                    Vec3 pos = getAwayPos();
                    Path newPath = mobPathNavigation.createPath(pos.x, pos.y, pos.z, 1);
                    mobPathNavigation.moveTo(newPath, this.speedModifier * 1.5);
                    isFlyingAway = true;
                }
            }
            else if (playerDistance < 6.5) {
                mobPathNavigation.stop();
            } else {
                mobPathNavigation.moveTo(this.player, this.speedModifier);
            }
        }

        protected Vec3 getAwayPos() {
            Vec3 awayFromPlayerDirection = this.player.getPosition(0.0F)
                    .vectorTo(this.mob.getPosition(0.0F));

            Vec3 bestPos = null;
            double bestScore = -Double.MAX_VALUE;
            for (int n=0; n<3; ++n) {
                Vec3 pos = HoverRandomPos.getPos(this.mob, 8, 7,
                        awayFromPlayerDirection.x, awayFromPlayerDirection.z,
                        (float) (Math.PI / 2), 3, 1);
                if (pos != null) {
                    double score = pos.y + this.player.distanceToSqr(pos);
                    if (score > bestScore) {
                        bestPos = pos;
                    }
                }
            }

            return bestPos != null ? bestPos
                    : AirAndWaterRandomPos.getPos(this.mob, 8, 4, -2,
                    awayFromPlayerDirection.x, awayFromPlayerDirection.z, (float) (Math.PI / 2));

        }

    }
}
