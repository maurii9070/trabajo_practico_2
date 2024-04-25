package ar.edu.unju.fi.ejercicio4.model;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase Jugador, representa un jugador de fútbol.
 * @author Velazquez, Mauricio Nehuen.
 * @version 1.0
 * */
public class Jugador {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private Short estatura;
    private Short peso;
    private Posicion posicion;

    public Jugador() {}

    public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, Short estatura, Short peso, Posicion posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.estatura = estatura;
        this.peso = peso;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", estatura=" + estatura +
                ", peso=" + peso +
                ", posicion=" + posicion +
                ", edad=" + calcularEdad() +
                '}';
    }

    public Byte calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        return (byte) Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
