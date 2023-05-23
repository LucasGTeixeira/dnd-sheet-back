package com.lucasgteixeira.dndsheetback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Player {
    @Id
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<CharacterSheet> sheets;
}
