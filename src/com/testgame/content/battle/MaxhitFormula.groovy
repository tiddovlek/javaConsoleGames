package com.testgame.content.battle;

import com.testgame.entity.user.Player
import com.testgame.entity.user.skills.SkillEnum;

class MaxhitFormula {

    static int getMaxhit(Player player){
        int attack = player.getSkillManager().getSkills().get(SkillEnum.ATTACK.ordinal()).currentLevel
        int strength = player.getSkillManager().getSkills().get(SkillEnum.STRENGTH.ordinal()).currentLevel

        (int) (((strength * 2) / 3) + ((attack * 2) / 3))
    }
}
