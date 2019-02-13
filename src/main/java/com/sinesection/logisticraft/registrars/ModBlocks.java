package com.sinesection.logisticraft.registrars;

import com.sinesection.logisticraft.block.*;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

	@GameRegistry.ObjectHolder("logisticraft:crate")
	public static BlockCrate crate;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		crate.initModel();
	}
}
