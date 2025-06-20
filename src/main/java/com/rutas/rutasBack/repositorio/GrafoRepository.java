package com.rutas.rutasBack.repositorio;

import com.rutas.rutasBack.entidad.CaminoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GrafoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> obtenerCaminoMasCorto(int inicio, int fin) {
        String sql = "SELECT * FROM camino_mas_corto(:inicio, :fin)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("inicio", inicio);
        query.setParameter("fin", fin);

        return query.getResultList();
    }

    public List<CaminoDTO> mapearResultado(List<Object[]> resultados) {
        List<CaminoDTO> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            CaminoDTO dto = new CaminoDTO();
            dto.setSeq(((Number) fila[0]).intValue());
            dto.setPathSeq(((Number) fila[1]).intValue());
            dto.setNode(((Number) fila[2]).intValue());
            dto.setEdge(((Number) fila[3]).intValue());
            dto.setCost(((Number) fila[4]).doubleValue());
            dto.setAggCost(((Number) fila[5]).doubleValue());
            lista.add(dto);
        }
        return lista;
    }
}
