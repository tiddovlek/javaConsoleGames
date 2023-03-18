package com.testgame.entity.npc;

import com.testgame.Locations;

import java.util.ArrayList;

enum NpcEnum {
    MOUSE(1,1,2, 1,Locations.STARTER_ISLE),
    BIRD(2,1,3, 1,Locations.STARTER_ISLE),
    SNAKE(3,1,3, 1,Locations.STARTER_ISLE),
    ANT(4,1,1, 1,Locations.STARTER_ISLE),
    HYDRA(5,412,100, 25,Locations.MEDIUM_AREA);

    final int id
    final int maxHit
    final int level
    final int maxHp
    final Locations location

    NpcEnum(int id, int level, int maxHp, int maxHit, Locations locations) {
        this.id = id
        this.level = level
        this.maxHp = maxHp
        this.maxHit = maxHit
        this.location = locations
    }

    static def getByLocation(Locations location){
        def npcEnumArrayList = new ArrayList<>()
        for(def npcEnum : values()) {
            if(npcEnum.location == location) {
                npcEnumArrayList.add(npcEnum)
            }
        }
        npcEnumArrayList
    }

     static NpcEnum getById(int id){
        for(def npcEnum : values()) {
            if(npcEnum.id == id) {
                return npcEnum
            }
        }
        MOUSE;
    }
}
