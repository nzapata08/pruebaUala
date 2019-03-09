package usuario;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.util.ArrayList;
import java.util.List;

import comunicacion.MedioDeComuncacion;
import pruebaUala.producto.Producto;
import recomendacion.Recomendacion;
import static java.time.temporal.ChronoUnit.*;

public class Usuario {

    private double credito;
    private Recomendacion estadoDeAnimo;
    private List<Producto> productosMirados = new ArrayList<>();
    private List<MedioDeComuncacion> mediosDeComunicacion = new ArrayList<MedioDeComuncacion>();

    
    public Usuario(double credito, Recomendacion estadoDeAnimo, MedioDeComuncacion medioDeComunicacion) {
        super();
        this.credito = credito;
        this.estadoDeAnimo = estadoDeAnimo;
        this.mediosDeComunicacion.add(medioDeComunicacion);
    }

    public void agregarMedioDeComunicacion(MedioDeComuncacion medioDeComunicacion) {
        this.mediosDeComunicacion.add(medioDeComunicacion);
    }

    public void agregarCredito(double recarga) {
        credito = credito + recarga;
    }
    
    

    public double getCredito() {
        return credito;
    }

    public boolean esAntiguo() {
        ChronoLocalDate to = ChronoLocalDate.from(LocalDate.now());

        for(Producto producto : productosMirados) {
            ChronoLocalDate from = ChronoLocalDate.from(producto.getAnioEstreno());
            ChronoPeriod period = ChronoPeriod.between(from, to);

            if (period.get(YEARS) < 2) {
                return false;
            }

        }
        return true;
    }

    public boolean miroAlgoInteresante() {
        for (Producto producto : this.productosMirados) {
            if (producto.esInteresante()) {
                return true;
            }
        }
        return false;
    }

    public void cobrar(double unMonto) {
        credito = credito - unMonto;
        mediosDeComunicacion.stream().forEach((medioDeComunicacion) -> medioDeComunicacion.notificarACliente(this));
    }

    public Recomendacion getEstadoDeAnimo() {
        return estadoDeAnimo;
    }

    public void setEstadoDeAnimo(Recomendacion estadoDeAnimo) {
        this.estadoDeAnimo = estadoDeAnimo;
    }

    public void mirar(Producto producto) {
        this.productosMirados.add(producto);
    }

}
