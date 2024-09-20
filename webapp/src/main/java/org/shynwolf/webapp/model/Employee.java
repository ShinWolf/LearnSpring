package org.shynwolf.webapp.model;

import lombok.Data;

@Data
public class Employee {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String password;
}
