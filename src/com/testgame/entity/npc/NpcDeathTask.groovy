package com.testgame.entity.npc

import com.testgame.content.items.Item;
import com.testgame.entity.Entity;
import com.testgame.entity.user.Player;
import com.testgame.entity.user.skills.SkillEnum;

class NpcDeathTask {

     static void handleDeath(Entity entity, Entity attacker){
        if(entity instanceof NPC) {
            NPC npc = (NPC) entity
            Player player = (Player) attacker

            switch (npc.getId()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    println("You have won the battle!")
                    println("-------------------------------------------------------------------")
                    println("Rewards:")
                    println(""+(npc.getMaxHp()*15)/3+" hp xp")
                    println(""+(npc.getMaxHp()*15)+" "+player.getAttackStyle().getSkillName()+" xp")
                    println("5 coin")
                    println("1x schrimp")
                    println("-------------------------------------------------------------------")
                    player.getSkillManager().addExperience(player.getAttackStyle().getSkillId(),(npc.getMaxHp()*15))
                    player.getSkillManager().addExperience(SkillEnum.HITPOINTS.ordinal(), (npc.getMaxHp()*5))

                    player.getInventory().add(1,1)
                    player.setCoin(player.getCoin()+5)
                       player.dismissTarget()
                    break
            }

        }
    }
}
