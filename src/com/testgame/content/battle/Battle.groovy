package com.testgame.content.battle

import com.testgame.entity.Entity;
import com.testgame.entity.npc.NPC;
import com.testgame.entity.npc.NpcDeathTask;
import com.testgame.entity.npc.NpcEnum;
import com.testgame.misc.Misc;
import com.testgame.entity.user.Player;

class Battle implements Runnable {
    Entity attacker
    Entity defender

    boolean started = false

    void init() {
        while (started && attacker != null && defender != null) {
            def scanner = new Scanner(System.in)
            def options = scanner.nextLine()

            if (options.contains("attack")) {
                run()
            }

            if (options.contains("flee")) {
                Player p;
                if (attacker instanceof Player) {
                    p = (Player) attacker
                } else {
                    p = (Player) defender
                }
                println("You successfully ran away from a level " + p.getTarget().getLevel() + " " + NpcEnum.getById(p.getTarget().getId()).name())
                endBattle();
            }
        }
    }

    def deathTask(Entity attacker, Entity defender) {
        if (attacker.getCurrentHp() < 1) {
            println("You died! GAME OVER")
            endBattle()
        } else {
            NpcDeathTask.handleDeath(defender, attacker)
            endBattle()
        }
    }

    static int hitCalculation(Entity attacker) {
        if (attacker instanceof Player) {
            MaxhitFormula.getMaxhit(attacker)
        } else {
            ((NPC) attacker).getMaxHit()
        }
    }

    void turn(Entity attacker, Entity defender) {
        int hit = hitCalculation(attacker)

        defender.setCurrentHp((defender.getCurrentHp() - hit))
        println("-------------------------------------------------------------------")
        println("[Battle] " + attacker.getName() + " has rolled a " + hit + "! " + defender.getName() + " has " + defender.getCurrentHp() + "/" + defender.getMaxHp() + " hp left!")

        if (defender.getCurrentHp() <= 0) {
            deathTask(attacker, defender)
        }
    }

    void endBattle() {
        this.started = false
    }

    static void findTarget(Player player) {
        if (player.getTarget() != null) {
            println("You already have a target")
            return
        }
        ArrayList<NpcEnum> npcList = NpcEnum.getByLocation(player.getLocation())

        if (npcList.size() > 0) {
            NpcEnum npcEnum = npcList.get(Misc.getRandom(npcList.size() - 1))

            player.target = new NPC(
                    id: npcEnum.getId(),
                    level: npcEnum.getLevel(),
                    maxHp: npcEnum.getMaxHp(),
                    currentHp: npcEnum.getMaxHp(),
                    maxHit: npcEnum.getMaxHit());
        } else {
            println("There are no monsters in this location");
        }
    }

    @Override
    void run() {
        int index = 0
        while (attacker.getCurrentHp() >= 1 && defender.getCurrentHp() >= 1) {

            if ((index % 2) == 0) turn(attacker, defender)
            else turn(defender, attacker)

            index++

            try {
                Thread.sleep(750)
            } catch (InterruptedException e) {
                throw new RuntimeException(e)
            }
        }
    }
}
