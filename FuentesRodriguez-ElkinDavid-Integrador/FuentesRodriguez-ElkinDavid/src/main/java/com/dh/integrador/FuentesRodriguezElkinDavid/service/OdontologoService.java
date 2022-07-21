package com.dh.integrador.FuentesRodriguezElkinDavid.service;



import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Odontologo;
import com.dh.integrador.FuentesRodriguezElkinDavid.repository.odontologoRepository;
import com.dh.integrador.FuentesRodriguezElkinDavid.dto.odontologoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OdontologoService {

    //ATRIBUTOS
    @Autowired
    odontologoRepository repository;

    @Autowired
    ObjectMapper mappper;

    public odontologoDTO consultar(Long id) {
        Optional<Odontologo> odontologo = repository.findAllById(id);
        odontologoDTO odontologoDTO = null;
        if (odontologo.isPresent()) {
            odontologoDTO = mappper.convertValue(odontologo, odontologoDTO.class);

        }
        return odontologoDTO;
    }

    public odontologoDTO save(odontologoDTO odontologoDTO){
       Odontologo odontologo = mappper.convertValue(odontologoDTO, Odontologo.class);
       repository.save(odontologo);
       odontologoDTO odontologoDTO1 = mappper.convertValue(odontologo, odontologoDTO.class);
       return odontologoDTO1;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Set<odontologoDTO> consultarTodos(){
        List<Odontologo> odontologo = repository.findAll();
        Set<odontologoDTO> odontologoDTO = new HashSet<>();

        for(Odontologo odontologos: odontologo){
            odontologoDTO.add(mappper.convertValue(odontologos, odontologoDTO.class));
        }
        return odontologoDTO;
    }

    public odontologoDTO actualizar(odontologoDTO odontologoDTO){
       if(repository.findAllById(odontologoDTO.getId()).isPresent()){
           return  save(odontologoDTO);
       }
       return odontologoDTO = null;
    }
}

