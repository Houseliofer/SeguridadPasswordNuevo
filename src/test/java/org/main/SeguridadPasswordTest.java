package org.main;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.main.SeguridadPassword.NivelSeguridad.*;

public class SeguridadPasswordTest{
    @Test
    public void debil_cuando_tiene_menos_de_8_caracteres(){
        assertEquals(debil, SeguridadPassword.assessPassword("1234567"));
    }

    @Test
    public void debil_cuando_solo_tiene_letras(){
        assertEquals(debil , SeguridadPassword.assessPassword("abcdefghi"));
    }

    @Test
    public void medio_cuando_tiene_letras_y_numeros(){
        assertEquals(medio , SeguridadPassword.assessPassword("abcd1234"));
    }

    @Test
    public void fuerte_cuando_tiene_letras_numeros_y_simbolos(){
        assertEquals(fuerte, SeguridadPassword.assessPassword("abcd123!"));
    }
}