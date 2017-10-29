package com.dse.dseMod.event;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropsHandler {
	/* @SubscribeEvent
	public void onMobDrops(LivingDropsEvent event) {
		if(event.getEntity() instanceof EntitySheep) {
			event.getDrops().clear();
		}
	} */

	public MobDropsHandler(){
	//	LootTableList.register(new ResourceLocation(DseMod.MODID,"custom_zombie_drop"));
	}

	@SubscribeEvent
	public void lootLoad(LootTableLoadEvent event) {
	//	if(event.getName().toString().equals("minecraft:entities/zombie")) {
	//		LootEntry entry = new LootEntryTable(new ResourceLocation("dsemod:custom_zombie_drop"), 1, 0, new LootCondition[0], "custom_zombie_drop_loot");
	//		LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "custom_zombie_drop_pool");
	//		event.getTable().addPool(pool);
	//	}
	}
}
