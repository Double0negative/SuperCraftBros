package org.mcsg.double0negative.supercraftbros.commands;

import org.bukkit.entity.Player;
import org.mcsg.double0negative.supercraftbros.GameManager;

public class LeaveCommand implements SubCommand{

	@Override
	public boolean onCommand(Player player, String[] args) {
		int game = GameManager.getInstance().getPlayerGameId(player);
		if(game != -1){
			GameManager.getInstance().getGame(game).removePlayer(player, false);
		}
		return true;
	}

	@Override
	public String help(Player p) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
