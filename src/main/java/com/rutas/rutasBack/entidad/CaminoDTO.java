package com.rutas.rutasBack.entidad;

public class CaminoDTO {
    private String camino;
    private int distanciaTotal;

    public CaminoDTO() {}

    public CaminoDTO(String camino, int distanciaTotal) {
        this.camino = camino;
        this.distanciaTotal = distanciaTotal;
    }

    public String getCamino() {
        return camino;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }

    public int getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(int distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }
}
