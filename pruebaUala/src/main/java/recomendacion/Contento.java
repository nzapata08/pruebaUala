package recomendacion;

import java.util.List;

import pruebaUala.producto.Producto;
import UalaMovies.UalaMovies;

public class Contento implements Recomendacion {

    public List<Producto> recomendarPeliculas(){ 
        return UalaMovies.getInstancia().getProductos();
    }
}
