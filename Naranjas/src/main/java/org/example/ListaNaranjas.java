package org.example;

import java.util.Random;

public class ListaNaranjas {
    private Naranja frente;
    private Naranja ultimo;

    public ListaNaranjas(){
        frente= null;
        ultimo= null;
    }

    //Nodo (naranja)
    public static class Naranja {
        public int id;
        public int tamanio;
        public int tempo; // ms
        public Naranja siguiente;

        public Naranja(){
            this.id = 0;
            Random rand = new Random();
            this.tamanio = rand.nextInt(10)+1;
            this.tempo = 0;
            this.siguiente = null;
        }

        public int getId(){
            return id;
        }

       public void setId(int id){
            this.id= id;
       }
        public int getTamanio() {
            return tamanio;
        }


        public int getTempo() {
            return tempo;
        }

        public void setTempo(int tempo){
            this.tempo = tempo;
        }

        public Naranja getSiguiente(){
            return siguiente;
        }

        public void setSiguiente(Naranja siguiente){
            this.siguiente = siguiente;
        }

    }

    public static class Piston {

        public boolean activate;

        public Piston(){
            this.activate = false;
        }

        public boolean getActivate(){
            return activate;
        }

        public void setActivate() {
            this.activate = true;
        }


    }
    public void detectaNaranja(Naranja nuevaNaranja) throws NullPointerException {
        if (frente == null) {
            frente = nuevaNaranja;
        } else {
            if (ultimo == null) {
                throw new NullPointerException("El último nodo es null mientras la lista no está vacía.");
            }
            ultimo.setSiguiente(nuevaNaranja);
        }
        ultimo = nuevaNaranja;
    }

    public void restarTiempo(){
        Naranja actual = frente;
        Naranja anterior = null;

        while (actual != null) {
            actual.setTempo(actual.getTempo() - 50);
            if (actual.getTempo() == 0) {
                System.out.println("La naranja con ID " + actual.getId() + " ha llegado al pistón corrspondiente.");
                activarPiston(actual.getTamanio());

                if (anterior == null) {
                    // Si la naranja a eliminar es la primera de la lista
                    frente = actual.getSiguiente();
                    actual = frente;
                } else {
                    // Si la naranja a eliminar está en el medio o al final de la lista
                    anterior.setSiguiente(actual.getSiguiente());
                    actual = anterior.getSiguiente();
                }
            } else {
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }
    }

    private void activarPiston(int tamanio) {
        Piston piston = new Piston();
        piston.setActivate();
        System.out.println("Pistón " + tamanio + " activado.");
    }

    public void mostrarLista() {
        Naranja actual = frente;
        System.out.println("Naranjas en banda -----------");
        while (actual != null) {
            System.out.print("Naranja ID: " + actual.getId()  + ", Tempo: " + actual.getTempo() + " ms -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }
}
