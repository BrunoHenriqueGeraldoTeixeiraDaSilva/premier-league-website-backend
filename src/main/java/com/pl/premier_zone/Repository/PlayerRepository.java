package com.pl.premier_zone.Repository;

import com.pl.premier_zone.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String>{

    void deleteByName(String playerName);
    Optional<Player> findByName(String playerName);
    List<Player> findAllByTeam(String teamName);
    List<Player> findPlayerByName(String playerName);
    List<Player> findPlayerByPosition(String teamName);
    List<Player> findPlayerByNation(String playerNation);
    List<Player> findPlayerByTeamAndPosition(String team, String position);
}
