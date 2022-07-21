package com.dh.integrador.FuentesRodriguezElkinDavid.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Turno;
import javax.persistence.*;

import java.util.Date;

import java.util.Set;

@Entity
@Table(name = "PACIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String DNI;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Domicilio domicilio;
    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;

    @Column
    private Date date;



}
