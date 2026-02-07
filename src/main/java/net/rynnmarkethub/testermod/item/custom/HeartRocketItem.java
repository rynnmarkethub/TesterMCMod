package net.rynnmarkethub.testermod.item.custom;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.Fireworks;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rynnmarkethub.testermod.item.ModItems;

import java.util.List;

public class HeartRocketItem extends Item {
    public HeartRocketItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide) {
            ItemStack heartRocketItem = new ItemStack(ModItems.HEART_ROCKET.get());
            FireworkExplosion customExplosion = new FireworkExplosion(
                    FireworkExplosion.Shape.LARGE_BALL,
                    IntArrayList.of(0x0000FF, 0x008000),
                    IntArrayList.of(0xFFC0CB),
                    true,
                    true
            );

            List<FireworkExplosion> explosions = List.of(customExplosion);
            heartRocketItem.set(DataComponents.FIREWORKS, new Fireworks(2, explosions));
            Vec3 vec3 = context.getClickLocation();
            Direction direction = context.getClickedFace();


            FireworkRocketEntity fireworkrocketentity = new FireworkRocketEntity(
                    level,
                    context.getPlayer(),
                    vec3.x + (double)direction.getStepX() * 0.15,
                    vec3.y + (double)direction.getStepY() * 0.15,
                    vec3.z + (double)direction.getStepZ() * 0.15,
                    heartRocketItem
            );
            level.addFreshEntity(fireworkrocketentity);
            heartRocketItem.shrink(1);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
