package clases.ordenmanientomas;

public class OrdenmanientoMAS {
//Ordenamiento radix

    public static void main(String[] args) {
        int arr[] = {55, 4, 43, 44, 2, 10};
        System.out.println("MAs tipos de ordenamiento");
        //   Radix_(arr);
        //Insercion(arr, arr.length);
        //Shell(arr);
        System.out.println("Ordenacion Externos");
    }

    public static void MostrarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            System.out.print(", ");

        }
    }

    public static void Radix_(int[] arreglo) {
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x++) {
            int auxiliar[] = new int[arreglo.length];
            j = 0;
            for (i = 0; i < arreglo.length; i++) {
                boolean mover = arreglo[i] << x >= 0;//<--Es una pregunta para saber si x es mayor que cero
                /*
                Usar el Operador ternario ?
                resultado =(condicion)?valor:valor2
                mayor=(x>y)?x:y;    
                 */
                if (x == 0 ? !mover : mover) {
                    auxiliar[j] = arreglo[i];
                    j++;
                } else {
                    arreglo[i - j] = arreglo[i];

                }
            }
            for (i = j; i < auxiliar.length; i++) {
                auxiliar[i] = arreglo[i - j];
            }
            arreglo = auxiliar;

        }
        System.out.println("Ordenado con radix sort");
        MostrarArreglo(arreglo);

    }

    public static void Insercion(int[] arreglo, int n) {
        int i, j, auxiliar;
        for (i = 1; i < n; i++) {
            auxiliar = arreglo[i];
            j = i - 1;
            while (j >= 0 && arreglo[j] > auxiliar) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = auxiliar;

        }
        System.out.println("Ordenado por inserccion");
        MostrarArreglo(arreglo);
    }
    
    public static void Shell(int[] arreglo) {
        int salto,i,j,k,auxiliar;
        salto=arreglo.length/2;
        while(salto>0){
            for (i = salto;  i< arreglo.length; i++) {
                j=i-salto;
                while(j>=0){
                k=j+salto;
                    if (arreglo[j]<=arreglo[k]) {
                        j=-1;
                    }
                    else{
                    auxiliar=arreglo[j];
                    arreglo[j]=arreglo[k];
                    arreglo[k]=auxiliar;
                    j-=salto;//>>j=j-salto
                    }
                }
            }
            salto=salto/2;
        }
        System.out.println("Ordenado por shell sort");
        MostrarArreglo(arreglo);
    }
}
