package com.lucasgteixeira.dndsheetback.controller;

import com.lucasgteixeira.dndsheetback.model.CharacterSheet;
import com.lucasgteixeira.dndsheetback.service.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/characterSheets")
public class CharacterSheetController {

    @Autowired
    private CharacterSheetService service;

    //find all
    @GetMapping
    public ResponseEntity<List<CharacterSheet>> findAll(){
        List<CharacterSheet> characterSheets = service.findAll();
        return ResponseEntity.ok().body(characterSheets);
    }

    //find all by player
    @GetMapping(value = "/Owner/{id}")
    public ResponseEntity<List<CharacterSheet>> findOwnedCharacters(@PathVariable Long id) {
        List<CharacterSheet> characterSheets = service.findAllByOwnerId(id);
        return ResponseEntity.ok().body(characterSheets);
    }

    //find one
    @GetMapping(value = "/{id}")
    public ResponseEntity<CharacterSheet> findCharacterById(@PathVariable Long id){
        CharacterSheet characterSheet = service.findCharacterSheetById(id);
        return ResponseEntity.ok().body(characterSheet);
    }

    @PostMapping
    public ResponseEntity<CharacterSheet> insert(@RequestBody CharacterSheet characterSheet){
        service.insert(characterSheet);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(characterSheet.getId()).toUri();
        return ResponseEntity.created(uri).body(characterSheet);
    }

    @PutMapping
    public ResponseEntity<CharacterSheet> update(@RequestBody CharacterSheet characterSheet){
        service.update(characterSheet);
        return ResponseEntity.ok().body(characterSheet);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
