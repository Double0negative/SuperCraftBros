package org.mcsg.double0negative.supercraftbros.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.mcsg.double0negative.supercraftbros.Game;
import org.mcsg.double0negative.supercraftbros.GameManager;

public class PlayerDamage implements Listener{


	@EventHandler
	public void PlayerDamanged(EntityDamageEvent e){
		try{
			if(e.getEntity() instanceof Player){
				Player p = (Player)e.getEntity();
				int i = GameManager.getInstance().getPlayerGameId(p);
				if(i != -1){
					Game g = GameManager.getInstance().getGame(i);
					if(g.getState() != Game.State.INGAME){
						e.setCancelled(true);
					}
					else if(e.getCause() == DamageCause.FALL){
						e.setCancelled(true);
					}
				}
			}
		}catch(Exception er){}
	}

	@EventHandler
	public void PlayerDamanged(EntityDeathEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			int i = GameManager.getInstance().getPlayerGameId(p);
			if(i != -1){
				e.getDrops().clear();
			}
		}
	}
}
