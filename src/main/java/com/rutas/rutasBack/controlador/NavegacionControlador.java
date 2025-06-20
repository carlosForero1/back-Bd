package com.rutas.rutasBack.controlador;


import com.rutas.rutasBack.entidad.CaminoDTO;
import com.rutas.rutasBack.servicios.NavegacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navegacion")
@CrossOrigin(origins = "http://localhost:3000")
public class NavegacionControlador {
    @Autowired
    private NavegacionServicio service;

    @GetMapping("/camino")
    public ResponseEntity<List<CaminoDTO>> obtenerCamino(
            @RequestParam int inicio,
            @RequestParam int fin) {
        List<CaminoDTO> camino = service.obtenerCamino(inicio, fin);
        return ResponseEntity.ok(camino);
    }
}

