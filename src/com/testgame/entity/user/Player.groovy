package com.testgame.entity.user

import com.testgame.Locations
import com.testgame.Server
import com.testgame.content.consumable.FoodEnum
import com.testgame.entity.Entity
import com.testgame.entity.npc.NPC
import com.testgame.entity.npc.NpcEnum
import com.testgame.entity.user.inventory.Inventory
import com.testgame.entity.user.skills.*
import com.testgame.misc.Misc

class Player implements Entity {
    def username
    int coin
    Server server
    Skills attackStyle
    Locations location
    NPC target

    Inventory inventory

    @Override
    void setCurrentHp(int hp) {
        Skills skill = this.getSkillManager().getSkills().get(SkillEnum.HITPOINTS.ordinal())
        if(skill.getLevel() > hp) {
            skill.setCurrentLevel(hp)
        } else {
            skill.setCurrentLevel(skill.getLevel())
        }
        this.getSkillManager().getSkills().set(SkillEnum.HITPOINTS.ordinal(),skill)
    }

    @Override
    String getName() {
        return username
    }

    @Override
    int getCurrentHp() {
        return this.getSkillManager().getSkills().get(SkillEnum.HITPOINTS.ordinal()).getCurrentLevel()
    }

    SkillManager skillManager = new SkillManager(p:this)


    @Override
     int getMaxHp() {
        return this.getSkillManager().getSkills().get(SkillEnum.HITPOINTS.ordinal()).getLevel();
    }

     def dismissTarget(){
        if(target != null)  target = null;
    }
}
