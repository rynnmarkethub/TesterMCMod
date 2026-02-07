package net.rynnmarkethub.testermod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rynnmarkethub.testermod.TesterMod;
import net.rynnmarkethub.testermod.item.custom.HeartRocketItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TesterMod.MODID);

    public static final DeferredItem<Item> PLAYERCOMPASS = ITEMS.register("playercompass",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ETERNAL_HEART = ITEMS.register("eternalheart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HEART_ROCKET = ITEMS.register("heartrocket",
            () -> new HeartRocketItem(new Item.Properties().stacksTo(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
