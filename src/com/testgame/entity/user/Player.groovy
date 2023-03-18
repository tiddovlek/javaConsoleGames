package com.testgame.entity.user

import com.testgame.Locations
import com.testgame.Server
import com.testgame.entity.Entity
import com.testgame.entity.npc.NPC
import com.testgame.entity.npc.NpcEnum
import com.testgame.entity.user.skills.*
import com.testgame.misc.Misc

class Player implements Entity {
    def username
    int coin
    Server server
    Skills attackStyle
    Locations location
    NPC target;

    @Override
    void setCurrentHp(int hp) {
        this.getSkillManager().getSkills().get(SkillEnum.HITPOINTS.ordinal()).currentLevel
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
