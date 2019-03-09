package recomendacion;

import static java.time.temporal.ChronoUnit.YEARS;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.util.ArrayList;
import java.util.List;

import UalaMovies.UalaMovies;
import pruebaUala.producto.Producto;

public class Melancolico implements Recomendacion {

    public List<Producto> recomendarPeliculas(){ 

        List<Producto> recomendaciones = new ArrayList<Producto>();
        List<Producto> productos =  UalaMovies.getInstancia().getProductos();

        ChronoLocalDate to = ChronoLocalDate.from(LocalDate.now());

        for (Producto producto: productos) {
            ChronoLocalDate from = ChronoLocalDate.from(producto.getAnioEstreno());
            ChronoPeriod period = ChronoPeriod.between(from, to);
            if (period.get(YEARS) >= 10) {
                recomendaciones.add(producto);
            }
        }

        return recomendaciones;

    }

}
