package com.dse.dseMod.worldgen;

import java.util.Random;

import com.dse.dseMod.DseMod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenDseFlower implements IWorldGenerator {
	public WorldGenDseFlower() {
	}

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		//:DEBUG
		//System.out.println("debug");

		Block list[] = {
				DseMod.BLOCKS.flower_cosmos,
				DseMod.BLOCKS.flower_dianthus,
				DseMod.BLOCKS.flower_gentiana,
				DseMod.BLOCKS.flower_lycoris,
				DseMod.BLOCKS.flower_myosotis
		};


		// TODO 自動生成されたメソッド・スタブ
		Block flower = list[rand.nextInt(list.length)];

		BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
		if(worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && (worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS )) {
			System.out.println("x:"+blockpos.getX()+" y:"+blockpos.getY()+" z:"+blockpos.getZ());
			worldIn.setBlockState(blockpos, flower.getDefaultState());
		}

		return true;
	}


	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		// TODO 自動生成されたメソッド・スタブ
		if(world.provider instanceof WorldProviderSurface) {
			this.generate(world, random, new BlockPos(chunkX * 16, world.getHeight(chunkX * 16, chunkZ * 16), chunkZ * 16));
		}
	}

}
