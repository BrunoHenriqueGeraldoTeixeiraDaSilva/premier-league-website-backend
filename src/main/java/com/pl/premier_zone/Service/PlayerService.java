package com.pl.premier_zone.Service;

import com.pl.premier_zone.Repository.PlayerRepository;
import com.pl.premier_zone.player.Player;
import jakarta.transaction.Transactional;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {


    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    //Getting players by their team
    public List<Player> getPlayersByTeam(String teamName){
        //using the PlayerRepositiory to retrive the information from the database
        return playerRepository.findAllByTeam(teamName);
    }

    //Getting players by their name
    public List<Player> getPlayersByName(String playerName){
        return playerRepository.findPlayerByName(playerName);
    }

    //Getting players by their position
    public List<Player> getPlayersByPosition(String position){
        return playerRepository.findPlayerByPosition(position);
    }

    public List<Player> getPlayersByNation(String nation){
        return playerRepository.findPlayerByNation(nation);
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position){
        return playerRepository.findPlayerByTeamAndPosition(team,position);
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());
        if(existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName){
        playerRepository.deleteByName(playerName);
    }



}
