public class NodoArbol {
    
    int dato;
    NodoArbol izq, der;
    
    NodoArbol (int dato) {
        this.dato = dato;
        izq = null;
        der = null;
    }

    public int getDato () {
        return dato;
    }

    public void setDato (int dato) {
        this.dato = dato;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }
}
