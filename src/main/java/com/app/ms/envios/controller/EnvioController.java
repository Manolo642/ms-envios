package com.app.ms.envios.controller;

import com.app.ms.envios.dto.EnvioResponseDTO;
import com.app.ms.envios.error.ErrorResponse;
import com.app.ms.envios.service.EnvioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService){
        this.envioService = envioService;
    }


    @GetMapping("/getEnvioById/{idEnvio}")
    public ResponseEntity<?> getEnvioById(@PathVariable Long idEnvio) throws BadRequestException {
        EnvioResponseDTO response = envioService.getEnvioById(idEnvio);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/envios")
    public ResponseEntity<List<EnvioResponseDTO>> findAll(){
        try {
            List<EnvioResponseDTO> env = envioService.getAllEnvios();
            if(env.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(env);
        }catch (Exception e){
            log.error("Error al obtener todos los envios {} ", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/enviosByOrdenId/{id_Orden}")
    public ResponseEntity<List<EnvioResponseDTO>> enviosByOrdenId(@PathVariable Long id_Orden){
        try {
            List<EnvioResponseDTO> env = envioService.getAllEnviosByIdOrden(id_Orden);
            if(env.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(env);
        }catch (Exception e){
            log.error("Error al obtener todos los envios por idOrden {} ", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
