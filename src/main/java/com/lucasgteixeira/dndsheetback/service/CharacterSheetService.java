package com.lucasgteixeira.dndsheetback.service;

import com.lucasgteixeira.dndsheetback.model.CharacterSheet;
import com.lucasgteixeira.dndsheetback.repositoty.CharacterSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterSheetService {

    @Autowired
    private CharacterSheetRepository repository;

    @Transactional(readOnly = true)
    public List<CharacterSheet> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public CharacterSheet findCharacterSheetById(Long id){
        return repository.findCharacterSheetById(id).get();
    }

    @Transactional(readOnly = true)
    public List<CharacterSheet> findAllByOwnerId(Long id){
        return repository.findAllByOwner(id);
    }

    @Transactional(readOnly = false)
    public void insert(CharacterSheet characterSheet){
        repository.save(characterSheet);
    }

    @Transactional(readOnly = false)
    public void update(CharacterSheet characterSheet){
        verifyCharcter(characterSheet);
        repository.save(characterSheet);
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        repository.deleteById(id);
    }

    private void verifyCharcter(CharacterSheet characterSheet) {
        Optional<CharacterSheet> charSelected = repository.findCharacterSheetById(characterSheet.getId());
        if(charSelected.isEmpty()) throw new IllegalArgumentException("Personagem Não encontrado");
    }
}
