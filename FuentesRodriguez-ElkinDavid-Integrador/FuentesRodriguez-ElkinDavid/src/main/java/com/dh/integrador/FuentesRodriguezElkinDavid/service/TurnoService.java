package com.dh.integrador.FuentesRodriguezElkinDavid.service;

import com.dh.integrador.FuentesRodriguezElkinDavid.dto.turnoDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Turno;
import com.dh.integrador.FuentesRodriguezElkinDavid.repository.turnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService {


    @Autowired
    turnoRepository turnoRepository;


    @Autowired
    ObjectMapper mappper;


    public turnoDTO save(turnoDTO turnoDTO){

       Turno turno =  mappper.convertValue(turnoDTO, Turno.class);
       turno.setDate(new Date());
       turnoRepository.save(turno);
       turnoDTO turno1 = mappper.convertValue(turnoDTO, turnoDTO.class);
       return turno1;

    }
    public void delete(Long id){
        turnoRepository.deleteById(id);
    }

    public turnoDTO findById(Long id){
        Optional<Turno> turno = turnoRepository.findById(id);
        turnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mappper.convertValue(turno, turnoDTO.class);
            return turnoDTO;
        }
        return turnoDTO;
    }

    public Set<turnoDTO> findByAll() {

        List<Turno> turno = turnoRepository.findAll();
        Set<turnoDTO> turnoDTO = new HashSet<>();

        for (Turno turnos: turno){
            turnoDTO.add(mappper.convertValue(turnos, turnoDTO.class));
        }

        return turnoDTO;

    }

}
