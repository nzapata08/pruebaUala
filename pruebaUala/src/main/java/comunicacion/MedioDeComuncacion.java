package comunicacion;

import usuario.Usuario;

public interface MedioDeComuncacion {

    /**
     * En base a la informacion del cliente lo notifica
     * 
     * @param usuario Usuario al que hay que notificar
     */
    void notificarACliente(Usuario usuario);
    
}
