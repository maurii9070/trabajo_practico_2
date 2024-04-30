package ar.edu.unju.fi.ejercicio5.model;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

import java.time.LocalDate;

/**
 * Clase PagoTarjeta que implementa la interfaz Pago
 * y define los métodos realizarPago e imprimirPago
 * @autor Velazquez Mauricio Nehuen
 * @version 1.0
 */
public class PagoTarjeta implements Pago {

    private String numeroTarjeta;
    private LocalDate fechaPago;
    private Double montoPagado;

    public PagoTarjeta() {}

    public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, Double montoPagado) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaPago = fechaPago;
        this.montoPagado = montoPagado;
    }

    @Override
    public void realizarPago(double monto) {
        montoPagado = monto + monto * 0.15;
    }

    @Override
    public void imprimirPago() {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN+"######## Pago con tarjeta de crédito ########"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"# Numero de tarjeta: " + numeroTarjeta+ANSI_RESET);
        System.out.println(ANSI_GREEN+"# Fecha de pago: " + fechaPago+ANSI_RESET);
        System.out.println(ANSI_GREEN+"# Monto pagado: $" + montoPagado+ANSI_RESET);
        System.out.println(ANSI_GREEN+"#############################################"+ANSI_RESET);
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }
}
