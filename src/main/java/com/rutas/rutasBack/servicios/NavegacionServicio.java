package com.rutas.rutasBack.servicios;

import com.rutas.rutasBack.entidad.CaminoDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Service
public class NavegacionServicio {

    private final JdbcTemplate jdbcTemplate;

    public NavegacionServicio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CaminoDTO> buscarCamino(int origen, int destino, int combustible) {
        String sql = "SELECT * FROM buscar_camino(?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{origen, destino, combustible}, new RowMapper<CaminoDTO>() {
            @Override
            public CaminoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                CaminoDTO camino = new CaminoDTO();

                // Obtener el array SQL y convertirlo a List<Integer>
                Array caminoSqlArray = rs.getArray("camino_out");
                if (caminoSqlArray != null) {
                    Integer[] caminoArray = (Integer[]) caminoSqlArray.getArray();
                    camino.setCaminoOut(Arrays.asList(caminoArray));
                } else {
                    camino.setCaminoOut(List.of());
                }

                // Obtener la distancia
                camino.setDistanciaOut(rs.getInt("distancia_out"));

                return camino;
            }
        });
    }
}
