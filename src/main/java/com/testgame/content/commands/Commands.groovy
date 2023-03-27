package com.testgame.content.commands;

import com.testgame.Locations
import com.testgame.content.actionLiseners.ItemAction;
import com.testgame.content.battle.Battle
import com.testgame.content.items.Item
import com.testgame.content.items.ItemDefinition;
import com.testgame.entity.npc.NpcEnum;
import com.testgame.entity.user.Player
import com.testgame.entity.user.skills.*;

class Commands {
    static void input(String options, Player p) {
        if (options.contains("travel")) {
            try {
                Locations location = Locations.findById(Integer.parseInt(options.substring(7)))
                if (location == null) {
                    println("id: " + options.substring(7) + " is a invalid, use command locations to find the right id")
                } else {
                    println("You have traveled to: " + location.name())
                    p.setLocation(location)
                }
            } catch (Exception e) {
                println("wrong syntax, use like travel location_id")
                for (Locations locations : Locations.values()) {
                    println("" + locations.name() + " id:" + locations.ordinal())
                }
            }
            return
        }
        if (options.contains("consume")) {
        try {
            int input = Integer.parseInt(options.substring(8))
            if(input > p.getInventory().getItems().size()) {
                println("no item in this inventory container!")
                return
            }
            ItemAction.firstAction(p.getInventory().getItems().get(input).getItemId(), p)
        }
        catch (Exception e) {
            println("Wrong syntax! consume {Inventory_id}")
        }
            return
    }

        if (options.contains("swap_style")) {

            try {
                int input = Integer.parseInt(options.substring(11))
                Skills skill = p.getSkillManager().getSkills().get(input)
                p.setAttackStyle(skill)
                println("Style swapped to $skill.skillName")

            } catch (Exception e) {
                String input = String.valueOf(options.substring(10))
                println(input + " not found!")

                println("Possible attack Styles:")
                println("- swap_style 0 (attack)")
                println("- swap_style 1 (strength)")
            }
            return
        }
        switch (options) {
            case "commands":
                for (CommandsEnum commands : CommandsEnum.values()) {
                    println("$commands.command - $commands.info")
                }
                break
            case "inventory":
                int index = 0
                if (p.getInventory().getItems().size() >= 1) {
                    for (Item item : p.getInventory().getItems()) {
                        ItemDefinition definition = ItemDefinition.forId(item.getItemId())
                        println("Inventory_id: " + index++ + " " + item.getAmount() + "x " + definition.getItemName() + "")
                    }
                } else {
                    println("No items in inventory yet!")
                }
                break

            case "levels":
                p.getSkillManager().getInfo()
                break

            case "battle":
                Battle.findTarget(p)
                try {
                    Battle battle = new Battle(
                            attacker: p,
                            defender: p.target
                    )
                    println("You have encountered a level " + p.getTarget().getLevel() + " " + NpcEnum.getById(p.getTarget().getId()).name())
                    println("Options: attack / flee")
                    battle.setStarted(true)
                    battle.init()
                } catch (NullPointerException e) {
                    println("No target found!")
                }
                break

            case "attack_styles":
                println("Possible attack Styles:")
                println("- swap_style 0 (attack)")
                println("- swap_style 1 (strength)")
                break

            case "locations":
                for (Locations locations : Locations.values()) {
                    println("" + locations.name() + " id:" + locations.ordinal())

                }
                break

            case "money":
                println("coins: " + p.getCoin())
                break

            case "kill":
                p.getServer().destroy()
                break

            default:
                println("Invalid command type 'commands' to view all commands")
                break
        }
    }
}
