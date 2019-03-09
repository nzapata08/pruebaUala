package UalaMovies;

import java.util.List;

import comunicacion.Mail;
import comunicacion.MedioDeComuncacion;
import pruebaUala.producto.Documental;
import pruebaUala.producto.Pelicula;
import pruebaUala.producto.Producto;
import pruebaUala.producto.Serie;
import recomendacion.Contento;
import recomendacion.Recomendacion;
import usuario.Usuario;

import java.time.LocalDate;


public class PruebaAplicacion {

    public static void main(String[] args) {
        UalaMovies ualaMovies = UalaMovies.getInstancia();
        ualaMovies.setMontoACobrar(40);

        Producto pelicula = new Pelicula(false, 7500, LocalDate.of(1990, 01, 15));
        Producto documental = new Documental("unofficial Documental", 5000, LocalDate.of(1991, 01, 15));
        Producto serie = new Serie(5, 7000, LocalDate.of(1989, 01, 15));

        ualaMovies.agregarProducto(pelicula);
        ualaMovies.agregarProducto(documental);
        ualaMovies.agregarProducto(serie);

        Recomendacion estadoDeAnimo = new Contento();

        MedioDeComuncacion medioDeComunicacion = new Mail();

        Usuario usuario = new Usuario(500, estadoDeAnimo, medioDeComunicacion);

        ualaMovies.agregarUsuario(usuario);

        List<Producto> recomendaciones = usuario.getEstadoDeAnimo().recomendarPeliculas();

        for (Producto producto :recomendaciones) {
            usuario.mirar(producto);
        }

        ualaMovies.cobrarAUsuarios();
        
        System.out.println(usuario.getCredito());
        System.out.println(usuario.esAntiguo());
        System.out.println(usuario.miroAlgoInteresante());
        
    }

}
