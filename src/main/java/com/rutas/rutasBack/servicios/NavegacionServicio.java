package com.rutas.rutasBack.servicios;

import com.rutas.rutasBack.entidad.CaminoDTO;
import com.rutas.rutasBack.repositorio.GrafoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NavegacionServicio {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GrafoRepository grafoRepository;

    public List<CaminoDTO> obtenerCamino(int inicio, int fin) {
        List<Object[]> resultado = grafoRepository.obtenerCaminoMasCorto(inicio, fin);
        return grafoRepository.mapearResultado(resultado);
    }
}




