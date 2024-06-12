
package Clases;


public class Funciones_AVL {
    private Nodo_AVL raiz;
    public Funciones_AVL(){
raiz =null;
}
    public Nodo_AVL Raiz(){
    return raiz;
    }
    //Buscar
    public Nodo_AVL buscar(int d, Nodo_AVL r)
    {
        if (raiz==null) {
            return null;
        }else if(r.dato==d){
        return r;
        }else if (r.dato<d){
        return buscar(d,r.hijoderecho);
        }else{
        return buscar(d,r.hijoizquierdo);
        }
    }
    //Obtener el factor de equilibrio
    public int obtenerFE(Nodo_AVL x)
    {
        if (x==null) {
            return -1;
        }else   {
        return x.fe;
        }
    }
    
    //Rotacion simple a la izquierda
    public Nodo_AVL rotacionIzq(Nodo_AVL c){
    Nodo_AVL auxiliar = c.hijoizquierdo;
    c.hijoizquierdo=auxiliar.hijoderecho;
    auxiliar.hijoderecho=c;
    c.fe=Math.max(obtenerFE(c.hijoizquierdo), obtenerFE(c.hijoderecho))+1;//MAx se usa para obtener el maxiom de dos valores
    auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoizquierdo), obtenerFE(auxiliar.hijoderecho))+1;
    return auxiliar;
    }
    //rotacion simple a la derecha
     public Nodo_AVL rotacionDer(Nodo_AVL c){
    Nodo_AVL auxiliar = c.hijoderecho;
    c.hijoderecho=auxiliar.hijoizquierdo;
    auxiliar.hijoizquierdo=c;
    c.fe=Math.max(obtenerFE(c.hijoizquierdo), obtenerFE(c.hijoderecho))+1;//MAx se usa para obtener el maxiom de dos valores
    auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoizquierdo), obtenerFE(auxiliar.hijoderecho))+1;
    return auxiliar;
    }
     //rotacion doble a la derecha
     public Nodo_AVL rotacionDobleIzq(Nodo_AVL c){
     Nodo_AVL auxiliar;
     c.hijoizquierdo=rotacionDer(c.hijoizquierdo);
     auxiliar=rotacionIzq(c);
     return auxiliar;
     }
     
     //Rotacion doble a la izquierda
     public Nodo_AVL rotacionDobleDer(Nodo_AVL c)
     {
     Nodo_AVL auxiliar;
     c.hijoderecho=rotacionIzq(c.hijoderecho);
     auxiliar=rotacionDer(c);
     return auxiliar;
     }
     
     //Metodo para insertar AVL
     public Nodo_AVL insertarAVL(Nodo_AVL nuevo,Nodo_AVL subAR)
     {
     Nodo_AVL nuevoPadre=subAR;
     //rotar a la izquierda
         if (nuevo.dato<subAR.dato) {
             if (subAR.hijoizquierdo==null) {
                 subAR.hijoizquierdo=nuevo;
             }else{
             subAR.hijoizquierdo=insertarAVL(nuevo,subAR.hijoizquierdo);
                 if (obtenerFE(subAR.hijoizquierdo)-obtenerFE(subAR.hijoderecho)==2){
                     if (nuevo.dato<subAR.hijoizquierdo.dato) {
                         nuevoPadre=rotacionIzq(subAR);
                     }else{
                      nuevoPadre=rotacionDobleIzq(subAR);
                     }
                 }
                 
             }
         }else if(nuevo.dato>subAR.dato)//rotar a la derecha
         {
             if (subAR.hijoderecho==null) {
                 subAR.hijoderecho=nuevo;
             }else{
             subAR.hijoderecho=insertarAVL(nuevo,subAR.hijoizquierdo);
                 if ((obtenerFE(subAR.hijoderecho)-obtenerFE(subAR.hijoizquierdo))==2) {
                     if (nuevo.dato>subAR.hijoderecho.dato) {
                         nuevoPadre=rotacionDer(subAR);
                     }else{
                     nuevoPadre=rotacionDobleDer(subAR);
                     }
                 }
             }  
         }else {
             System.out.println("Nodo duplicado");
         }
         //Actualizar el factor de equilibrio
         if ((subAR.hijoizquierdo==null) &&(subAR.hijoderecho!=null)) {
             subAR.fe=subAR.hijoderecho.fe+1;
         }else if((subAR.hijoderecho==null)&&(subAR.hijoizquierdo!=null))
         {
         subAR.fe=subAR.hijoizquierdo.fe+1;
         }else{
         subAR.fe=Math.max(obtenerFE(subAR.hijoizquierdo), obtenerFE(subAR.hijoderecho))+1;
         }
         return nuevoPadre;
     }
     //Metodo para insertar
     public void Insertar(int d)
     {
     Nodo_AVL nuevo=new Nodo_AVL(d);
         if (raiz==null) {
             raiz=nuevo;
         }else  {
         raiz=insertarAVL(nuevo,raiz);
         }
     }
     
     //Recorrer el arbol InOrder, forma recursiva: Hijo, izquierdo, Raiz, hijo Derecho
    public void InOrder(Nodo_AVL R){
        if (R!=null) {
            InOrder(R.hijoizquierdo);
            System.out.print(R.dato+" , ");
            InOrder(R.hijoderecho);
          
        }
    
    }
    //Recorrer el arbol PreOrden, forma recusiva:  Raiz, Hijo izquierdo, Hijo Derecho
    public void PreOrder(Nodo_AVL R){
    if (R!=null) {
        System.out.print(R.dato+" , ");
            PreOrder(R.hijoizquierdo);
            PreOrder(R.hijoderecho);
            
        }
    
    }
    //Recorrer el arbol PostOrden, forma recursiva: Hijo izquierdo, Hijo derecho, Raiz.
    public void PostOrder(Nodo_AVL R){
    if (R!=null) {
            PostOrder(R.hijoizquierdo);
            PostOrder(R.hijoderecho);
            System.out.print(R.dato+" , ");
        }
    
    }
}
