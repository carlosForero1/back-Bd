package com.rutas.rutasBack.entidad;

import java.util.List;

public class CaminoDTO {
    private List<Integer> caminoOut;  // para el array de enteros
    private int distanciaOut;

    // Getters y setters
    public List<Integer> getCaminoOut() {
        return caminoOut;
    }

    public void setCaminoOut(List<Integer> caminoOut) {
        this.caminoOut = caminoOut;
    }

    public int getDistanciaOut() {
        return distanciaOut;
    }

    public void setDistanciaOut(int distanciaOut) {
        this.distanciaOut = distanciaOut;
    }
}
