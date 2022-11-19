package org.blackcat;

import org.blackcat.Application.Game;
import org.blackcat.Entity.Plane;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Plane plane = new Plane(60);

        Game game = new Game(plane, 1000000, 10);
        game.play();

    }
}
