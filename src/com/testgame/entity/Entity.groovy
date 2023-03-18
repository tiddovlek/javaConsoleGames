package com.testgame.entity

interface Entity {
    abstract int getCurrentHp();

    abstract void setCurrentHp(int hp);

    abstract String getName();

    abstract int getMaxHp();
}