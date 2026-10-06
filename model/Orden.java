package model;
public class Orden {

    private int numeroOrden;
    private Pizza pizza;
    private boolean bebida;
    private float precio;

    public Orden(int numeroOrden, Pizza pizza, boolean bebida) {
        this.numeroOrden = numeroOrden;
        this.pizza = pizza;
        this.bebida = bebida;
        this.precio = 40;
    }

    public void recibirOrden() {
        System.out.println("La orden ha sido recibida.");
    }

    public void leerOrden() {

        System.out.println("Tu número de orden es: " + numeroOrden );

        pizza.mostrarPizza();

        if (bebida == true) {
            System.out.println("Bebida: Si");
        } else {
            System.out.println("Bebida: No");
        }

        System.out.println("Precio: Q" + precio);
    }

    public void prepararOrden() {

    System.out.println("Preparando orden " + numeroOrden);

    pizza.amasar();
    pizza.cocinar();
}

    public void entregarOrden() {
        System.out.println("Orden " + numeroOrden + " entregada.");
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }
}