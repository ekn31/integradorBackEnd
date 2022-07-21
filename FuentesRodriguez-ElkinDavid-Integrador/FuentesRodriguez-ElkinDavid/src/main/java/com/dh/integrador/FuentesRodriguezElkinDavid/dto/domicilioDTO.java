package com.dh.integrador.FuentesRodriguezElkinDavid.dto;

import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
public class domicilioDTO implements Serializable {


    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
    private Paciente paciente;
}
