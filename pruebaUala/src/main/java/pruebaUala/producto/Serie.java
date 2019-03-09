package pruebaUala.producto;

import java.time.LocalDate;

public class Serie extends Producto {

    private int cantidadTemporadas;
    
    public Serie(int cantidadTemporadas, Integer duracionSegundos, LocalDate anioEstreno) {
        super(duracionSegundos, anioEstreno);
        this.cantidadTemporadas = cantidadTemporadas;
    }

    @Override
    public boolean esInteresante() {
        return cantidadTemporadas >= 4 && cantidadTemporadas <= 5;
        
    }

}
