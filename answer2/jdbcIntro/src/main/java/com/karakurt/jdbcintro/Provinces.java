package com.karakurt.jdbcintro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provinces {
    private Long id;
    private String uId;
    private String numberPlate;
    private String name;
    private Boolean cityOrNot;
}
