package MyStuff.SnakeLadderPackage;

import java.util.*;

public class DriverCode {
    public static void main(String[] args) {
    
        List<Snake> snakes = new ArrayList<Snake>();
        snakes.add(new Snake(10, 4));
        snakes.add(new Snake(32,13));
        snakes.add(new Snake(67,9));
        snakes.add(new Snake(97,3));
        List<Ladder> ladder = new ArrayList<Ladder>();
        ladder.add(new Ladder(51, 87));
        ladder.add(new Ladder(11, 47));
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("abc", 1));
        players.add(new Player("pqr", 2));

        Game game = new Game(100);
        game.addPlayers(players);
        game.setSnakes(snakes);
        game.setLadder(ladder);

        game.startGame();
        
    }

}
