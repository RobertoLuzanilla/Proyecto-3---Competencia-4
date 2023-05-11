import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0, Numero;

        Oper_Arboles OA = new Oper_Arboles();
        
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
                        OA.Insertar(OA.raiz, Numero);
                        System.out.println("Se ha insertado el numero " + Numero);
                        break;

                    case 2:
                        if (OA.raiz != null) {
                            System.out.println("\nRecorrido PREORDEN:");
                            OA.PREORDEN(OA.raiz);

                        } else
                            System.out.println("El arbol no tiene elementos");
                        break;

                    case 3:
                        if (OA.raiz != null) {
                            System.out.println("Recorrido INORDEN");
                            OA.INORDEN(OA.raiz);
                        } else
                            System.out.println("El arbol no tiene elementos");
                        break;

                    case 4:
                        if (OA.raiz != null) {
                            System.out.println("Recorrido en POSORDEN");
                            OA.POSORDEN(OA.raiz);
                        } else
                            System.out.println("El arbol no tiene elementos");
                        break;

                    case 5:
                        System.out.println("El tamaño del arbol es: " + OA.TamañoArbol(OA.raiz));
                        break;

                    case 6:
                        System.out.println("El arbol contiene " + OA.HOJAS(OA.raiz) + " HOJAS");
                        break;

                    case 7:
                        System.out.println("Ingrese el numero a eliminar");
                        Numero = Integer.parseInt(sc.nextLine());
                        if (OA.raiz != null) {
                            if (OA.EliminarNumero(null, OA.raiz, Numero))
                                System.out.println("Se ha eliminado el numero" + Numero);
                        } else
                            System.out.println("El arbol no tiene elementos");
                        break;

                    case 8:
                        System.out.println("La altura del arbol es: " + OA.AlturaArbol(OA.raiz, 1));
                        break;

                    case 9:
                        if (OA.EsCompleto())
                            System.out.println("El arbol si es completo");
                        else
                            System.out.println("El arbol no es completo");
                        break;

                    case 10:

                        System.out.println("El arbol contiene " + OA.NodosInternos(null, OA.raiz) + " Nodos internos");
                        break;

                    case 11:

                        System.out.println("El arbol contiene " + OA.NodosUnHijo(OA.raiz) + " Nodos con un hijo");
                        break;
                    case 12:

                        System.out.println("El arbol contiene " + OA.HijoDerecha(OA.raiz) + " Nodos con un hijo en la derecha");
                        break;
                    case 13:
                        System.out.println("El arbol contiene " + OA.DosHijos(OA.raiz) + " Nodos con dos hijos");
                        break;
                    case 14:
                        System.out.println("La suma de los nodos " + OA.Suma(OA.raiz));
                        break;
                    case 15:
                        System.out.println("El arbol contiene " + OA.NodsoMultiplo5(OA.raiz) + " Nodos cuyos multiplos es 5");
                        break;
                }
        } while (opcion != 16);
        
    }
    
}
