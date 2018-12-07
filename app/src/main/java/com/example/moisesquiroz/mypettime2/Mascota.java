package com.example.moisesquiroz.mypettime2;

public class Mascota {
    private String planetName;
    private int edad;
    private int nacimiento;
    private int peso;
    public Mascota(String planetName, int edad, int nacimiento, int peso) {
        this.planetName = planetName;
        this.edad = edad;
        this.nacimiento = nacimiento;
        this.peso = peso;
    }
    public String getPlanetName() {
        return planetName;
    }
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
}