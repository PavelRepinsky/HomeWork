package Homework_15_01_2024.Task3.Plugins;

import java.util.ArrayList;
import java.util.Random;

public class SecondPlugin implements RPSPlugin {
    @Override
    public String getMove() {
        ArrayList<String> move = new ArrayList<>();
        move.add("Rock");
        move.add("Paper");
        move.add("Scissors");
        return move.get(new Random().nextInt(move.size()));
    }
}
