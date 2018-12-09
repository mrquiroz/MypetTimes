package com.example.moisesquiroz.mypettime2;

public class Medicamento {
    private String nombre;
    private String hora;
    private int id;
    private int idMascota;

    public Medicamento(String nombre, String hora, int id, int idMascota) {
        this.nombre = nombre;
        this.hora = hora;
        this.id = id;
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
}
