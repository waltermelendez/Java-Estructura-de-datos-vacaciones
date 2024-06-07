

package com.mycompany.nuevo_binario;

import javax.swing.JOptionPane;


public class Nuevo_binario {

    public static void main(String[] args) {
         int opc=0, elemento;
      String nombre;
      Funciones arbolito= new Funciones();
      do{
      try{
      opc= Integer.parseInt(JOptionPane.showInputDialog(null,
              "1. Agregar nodo\n"+
                      "2.Recorrer el arbol InOrder\n"+
                       "3.Recorrer el arbol PreOrder\n"+
                      "4.Recorrer el arbol PostOrder\n"+
                       "5.Buscar un nodo\n"+
                       "6.Eliminar un nodo\n"+
             "7. Salir\n"+
             "Elija una opcion",
              JOptionPane.QUESTION_MESSAGE
      ));
      switch(opc){
          case 1:{
          elemento= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero del nodo"
                  ,JOptionPane.QUESTION_MESSAGE));
          nombre= JOptionPane.showInputDialog(null,"Ingresa el nombre del nodo",
                  JOptionPane.QUESTION_MESSAGE);
          arbolito.agregar_nodo(elemento, nombre);
          }
              break;
          case 2:{
              if (!arbolito.estavacio()) {
                  System.out.println();
                  arbolito.InOrder(arbolito.raiz);
              }else{
              JOptionPane.showInputDialog(null,"Arbol vacio",
                  JOptionPane.QUESTION_MESSAGE);
              }
          
          }break;
          case 3:
          {
             if (!arbolito.estavacio()) {
                 System.out.println();
                  arbolito.PreOrder(arbolito.raiz);
              }else{
              JOptionPane.showInputDialog(null,"Arbol vacio",
                  JOptionPane.QUESTION_MESSAGE);
              }
          }break;
          case 4:{
           if (!arbolito.estavacio()) {
               System.out.println();
                  arbolito.PostOrder(arbolito.raiz);
              }else{
              JOptionPane.showInputDialog(null,"Arbol vacio",
                  JOptionPane.QUESTION_MESSAGE);
              }
          }break;
          case 5:
          {
              if (!arbolito.estavacio()) {
                  elemento= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero del nodo a buscar"
                  ,JOptionPane.QUESTION_MESSAGE));
                  arbolito.buscarNodo(elemento);
                  if (arbolito.buscarNodo(elemento)==null) {
                      JOptionPane.showInputDialog(null,"Arbol vacio o nodo no encontrado",
                  JOptionPane.QUESTION_MESSAGE);
                  }else
                  {
                      System.out.println("Nodo encontrado, sus datos son: "+arbolito.buscarNodo(elemento));
                  }
              }else{
              JOptionPane.showInputDialog(null,"Arbol vacio o nodo no encontrado",
                  JOptionPane.QUESTION_MESSAGE);
              }
          }break;
          case 6:
          {
           if (!arbolito.estavacio()) {
                  elemento= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero del nodo a eleminar"
                  ,JOptionPane.QUESTION_MESSAGE));
                  arbolito.buscarNodo(elemento);
                  if (arbolito.eliminar(elemento)==false) {
                      JOptionPane.showInputDialog(null,"Arbol vacio o nodo no encontrado",
                  JOptionPane.QUESTION_MESSAGE);
                  }else
                  {
                      JOptionPane.showInputDialog(null,"El nodo ha sido eliminado del arbol",
                  JOptionPane.QUESTION_MESSAGE);
                  }
              }else{
              JOptionPane.showInputDialog(null,"Arbol vacio o nodo no encontrado",
                  JOptionPane.QUESTION_MESSAGE);
              }
          }break;
          case 7:
          {
           System.out.println("Cerradndo programa...");
          }break;
          default:
          {
              System.out.println("Opcion ");
          }break;
      }
      }catch(NumberFormatException n){
      JOptionPane.showMessageDialog(null,"Error"+n.getMessage());
      }
      }
      
          while(opc!=5);
    }
}
