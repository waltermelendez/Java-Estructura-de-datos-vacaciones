
package com.mycompany.nuevo_binario;


public class Funciones {
    Nodo raiz;
    public Funciones()
            {
            raiz =null;
            }
    public void agregar_nodo(int dato, String nombre){
    Nodo nuevo = new Nodo(dato, nombre);
    if(raiz==null){
        //Cuando esta vacio
    raiz = nuevo;
    
    }else
    {
        Nodo Auxiliar= raiz;
        Nodo padre;
        while(true)
        {
        padre= Auxiliar;
        if(dato<Auxiliar.dato)//Cuando es menor
        {
            Auxiliar = Auxiliar.hijoIzq;
            if(Auxiliar==null)
            {
            padre.hijoIzq=nuevo;
            return;//Sirve para final el metodo.
            }
        }else //Cuando es mayor
        {
        Auxiliar= Auxiliar.hijoDer;
            if (Auxiliar==null) {
                padre.hijoDer=nuevo;
             return;
            }
        }
        }
    }
    
    }
    //Metodo cuando el arbol etsa vacio
    public boolean estavacio(){
return raiz == null;
}
    //Recorrer el arbol InOrder, forma recursiva: Hijo, izquierdo, Raiz, hijo Derecho
    public void InOrder(Nodo R){
        if (R!=null) {
            InOrder(R.hijoIzq);
            System.out.println(R.dato);
            InOrder(R.hijoDer);
          
        }
    
    }
    //Recorrer el arbol PreOrden, forma recusiva:  Raiz, Hijo izquierdo, Hijo Derecho
    public void PreOrder(Nodo R){
    if (R!=null) {
        System.out.println(R.dato);
            PreOrder(R.hijoIzq);
            PreOrder(R.hijoDer);
            
        }
    
    }
    //Recorrer el arbol PostOrden, forma recursiva: Hijo izquierdo, Hijo derecho, Raiz.
    public void PostOrder(Nodo R){
    if (R!=null) {
            PostOrder(R.hijoIzq);
            PostOrder(R.hijoDer);
            System.out.println(R.dato);
        }
    
    }
}


