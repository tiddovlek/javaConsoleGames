package com.testgame

import com.testgame.content.commands.Commands
import com.testgame.content.items.ItemDefinition
import com.testgame.entity.user.Player
import com.testgame.entity.user.inventory.Inventory
import com.testgame.entity.user.skills.SkillEnum
import com.testgame.entity.user.skills.SkillManager

class Server {
    Player player

    def init(){
        def scanner = new Scanner(System.in)
        def options = scanner.nextLine()
        Commands.input(options,player)
        //Commands.input("commands",player)
        print("Ready for next command...")
        // todo: add commands output here so i dont have to type it
    }

     def destroy(){
        player = null
    }

    def launch(def username) {
        ItemDefinition.init()

        generatePlayer(username)
        println("Welcome ${username}")
        println("Type 'commands' to start your adventure!")

        while (player != null) init()
    }

    def generatePlayer(def username){
        setPlayer(new Player(
                username:username,
                server:this,
                coin: 0,
                location: Locations.STARTER_ISLE))

        player.setInventory(new Inventory(player: player))
        player.getSkillManager().setSkills(SkillManager.Generate());
        player.setAttackStyle(player.getSkillManager().getSkills().get(SkillEnum.STRENGTH.id))

    }
}
