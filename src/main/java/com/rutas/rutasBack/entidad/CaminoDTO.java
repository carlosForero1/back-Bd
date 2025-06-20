package com.rutas.rutasBack.entidad;

public class CaminoDTO {
    private int seq;
    private int pathSeq;
    private int node;
    private int edge;
    private double cost;
    private double aggCost;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getPathSeq() {
        return pathSeq;
    }

    public void setPathSeq(int pathSeq) {
        this.pathSeq = pathSeq;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getEdge() {
        return edge;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAggCost() {
        return aggCost;
    }

    public void setAggCost(double aggCost) {
        this.aggCost = aggCost;
    }
}
