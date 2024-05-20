package org.example;

import java.util.concurrent.TimeUnit;
public class App
{
    public static void main(String[] args) {
        try {
            boolean fun = true;
            int idCounter = 1;

            ListaNaranjas listaNaranjas = new ListaNaranjas();

            while (fun) {
                try {
                    // Crea una nueva naranja
                    ListaNaranjas.Naranja nuevaNaranja = new ListaNaranjas.Naranja();
                    nuevaNaranja.setId(idCounter++);
                    int tamanio = nuevaNaranja.getTamanio();
                    int tempo = tamanio * 50;
                    nuevaNaranja.setTempo(tempo);

                    // Detecta la naranja
                    listaNaranjas.detectaNaranja(nuevaNaranja);

                    // Se imprimen los datos de la naranja nueva
                    System.out.println("Naranja ID: " + nuevaNaranja.getId() + ", Tamaño: " + tamanio + ", Tempo: " + tempo + " ms");

                    // Resta 50 ms
                    listaNaranjas.restarTiempo();

                    // Lista de las naranjas en la banda
                    listaNaranjas.mostrarLista();

                    TimeUnit.SECONDS.sleep(1);
                } catch (NullPointerException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
