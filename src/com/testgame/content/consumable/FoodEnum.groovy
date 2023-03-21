package com.testgame.content.consumable

enum FoodEnum {
    Shrimp(1,2),
    Sardine(2,4),
    Herring(3,7),
    Mackerel(4,9),

    int itemId
    int hpIncrement

    private FoodEnum(int itemId, int hpIncrement){
        this.itemId = itemId
        this.hpIncrement = hpIncrement
    }

    static FoodEnum getById(int itemId) {
        for (FoodEnum anEnum : values()) {
            if(anEnum.getItemId() == itemId) {
                return anEnum
            }
        }
        return null
    }
}