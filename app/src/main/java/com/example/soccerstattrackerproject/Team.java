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

    public String[] getPlayerData(String pname){
        boolean foundPlayer = false;
        int i = 0;
        String[] playerData = new String[5];

        while (!foundPlayer){
            if(i == players.size() && !foundPlayer){
                return null;
            }
            if(players.get(i).getName().equals(pname)){
                foundPlayer = true;
                playerData[0] = players.get(i).getName();
                playerData[1] = players.get(i).getPosition();
                playerData[2] = String.valueOf(players.get(i).getGoals());
                playerData[3] = String.valueOf(players.get(i).getAssists());
                playerData[4] = String.valueOf(players.get(i).getMinutes());
            }
        }

        return playerData;
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
