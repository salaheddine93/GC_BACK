package com.example.gcback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Courrier {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    private Type type;
    private Integer refEcrit;
    private Date dateEcrit;
    @ManyToOne
    private Origine origine;
    private String objet;
    private String classement;
    private String fichierNum;
}
