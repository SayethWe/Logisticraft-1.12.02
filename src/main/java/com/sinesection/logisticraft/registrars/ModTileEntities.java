package com.sinesection.logisticraft.registrars;

import com.sinesection.logisticraft.Logisticraft;
import com.sinesection.logisticraft.tileEntity.TileEntityCrate;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	
	public static void registerAll() {
		GameRegistry.registerTileEntity(TileEntityCrate.class, new ResourceLocation(Logisticraft.MODID + "_crate"));
				
	}
}
