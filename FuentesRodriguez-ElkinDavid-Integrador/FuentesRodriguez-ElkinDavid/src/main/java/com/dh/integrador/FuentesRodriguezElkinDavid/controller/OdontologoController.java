package com.dh.integrador.FuentesRodriguezElkinDavid.controller;


import com.dh.integrador.FuentesRodriguezElkinDavid.dto.odontologoDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Odontologo;
import com.dh.integrador.FuentesRodriguezElkinDavid.service.OdontologoService;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Log4j
public class OdontologoController {

    public static final Logger logger = Logger.getLogger(OdontologoController.class);
     // INSTANCIAR EL SERVICE

    @Autowired
    private OdontologoService odontologoService;


    @GetMapping("/api/v1/Odontologo/{id}")
    public ResponseEntity<odontologoDTO> findById(@PathVariable Long id){
        logger.info("*****  SE INICIA PROCESO DE BUSCAR UN ODONTOLGO ******");

        if(odontologoService.consultar(id) == null){
            logger.debug("No se encontro el odontolgo:" + id);
            logger.error("HTTP STATUS: NOTFOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        logger.info("Se encontro el odontolgo:" + id);
        logger.info("*****  FINALIZA PROCESO DE BUSCAR UN ODONTOLGO ******");

        return ResponseEntity.ok(odontologoService.consultar(id));
    }

    @PostMapping("/api/v1/Odontologo/")
    public ResponseEntity<odontologoDTO> save(@RequestBody odontologoDTO odontologoDTO) {
        logger.info("*****  SE INICIA PROCESO DE INSERTAR ODONTOLOGO ******");
        logger.debug("Se inserto el domicilio con id: " + odontologoDTO.getId());
        logger.info("*****  FINALIZA PROCESO DE INSERTAR ODONTOLOGO ******");

        return ResponseEntity.ok(odontologoService.save(odontologoDTO));
    }


    @GetMapping("/api/v1/Odontologo/buscarTodos")
    public Set<odontologoDTO> buscarTodos(){
        logger.info("*****  INICIA EL PROCESO DE CONSULTAR TODOS LOS  ODONTOLOGOS ******");
        logger.info("*****  FINALIZA EL PROCESO DE CONSULTAR TODOS LOS  ODONTOLOGOS ******");

        return odontologoService.consultarTodos();
    }

    @DeleteMapping("/api/v1/Odontologo/{id}")
    public String eliminarOdontolgo(@PathVariable Long id) {
        logger.info("*****  SE INICIA PROCESO DE ELIMINAR ODONTOLOGO ******");

        String response = id + " no encontrado.";
        if(odontologoService.consultar(id) !=null){
            logger.debug("Se elimino el odontologo: " + id);
            odontologoService.eliminar(id);
            response = "Se elimino odontologo con id: " + id;
        }else {
            logger.error("No se encontro el odontologo: " + id);
            logger.error("HTTP STATUS: NOTFOUND");
            return response;
        }
        logger.info("*****  FINALIZA EL PROCESO DE ELIMINAR ODONTOLOGO ******");

        return response;

    }

    @PutMapping("/api/v1/Odontologo/")
    public ResponseEntity<odontologoDTO> actualizar(@RequestBody odontologoDTO odontologoDTO) {
        logger.info("*****  INICIA EL PROCESO DE ACTUALIZAR DOMICILIOS ******");

        if(odontologoService.consultar(odontologoDTO.getId()) != null){
            logger.info("Se actualizo el domicilio:" + odontologoService.consultar(odontologoDTO.getId()));
            logger.info("*****  FINALIZA EL PROCESO DE ACTUALIZAR ODONTOLOGO ******");

            return ResponseEntity.ok(odontologoService.actualizar(odontologoDTO));
        }else {
            logger.error("No se pudo actualizar el odontolgo:" + odontologoDTO.getId());
            logger.error("HTTP STATUS: NOTFOUND");
        }
        logger.info("*****  FINALIZA EL PROCESO DE ACTUALIZAR ODONTOLOGO ******");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
