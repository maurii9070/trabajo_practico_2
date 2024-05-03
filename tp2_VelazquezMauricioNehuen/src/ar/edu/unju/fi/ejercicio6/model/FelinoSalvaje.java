package ar.edu.unju.fi.ejercicio6.model;

public class FelinoSalvaje {
    private String nombre;
    private Byte edad;
    private Float peso;

    public FelinoSalvaje() {
    }

    public FelinoSalvaje(String nombre, Byte edad, Float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "FelinoSalvaje{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte getEdad() {
        return edad;
    }

    public void setEdad(Byte edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
}
