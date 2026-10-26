package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidadorTest {

    private Validador validadorNulo;
    private Validador validadorVacio;
    private Validador validadorBlanco;

    @Before
    public void setUp() throws Exception {
        // Configuramos los eslabones
        validadorNulo = new ValidadorNoNulo();
        validadorVacio = new ValidadorNoVacio();
        validadorBlanco = new ValidadorNoBlanco();

        // Unimos los eslabones para formar la cadena
        validadorNulo.setSiguiente(validadorVacio);
        validadorVacio.setSiguiente(validadorBlanco);
    }

    @Test
    public void testCasoUnoEsNull() {
        String caso1 = null;
        assertFalse(validadorNulo.procesar(caso1));
    }

    @Test
    public void testCasoDosEsVacio() {
        String caso2 = "";
        assertFalse(validadorNulo.procesar(caso2));
    }

    @Test
    public void testCasoTresEspaciosEnBlanco() {
        String caso3 = "   ";
        assertFalse(validadorNulo.procesar(caso3));
    }

    @Test
    public void testCasoCuatroTextoValido() {
        String caso4 = "Texto Válido";
        assertTrue(validadorNulo.procesar(caso4));
    }
}