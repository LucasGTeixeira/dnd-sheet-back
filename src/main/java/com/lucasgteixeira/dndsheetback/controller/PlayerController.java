package com.lucasgteixeira.dndsheetback.controller;

import com.lucasgteixeira.dndsheetback.model.Player;
import com.lucasgteixeira.dndsheetback.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public ResponseEntity<List<Player>> findAll(){
        List<Player> players = service.findAll();
        return ResponseEntity.ok().body(players);
    }

    @GetMapping(value = "/{username}/{password}")
    public ResponseEntity<Player> findPlayerByUsernameAndPassword(@PathVariable String username, String password){
        Player player = service.findPlayerByUsernameAndPassword(username, password);
        return ResponseEntity.ok().body(player);
    }

    @PostMapping
    public ResponseEntity<Player> insert(@RequestBody Player player){
        service.insert(player);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(player.getId()).toUri();
        return ResponseEntity.created(uri).body(player);
    }

}
