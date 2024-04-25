package ar.edu.unju.fi.ejercicio3.constantes;

/**
 * Enumerado que contiene algunas provincias de Argentina con su cantidad de poblacion y superficie.
 */
public enum Provincia {
    JUJUY(811000, 53219),
    SALTA(1440000, 155488),
    TUCUMAN(1730000, 22524),
    CATAMARCA(430000, 102602),
    LA_RIOJA(380000, 89680),
    SANTIAGO_DEL_ESTERO(1060000, 136351),;

    private final Integer cantidadPoblacion;
    private final Integer superficie;


    Provincia(Integer cantidadPoblacion, Integer superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }


    public Integer getCantidadPoblacion() {
        return cantidadPoblacion;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    /**
     * Calcula la densidad poblacional de la provincia.
     * @return Densidad poblacional de la provincia.
     */
    public Float getDensidadPoblacional() {
        return (float)(cantidadPoblacion / (float)superficie);
    }

}
