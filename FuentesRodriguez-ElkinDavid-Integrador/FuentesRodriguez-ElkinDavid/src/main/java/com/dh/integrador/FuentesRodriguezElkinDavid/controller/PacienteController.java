package com.dh.integrador.FuentesRodriguezElkinDavid.controller;


import com.dh.integrador.FuentesRodriguezElkinDavid.dto.pacienteDTO;

import com.dh.integrador.FuentesRodriguezElkinDavid.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/Paciente/")
public class PacienteController {

    public static final Logger logger = Logger.getLogger(PacienteController.class);
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @GetMapping("{id}")
    public ResponseEntity<pacienteDTO> findById(@PathVariable Long id){
        logger.info("*****  SE INICIA PROCESO DE BUSCAR UN PACIENTE ******");
       if(pacienteService.findById(id) ==  null){
           logger.debug("No se encontro el paciente:" + id);
           logger.error("HTTP STATUS: NOTFOUND");
         return   ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }
        logger.info("Se encontro el paciente:" + id);
        logger.info("Se encontro el paciente:");
        logger.info("*****  FINALIZA PROCESO DE BUSCAR UN PACIEMTE ******");

        return ResponseEntity.ok(pacienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<pacienteDTO> save(@RequestBody pacienteDTO pacienteDTO){
        logger.info("*****  SE INICIA PROCESO DE INSERTAR PACIENTE ******");
        logger.debug("Se inserto el paciente con id: " + pacienteDTO.getId());
        logger.info("*****  FINALIZA PROCESO DE INSERTAR PACIENTE ******");

        return ResponseEntity.ok(pacienteService.save(pacienteDTO));

    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        logger.info("*****  SE INICIA PROCESO DE ELIMINAR PACIENTE ******");

        String response = id + " Not Found";
        if(pacienteService.findById(id) != null){
            logger.debug("Se elimino el paciente: " + id);
            pacienteService.delete(id);
            response = "Se elimino el paciente";
        }else {
            logger.error("No se encontro el paciente: " + id);
            logger.error("HTTP STATUS: NOTFOUND");
        }
        logger.info("*****  FINALIZA EL PROCESO DE ELIMINAR PACIENTE ******");

        return response;

    }

    @GetMapping
    public Set<pacienteDTO> findByAll(){
        logger.info("*****  INICIA EL PROCESO DE CONSULTAR TODOS LOS  PACIENTES ******");
        logger.info("*****  FINALIZA EL PROCESO DE CONSULTAR TODOS LOS  PACIENTES ******");

        return pacienteService.findAll();
    }


    @PutMapping
    public ResponseEntity<pacienteDTO> update(@RequestBody pacienteDTO pacienteDTO){
        logger.info("*****  INICIA EL PROCESO DE ACTUALIZAR PACIENTES ******");
        if(pacienteService.findById(pacienteDTO.getId()) != null){
            logger.info("Se actualizo el paciente:" + pacienteService.findById(pacienteDTO.getId()));
            logger.info("*****  FINALIZA EL PROCESO DE ACTUALIZAR PACIENTES ******");

            return ResponseEntity.ok(pacienteService.save(pacienteDTO));
        }else {
            logger.error("No se pudo actualizar el paciente:" + pacienteDTO.getId());
            logger.error("HTTP STATUS: NOTFOUND");
        }
        logger.info("*****  FINALIZA EL PROCESO DE ACTUALIZAR PACIENTES ******");
        return  ResponseEntity.notFound().build();
    }
}
