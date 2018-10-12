package com.dse.dseMod;

import com.dse.dseMod.block.BlockMame;
import com.dse.dseMod.block.BlockRailDse;
import com.dse.dseMod.item.Dsecart;
import com.dse.dseMod.item.MamedolEgg;
import com.dse.dseMod.item.MamedolSeeds;
import com.dse.dseMod.item.MamedolSeedsIrimame;
import com.dse.dseMod.potion.PotionHannari;
import com.dse.dseMod.proxy.CommonProxy;
import com.dse.dseMod.record.ImasRecord;

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
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = DseMod.MODID, version = DseMod.VERSION)
@EventBusSubscriber
public class DseMod {
	public static final String  MODID = "dsemod";
	public static final String  VERSION = "0.2.0.3";

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
				new ItemBlock(BLOCKS.rail_dse).setRegistryName(BLOCKS.rail_dse.getRegistryName())
				);
	}

	@SubscribeEvent
	protected static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				BLOCKS.mame,
				BLOCKS.rail_dse
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
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.addGrassSeed(new ItemStack(ITEMS.mamedol_seeds), 1);
		proxy.postInit(event);
	}
}
