package com.app.ms.envios.entiti;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "paquete")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaquete")
    private Long idPaquete;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "codigo",nullable = false)
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnvio",nullable = false)
    //@JsonBackReference
    @JsonIgnore
    private Envio envio;

}
