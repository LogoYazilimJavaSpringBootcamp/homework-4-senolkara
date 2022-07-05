package com.karakurt.hibernateandjpa.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "provinces")
public class Provinces {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "u_id")
    private String uId;

    @Column(name = "number_plate")
    private String numberPlate;

    @Column(name = "name")
    private String name;

    @Column(name = "city_or_not")
    private boolean cityOrNot;
}
