package com.lucasgteixeira.dndsheetback.repositoty;

import com.lucasgteixeira.dndsheetback.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findPlayerByUsernameAndPassword(String username, String password);
}
