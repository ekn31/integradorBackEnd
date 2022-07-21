package com.dh.integrador.FuentesRodriguezElkinDavid.dto;

import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Odontologo;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Paciente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
public class turnoDTO implements Serializable {


    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
}
