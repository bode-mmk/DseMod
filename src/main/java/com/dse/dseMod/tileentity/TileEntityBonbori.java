package com.dse.dseMod.tileentity;

import com.dse.dseMod.DseMod;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityBonbori extends TileEntity implements ITickable {

	@Override
	public void update() {
		if(this.world != null && !this.world.isRemote && this.world.getTotalWorldTime() % 20L == 0L && (this.getBlockType() == DseMod.BLOCKS.bonbori_on || this.getBlockType() == DseMod.BLOCKS.bonbori_off)) {
			DseMod.BLOCKS.bonbori_off.updateLightPower(this.world, this.pos);
			DseMod.BLOCKS.bonbori_on.updateLightPower(this.world, this.pos);
		}
	}
}
