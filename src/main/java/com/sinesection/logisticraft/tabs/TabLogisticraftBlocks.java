package com.sinesection.logisticraft.tabs;

import com.sinesection.logisticraft.registrars.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabLogisticraftBlocks extends CreativeTabs {

	public TabLogisticraftBlocks() {
		super("Logisticraft Blocks");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.crate);
	}

}
