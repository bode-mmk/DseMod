package com.dse.dseMod.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemKokeshi extends ItemBlock{
	public ItemKokeshi(Block block) {
		super(block);
	}

    public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity)
    {
        return armorType == EntityEquipmentSlot.HEAD;
    }
}
