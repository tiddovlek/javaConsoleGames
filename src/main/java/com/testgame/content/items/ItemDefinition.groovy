package com.testgame.content.items


import org.json.simple.JSONArray
import org.json.simple.parser.JSONParser

class ItemDefinition {

     int itemId
     String itemName
     int value

    static ArrayList<ItemDefinition> definitions = new ArrayList<>()

    static void init(){
        try {
            JSONParser parser = new JSONParser()
            JSONArray data = parser.parse(
                    new FileReader('../item.json')) as JSONArray

            for (def var : data) {
                definitions.add(new ItemDefinition(
                        itemId: var["id"],
                        itemName: var["name"],
                        value: var["value"]
                ))
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    static ItemDefinition forId(int itemId){
        for(ItemDefinition definition : getDefinitions()) {
            if(definition.getItemId() == itemId) {
               return definition
            }
        }
        null
    }
}
