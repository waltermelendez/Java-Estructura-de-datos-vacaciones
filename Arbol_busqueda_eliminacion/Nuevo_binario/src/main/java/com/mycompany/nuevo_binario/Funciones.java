
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
            System.out.print(R.dato+" , ");
            InOrder(R.hijoDer);
          
        }
    
    }
    //Recorrer el arbol PreOrden, forma recusiva:  Raiz, Hijo izquierdo, Hijo Derecho
    public void PreOrder(Nodo R){
    if (R!=null) {
        System.out.print(R.dato+" , ");
            PreOrder(R.hijoIzq);
            PreOrder(R.hijoDer);
            
        }
    
    }
    //Recorrer el arbol PostOrden, forma recursiva: Hijo izquierdo, Hijo derecho, Raiz.
    public void PostOrder(Nodo R){
    if (R!=null) {
            PostOrder(R.hijoIzq);
            PostOrder(R.hijoDer);
            System.out.print(R.dato+" , ");
        }
    
    }
    //Metodo para buscar un nodo en el arbol
    public Nodo buscarNodo(int d)
    {
        Nodo  aux = raiz;
        while(aux.dato!=d)
        {
            if (d<aux.dato) {
                aux=aux.hijoIzq;
            }else  
            {
            aux = aux.hijoDer;
            }
        }
        if (aux==null) {
            return null;
        }
        return aux;
    }
   //Metodo para eliminar un nodo del arbol.
    public boolean eliminar(int d)
    {
    Nodo auxiliar = raiz;
    Nodo  padre = raiz;
    boolean eshijoIzquier=true;
    while(auxiliar.dato!=d)
    {
    padre = auxiliar;
        if (d<auxiliar.dato) {
            eshijoIzquier=true;
            auxiliar = auxiliar.hijoIzq;
            
        }else{
        eshijoIzquier=false;
        auxiliar= auxiliar.hijoDer;
        }
        if (auxiliar==null) {
            return false;
        }
    }//fin del while
        if (auxiliar.hijoIzq==null&&auxiliar.hijoDer==null) {
            //caso en donde el nodo es hoja o raiz
            if (auxiliar==raiz) {
                raiz= null;
            }else if (eshijoIzquier){
            padre.hijoIzq=null;
            }else{
            padre.hijoDer=null;
            }
        }else if(auxiliar.hijoDer==null)
        {
        if (auxiliar==raiz) {
                raiz= auxiliar.hijoIzq;
            }else if (eshijoIzquier){
            padre.hijoIzq=auxiliar.hijoIzq;
            }else{
            padre.hijoDer=auxiliar.hijoIzq;
            }
        }else if(auxiliar.hijoIzq==null)
        {
        if (auxiliar==raiz) {
                raiz= auxiliar.hijoDer;
            }else if (eshijoIzquier){
            padre.hijoIzq=auxiliar.hijoDer;
            }else{
            padre.hijoDer=auxiliar.hijoIzq;
            }
        }else {
        Nodo reemplazo=obtenerNodoreemplazo(auxiliar);
            if (auxiliar==raiz) {
                raiz=reemplazo;
            }else if(eshijoIzquier){
            padre.hijoIzq=reemplazo;
            
            }else
            {
            padre.hijoDer=reemplazo;
            }
            reemplazo.hijoIzq=auxiliar.hijoIzq;
        }
        return true;
    }
    //Meotod para buscar el nodo que se paresca al nodo a eliminar
    public Nodo obtenerNodoreemplazo(Nodo nodoree)
    {
    Nodo reemplazar_padre=nodoree;
    Nodo reemplazo=nodoree;
    Nodo auxiliar= nodoree;
    while(auxiliar!=null)
    {
    reemplazar_padre=reemplazo;
    reemplazo=auxiliar;
    auxiliar=auxiliar.hijoIzq;
    }
        if (reemplazo!=nodoree.hijoDer) {
            reemplazar_padre.hijoIzq=reemplazo;
            reemplazo.hijoDer=nodoree.hijoDer;
        }
        System.out.println("El nodo reemplazo es: "+reemplazo);
        return reemplazo;
    }
}


