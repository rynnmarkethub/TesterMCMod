package net.rynnmarkethub.testermod.item.custom;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class HeartRocketItem extends Item {
    public HeartRocketItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide) {
            ItemStack itemstack = context.getItemInHand();
            CompoundTag hearttag = new CompoundTag();
            ListTag explosionsList = new ListTag();
            CompoundTag explosion = new CompoundTag();
            Vec3 vec3 = context.getClickLocation();
            Direction direction = context.getClickedFace();


            FireworkRocketEntity fireworkrocketentity = new FireworkRocketEntity(
                    level,
                    context.getPlayer(),
                    vec3.x + (double)direction.getStepX() * 0.15,
                    vec3.y + (double)direction.getStepY() * 0.15,
                    vec3.z + (double)direction.getStepZ() * 0.15,
                    itemstack
            );
            level.addFreshEntity(fireworkrocketentity);
            itemstack.shrink(1);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
