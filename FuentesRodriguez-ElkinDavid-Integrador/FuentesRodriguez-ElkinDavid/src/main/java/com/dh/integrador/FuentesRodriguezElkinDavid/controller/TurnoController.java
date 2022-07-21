package com.dh.integrador.FuentesRodriguezElkinDavid.controller;

import com.dh.integrador.FuentesRodriguezElkinDavid.dto.turnoDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Turno;
import com.dh.integrador.FuentesRodriguezElkinDavid.service.OdontologoService;
import com.dh.integrador.FuentesRodriguezElkinDavid.service.PacienteService;
import com.dh.integrador.FuentesRodriguezElkinDavid.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/Turno/")
public class TurnoController {

    public static final Logger logger = Logger.getLogger(TurnoController.class);

    private final TurnoService turnoService;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;




    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, PacienteService pacienteService1, PacienteService pacienteService2, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService2;

        this.odontologoService = odontologoService;
    }


    @GetMapping("{id}")
    public ResponseEntity<turnoDTO> findById(@PathVariable Long id){
        logger.info("*****  SE INICIA PROCESO DE BUSCAR UN TURNO ******");

        if(turnoService.findById(id) ==  null){
            logger.debug("No se encontro el turno:" + id);
            logger.error("HTTP STATUS: NOTFOUND");

            return   ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        logger.info("Se encontro el turno:" + id);
        logger.info("*****  FINALIZA PROCESO DE BUSCAR UN TURNO ******");

        return ResponseEntity.ok(turnoService.findById(id));
    }


    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        logger.info("*****  SE INICIA PROCESO DE ELIMINAR TURNO ******");

        String response = id + " Not Found";
        if(turnoService.findById(id) != null){
            logger.debug("Se elimino el turno: " + id);

            turnoService.delete(id);
            response = "Se elimino el turno";
        }else {
            logger.error("No se encontro el turno: " + id);
            logger.error("HTTP STATUS: NOTFOUND");
            return response;
        }
        logger.info("*****  FINALIZA EL PROCESO DE ELIMINAR TURNO ******");

        return response;

    }

    @GetMapping
    public Set<turnoDTO> findByAll(){

        logger.info("*****  INICIA EL PROCESO DE CONSULTAR TODOS LOS  TURNOS ******");
        logger.info("*****  FINALIZA EL PROCESO DE CONSULTAR TODOS LOS  TURNOS ******");
        return turnoService.findByAll();
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody turnoDTO turnoDTO) {
        logger.info("*****  SE INICIA PROCESO DE INSERTAR TURNO ******");
        logger.debug("Se inserto el turno con id: " + turnoDTO.getId());


        ResponseEntity response = null;
        if (pacienteService.findById(turnoDTO.getPaciente().getId()) != null &&
                odontologoService.consultar(turnoDTO.getOdontologo().getId()) != null
        ) {
            turnoService.save(turnoDTO);
            logger.debug("Se inserto el turno con id: " + turnoDTO.getId());
            return response = ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            logger.debug("No se inserto el turno con id: " + turnoDTO.getId());

            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        logger.info("*****  FINALIZA PROCESO DE INSERTAR TURNO ******");
        return response;
    }

}
