package com.testgame.content.actionLiseners

import com.testgame.content.consumable.Consumable
import com.testgame.entity.user.Player

class ItemAction {


    static void firstAction(int itemId, Player player){
        switch (itemId) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Consumable.restoreHp(itemId,player)
                break
        }
    }
}
