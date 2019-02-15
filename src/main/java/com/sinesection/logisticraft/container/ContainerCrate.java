package com.sinesection.logisticraft.container;

import com.sinesection.logisticraft.tileEntity.TileEntityCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCrate extends Container {
	
	private static final int inv_y = 85;
	private static final int inv_x = 18;
	
	private static final int slots_y = 18;
	private static final int slots_x = 9;
	
	private TileEntityCrate tileEntity;
	
	public ContainerCrate(IInventory playerInventory, TileEntityCrate tileEntity) {
		this.tileEntity = tileEntity;
		
		addOwnSlots();
		addPlayerSlots(playerInventory);
	}

	private void addPlayerSlots(IInventory playerInventory) {
		 // Slots for the main inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = inv_x + col * 18;
                int y = inv_y + row * 18;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
            }
        }

        // Slots for the hotbar
        for (int row = 0; row < 9; ++row) {
            int x = inv_x + row * 18;
            int y = inv_y + 58;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
	}
	
	private void addOwnSlots() {
		IItemHandler itemHandler = this.tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		int index = 0;
		for (int layer = 0; layer<TileEntityCrate.LAYERS; layer++) {
			for (int row = 0; row<TileEntityCrate.LAYER_SIZE; row++) {
				for (int col = 0; col<TileEntityCrate.LAYER_SIZE; col++) {
					int x = slots_x + layer * 63 + col * 18;
					int y = slots_y + row * 18;
					addSlotToContainer(new SlotItemHandler(itemHandler, index, x, y));
					index++;
				}
			}
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack result = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			result = itemStack1.copy();
		}
		
		return result;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileEntity.canInteractWith(playerIn);
	}
}
