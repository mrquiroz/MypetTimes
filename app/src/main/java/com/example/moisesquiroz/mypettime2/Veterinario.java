package com.example.moisesquiroz.mypettime2;

public class Veterinario {
    private String nombre;
    private String fecha;
    private int id;
    private int idMascota;

    public Veterinario(String nombre, String fecha, int id, int idMascota) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.id = id;
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
}
