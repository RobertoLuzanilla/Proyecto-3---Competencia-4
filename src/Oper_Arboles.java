public class Oper_Arboles {
    
    NodoArbol raiz = null;
    
    void Insertar(NodoArbol n, int x) {
        NodoArbol nuevo = new NodoArbol(x);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            if (x < n.getDato()) {
                if (n.izq == null)
                    n.izq = nuevo;
                else
                    Insertar(n.izq, x);
            } else {
                if (x > n.getDato()) {
                    if (n.der == null)
                        n.der = nuevo;
                    else
                        Insertar(n.der, x);
                }
            }
        }
    }
    boolean EliminarNumero(NodoArbol p, NodoArbol n, int y) {
        if (n.getDato() == y) {
            if (n.izq == null && n.der == null) {
                if (n == raiz)
                    raiz = null;
                else {
                    if (n == p.izq)
                        p.izq = null;
                    else
                        p.der = null;
                }
            } else {
                if (n.izq != null && n.der == null) {
                    if (n == raiz) {
                        NodoArbol aux = n.izq;
                        n.izq = null;
                        raiz = aux;
                    } else {
                        if (n == p.izq) {
                            p.izq = n.izq;
                            n.izq = null;
                        } else {
                            p.der = n.izq;
                            n.izq = null;
                        }
                    }
                } else {
                    if (n.izq == null && n.der != null) {
                        if (n == raiz) {
                            NodoArbol aux = n.der;
                            n.der = null;
                            raiz = aux;
                        } else {
                            if (n == p.izq) {
                                p.izq = n.der;
                                n.der = null;
                            } else {
                                p.der = n.der;
                                n.der = null;
                            }
                        }
                    } else {
                        n.setDato(MayorMenores(n, n.izq)); //
                    }
                }
            }
        } else {
            System.out.println("Vas bien");
            if (y < n.getDato()) {
                if (n.izq != null) {
                    EliminarNumero(n, n.izq, y);
                } else {
                    System.out.println("No se ha encontrado el nodo");
                    return false;
                }
            } else {
                if (n.der != null) {
                    EliminarNumero(n, n.der, y);
                } else {
                    System.out.println("No se ha encontrado el nodo");
                    return false;
                }
            }
        }
        return true;
    }
    
    int MayorMenores(NodoArbol p, NodoArbol n) {
        if (n.izq == null && n.der == null) {
            p.izq = null;
            return n.getDato();
        } else {
            if (n.izq != null && n.der == null) {
                p.izq = n.izq;
                n.izq = null;
                return n.getDato();
            } else {
                p = n;
                n = n.der;
                for (; n.der != null; p = n, n = n.der);
                if (n.izq != null) {
                    p.der = n.izq;
                    n.izq = null;
                } else {
                    p.der = null;
                }
                return n.getDato();
            }
        }
    }
    
    void PREORDEN(NodoArbol n) {
        if (n != null) {
            System.out.print(n.getDato() + " ");
            if (n.izq != null)
                PREORDEN(n.izq);
            if (n.der != null)
                PREORDEN(n.der);
        }
    }
    
    void INORDEN(NodoArbol n) {
        if (n != null) {
            if (n.izq != null)
                INORDEN(n.izq);
            System.out.print(n.getDato() + " ");
            if (n.der != null)
                INORDEN(n.der);
        }
    }
    
    void POSORDEN(NodoArbol n) {
        if (n != null) {
            if (n.izq != null)
                POSORDEN(n.izq);
            if (n.der != null)
                POSORDEN(n.der);
            System.out.print(n.getDato() + " ");
        }
    }
    
    int TamañoArbol(NodoArbol n) {
        if (n == null)
            return 0;
        else
            return 1 + TamañoArbol(n.izq) + TamañoArbol(n.der);
    }
    
    int Suma(NodoArbol n) {
        if (n == null)
            return 0;
        else
            return n.getDato() + Suma(n.izq) + Suma(n.der);
    }
    
    int HOJAS(NodoArbol n) {
        if (n == null)
            return 0;
        else {
            if (n.izq == null && n.der == null)
                return 1;
            else
                return 0 + HOJAS(n.izq) + HOJAS(n.izq);
        }
    }
    
    int AlturaArbol(NodoArbol n, int altura) {
        if (n == null)
            return 0;
        else {
            if (n.izq == null && n.der == null) 
                return altura;
            else
                return Integer.max(AlturaArbol(n.izq, altura + 1), AlturaArbol(n.der, altura + 1));
        }
    }
    
    boolean EsCompleto() {
        return (TamañoArbol(raiz) == (int) Math.pow(2, AlturaArbol(raiz, 1)) - 1);
    }
    
    int NodosInternos(NodoArbol p, NodoArbol n) {
        if (n == null) {
            return 0;
        } else {
            if (p == null)
                return 0 + NodosInternos(n, n.izq) + NodosInternos(n, n.der);
            else {
                if (n.izq == null && n.der == null)
                    return 0;
                else
                    return 1 + NodosInternos(n, n.izq) + NodosInternos(n, n.der);
            }
        }
    }
    
    int NodosUnHijo(NodoArbol n) {
        if (n == null) {
            return 0;
        } else {
            if (n.izq != null && n.der == null)
                return 1 + NodosUnHijo(n.izq) + NodosUnHijo(n.der);
            else if (n.izq == null && n.der != null)
                return 1 + NodosUnHijo(n.izq) + NodosUnHijo(n.der);
            else
                return 0 + NodosUnHijo(n.izq) + NodosUnHijo(n.der);
        }
    }
    
    int HijoDerecha(NodoArbol n) {
        if (n == null) {
            return 0;
        } else {
            if (n.izq == null && n.der != null)
                return 1 + HijoDerecha(n.der);
            else
                return 0 + HijoDerecha(n.izq) + HijoDerecha(n.der);
        }
    }
    
    int DosHijos(NodoArbol n) {
        if (n == null) {
            return 0;
        } else {
            if (n.izq != null && n.der != null)
                return 1 + DosHijos(n.izq) + DosHijos(n.der);
            else
                return 0 + DosHijos(n.izq) + DosHijos(n.der);
        }
    }
    
    int NodsoMultiplo5(NodoArbol n) {
        if (n == null) {
            return 0;
        } else {
            if (n.getDato() % 5 == 0)
                return 1 + NodsoMultiplo5(n.izq) + NodsoMultiplo5(n.der);
            else
                return 0 + NodsoMultiplo5(n.izq) + NodsoMultiplo5(n.der);
        }
    }
    
}
