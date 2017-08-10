package com.clicker.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "buildings_dictionary")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    @Column
    Integer primaryCost;

    @Column
    Integer basicLvlUpMultiplierCost;

    @Column
    Integer basicProduction;

    @Column
    Integer BasicLvlMultiplierProd;

    @Column
    Integer resourceID;
}
