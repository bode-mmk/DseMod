package com.dse.dseMod.block;

import com.dse.dseMod.DseMod;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockKokeshiEmily extends BlockDirectionedBlock {
	public static final AxisAlignedBB KOKESHI_AABB = new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 0.62D, 0.7D);

	public BlockKokeshiEmily(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setRegistryName("kokeshi_emily");
		this.setUnlocalizedName("kokeshi_emily");
		this.setHardness(0.1f);
	}

	public BlockKokeshiEmily() {
		this(Material.WOOD);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return KOKESHI_AABB;
	}

	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }

	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(DseMod.BLOCK_ITEMS.kokeshi_emily_title_item, 1, 0));
	}

}
