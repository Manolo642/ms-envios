package com.app.ms.envios.repositori;

import com.app.ms.envios.entiti.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EnvioRepository extends JpaRepository<Envio,Long> {

    //@Query("SELECT e FROM envio e WHERE e.idOrden =: idOrden")
    //List<Envio> getEnviosByIdOrden(@Param("idOrden")Long idOrden);

    List<Envio> findByIdOrden(Long id_Orden);

}
