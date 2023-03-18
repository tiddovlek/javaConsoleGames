package com.testgame.content.commands;

import java.util.Arrays;

public enum CommandsEnum {
    Levels("'levels' ","Show your current stats"),
    BATTLE("'Battle' ","Fight a random npc"),
    TRAVEL("'Travel' ","Travel to a new location, command location to view all locations"),
    LOCATIONS("'Locations' ","All locations"),
    ATTACK_STYLE("'attack_styles' ","Swap attack style usage: swap-style attack"),
    SWAP_STYLE("'swap_style' ","View all possible attack styles!"),
    CASH("'money' ","check your pouch");

    final String command;
    final String info;

    CommandsEnum(String command, String info) {
        this.command = command;
        this.info = info;
    }
    CommandsEnum(String command, String[] info) {
        this.command = command;
        this.info = Arrays.toString(info);
    }
}
