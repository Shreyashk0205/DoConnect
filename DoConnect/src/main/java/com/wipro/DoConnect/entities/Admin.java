package com.wipro.DoConnect.entities;

import javax.persistence.*;

import lombok.Data;



@Entity
@Table(name = "admin")
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

 
}
