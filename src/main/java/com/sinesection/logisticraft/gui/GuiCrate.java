package com.sinesection.logisticraft.gui;

import com.sinesection.logisticraft.Logisticraft;
import com.sinesection.logisticraft.container.ContainerCrate;
import com.sinesection.logisticraft.tileEntity.TileEntityCrate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiCrate extends GuiContainer {
	public static final int WIDTH = 194;
	public static final int HEIGHT = 166;
	
	private static final ResourceLocation background = new ResourceLocation(Logisticraft.MODID, "textures/gui/crate.png");

	public GuiCrate(TileEntityCrate tileEntity, ContainerCrate container) {
		super(container);
		
		xSize = WIDTH;
		ySize = HEIGHT;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		mc.getTextureManager().bindTexture(background);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
