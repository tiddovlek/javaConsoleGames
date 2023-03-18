package com.testgame

enum Locations {
    STARTER_ISLE,
    BEGINNER_AREA,
    MEDIUM_AREA;


    static Locations findByName(String name) {
        for (Locations locations : values()) {
            if (locations.name().equals(name)) {
                return locations;
            }
        }
        null
    }

    static Locations findById(int id) {
        for (def locations : values()) {
            if (locations.ordinal() == id) {
               return locations;
            }
        }
        null
    }
}
