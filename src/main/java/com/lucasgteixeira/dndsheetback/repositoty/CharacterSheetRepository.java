package com.lucasgteixeira.dndsheetback.repositoty;

import com.lucasgteixeira.dndsheetback.model.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Long> {
    Optional<CharacterSheet> findCharacterSheetById(Long id);
}
