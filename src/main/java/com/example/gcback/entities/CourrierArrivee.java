package com.example.gcback.entities;



import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourrierArrivee extends Courrier{

    private Integer numOrdre;
    private Date dateArrivee;
}
