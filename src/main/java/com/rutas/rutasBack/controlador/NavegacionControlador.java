package com.rutas.rutasBack.controlador;

import com.rutas.rutasBack.entidad.CaminoDTO;
import com.rutas.rutasBack.servicios.NavegacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navegacion")
@CrossOrigin(origins = "http://localhost:3000")
public class NavegacionControlador {

    @Autowired
    private NavegacionServicio service;

    @GetMapping("/buscar")
    public List<CaminoDTO> buscarRuta(
            @RequestParam int origen,
            @RequestParam int destino,
            @RequestParam int combustible
    ) {
        return service.buscarCamino(origen, destino, combustible);
    }
}
