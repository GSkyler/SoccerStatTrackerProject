package com.example.soccerstattrackerproject;

import java.util.ArrayList;

public class Team {

    private ArrayList<Player> players;

    public Team(){
        players = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            players.add(createRandomPlayer());
        }
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public ArrayList<String> getPlayerNames(){
        ArrayList<String> playerNames = new ArrayList<>();
        for(Player p: players){
            playerNames.add(p.getName());
        }

        return playerNames;
    }

    public Player createRandomPlayer(){
        String name = Character.toString((char)(players.size()+65));
        Player newPlayer = new Player(name);
        newPlayer.setMinutes((int)(Math.random()*90));
        newPlayer.setAssists((int)(Math.random()*3));
        newPlayer.setGoals((int)(Math.random()*3));

        return newPlayer;
    }

}
