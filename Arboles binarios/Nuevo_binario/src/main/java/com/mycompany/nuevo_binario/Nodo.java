/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nuevo_binario;

/**
 *
 * @author walte
 */
public class Nodo {
      int dato;
    String nombre;
    Nodo hijoIzq;
    Nodo hijoDer;
    public Nodo(int d, String nom){
    this.dato=d;
    this.nombre=nom;
    this.hijoDer=null;
    this.hijoIzq=null;
    }
    public String toString(){
    return nombre + "Su datos es " +dato;
    
    }
}
