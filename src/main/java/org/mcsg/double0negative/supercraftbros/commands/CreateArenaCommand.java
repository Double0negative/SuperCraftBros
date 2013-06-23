package org.mcsg.double0negative.supercraftbros.commands;

import org.bukkit.entity.Player;
import org.mcsg.double0negative.supercraftbros.GameManager;

public class CreateArenaCommand implements SubCommand {

	@Override
	public boolean onCommand(Player player, String[] args) {
		if(player.isOp()){
			
			GameManager.getInstance().createArenaFromSelection(player);
			
		}
		return true;
	}

	@Override
	public String help(Player p) {
		// TODO Auto-generated method stub
		return null;
	}

}
