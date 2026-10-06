package model;
public class Cocina {

    private Orden[] ordenes;
    private int cantidadOrdenes;

    public Cocina() {
        ordenes = new Orden[5];
        cantidadOrdenes = 0;
    }

    public void recibirOrden(Orden orden) {

        if (cantidadOrdenes < 5) {

            ordenes[cantidadOrdenes] = orden;
            cantidadOrdenes++;

            System.out.println("La cocina recibio la orden.");

        } else {

            System.out.println("No se pueden recibir mas ordenes.");
            System.out.println("El maximo es de 5 ordenes.");
        }
    }

    public void prepararOrden(Orden orden) {

        System.out.println("Se está preparando la orden.");

        orden.prepararOrden();
    }

    public void enviarOrden(Orden orden) {

        orden.entregarOrden();
    }

    public void mostrarCantidadOrdenes() {

        System.out.println(
            "Cantidad de ordenes recibidas: " + cantidadOrdenes
        );
    }
}