package com.dh.integrador.FuentesRodriguezElkinDavid.dto;

import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.Set;

@Getter
@Setter

public class odontologoDTO implements Serializable {


    private Long id;
    private int matricula;
    private String nombre;
    private String apellido;
    private Set<Turno> turno;
}
