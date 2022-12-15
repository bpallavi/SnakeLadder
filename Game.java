package MyStuff.SnakeLadderPackage;

import java.util.*;

public class Game {
    private Board board;
    private int numPlayers;
    private Dice dice;
    //private boolean isGameOn;
    Queue<Player> players;


    private final int size = 100;


    public Game(int size) {
        this.board = new Board(size);
        this.players = new LinkedList<>();
        this.dice = new Dice();

    }


    public void setLadder(List<Ladder> ladders) {
        this.board.setLadder(ladders); // Add ladders to board
    }

    public void addPlayers(List<Player> players) {
        this.numPlayers = players.size();
        // this.players = new LinkedList<>();
        Map<String, Integer> playerPieces = new HashMap<>();
        for (Player player : players) {
            this.players.add(player);
            playerPieces.put(player.getName(), 0);
        }

        this.board.setPlayers(playerPieces);
    }
    
    public void setSnakes(List<Snake> snakes) {
        this.board.setSnakes(snakes);
    }

    public void setladder(List<Ladder> ladder) {
        this.board.setLadder(ladder);
    }

    public boolean isGameCompleted() {
        int currentPlayers = players.size();
        return currentPlayers < this.numPlayers;
    }
    public void startGame() {
        while (!this.isGameCompleted()) {
            int value = dice.rolldice();
            Player player = this.players.poll();
            movePlayer(player, value);
            if (hasPlayerWOn(player)) {
                System.out.println("The winner is " + player.getName());
                this.board.getPlayers().remove(player.getName());
            } else {
                players.add(player);
            }
        }
    }

    
    private void movePlayer(Player player, int value) {
        int oldPos = this.board.getPlayers().get(player.getName());
        int newPos = oldPos + value;

        int boardSize = this.board.getSize();

        if (newPos > boardSize) {
            newPos = oldPos;
        } else {
            newPos = getNewPosAfterSnakeLadder(newPos);
        }

        this.board.getPlayers().put(player.getName(), newPos);
        System.out.println(player.getName() + " rolled a " + value + " and moved from " + oldPos +" to " + newPos);

    }
    
    private int getNewPosAfterSnakeLadder(int newPos) {
        int previousPos;
        do {
            previousPos = newPos;
            for (Snake snake : this.board.getSnakes()) {
                if (snake.getStart() == newPos) {
                    newPos = snake.getEnd();
                }
            }
            for(Ladder ladder: this.board.getLadder()) {
                if(ladder.getEnd() == newPos) {
                    newPos = ladder.getStart();
                }
            }

        } while (newPos != previousPos);

        return newPos;
    }

    private boolean hasPlayerWOn(Player player) {
        int playerPos = this.board.getPlayers().get(player.getName());
        int winningPos = this.board.getSize();
        return playerPos == winningPos;
    }


}
