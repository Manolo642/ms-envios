package com.app.ms.envios.service;

import com.app.ms.envios.dto.EnvioResponseDTO;
import com.app.ms.envios.entiti.Envio;
import com.app.ms.envios.repositori.EnvioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    private final EnvioRepository envioRepository;

    public EnvioService(EnvioRepository envioRepository){
        this.envioRepository = envioRepository;
    }



    public List<EnvioResponseDTO> getAllEnviosByIdOrden(Long idOrden){
        List<Envio> envioList = new ArrayList<>();
        List<EnvioResponseDTO> envioResponseDTOList = new ArrayList<>();

        //envioList = envioRepository.getEnviosByIdOrden(idOrden);
        envioList = envioRepository.findByIdOrden(idOrden);

        if(!envioList.isEmpty()){
            envioResponseDTOList = envioList.stream().map(
                    item ->{
                        EnvioResponseDTO dto = new EnvioResponseDTO();
                        dto.setIdEnvio(item.getIdEnvio());
                        dto.setIdOrden(item.getIdOrden());
                        dto.setEstado(item.getEstado());
                        dto.setFechaEstimada(item.getFechaEstimada());
                        dto.setDetalles(item.getDetalles());
                        return dto;
                    }
            ).toList();

        }
        return envioResponseDTOList;
    }

    /*
    public List<EnvioResponseDTO> getAllEnvios(){
        List<Envio> envioList = new ArrayList<>();
        List<EnvioResponseDTO> envioResponseDTOList = new ArrayList<>();

        envioList = envioRepository.findAll();

        if(!envioList.isEmpty()){
            envioResponseDTOList = envioList.stream().map(
                    item ->{
                        EnvioResponseDTO dto = new EnvioResponseDTO();
                        dto.setIdEnvio(item.getIdEnvio());
                        dto.setIdOrden(item.getIdOrden());
                        dto.setEstado(item.getEstado());
                        dto.setFechaEstimada(item.getFechaEstimada());
                        dto.setDetalles(item.getDetalles());
                        return dto;
                    }
            ).toList();

        }
        return envioResponseDTOList;
    }
*/

    public List<Envio> getAllEnvios(){
        return  envioRepository.findAll();
    }

    public EnvioResponseDTO getEnvioById(Long idEnvio) throws BadRequestException {

        if(idEnvio == null || idEnvio <= 0){
            throw  new BadRequestException("idEnvio del envio es invalido");
        }

        Envio env = envioRepository.findById(idEnvio).orElseThrow(()-> new EntityNotFoundException("Erro al obtener el envio con id: "+ idEnvio));


        EnvioResponseDTO envioResponseDTO = new EnvioResponseDTO();
        envioResponseDTO.setIdEnvio(env.getIdEnvio());
        envioResponseDTO.setIdOrden(env.getIdOrden());
        envioResponseDTO.setEstado(env.getEstado());
        envioResponseDTO.setFechaEstimada(env.getFechaEstimada());
        envioResponseDTO.setDetalles(env.getDetalles());
        return envioResponseDTO;
    }


}
