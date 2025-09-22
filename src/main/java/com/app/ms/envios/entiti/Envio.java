package com.app.ms.envios.entiti;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnvio;
    private Long idOrden;
    private String Estado;
    private LocalDate fechaEstimada;
    private String detalles;

    @OneToMany(mappedBy = "envio",cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonManagedReference
    private List<Paquete> paquetes;
}
