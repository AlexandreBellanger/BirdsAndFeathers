package net.aelion.birds_and_feathers.entity.custom;

import net.aelion.birds_and_feathers.sound.ModSounds;
import net.aelion.birds_and_feathers.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class Crow extends SmallBird {

    public Crow(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        // TODO: Implement this (see song made by Madilyn Mei)
        // this.goalSelector.addGoal(1, new Crow.KleptomaniacrowQuest(this));
        // TODO: Implement fox like item holding
        // this.goalSelector.addGoal(2, new Crow.PickShinyItem(this));
        this.goalSelector.addGoal(3, new BirdTemptGoal(this, 1.05,
                Ingredient.of(ModTags.Items.CROW_LOVED)));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));

        // TODO: Custom goal(s) to annoy player
        // this.goalSelector.addGoal(4, new FollowPlayerGoal(this, 1.0, 3.0F, 7.0F));
        this.goalSelector.addGoal(6, new SmallBird.BirdWanderGoal(this, 1.0));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 8)
                .add(Attributes.FLYING_SPEED, 0.8)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.FOLLOW_RANGE, 24);
    }

    @Override
    public boolean canMate(Animal pOtherAnimal) {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return false;
    }

    @javax.annotation.Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return ModSounds.CROW_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.CROW_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CROW_DEATH.get();
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(SoundEvents.PARROT_STEP, 0.15F, 1.0F);
    }
}
