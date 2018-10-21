package com.dse.dseMod.block;

import java.util.Random;

import com.dse.dseMod.DseMod;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public abstract class BlockAodatami extends BlockDirectionedSlab {
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);

	public BlockAodatami() {
		super();
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(0.1f);
	}

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return DseMod.BLOCK_ITEMS.aodatami_slab_tile_item;
    }

	public static class Double extends BlockAodatami
	{
		public Double() {
			super();
			this.setUnlocalizedName("aodatami_slab_double");
			this.setRegistryName("aodatami_slab_double");
		}

		@Override
		public boolean isDouble() {
			return true;
		}
	}

	public static class Half extends BlockAodatami
	{

		public Half() {
			super();
			this.setUnlocalizedName("aodatami_slab");
			this.setRegistryName("aodatami_slab");
		}

		@Override
		public boolean isDouble() {
			return false;
		}
	}
}
