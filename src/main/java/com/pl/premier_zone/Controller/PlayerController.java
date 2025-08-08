package com.pl.premier_zone.Controller;

import com.pl.premier_zone.Service.PlayerService;
import com.pl.premier_zone.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //Getitng player from the database
    @GetMapping()
    public List<Player> getPlayersFromTeam(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {
        if (team != null & position != null) {
            return playerService.getPlayersByTeamAndPosition(team, position);
        } else if (team != null) {
            return playerService.getPlayersByTeam(team);
        } else if (name != null) {
            return playerService.getPlayersByName(name);
        } else if (position != null) {
            return playerService.getPlayersByPosition(position);
        } else if (nation != null) {
            return playerService.getPlayersByNation(nation);
        } else {
            return playerService.getPlayers();
        }
    }

    //adding player to the database
    @PostMapping()
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer =  playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    //updated existing player
    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player updatedPlayer =  playerService.updatePlayer(player);
        if(updatedPlayer != null){
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }
        return new ResponseEntity<>(updatedPlayer, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted", HttpStatus.OK);
    }

}
