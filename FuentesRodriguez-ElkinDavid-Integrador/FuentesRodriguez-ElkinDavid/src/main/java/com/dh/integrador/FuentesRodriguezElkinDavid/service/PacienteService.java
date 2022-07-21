package com.dh.integrador.FuentesRodriguezElkinDavid.service;


import com.dh.integrador.FuentesRodriguezElkinDavid.dto.pacienteDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Paciente;
import com.dh.integrador.FuentesRodriguezElkinDavid.repository.pacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteService {

    @Autowired
    pacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mappper;

    public pacienteDTO findById (Long id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        pacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
             pacienteDTO = mappper.convertValue(paciente, pacienteDTO.class);
            return pacienteDTO;
        }

        return pacienteDTO;
    }

    public Set<pacienteDTO> findAll(){

        List<Paciente> paciente = pacienteRepository.findAll();
        Set<pacienteDTO> pacienteDTO = new HashSet<>();

        for (Paciente pacientes: paciente){
             pacienteDTO.add(mappper.convertValue(pacientes, pacienteDTO.class));
        }

        return pacienteDTO;
    }


    public void delete (Long id){ pacienteRepository.deleteById(id);}

    public pacienteDTO save(pacienteDTO pacienteDTO){


        Paciente paciente = mappper.convertValue(pacienteDTO, Paciente.class);
        paciente.setDate(new Date());
        pacienteRepository.save(paciente);
        pacienteDTO pacienteDTO1 = mappper.convertValue(paciente, pacienteDTO.class);
        return pacienteDTO1;

    }



}
