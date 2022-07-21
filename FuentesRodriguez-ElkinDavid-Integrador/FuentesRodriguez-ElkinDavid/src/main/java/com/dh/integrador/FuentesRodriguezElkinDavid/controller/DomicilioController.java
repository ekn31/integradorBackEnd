package com.dh.integrador.FuentesRodriguezElkinDavid.controller;

import com.dh.integrador.FuentesRodriguezElkinDavid.dto.domicilioDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.dto.pacienteDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.service.DomicilioService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/Domicilio/")
public class DomicilioController {

    public static final Logger logger = Logger.getLogger(DomicilioController.class);

    private final DomicilioService domicilioService;

    public DomicilioController(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }


    @GetMapping("{id}")
    public ResponseEntity<domicilioDTO> findById(@PathVariable Long id){
        logger.info("*****  SE INICIA PROCESO DE BUSCAR UN DOMICILIO ******");
        if(domicilioService.findById(id) ==  null){
            logger.debug("No se encontro el domicilio:" + id);
            logger.error("HTTP STATUS: NOTFOUND");
            return   ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        logger.info("Se encontro el domicilio:" + id);
        logger.info("*****  FINALIZA PROCESO DE BUSCAR UN DOMICILIO ******");
        return ResponseEntity.ok(domicilioService.findById(id));

    }

    @PostMapping
    public ResponseEntity<domicilioDTO> save(@RequestBody domicilioDTO domicilioDTO){
        logger.info("*****  SE INICIA PROCESO DE INSERTAR DOMICILIO ******");
        logger.debug("Se inserto el domicilio con id: " + domicilioDTO.getId());
        logger.info("*****  FINALIZA PROCESO DE INSERTAR DOMICILIO ******");
        return ResponseEntity.ok(domicilioService.save(domicilioDTO));


    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        logger.info("*****  SE INICIA PROCESO DE ELIMINAR DOMICILIO ******");
        String response = id + " Not Found";
        if(domicilioService.findById(id) != null){
            logger.debug("Se elimino el domicilio: " + id);

            domicilioService.delete(id);
            response = "Se elimino el domicilio";
        }
        else {
            logger.error("No se encontro el domicilo: " + id);
            logger.error("HTTP STATUS: NOTFOUND");
            return response;
        }
        logger.info("*****  FINALIZA EL PROCESO DE ELIMINAR DOMICILIO ******");
        return response;
    }

    @GetMapping
    public Set<domicilioDTO> findByAll(){

        logger.info("*****  INICIA EL PROCESO DE CONSULTAR TODOS LOS  DOMICILIOS ******");
        logger.info("*****  FINALIZA EL PROCESO DE CONSULTAR TODOS LOS  DOMICILIOS ******");
        return domicilioService.findAll();
    }


    @PutMapping
    public ResponseEntity<domicilioDTO> update(@RequestBody domicilioDTO domicilioDTO){
        logger.info("*****  INICIA EL PROCESO DE ACTUALIZAR DOMICILIOS ******");
        if(domicilioService.findById(domicilioDTO.getId()) != null){
            logger.info("Se actualizo el domicilio:" + domicilioService.findById(domicilioDTO.getId()));
            logger.info("*****  FINALIZA EL PROCESO DE ACTUALIZAR DOMICILIOS ******");
            return ResponseEntity.ok(domicilioService.save(domicilioDTO));
        }else {
            logger.error("No se pudo actualizar el domicilio:" + domicilioDTO.getId());
            logger.error("HTTP STATUS: NOTFOUND");
        }
        logger.info("*****  FINALIZA EL PROCESO DE ACTUALIZAR PACIENTE ******");
        return  ResponseEntity.notFound().build();
    }
}
