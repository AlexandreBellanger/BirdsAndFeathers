package net.aelion.birds_and_feathers.items.custom;

import net.aelion.birds_and_feathers.tags.ModTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FeatherArmorItem extends ArmorItem {
    private static final MobEffectInstance FEATHER_ARMOR_EFFECT =
            new MobEffectInstance(MobEffects.SLOW_FALLING,20, 1,
                    false, true, true);

    public FeatherArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (isTolerableToPhantoms(player)) {
                applyArmorEffect(player);
            }
        }
    }

    private void applyArmorEffect(Player player) {
        if (!player.hasEffect(FEATHER_ARMOR_EFFECT.getEffect()))
            player.addEffect(new MobEffectInstance(FEATHER_ARMOR_EFFECT));
    }

    public boolean isTolerableToPhantoms(Player player) {
        boolean hasFeatherArmor = false;
        for (ItemStack armorStack: player.getArmorSlots()) {
            // Player can have some empty armor slot
            if (armorStack.isEmpty()) continue;
            // They can also wear some non-armor items (heads, pumpkin, elytra)
            if (!(armorStack.getItem() instanceof ArmorItem)) continue;
            // But they need at least one piece of feather armor
            if (armorStack.is(ModTags.Items.TOLERATED_BY_PHANTOMS)) hasFeatherArmor = true;
            // And they can not wear any other kind of armor
            else return false;
        }
        return hasFeatherArmor;
    }

}
