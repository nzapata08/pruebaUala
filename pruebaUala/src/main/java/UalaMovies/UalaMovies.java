package UalaMovies;

import java.util.ArrayList;
import java.util.List;

import pruebaUala.producto.Producto;
import usuario.Usuario;

public class UalaMovies {

    private static UalaMovies ualaMoviesSingleton;
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private double montoACobrar = 20;
    private List<Producto> productos = new ArrayList<Producto>();


    private UalaMovies() {
        super();
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
        usuarios.add(nuevoUsuario);
    }

    public void cobrarAUsuarios() {
        usuarios.stream().forEach((usuario)-> usuario.cobrar(montoACobrar));
    }

    public double getMontoACobrar() {
        return montoACobrar;
    }

    public static UalaMovies getInstancia() {
        if(ualaMoviesSingleton == null) {
            ualaMoviesSingleton = new UalaMovies();
        }
        return ualaMoviesSingleton;
    }


    public void setMontoACobrar(double montoACobrar) {
        this.montoACobrar = montoACobrar;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
