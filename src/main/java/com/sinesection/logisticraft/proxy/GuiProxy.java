package com.sinesection.logisticraft.proxy;

import com.sinesection.logisticraft.container.ContainerCrate;
import com.sinesection.logisticraft.gui.GuiCrate;
import com.sinesection.logisticraft.tileEntity.TileEntityCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

	public static final int CRATE_GUI_ID = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x,y,z);
		TileEntity te = world.getTileEntity(pos);
		switch (ID) {
		case 1:
			return new ContainerCrate(player.inventory,(TileEntityCrate) te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        switch (ID) {
        case 1:
            TileEntityCrate tileEntity = (TileEntityCrate) te;
            return new GuiCrate(tileEntity, new ContainerCrate(player.inventory, tileEntity));
        }
		return null;
	}

}
