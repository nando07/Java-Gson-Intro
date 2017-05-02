package nando;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

/**
 * Created by fernandogomez on 5/1/17.
 */
public class Game {

    Player p = new Player();

    File filename = new File("gamer.txt");

    public Game(Player player) {

        p = player;
    }

    // Create a function in the Game class called saveGame() that will use the GSON library
    // to serialize the object to a string, and save that string to a file.
    public void saveGame() {

        // Gson object
        Gson gson = new Gson();
        String userJson;
        Game playerObject = new Game(p);
        userJson = gson.toJson(playerObject);

        System.out.println(userJson);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            writer.write(userJson);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

// This function should load the file contents as a String, then use the
// GSON library to deserialize it into a new Player class, create a
// new Game instance with that player, then return the new game instance.
    public static Game loadGame(String filename) {

        String f = "";

        try {
            f = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Gson object
        Gson gson = new Gson();

        Game newObject = gson.fromJson(f, Game.class);

        return newObject;
    }

    public static void main(String[] args) {
        // write your code here

        Gson g = new Gson();

        Player player = new Player("Nando", 20.0, 15.0, 30.0);

        player.addEquipment("Slingshot", 45);
        player.addEquipment("Arrows", 80);
        player.addEquipment("Rocks", 70);

        player.display();

        Game game = new Game(player);

        game.saveGame();

        Game secondGame = loadGame("gamer.txt");

        // Display contents of second game for testing.
        System.out.println(secondGame.p.getName());

    }
 }
