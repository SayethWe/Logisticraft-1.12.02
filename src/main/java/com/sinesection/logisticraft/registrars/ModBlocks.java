package com.sinesection.logisticraft.registrars;

import com.sinesection.logisticraft.block.BlockCrate;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	@GameRegistry.ObjectHolder("logisticraft:crate")
	public static BlockCrate crate;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		crate.initModel();
	}
	
	public static void registerAll(IForgeRegistry<Block> r) {
		r.register(new BlockCrate());
	}
	
	public static void registerAllItems(IForgeRegistry<Item> r) {
		r.register(new ItemBlock(ModBlocks.crate).setRegistryName(ModBlocks.crate.getRegistryName()));
	}
}
