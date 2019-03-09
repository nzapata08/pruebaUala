package pruebaUala.producto;

import java.time.LocalDate;

public abstract class Producto {

    private Integer duracionSegundos;
    private LocalDate anioEstreno;

    public Producto(Integer duracionSegundos, LocalDate anioEstreno) {
        super();
        this.duracionSegundos = duracionSegundos;
        this.anioEstreno = anioEstreno;
    }

    public abstract boolean esInteresante();

    public Integer getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(Integer duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public LocalDate getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(LocalDate anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

}
