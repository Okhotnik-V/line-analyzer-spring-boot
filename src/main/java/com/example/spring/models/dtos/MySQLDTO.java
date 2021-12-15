package com.example.spring.models.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "my_db")
public class MySQLDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String text;
}
