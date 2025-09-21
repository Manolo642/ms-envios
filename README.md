# 📦 MS-ENVIOS

Microservicio de **gestión de envíos** desarrollado con **Spring Boot**.  
Forma parte de una arquitectura basada en microservicios y expone endpoints REST para manejar envíos.  
El microservicio **`ms-ordenes` consume la información de `ms-envios` mediante Feign Client**,
lo que permite enriquecer las órdenes con datos relacionados a los envíos.

---

## 🚀 Tecnologías utilizadas

- **Java 17+**
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
- **Maven**
- **Lombok**
- **MySQL**

---



## 🔗 Relación con MS-ORDENES

Este microservicio es **consumido por `ms-ordenes`** mediante **Feign Client**, lo que permite que al consultar o registrar órdenes se pueda acceder a información de los envíos.

Ejemplo de cliente Feign en `ms-ordenes`:

```java
@FeignClient(name = "ms-envios", url = "http://localhost:8082/api/envios")
public interface EnvioClient {

    @GetMapping("/{id}")
    EnvioResponseDTO obtenerEnvioPorId(@PathVariable Long id);
}
