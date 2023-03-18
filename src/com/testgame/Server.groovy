package com.testgame

import com.testgame.content.commands.Commands
import com.testgame.entity.user.Player
import com.testgame.entity.user.skills.SkillEnum
import com.testgame.entity.user.skills.SkillManager

class Server {
    Player player;

    def init(){
        def scanner = new Scanner(System.in)
        def options = scanner.nextLine()
        Commands.input(options,player)
    }

    def launch(def username) {
        generatePlayer(username)
        println("Welcome ${username}")
        println("Type 'commands' to start your adventure!")

        while (player != null) init()
    }

     def destroy(){
        player = null
    }

    def generatePlayer(def username){
        setPlayer(new Player(
                username:username,
                server:this,
                coin: 0,
                location: Locations.STARTER_ISLE))

        player.getSkillManager().setSkills(SkillManager.Generate());
        player.setAttackStyle(player.getSkillManager().getSkills().get(SkillEnum.STRENGTH.id))

    }
}
