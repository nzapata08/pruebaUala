package pruebaUala.producto;

import java.time.LocalDate;

public class Documental extends Producto {

    private String titulo;

    public Documental(String titulo, Integer duracionSegundos, LocalDate anioEstreno) {
        super(duracionSegundos, anioEstreno);

        this.titulo = titulo;
    }



    @Override
    public boolean esInteresante() {
        return titulo.contains("unofficial");
    }

}
