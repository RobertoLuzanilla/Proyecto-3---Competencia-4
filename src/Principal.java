import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0, Numero;

        Oper_Arboles Raiz = new Oper_Arboles();
        
        do {
            System.out.println(
                "MENÚ DE OPCIONES:\n" +
                "1) Insertar\n" +
                "2) Recorrido Preorden\n" +
                "3) Recorrido Inorden\n" +
                "4) Recorrido Posorden\n" +
                "5) Tamaño\n" +
                "6) Número de hojas\n" +
                "7) Eliminar \n" +
                "8) Altura del árbol \n" +
                "9) ¿Es árbol completo o lleno?\n" +
                "10) Cantidad de nodos internos\n" +
                "11) Cantidad de nodos que tienen un solo hijo\n" +
                "12) Cantidad de nodos que tienen un solo hijo a la derecha\n" +
                "13) Cantidad de nodos con 2 hijos\n" +
                "14) Suma de los datos de todos los nodos\n" +
                "15) Cantidad de nodos cuyo dato es múltiplo de 5\n" +
                 "16) Salir");
            

                System.out.println("Ingrese lo que desea realizar");
                opcion =Integer.parseInt(sc.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese un numero para insertar al arbol");
                        Numero = Integer.parseInt(sc.nextLine());
                        Raiz.Insertar(Raiz.raiz, Numero);
                        System.out.println("Se ha insertado el numero " + Numero);
                        break;

                    case 2:
                        if (Raiz.raiz != null) {
                            System.out.println("\nRecorrido PREORDEN:");
                            Raiz.PREORDEN(Raiz.raiz);

                        } else
                            System.out.println("El arbol no tiene elementos");
                        break;

                    case 3:
                        if (Raiz.raiz != null) {
                            System.out.println("Recorrido INORDEN");
                            Raiz.INORDEN(Raiz.raiz);
                        } else
                            System.out.println("El arbol no tiene elementos");
                        break;

                    case 4:
                        if (Raiz.raiz != null) {
                            System.out.println("Recorrido en POSORDEN");
                            Raiz.POSORDEN(Raiz.raiz);
                        } else
                            System.out.println("El arbol no tiene elementos");
                        break;

                    case 5:
                        System.out.println("El tamaño del arbol es: " + Raiz.TamañoArbol(Raiz.raiz));
                        break;

                    case 6:
                        System.out.println("El arbol contiene " + Raiz.HOJAS(Raiz.raiz) + " HOJAS");
                        break;

                    case 7:
                        System.out.println("Ingrese el numero a eliminar");
                        Numero = Integer.parseInt(sc.nextLine());
                        if (Raiz.raiz != null) {
                            if (Raiz.EliminarNumero(null, Raiz.raiz, Numero))
                                System.out.println("Se ha eliminado el numero" + Numero);
                        } else
                            System.out.println("El arbol no tiene elementos");
                        break;

                    case 8:
                        System.out.println("La altura del arbol es: " + Raiz.AlturaArbol(Raiz.raiz, 1));
                        break;

                    case 9:
                        if (Raiz.EsCompleto())
                            System.out.println("El arbol si es completo");
                        else
                            System.out.println("El arbol no es completo");
                        break;

                    case 10:

                        System.out.println("El arbol contiene " + Raiz.NodosInternos(null, Raiz.raiz) + " Nodos internos");
                        break;

                    case 11:

                        System.out.println("El arbol contiene " + Raiz.NodosUnHijo(Raiz.raiz) + " Nodos con un hijo");
                        break;
                    case 12:

                        System.out.println("El arbol contiene " + Raiz.HijoDerecha(Raiz.raiz) + " Nodos con un hijo en la derecha");
                        break;
                    case 13:
                        System.out.println("El arbol contiene " + Raiz.DosHijos(Raiz.raiz) + " Nodos con dos hijos");
                        break;
                    case 14:
                        System.out.println("La suma de los nodos " + Raiz.Suma(Raiz.raiz));
                        break;
                    case 15:
                        System.out.println("El arbol contiene " + Raiz.NodsoMultiplo5(Raiz.raiz) + " Nodos cuyos multiplos es 5");
                        break;
                }
        } while (opcion != 16);
        
    }
    
}
