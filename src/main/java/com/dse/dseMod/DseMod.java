package com.dse.dseMod;

import com.dse.dseMod.block.BlockAodatami;
import com.dse.dseMod.block.BlockBonbori;
import com.dse.dseMod.block.BlockFlowerCosmos;
import com.dse.dseMod.block.BlockFlowerDianthus;
import com.dse.dseMod.block.BlockFlowerGentiana;
import com.dse.dseMod.block.BlockFlowerLycoris;
import com.dse.dseMod.block.BlockFlowerMyosotis;
import com.dse.dseMod.block.BlockKidatami;
import com.dse.dseMod.block.BlockMame;
import com.dse.dseMod.block.BlockNormalStairs;
import com.dse.dseMod.block.BlockRailDse;
import com.dse.dseMod.block.BlockStoneBrickBlack;
import com.dse.dseMod.block.BlockStoneBrickBlackSlab;
import com.dse.dseMod.block.BlockStoneBrickGray;
import com.dse.dseMod.block.BlockWeatherFrog;
import com.dse.dseMod.entity.EntityDsecart;
import com.dse.dseMod.entity.EntityDsecartEmpty;
import com.dse.dseMod.item.Dsecart;
import com.dse.dseMod.item.ItemDirectionedSlab;
import com.dse.dseMod.item.ItemNormalSlab;
import com.dse.dseMod.item.MamedolEgg;
import com.dse.dseMod.item.MamedolSeeds;
import com.dse.dseMod.item.MamedolSeedsIrimame;
import com.dse.dseMod.potion.PotionHannari;
import com.dse.dseMod.proxy.CommonProxy;
import com.dse.dseMod.record.ImasRecord;
import com.dse.dseMod.tileentity.TileEntityBonbori;
import com.dse.dseMod.tileentity.TileEntityWeatherFrog;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = DseMod.MODID, version = DseMod.VERSION)
@EventBusSubscriber
public class DseMod {
	public static final String  MODID = "dsemod";
	public static final String  VERSION = "0.2.0.6";
	// world generator holder
	//public static class WORLD_GEN {
	//	public static IWorldGenerator dse_flower_generator = new com.dse.dseMod.worldgen.WorldGenDseFlower();
	//}

	// mamedol holder
	public static class MAMEDOLS {
		// AS
		public static Item as_azusa = new com.dse.dseMod.mamedol.as.Azusa();
		public static Item as_chihaya = new com.dse.dseMod.mamedol.as.Chihaya();
		public static Item as_hibiki = new com.dse.dseMod.mamedol.as.Hibiki();
		public static Item as_iori = new com.dse.dseMod.mamedol.as.Iori();
		public static Item as_yayoi = new com.dse.dseMod.mamedol.as.Yayoi();
		public static Item as_yukiho = new com.dse.dseMod.mamedol.as.Yukiho();

		// CG
		public static Item cg_anzu = new com.dse.dseMod.mamedol.cg.Anzu();
		public static Item cg_ayame = new com.dse.dseMod.mamedol.cg.Ayame();
		public static Item cg_chieri = new com.dse.dseMod.mamedol.cg.Chieri();
		public static Item cg_clarice = new com.dse.dseMod.mamedol.cg.Clarice();
		public static Item cg_emi = new com.dse.dseMod.mamedol.cg.Emi();
		public static Item cg_kaede = new com.dse.dseMod.mamedol.cg.Kaede();
		public static Item cg_kanako = new com.dse.dseMod.mamedol.cg.Kanako();
		public static Item cg_kaoru = new com.dse.dseMod.mamedol.cg.Kaoru();
		public static Item cg_karin = new com.dse.dseMod.mamedol.cg.Karin();
		public static Item cg_kirari = new com.dse.dseMod.mamedol.cg.Kirari();
		public static Item cg_lyla = new com.dse.dseMod.mamedol.cg.Lyla();
		public static Item cg_miku = new com.dse.dseMod.mamedol.cg.Miku();
		public static Item cg_momoka = new com.dse.dseMod.mamedol.cg.Momoka();
		public static Item cg_nanami = new com.dse.dseMod.mamedol.cg.Nanami();
		public static Item cg_natsuki = new com.dse.dseMod.mamedol.cg.Natsuki();
		public static Item cg_nina = new com.dse.dseMod.mamedol.cg.Nina();
		public static Item cg_sachiko = new com.dse.dseMod.mamedol.cg.Sachiko();
		public static Item cg_sae = new com.dse.dseMod.mamedol.cg.Sae();
		public static Item cg_syuko = new com.dse.dseMod.mamedol.cg.Syuko();
		public static Item cg_takumi = new com.dse.dseMod.mamedol.cg.Takumi();
		public static Item cg_tamami = new com.dse.dseMod.mamedol.cg.Tamami();
		public static Item cg_yoshino = new com.dse.dseMod.mamedol.cg.Yoshino();
		public static Item cg_yuko = new com.dse.dseMod.mamedol.cg.Yuko();

		// ML
		public static Item ml_anna = new com.dse.dseMod.mamedol.ml.Anna();
		public static Item ml_arisa = new com.dse.dseMod.mamedol.ml.Arisa();
		public static Item ml_emily = new com.dse.dseMod.mamedol.ml.Emily();
		public static Item ml_iku = new com.dse.dseMod.mamedol.ml.Iku();
		public static Item ml_kana = new com.dse.dseMod.mamedol.ml.Kana();
		public static Item ml_matsuri = new com.dse.dseMod.mamedol.ml.Matsuri();
		public static Item ml_momoko = new com.dse.dseMod.mamedol.ml.Momoko();
		public static Item ml_nao = new com.dse.dseMod.mamedol.ml.Nao();
		public static Item ml_serika = new com.dse.dseMod.mamedol.ml.Serika();
		public static Item ml_tomoka = new com.dse.dseMod.mamedol.ml.Tomoka();
		public static Item ml_yuriko = new com.dse.dseMod.mamedol.ml.Yuriko();
	}

	// item holder
	public static class ITEMS{
		public static Item dsecart = new Dsecart(
				EntityMinecart.Type.RIDEABLE
				)
				.setUnlocalizedName("dsecart")
				.setRegistryName("dsecart");

		public static Item mamedol_seeds = new MamedolSeeds(
				1, 0.3F,DseMod.BLOCKS.mame, DseMod.BLOCKS.mame )
				.setUnlocalizedName("mamedol_seeds")
				.setRegistryName("mamedol_seeds");

		public static Item mamedol_seeds_irimame = new MamedolSeedsIrimame(
				2, 0.31F, DseMod.BLOCKS.mame, null )
				.setCreativeTab(CreativeTabs.FOOD)
				.setUnlocalizedName("mamedol_seeds_irimame")
				.setRegistryName("mamedol_seeds_irimame");

		public static Item mamedol_egg =  new MamedolEgg()
				.setCreativeTab(CreativeTabs.FOOD)
				.setUnlocalizedName("mamedol_egg")
				.setRegistryName("mamedol_egg");
	}

	// block holder
	public static class BLOCKS{
		public static Block mame = new BlockMame()
				.setUnlocalizedName("block_mame")
				.setRegistryName("block_mame");
		public static Block rail_dse = new BlockRailDse()
				.setCreativeTab(CreativeTabs.TRANSPORTATION)
				.setUnlocalizedName("rail_dse")
				.setRegistryName("rail_dse");
		public static Block flower_cosmos = new BlockFlowerCosmos()
				.setCreativeTab(CreativeTabs.DECORATIONS)
				.setUnlocalizedName("flower_cosmos")
				.setRegistryName("flower_cosmos");
		public static Block flower_myosotis = new BlockFlowerMyosotis()
				.setCreativeTab(CreativeTabs.DECORATIONS)
				.setUnlocalizedName("flower_myosotis")
				.setRegistryName("flower_myosotis");
		public static Block flower_dianthus = new BlockFlowerDianthus()
				.setCreativeTab(CreativeTabs.DECORATIONS)
				.setUnlocalizedName("flower_dianthus")
				.setRegistryName("flower_dianthus");
		public static Block flower_lycoris = new BlockFlowerLycoris()
				.setCreativeTab(CreativeTabs.DECORATIONS)
				.setUnlocalizedName("flower_lycoris")
				.setRegistryName("flower_lycoris");
		public static Block flower_gentiana = new BlockFlowerGentiana()
				.setCreativeTab(CreativeTabs.DECORATIONS)
				.setUnlocalizedName("flower_gentiana")
				.setRegistryName("flower_gentiana");
		public static BlockStoneBrickBlack stonebrick_black = new BlockStoneBrickBlack();
		public static BlockStoneBrickGray stonebrick_gray = new BlockStoneBrickGray();
		public static BlockBonbori bonbori_off = new BlockBonbori(false);
		public static BlockBonbori bonbori_on = new BlockBonbori(true);
		public static BlockWeatherFrog weather_frog = new BlockWeatherFrog();
		public static BlockAodatami aodatami_slab = new BlockAodatami.Half();
		public static BlockAodatami aodatami_slab_double = new BlockAodatami.Double();
		public static BlockKidatami kidatami_slab = new BlockKidatami.Half();
		public static BlockKidatami kidatami_slab_double = new BlockKidatami.Double();
		public static BlockStoneBrickBlackSlab stonebrick_black_slab = new BlockStoneBrickBlackSlab.Half();
		public static BlockStoneBrickBlackSlab stonebrick_black_slab_double = new BlockStoneBrickBlackSlab.Double();
		public static Block stonebrick_black_stairs = new BlockNormalStairs(stonebrick_black.getDefaultState()).setRegistryName("stonebrick_black_stairs");
	}

	public static class BLOCK_ITEMS{
		public static Item rail_dse_tile_item = new ItemBlock(BLOCKS.rail_dse)
				.setRegistryName(BLOCKS.rail_dse.getRegistryName());
		public static Item flower_cosmos_tile_item = new ItemBlock(BLOCKS.flower_cosmos)
				.setRegistryName(BLOCKS.flower_cosmos.getRegistryName());
		public static Item flower_myosotis_tile_item = new ItemBlock(BLOCKS.flower_myosotis)
				.setRegistryName(BLOCKS.flower_myosotis.getRegistryName());
		public static Item flower_dianthus_tile_item = new ItemBlock(BLOCKS.flower_dianthus)
				.setRegistryName(BLOCKS.flower_dianthus.getRegistryName());
		public static Item flower_lycoris_tile_item = new ItemBlock(BLOCKS.flower_lycoris)
				.setRegistryName(BLOCKS.flower_lycoris.getRegistryName());
		public static Item flower_gentiala_tile_item = new ItemBlock(BLOCKS.flower_gentiana)
				.setRegistryName(BLOCKS.flower_gentiana.getRegistryName());
		public static Item bonbori_tile_item = new ItemBlock(BLOCKS.bonbori_off)
				.setRegistryName(BLOCKS.bonbori_off.getRegistryName());
		public static Item weather_frog_tile_item = new ItemBlock(BLOCKS.weather_frog)
				.setRegistryName(BLOCKS.weather_frog.getRegistryName());
		public static Item aodatami_slab_tile_item = new ItemDirectionedSlab(BLOCKS.aodatami_slab, BLOCKS.aodatami_slab, BLOCKS.aodatami_slab_double).setRegistryName(BLOCKS.aodatami_slab.getRegistryName());
		public static Item kidatami_slab_tile_item = new ItemDirectionedSlab(BLOCKS.kidatami_slab, BLOCKS.kidatami_slab, BLOCKS.kidatami_slab_double).setRegistryName(BLOCKS.kidatami_slab.getRegistryName());
		public static Item stonebrick_black_slab_tile_item = new ItemNormalSlab(BLOCKS.stonebrick_black_slab, BLOCKS.stonebrick_black_slab, BLOCKS.stonebrick_black_slab_double).setRegistryName(BLOCKS.stonebrick_black_slab.getRegistryName());
		public static Item stonebrick_black_tile_item = new ItemBlock(BLOCKS.stonebrick_black).setRegistryName(BLOCKS.stonebrick_black.getRegistryName());
		public static Item stonebrick_black_stairs_tile_item = new ItemBlock(BLOCKS.stonebrick_black_stairs).setRegistryName(BLOCKS.stonebrick_black_stairs.getRegistryName());
		public static Item stonebrick_gray_tile_item =new ItemBlock(BLOCKS.stonebrick_gray).setRegistryName(BLOCKS.stonebrick_gray.getRegistryName());
	}

	// sound event holder
	public static class SOUNDS{
		public static SoundEvent ankirakyousoukyoku =
				new SoundEvent(new ResourceLocation("dsemod", "imas_records/ankirakyousoukyoku"))
				.setRegistryName("imas_record_ankirakyousoukyoku");
		public static SoundEvent sakuranokoro =
				new SoundEvent(new ResourceLocation("dsemod", "imas_records/sakuranokoro"))
				.setRegistryName("imas_record_sakuranokoro");
	}

	// record holder
	public static class IMAS_RECORDS{
		public static Item ankirakyousoukyoku= new ImasRecord("ankirakyousoukyoku", SOUNDS.ankirakyousoukyoku, "item.imas_record.ankirakyousoukyoku.desc")
				.setUnlocalizedName("record")
				.setRegistryName("imas_record_ankirakyousoukyoku");
		public static Item sakuranokoro = new ImasRecord("sakuranokoro", SOUNDS.sakuranokoro, "item.imas_record.sakuranokoro.desc")
				.setUnlocalizedName("record")
				.setRegistryName("imas_record_sakuranokoro");
	}

	// potion effect holder
	public static class POTIONS{
		public static Potion hannari = new PotionHannari(false, 0)
		.setRegistryName("potion_hannari")
		.setPotionName("potion.hannari");
	}

	// create proxy
	@SidedProxy(clientSide="com.dse.dseMod.proxy.ClientProxy", serverSide="com.dse.dseMod.proxy.CommonProxy")
	static private CommonProxy proxy;

	@SubscribeEvent
	protected static void registerItems(RegistryEvent.Register<Item> event){
		event.getRegistry().registerAll(
				MAMEDOLS.as_azusa,
				MAMEDOLS.as_chihaya,
				MAMEDOLS.as_hibiki,
				MAMEDOLS.as_iori,
				MAMEDOLS.as_yayoi,
				MAMEDOLS.as_yukiho,

				MAMEDOLS.cg_anzu,
				MAMEDOLS.cg_ayame,
				MAMEDOLS.cg_chieri,
				MAMEDOLS.cg_clarice,
				MAMEDOLS.cg_emi,
				MAMEDOLS.cg_kaede,
				MAMEDOLS.cg_kanako,
				MAMEDOLS.cg_kaoru,
				MAMEDOLS.cg_karin,
				MAMEDOLS.cg_kirari,
				MAMEDOLS.cg_lyla,
				MAMEDOLS.cg_miku,
				MAMEDOLS.cg_momoka,
				MAMEDOLS.cg_nanami,
				MAMEDOLS.cg_natsuki,
				MAMEDOLS.cg_nina,
				MAMEDOLS.cg_sachiko,
				MAMEDOLS.cg_sae,
				MAMEDOLS.cg_syuko,
				MAMEDOLS.cg_takumi,
				MAMEDOLS.cg_tamami,
				MAMEDOLS.cg_yoshino,
				MAMEDOLS.cg_yuko,

				MAMEDOLS.ml_anna,
				MAMEDOLS.ml_arisa,
				MAMEDOLS.ml_emily,
				MAMEDOLS.ml_iku,
				MAMEDOLS.ml_kana,
				MAMEDOLS.ml_matsuri,
				MAMEDOLS.ml_momoko,
				MAMEDOLS.ml_nao,
				MAMEDOLS.ml_serika,
				MAMEDOLS.ml_tomoka,
				MAMEDOLS.ml_yuriko,

				ITEMS.dsecart,
				ITEMS.mamedol_egg,
				ITEMS.mamedol_seeds,
				ITEMS.mamedol_seeds_irimame,

				IMAS_RECORDS.ankirakyousoukyoku,
				IMAS_RECORDS.sakuranokoro,

				// itemとしてのブロックを登録
				BLOCK_ITEMS.rail_dse_tile_item,
				BLOCK_ITEMS.flower_cosmos_tile_item,
				BLOCK_ITEMS.flower_myosotis_tile_item,
				BLOCK_ITEMS.flower_dianthus_tile_item,
				BLOCK_ITEMS.flower_lycoris_tile_item,
				BLOCK_ITEMS.flower_gentiala_tile_item,
				BLOCK_ITEMS.bonbori_tile_item,
				BLOCK_ITEMS.weather_frog_tile_item,
				BLOCK_ITEMS.aodatami_slab_tile_item,
				BLOCK_ITEMS.kidatami_slab_tile_item,
				BLOCK_ITEMS.stonebrick_black_tile_item,
				BLOCK_ITEMS.stonebrick_gray_tile_item,
				BLOCK_ITEMS.stonebrick_black_slab_tile_item,
				BLOCK_ITEMS.stonebrick_black_stairs_tile_item
				);
	}

	@SubscribeEvent
	protected static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				BLOCKS.mame,
				BLOCKS.rail_dse,
				BLOCKS.flower_cosmos,
				BLOCKS.flower_myosotis,
				BLOCKS.flower_dianthus,
				BLOCKS.flower_lycoris,
				BLOCKS.flower_gentiana,
				BLOCKS.bonbori_off,
				BLOCKS.bonbori_on,
				BLOCKS.weather_frog,
				BLOCKS.aodatami_slab,
				BLOCKS.aodatami_slab_double,
				BLOCKS.kidatami_slab,
				BLOCKS.kidatami_slab_double,
				BLOCKS.stonebrick_black,
				BLOCKS.stonebrick_black_slab,
				BLOCKS.stonebrick_black_slab_double,
				BLOCKS.stonebrick_black_stairs,
				BLOCKS.stonebrick_gray
				);
	}

	@SubscribeEvent
	protected static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(
				SOUNDS.ankirakyousoukyoku,
				SOUNDS.sakuranokoro
				);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ForgeRegistries.POTIONS.register(POTIONS.hannari);
		GameRegistry.addSmelting(ITEMS.mamedol_seeds, new ItemStack(ITEMS.mamedol_seeds_irimame), 0.1f);
		EntityRegistry.registerModEntity(new ResourceLocation(DseMod.MODID,"Dsecart"), EntityDsecart.class, "DsecartEntity", 0, this, 250, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation(DseMod.MODID,"DsecartEmpty"), EntityDsecartEmpty.class, "DsecarEmptytEntity", 1, this, 250, 1, false);
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.addGrassSeed(new ItemStack(ITEMS.mamedol_seeds), 1);

		//register world generator
		GameRegistry.registerWorldGenerator(new com.dse.dseMod.worldgen.WorldGenDseFlower(), 1);

		//register tile entity
		GameRegistry.registerTileEntity(TileEntityBonbori.class, "tile_entity_bonbori");
		GameRegistry.registerTileEntity(TileEntityWeatherFrog.class, "tile_entity_weather_frog");

		proxy.postInit(event);
	}
}
