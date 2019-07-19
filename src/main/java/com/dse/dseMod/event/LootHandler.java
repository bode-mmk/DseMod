package com.dse.dseMod.event;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class LootHandler {
	public LootHandler() {
		LootTableList.register(new ResourceLocation("dsemod:dse_abandoned_mineshaft"));
		LootTableList.register(new ResourceLocation("dsemod:dse_desert_pyramid"));
		LootTableList.register(new ResourceLocation("dsemod:dse_jungle_temple"));
		LootTableList.register(new ResourceLocation("dsemod:dse_simple_dungeon"));
	}

	@SubscribeEvent
	public void lootLoad(LootTableLoadEvent evt) {
		if(evt.getName().toString().equals("minecraft:chests/abandoned_mineshaft")) {
			LootEntry entry = new LootEntryTable(new ResourceLocation("dsemod:dse_abandoned_mineshaft"), 1, 0, new LootCondition[0], "dse_abandoned_mineshaft_entry");
			LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "dse_abndoned_mineshaft_pool");

			evt.getTable().addPool(pool);
		}else if(evt.getName().toString().equals("minecraft:chests/desert_pyramid")) {
			LootEntry entry = new LootEntryTable(new ResourceLocation("dsemod:dse_desert_pyramid"), 1, 0, new LootCondition[0], "dse_desert_pyramid_entry");
			LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "dse_desert_pyramid_pool");

			evt.getTable().addPool(pool);
		}else if(evt.getName().toString().equals("minecraft:chests/jungle_temple")) {
			LootEntry entry = new LootEntryTable(new ResourceLocation("dsemod:dse_jungle_temple"), 1, 0, new LootCondition[0], "dse_jungle_temple_entry");
			LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "dse_jungle_temple_pool");

			evt.getTable().addPool(pool);
		}else if(evt.getName().toString().equals("minecraft:chests/simple_dungeon")) {
			LootEntry entry = new LootEntryTable(new ResourceLocation("dsemod:dse_simple_dungeon"), 1, 0, new LootCondition[0], "dse_simple_dungeon_entry");
			LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "dse_simple_dungeon_pool");

			evt.getTable().addPool(pool);
		}
	}
}
