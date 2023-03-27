package com.testgame.entity.user.skills

import com.testgame.entity.user.Player

class SkillManager {

    Player p;

    ArrayList<Skills> skills = new ArrayList<Skills>();

    static def Generate(){
        def newSkills = new ArrayList<Skills>();

        for(SkillEnum skillEnum : SkillEnum.values()) {
            if(skillEnum.id == skillEnum.HITPOINTS.ordinal()) {
                newSkills.add(new Skills(
                        skillId:skillEnum.id,
                        skillName:skillEnum.name(),
                        currentExp:0,
                        currentLevel:10,
                        level:10
                ))
            } else {
                newSkills.add(new Skills(
                        skillId:skillEnum.id,
                        skillName:skillEnum.name(),
                        currentExp:0,
                        currentLevel:1,
                        level:1
                ))
            }
        }
        return newSkills;
    }

     void addExperience(int skillId, int experience){
        Skills skill = skills.get(skillId)
        skill.setCurrentExp((skill.getCurrentExp()+experience))
        levelUp(skill)
    }

    def getInfo(){
        for(Skills skills : this.skills) {
            println("Skill: "+ skills.getSkillName()+"| level: "+ skills.currentLevel +" | Exp: "+ skills.getCurrentExp()+"")
        }
    }

    static def levelUp(Skills skill){
        if(experienceLeft(skill.getCurrentLevel()) < skill.currentExp) {
            skill.setLevel((skill.getLevel()+1))
            skill.setCurrentExp(0)
            skill.setCurrentLevel((skill.currentLevel+1))
            println("[Skill Manager] Congratulations, you have leveled up your "+ skill.getSkillName()+" to level:"+ skill.getLevel())
        }

    }

    static def experienceLeft(int level){
        int[] expRequired = new int[] {83,174,276,388,512,650,801,969,1154,1358,1584,1833,2107,1411,2746,3115,3523,3973,4470}

        expRequired[(level-1)]
    }
}
