package com.rutas.rutasBack.servicios;

import com.rutas.rutasBack.entidad.CaminoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class NavegacionServicio {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CaminoDTO> buscarCamino(int origen, int destino, int combustible) {
        String sql = "SELECT * FROM buscar_camino_mas_corto(?, ?, ?)";

        return jdbcTemplate.query(sql, new Object[]{origen, destino, combustible}, (rs, rowNum) -> mapRowToCaminoDTO(rs));
    }

    private CaminoDTO mapRowToCaminoDTO(ResultSet rs) throws SQLException {
        CaminoDTO camino = new CaminoDTO();
        camino.setCamino(rs.getString("camino"));
        camino.setDistanciaTotal(rs.getInt("distancia_total"));
        return camino;
    }
}
