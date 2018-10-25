package com.dse.dseMod.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockWeatherFrog extends BlockDirectionedBlock {

	public BlockWeatherFrog() {
		super(Material.ANVIL);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}


}
