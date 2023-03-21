package com.testgame.content.items

import netscape.javascript.JSObject
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException

class ItemDefinition {

     int itemId
     String itemName
     int value

    static ArrayList<ItemDefinition> definitions = new ArrayList<>()

    static void init(){
        try {
            JSONParser parser = new JSONParser()
            JSONArray data = parser.parse(
                    new FileReader("content/items/Items.json"))

            for (def var : data) {
                definitions.add(new ItemDefinition(
                        itemId: var["id"],
                        itemName: var["name"],
                        value: var["value"]
                ))
            }
        } catch (IOException | ParseException e) {
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
