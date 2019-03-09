package comunicacion;

import usuario.Usuario;

public class SMS implements MedioDeComuncacion {

    @Override
    public void notificarACliente(Usuario usuario) {
        System.out.println("se notifico via sms");
        
    }

}
