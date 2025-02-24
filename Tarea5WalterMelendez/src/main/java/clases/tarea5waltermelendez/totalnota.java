/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.tarea5waltermelendez;

/**
 *
 * @author walter
 */
public class totalnota {
    private int nota;
    private totalnota siguiente;
    private totalnota anteroir;
    public int getNota() {
        return nota;
    }

    public totalnota(int nota) {
        this.nota = nota;
        this.siguiente = null;
        this.anteroir= null;
    }

    public totalnota getAnteroir() {
        return anteroir;
    }

    public void setAnteroir(totalnota anteroir) {
        this.anteroir = anteroir;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public totalnota getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(totalnota siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Notas: "+ nota;
    }

   
    
}
