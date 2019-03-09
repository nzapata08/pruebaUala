package pruebaUala.pruebaUala;

import java.time.LocalDate;
import java.util.List;

import UalaMovies.UalaMovies;
import comunicacion.Mail;
import comunicacion.MedioDeComuncacion;
import junit.framework.TestCase;
import pruebaUala.producto.Documental;
import pruebaUala.producto.Pelicula;
import pruebaUala.producto.Producto;
import pruebaUala.producto.Serie;
import recomendacion.Contento;
import recomendacion.Recomendacion;
import recomendacion.Triste;
import usuario.Usuario;

/**
 * Se prueba la funcionalidad de recomendar peliculas a los usuarios segun 
 * su estado de animo de ese momento para eso se uso el patron state el cual 
 * responde de una manera distinta, se uso el singleton que representa 
 * a la parte del sistema que contiene informacion de los usuarios, peliculas
 * y monto a cobrar a cada uno de los usuario registrados
 * se prueba ademas si el cliente es antiguo y si miro algo interesante
 * tanto en forma positiva como negativa
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

  

    /**
     * Se prueba si un cliente es antiguo 
     * se prueba con un usuario contento
     */
    public void testClienteAntiguo()
    {
        UalaMovies ualaMovies = UalaMovies.getInstancia();
        ualaMovies.setMontoACobrar(40);

        Producto pelicula = new Pelicula(false, 7500, LocalDate.of(1990, 1, 15));
        Producto documental = new Documental("unofficial Documental", 5000, LocalDate.of(1991, 1, 15));
        Producto serie = new Serie(5, 7000, LocalDate.of(1989, 1, 15));

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
        
        assertTrue(usuario.esAntiguo() == true);
        
    }
    
    /**
     * Se prueba si un cliente es antiguo 
     */
    public void testNoEsClienteAntiguo()
    {
        UalaMovies ualaMovies = UalaMovies.getInstancia();
        ualaMovies.setMontoACobrar(40);

        Producto pelicula = new Pelicula(false, 7500, LocalDate.of(2019, 1, 15));
        Producto documental = new Documental("unofficial Documental", 5000, LocalDate.of(2018, 5, 15));
        Producto serie = new Serie(5, 7000, LocalDate.of(2018, 8 , 15));

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
        
        assertTrue(usuario.esAntiguo() == false);
        
    }
    
    
    /**
     * Se prueba con un usuario Contento que ve un producto interesante
     * y un usuario triste que no ve ningun producto interesante
     */
    public void testMiroAlgoInteresante()
    {
        UalaMovies ualaMovies = UalaMovies.getInstancia();
        ualaMovies.setMontoACobrar(40);

        Producto pelicula = new Pelicula(false, 7200, LocalDate.of(1990, 1, 15));
        Producto documental = new Documental("unofficial Documental", 5000, LocalDate.of(1991, 1, 15));
        Producto serie = new Serie(5, 7000, LocalDate.of(1989, 1, 15));

        ualaMovies.agregarProducto(pelicula);
        ualaMovies.agregarProducto(documental);
        ualaMovies.agregarProducto(serie);

        Recomendacion estadoDeAnimoContento = new Contento();
        Recomendacion estadoDeAnimoTriste = new Triste();

        MedioDeComuncacion medioDeComunicacion = new Mail();

        Usuario usuario1 = new Usuario(500, estadoDeAnimoContento, medioDeComunicacion);
        Usuario usuario2 = new Usuario(500, estadoDeAnimoTriste, medioDeComunicacion);

        ualaMovies.agregarUsuario(usuario1);
        ualaMovies.agregarUsuario(usuario2);

        List<Producto> recomendaciones = usuario1.getEstadoDeAnimo().recomendarPeliculas();

        for (Producto producto :recomendaciones) {
            usuario1.mirar(producto);
        }
        
        List<Producto> recomendaciones2 = usuario2.getEstadoDeAnimo().recomendarPeliculas();

        for (Producto producto :recomendaciones2) {
            usuario1.mirar(producto);
        }
        
        ualaMovies.cobrarAUsuarios();
        
        assertTrue(usuario1.miroAlgoInteresante() == true);
        assertTrue(usuario2.miroAlgoInteresante() == false);
        
    }
    
    
    /**
     * Se prueba con un usuario Contento que ve un producto interesante
     * y un usuario triste que se le cobre lo correspondinte dependiendo del valor
     * del servicio en ese momento
     */
    public void testCobrarAUsuarios()
    {
        UalaMovies ualaMovies = UalaMovies.getInstancia();
        ualaMovies.setMontoACobrar(40);

        Producto pelicula = new Pelicula(false, 7200, LocalDate.of(1990, 1, 15));
        Producto documental = new Documental("unofficial Documental", 5000, LocalDate.of(1991, 1, 15));
        Producto serie = new Serie(5, 7000, LocalDate.of(1989, 1, 15));

        ualaMovies.agregarProducto(pelicula);
        ualaMovies.agregarProducto(documental);
        ualaMovies.agregarProducto(serie);

        Recomendacion estadoDeAnimoContento = new Contento();
        Recomendacion estadoDeAnimoTriste = new Triste();

        MedioDeComuncacion medioDeComunicacion = new Mail();

        Usuario usuario1 = new Usuario(500, estadoDeAnimoContento, medioDeComunicacion);
        Usuario usuario2 = new Usuario(200, estadoDeAnimoTriste, medioDeComunicacion);

        ualaMovies.agregarUsuario(usuario1);
        ualaMovies.agregarUsuario(usuario2);

        List<Producto> recomendaciones = usuario1.getEstadoDeAnimo().recomendarPeliculas();

        for (Producto producto :recomendaciones) {
            usuario1.mirar(producto);
        }
        
        List<Producto> recomendaciones2 = usuario2.getEstadoDeAnimo().recomendarPeliculas();

        for (Producto producto :recomendaciones2) {
            usuario1.mirar(producto);
        }
        
        ualaMovies.cobrarAUsuarios();
        
        assertTrue(usuario1.getCredito() == 460);
        assertTrue(usuario2.getCredito() == 160);
        
        
        ualaMovies.setMontoACobrar(100);
        ualaMovies.cobrarAUsuarios();
        
        assertTrue(usuario1.getCredito() == 360);
        assertTrue(usuario2.getCredito() == 60);
        
    }
}
