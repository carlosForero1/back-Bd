package com.rutas.rutasBack.controlador;

import com.rutas.rutasBack.entidad.CaminoDTO;
import com.rutas.rutasBack.servicios.NavegacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/navegacion")
@CrossOrigin(origins = "http://localhost:3000")
public class NavegacionControlador {

    @Autowired
    private NavegacionServicio service;

    @Autowired
    private  JdbcTemplate jdbcTemplate;

    @GetMapping("/buscar")
    public List<CaminoDTO> buscarRuta(
            @RequestParam int origen,
            @RequestParam int destino,
            @RequestParam int combustible
    ) {
        return service.buscarCamino(origen, destino, combustible);
    }

    @GetMapping("/mapa")
    public Map<String, Object> getMapa() {
        List<Map<String, Object>> planetas = jdbcTemplate.queryForList("SELECT id, nombre FROM planeta");
        List<Map<String, Object>> rutas = jdbcTemplate.queryForList(
                "SELECT origen, destino, distancia, hay_estacion, hay_enemigos FROM ruta;"
        );

        Map<String, Object> mapa = new HashMap<>();
        mapa.put("planetas", planetas);
        mapa.put("rutas", rutas);
        return mapa;
    }

}
