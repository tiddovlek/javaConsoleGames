package com.testgame.entity.user.inventory

import com.testgame.content.items.Item
import com.testgame.entity.user.Player

class Inventory {
    Player player
    int maxSize = 50
    ArrayList<Item> items = new ArrayList<>()



    boolean contains(int itemId){
        for(Item item : getItems()) {
            if(item.getItemId() == itemId) {
                return true
            }
        }
        false
    }

    void add(int itemId, int amount){
        if(contains(itemId)) {
            for(Item item : getItems()) {
                if(item.itemId == itemId) {
                    item.setAmount(item.getAmount()+amount)
                }
            }
        } else {
            getItems().add(new Item(
                    itemId:itemId,
                    amount:amount
            ))
        }
    }

    void remove(int itemId, int amount){
        ArrayList<Item> newItems = new ArrayList<>()
        for(Item item : getItems()) {
            if(item.getItemId() == itemId && item.getAmount() >= amount) {
                if(item.getAmount() > amount) {
                    item.setAmount((item.getAmount()-amount))
                    newItems.add(item)
                }
            } else {
                newItems.add(item)
            }
        }
        setItems(newItems)
    }
}
