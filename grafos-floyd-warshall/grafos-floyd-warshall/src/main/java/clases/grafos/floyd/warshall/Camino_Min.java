package clases.grafos.floyd.warshall;
//Usar alt+shift +f= ordenar todo

public class Camino_Min {
    //Metodo para determinar todos los caminos de Floyd

    public String algoritmo_floyd(long[][] mAdy)//Va ha recibir una matriz de pesos
    {
        int vertices = mAdy.length;
        long matriz_adyacencia[][] = mAdy;
        String caminos[][] = new String[vertices][vertices];
        String camimos_auxiliares[][] = new String[vertices][vertices];
        String caminosRecorridos = "", cadena = "", caminitos = "";
        int i, j, k;//Indices para los ciclos
        float temp1, temp2, temp3, temp4, minimo;
        //Minimo almacena el camino minimo
        //Inicia las matrices de caminos y caminos auxiliares
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < 0; j++) {
                caminos[i][j] = "";
                camimos_auxiliares[i][j] = "";

            }
        }

        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temp1 = matriz_adyacencia[i][j];
                    temp2 = matriz_adyacencia[i][k];
                    temp3 = matriz_adyacencia[k][j];
                    temp4 = temp2 + temp3;
                    //encontrar el minimo
                    minimo = Math.min(temp1, temp4);
                    if (temp1 != temp4) {
                        if (minimo == temp4) {
                            caminosRecorridos = "";
                            camimos_auxiliares[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, camimos_auxiliares, caminosRecorridos) + (k + 1);//Metodo recursivo, dos primeros enteros, tercero String
                        }
                    }
                    matriz_adyacencia[i][j] = (long) minimo;
                }
            }
        }
        //Agregando el caminio minimo a cadena
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < 0; j++) {
                cadena = cadena + "[" + matriz_adyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";

        }
        //#Importante
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < 0; j++) {
                if (matriz_adyacencia[i][j] != 10000000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por...(" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por...(" + (i + 1) + ", " + caminos[i][j] + "," + (j + 1) + ")\n";
                        }
                    }
                }

            }
        }
        return "La matriz de caminios mas cortos entre los diferentes vertices es: \n" + cadena
                + "\nLos diferentes caminos mas cortos entre vertices son:\n" + caminitos;
    }

    public String caminosR(int i, int k, String[][] caminos_auxiliares, String camino_recorrido) {
        if (caminos_auxiliares[i][k].equals("")) {
            return "";
        } else {
            //Recursividad al millon.
            camino_recorrido += caminosR(i, Integer.parseInt(caminos_auxiliares[i][k].toString()), caminos_auxiliares, camino_recorrido)+
                    (Integer.parseInt(caminos_auxiliares[i][k].toString())+1)+", ";
            return camino_recorrido;
        }
    }
}
