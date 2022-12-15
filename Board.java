package MyStuff.SnakeLadderPackage;

import java.util.*;

public class Board {
    Map<String, Integer> players;
    private List<Snake> snakes;
    private List<Ladder>  ladder;
    private int winPos;
    private int size;

    public Map<String, Integer> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Integer> players) {
        this.players = players;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadder() {
        return ladder;
    }

    public void setLadder(List<Ladder> ladder) {
        this.ladder = ladder;
    }

    public int getWinPos() {
        return winPos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Board(int size) {
        this.snakes = new ArrayList<>();
        this.ladder = new ArrayList<>();
        this.players = new HashMap<>();
        this.size = size;
    }
    
}
