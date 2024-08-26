package de.asiegwarth.mssql.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "werte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wert {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wert_id")
    private int wertId;
    @Column(name = "wert")
    private int wert;
    @Column(name = "datum")
    private Date datum;

}
