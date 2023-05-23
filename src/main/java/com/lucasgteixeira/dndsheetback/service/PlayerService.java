package com.lucasgteixeira.dndsheetback.service;

import com.lucasgteixeira.dndsheetback.model.Player;
import com.lucasgteixeira.dndsheetback.repositoty.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Transactional(readOnly = true)
    public List<Player> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Player findPlayerByUsernameAndPassword(String username, String password){
        return repository.findPlayerByUsernameAndPassword(username, password);
    }

    @Transactional(readOnly = false)
    public void insert(Player characterSheet){
        repository.save(characterSheet);
    }

    @Transactional(readOnly = true)
    public void delete(Player player) {
        repository.delete(player);
    }
}
