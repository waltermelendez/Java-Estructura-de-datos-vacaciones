/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.tarea5waltermelendez;

/**
 *
 * @author walter
 */
public class Nota {
    private String Nombre="";
private totalnota Note;
    private int Carnet=0;
  

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public totalnota getNote() {
        return Note;
    }

   

    public int getCarnet() {
        return Carnet;
    }

    public void setCarnet(int Carnet) {
        this.Carnet = Carnet;
    }

    @Override
    public String toString() {
        return "Nombre: "+getNombre()+" "+"Carnet: "+getCarnet()+ getNote();
    }
    public void add(int cantidad){
    
    totalnota nueva = new totalnota(cantidad);
        if (nueva.getSiguiente()==null) {
          Note=nueva;
Note.setAnteroir(null);
          /* Note.setSiguiente(nueva);
           nueva=Note;*/
        } else {
            totalnota aux=Note;
           // Note=nueva;
            Note.setSiguiente(nueva);
           Note.setAnteroir(aux);
            
        }
        
    }
  
}
