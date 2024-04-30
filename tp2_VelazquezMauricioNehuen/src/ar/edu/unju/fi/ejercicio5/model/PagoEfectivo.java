package ar.edu.unju.fi.ejercicio5.model;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

import java.time.LocalDate;

public class PagoEfectivo implements Pago {

    private Double montoPagado;
    private LocalDate fechaPago;

    public PagoEfectivo() {}

    public PagoEfectivo(Double montoPagado, LocalDate fechaPago) {
        this.montoPagado = montoPagado;
        this.fechaPago = fechaPago;
    }

    @Override
    public void realizarPago(double monto) {
        montoPagado = monto - monto * 0.10;
    }

    @Override
    public void imprimirPago() {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN+"######## Pago en efectivo ########"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"# Fecha de pago: " + fechaPago+ANSI_RESET);
        System.out.println(ANSI_GREEN+"# Monto pagado: $" + montoPagado+ANSI_RESET);
        System.out.println(ANSI_GREEN+"##################################"+ANSI_RESET);
    }

    public Double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
