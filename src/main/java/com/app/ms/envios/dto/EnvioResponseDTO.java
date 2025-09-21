package com.app.ms.envios.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class EnvioResponseDTO {

    private Long idEnvio;

    private Long idOrden;

    private String Estado;
    private LocalDate fechaEstimada;

    private String detalles;
}
