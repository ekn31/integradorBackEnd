package com.dh.integrador.FuentesRodriguezElkinDavid.dto;

import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Domicilio;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Turno;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
public class pacienteDTO implements Serializable {


    private Long id;
    private String nombre;
    private String apellido;
    private String DNI;
    private Domicilio domicilio;
    private Date date;
    private Set<Turno> turno;
}
