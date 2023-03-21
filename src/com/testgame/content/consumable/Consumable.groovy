package com.testgame.content.consumable

import com.testgame.entity.user.Player
import com.testgame.entity.user.skills.SkillEnum

class Consumable {



    static restoreHp(int itemId, Player player){
        if(!player.getInventory().contains(itemId)){
            println("You don't have this specific item!")
            return
        }
        println("You have restored your hp by +"+FoodEnum.getById(itemId).getHpIncrement()+" hp!")

        player.setCurrentHp(player.getCurrentHp()+FoodEnum.getById(itemId).getHpIncrement())
        player.getInventory().remove(itemId,1)
    }
}
