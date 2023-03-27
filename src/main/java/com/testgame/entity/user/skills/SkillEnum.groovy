package com.testgame.entity.user.skills

enum SkillEnum {

    ATTACK(0, "Attack"),
    STRENGTH(1, "Strength"),
    HITPOINTS(2, "Hp");

    final def id
    final def skill

    SkillEnum(int id, String skill){
        this.id = id;
        this.skill = skill;
    }

    static SkillEnum skillEnumByName(String name) {
        for (SkillEnum enu : values()) {
            if (enu.name().toLowerCase().contains(name.toLowerCase())) {
                return enu
            }
        }
       return null
    }

    static SkillEnum skillEnumById(int id) {
        for (SkillEnum enu : values()) {
            if (enu.ordinal() == id) {
                return enu
            }
        }
       return null
    }
}