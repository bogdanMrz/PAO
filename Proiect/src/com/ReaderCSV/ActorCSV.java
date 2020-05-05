package com.ReaderCSV;

import com.Actor;

public class ActorCSV extends CitireCSV<Actor> {
    public ActorCSV(String filename) {
        super(filename);
    }

    @Override
    public Actor nextInstance() {

        String[] fields = scanner.nextLine().split(",");

        return new Actor(fields[0],fields[1],Integer.parseInt(fields[2]),Byte.parseByte(fields[3]));
    }

}
