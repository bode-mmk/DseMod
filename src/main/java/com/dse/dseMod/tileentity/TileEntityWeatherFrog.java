package com.dse.dseMod.tileentity;

import com.dse.dseMod.DseMod;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityWeatherFrog extends TileEntity implements ITickable{
	@Override
	public void update() {
		// 雨と雷を検知
		if(/* this.world.isRemote && */ this.getBlockType() == DseMod.BLOCKS.weather_frog && this.world.getTotalWorldTime() % 20L == 0L) {
			int power = 0;
			if(this.world.isRaining()) {
				if(this.world.isThundering()) {
					power = 2;
				}else {
					power = 1;
				}
			}

			DseMod.BLOCKS.weather_frog.updatePower(this.world, this.pos, power);
		}
	}
}
