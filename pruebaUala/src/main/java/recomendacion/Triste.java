package recomendacion;

import java.util.ArrayList;
import java.util.List;

import UalaMovies.UalaMovies;
import pruebaUala.producto.Producto;

public class Triste implements Recomendacion {

    public List<Producto> recomendarPeliculas(){ 
        List<Producto> productos = UalaMovies.getInstancia().getProductos();
        List<Producto> recomendaciones = new ArrayList<Producto>();

        for (Producto producto : productos) {
            if(producto.getDuracionSegundos() >= 72000) {
                recomendaciones.add(producto);
            }
        }
        return recomendaciones;
    }
}
