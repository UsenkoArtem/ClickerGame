package com.clicker.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "buildings_dictionary")

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Building {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "basic_cost")
    Double basicCost;

    @Column(name = "b_lvl_up_m_cost")
    Double basicLvlUpMultiplierCost;

    @Column(name = "b_prod")
    Double basicProduction;

    @Column(name = "b_consume")
    Double basicConsume;

    @Column(name = "b_m_prod")
    Double basicLvlMultiplierProd;

    @Column(name = "b_quality")
    Double basicQuality;

    @OneToMany(mappedBy = "inBuilding", cascade = CascadeType.ALL)
    Set<Resource> inResource;

    @OneToMany(mappedBy = "outBuilding", cascade = CascadeType.ALL)
    Set<Resource> outResource;

    public Building(String name, Double basicCost, Double basicLvlUpMultiplierCost, Double basicProduction, Double basicConsume, Double basicLvlMultiplierProd, Double basicQuality, Set<Resource> inResource, Set<Resource> outResource) {
        this.name = name;
        this.basicCost = basicCost;
        this.basicLvlUpMultiplierCost = basicLvlUpMultiplierCost;
        this.basicProduction = basicProduction;
        this.basicConsume = basicConsume;
        this.basicLvlMultiplierProd = basicLvlMultiplierProd;
        this.basicQuality = basicQuality;
        this.inResource = inResource;
        this.outResource = outResource;
    }

    public Building() {
    }
}
