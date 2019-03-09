package pruebaUala.pruebaUala;

import java.time.LocalDate;
import java.util.List;

import UalaMovies.UalaMovies;
import comunicacion.Mail;
import comunicacion.MedioDeComuncacion;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pruebaUala.producto.Documental;
import pruebaUala.producto.Pelicula;
import pruebaUala.producto.Producto;
import pruebaUala.producto.Serie;
import recomendacion.Contento;
import recomendacion.Recomendacion;
import usuario.Usuario;

/**
 * Unit test for simple App.
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

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp()
    {
        
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
        
        assertTrue(usuario.getCredito() == 460);
        assertTrue(usuario.esAntiguo() == true);
        assertTrue(usuario.miroAlgoInteresante() == true);
        
    }
}
