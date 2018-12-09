package com.example.moisesquiroz.mypettime2;

public class Ejercicio {
    private String etiqueta;
    private String hora;
    private int duracion;
    private int id;
    private int idMascota;

    public Ejercicio(String etiqueta, String hora, int duracion, int id, int idMascota) {
        this.etiqueta = etiqueta;
        this.hora = hora;
        this.duracion = duracion;
        this.id = id;
        this.idMascota = idMascota;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
}
