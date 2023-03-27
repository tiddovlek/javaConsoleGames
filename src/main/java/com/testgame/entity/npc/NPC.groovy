package com.testgame.entity.npc;

import com.testgame.entity.Entity;

class NPC implements Entity {
    int id;
    int level;
    int currentHp;
    int maxHp;
    int maxHit;

    @Override
    String getName() {
        return  NpcEnum.getById(this.id).name().toLowerCase();
    }
}

