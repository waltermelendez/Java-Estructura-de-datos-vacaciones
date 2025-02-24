/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package clases.tarea5waltermelendez;

import java.util.Scanner;

/**
 *
 * @author walter
 */
public class Tarea5WalterMelendez {

    public static void main(String[] args) {
        Nota[] estudiantes = new Nota[10];
        Scanner entrada = new Scanner(System.in);
        String nombre="";
        int numero=0;
        int contar=0;
        int opcion;
        boolean ciclo= true;
        do {     
            System.out.println("1...Agregar un estudiante");
            System.out.println("2...Agregar una nota al estudiante");
                System.out.println("3...Mostrar información almacenada");
                System.out.println("4...Salir");
                opcion=entrada.nextInt();
                Scanner nombres= new Scanner(System.in);
            switch(opcion){
                case 1:{
                    if (contar<9) {
                         Nota uno= new Nota();
                    System.out.println("Diga el nombre del estudiante");
                    nombre=nombres.nextLine();
                    uno.setNombre(nombre);
                    System.out.println("Diga el carnet del estudiante, solo numeros");
                    numero=entrada.nextInt();
                    uno.setCarnet(numero);
                    estudiantes[contar]=uno;
                    contar++;
                    } else {
                        System.out.println("Ya no hay mas espacio para mas estudiantes.");
                    }
                    
                }break;
                case 2:{
                    System.out.println("Diga el carnet del estudiante que desea buscar el carnet");
                    numero=entrada.nextInt();
                    int i=0;
                    int posi=0;
                   boolean ver=false;
                    
                    while (posi<9) {
                      i=estudiantes[posi].getCarnet();
                        if (numero==i) {
                            System.out.println("Diga la nota del estudiante");
                            numero=entrada.nextInt();
                         estudiantes[posi].add(numero);
                            ver=true;
                            break;
                        } else {
                            posi++;
                        }
                    }
                    if (!ver) {
                        System.out.println("Estudiante no encontrado.");
                    }
                    
                
                }break;
                case 3:{
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Estudiante numero "+(i+1)+": "+estudiantes[i]);
                        
                    }
                }break;
                case 4:{
                ciclo=false;
                }break;
            }
            
        } while (ciclo);
    }
}
