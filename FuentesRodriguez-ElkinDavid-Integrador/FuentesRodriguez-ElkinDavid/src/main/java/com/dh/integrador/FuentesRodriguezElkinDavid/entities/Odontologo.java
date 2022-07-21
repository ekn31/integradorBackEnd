package com.dh.integrador.FuentesRodriguezElkinDavid.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Table(name = "ODONTOLOGO")
@Entity
@Getter
@Setter
public class Odontologo {

    public static final Logger logger = Logger.getLogger(Odontologo.class);

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int matricula;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos;

}


