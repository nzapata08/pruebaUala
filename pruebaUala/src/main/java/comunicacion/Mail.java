package comunicacion;

import usuario.Usuario;

public class Mail implements MedioDeComuncacion {

    @Override
    public void notificarACliente(Usuario usuario) {
        System.out.println("se notifico via mail");
        
    }

}
