package pruebaUala.producto;

import java.time.LocalDate;

public class Pelicula extends Producto {

    private boolean ganoOscar;
    
    public Pelicula(boolean ganoOscar, Integer duracionSegundos, LocalDate anioEstreno) {
        super(duracionSegundos, anioEstreno);
        this.ganoOscar = ganoOscar;
    }

    public boolean isGanoOscar() {
        return ganoOscar;
    }

    public void setGanoOscar(boolean ganoOscar) {
        this.ganoOscar = ganoOscar;
    }

    @Override
    public boolean esInteresante() {
        return ganoOscar;
    }

}
