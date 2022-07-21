package com.dh.integrador.FuentesRodriguezElkinDavid.service;

import com.dh.integrador.FuentesRodriguezElkinDavid.dto.domicilioDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.dto.domicilioDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Domicilio;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Paciente;
import com.dh.integrador.FuentesRodriguezElkinDavid.repository.domicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dh.integrador.FuentesRodriguezElkinDavid.repository.domicilioRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DomicilioService {

    @Autowired
    domicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mappper;
    public domicilioDTO findById (Long id){
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        domicilioDTO domicilioDTO = null;
        if(domicilio.isPresent()){
            domicilioDTO = mappper.convertValue(domicilio, domicilioDTO.class);
            return domicilioDTO;
        }

        return domicilioDTO;
    }

    public Set<domicilioDTO> findAll(){

        List<Domicilio> domilicio = domicilioRepository.findAll();
        Set<domicilioDTO> domicilioDTO = new HashSet<>();

        for (Domicilio domicilios: domilicio){
            domicilioDTO.add(mappper.convertValue(domicilios, domicilioDTO.class));
        }

        return domicilioDTO;
    }


    public void delete (Long id){ domicilioRepository.deleteById(id);}

    public domicilioDTO save(domicilioDTO domicilioDTO){

        Domicilio domicilio = mappper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        domicilioDTO domicilioDTO1 = mappper.convertValue(domicilio, domicilioDTO.class);
        return domicilioDTO1;

    }

}
