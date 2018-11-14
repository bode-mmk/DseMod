package com.dse.dseMod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStoneBrickGray extends Block {
	public BlockStoneBrickGray() {
		super(Material.ROCK);
		this.setHardness(0.7f);
		this.setHarvestLevel("pickaxe", 0);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setUnlocalizedName("stonebrick_gray");
		this.setRegistryName("stonebrick_gray");
	}
}
