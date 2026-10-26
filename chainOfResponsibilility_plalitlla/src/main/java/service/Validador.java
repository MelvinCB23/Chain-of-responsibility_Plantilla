package service;

// Clase abstracta base
abstract class Validador {

    protected Validador siguiente;

    public void setSiguiente(Validador siguiente) {
        this.siguiente = siguiente;
    }

    public abstract boolean procesar(String texto);

    // Método auxiliar para avanzar al siguiente eslabón
    protected boolean verificarSiguiente(String texto) {
        if (siguiente == null) {
            return true; // Llegamos al final de la cadena con éxito
        }
        return siguiente.procesar(texto);
    }
}

// Eslabón 1: Verifica que no sea nulo
class ValidadorNoNulo extends Validador {
    @Override
    public boolean procesar(String texto) {
        if (null == texto) {
            System.out.println("Fallo: El texto es nulo.");
            return false;
        }
        return verificarSiguiente(texto);
    }
}

// Eslabón 2: Verifica que no esté vacío (longitud > 0)
class ValidadorNoVacio extends Validador {
    @Override
    public boolean procesar(String texto) {
        if (texto.isEmpty()) {
            System.out.println("Fallo: El texto tiene longitud cero (isEmpty).");
            return false;
        }
        return verificarSiguiente(texto);
    }
}

// Eslabón 3: Verifica que no sean solo espacios en blanco
class ValidadorNoBlanco extends Validador {
    @Override
    public boolean procesar(String texto) {
        if (texto.isBlank()) {
            System.out.println("Fallo: El texto solo contiene espacios (isBlank).");
            return false;
        }
        return verificarSiguiente(texto);
    }
}