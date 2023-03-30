package com.example.gcback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Courrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numOrdre;
    private Date dateArrivee;
    private Boolean departArrivee; //depart wla arrivee
    @ManyToOne
    private Type type;
    private Integer refEcrit;
    private Date dateEcrit;
    @ManyToOne
    private Origine origine;
    private String objet;
    private String classement;
}
