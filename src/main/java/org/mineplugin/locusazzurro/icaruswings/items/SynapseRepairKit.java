package org.mineplugin.locusazzurro.icaruswings.items;

import org.mineplugin.locusazzurro.icaruswings.data.ModGroup;

import net.minecraft.item.Item;

public class SynapseRepairKit extends Item{
	
	public SynapseRepairKit() {
		super(new Properties().tab(ModGroup.itemGroup).stacksTo(1).fireResistant());
	}
	
}
