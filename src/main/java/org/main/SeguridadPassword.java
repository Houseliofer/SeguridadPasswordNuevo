package org.main;

public class SeguridadPassword {
    public enum NivelSeguridad{
        debil, medio, fuerte
    }//

    public static NivelSeguridad assessPassword(String password){

        if(password.length() < 8)
            return NivelSeguridad.debil;

        if(password.matches("[a-zA-Z]+"))
            return NivelSeguridad.debil;

        if(password.matches("[a-zA-Z0-9]+"))
            return NivelSeguridad.medio;

        return NivelSeguridad.fuerte;
    }
}
