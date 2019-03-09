package comunicacion;

import usuario.Usuario;

public class Celular implements MedioDeComuncacion {

    @Override
    public void notificarACliente(Usuario usuario) {
        System.out.println("se notifico via celular");
        
    }

}
