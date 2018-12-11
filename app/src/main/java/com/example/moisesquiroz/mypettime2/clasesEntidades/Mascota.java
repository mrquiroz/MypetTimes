package com.example.moisesquiroz.mypettime2.clasesEntidades;

public class Mascota {
    private String planetName;
    private String especie;
    private String fechaNacimiento;
    private int id;

    public Mascota(String planetName, String especie, String fechaNacimiento, int id) {
        this.planetName = planetName;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.id = id;
    }

    public String getPlanetName() {
        return planetName;
    }
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}