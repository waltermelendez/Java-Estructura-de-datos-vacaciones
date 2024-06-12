

package Clases;


public class ArbolAVL {

    public static void main(String[] args) {
    Funciones_AVL arbolito = new Funciones_AVL();
    arbolito.Insertar(10);
    arbolito.Insertar(5);
    arbolito.Insertar(13);
    arbolito.Insertar(1);
    arbolito.Insertar(6);
    arbolito.Insertar(17);
 arbolito.PreOrder(arbolito.Raiz());
       
       
    }
}
