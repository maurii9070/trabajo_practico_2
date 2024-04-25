package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

/**
 * Clase que representa una efeméride.
 * @author Velazquez, Mauricio Nehuen.
 * @version 1.0
 */
public class Efemeride {
    private String codigo;
    private Mes mes;
    private Byte dia;
    private String detalle;

    public Efemeride() {}

    /**
     * Constructor de la clase Efemeride.
     * @param codigo Código de la efeméride.
     * @param mes Mes de la efeméride.
     * @param dia Día de la efeméride.
     * @param detalle Detalle de la efeméride.
     */
    public Efemeride(String codigo, Mes mes, Byte dia, String detalle) {
        this.codigo = codigo;
        this.mes = mes;
        this.dia = dia;
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Efemeride{" +
                "codigo='" + codigo + '\'' +
                ", mes=" + mes +
                ", dia=" + dia +
                ", detalle='" + detalle + '\'' +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Byte getDia() {
        return dia;
    }

    public void setDia(Byte dia) {
        this.dia = dia;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
