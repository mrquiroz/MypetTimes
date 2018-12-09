package com.example.moisesquiroz.mypettime2;

public class Comida {
    private String etiqueta;
    private String hora;
    private int cantidad;
    private int id;
    private int idMascota;

    public Comida(String etiqueta, String hora, int cantidad, int id, int idMascota) {
        this.etiqueta = etiqueta;
        this.hora = hora;
        this.cantidad = cantidad;
        this.id = id;
        this.idMascota = idMascota;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
}
