import model.Cocina;
import model.Orden;
import model.Pizza;
import model.Masa;
import model.Sabor;
import model.Ingrediente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Cocina cocina = new Cocina();

        System.out.println("¡Bienvenido a Jack's Pizza Chef!");

        System.out.print("Cuantas ordenes desea hacer?: ");
        int cantidad = teclado.nextInt();

        if (cantidad > 5) {
            cantidad = 5;
            System.out.println("Solo se permiten 5 ordenes.");
        }

        for (int i = 1; i <= cantidad; i++) {

            System.out.println("Orden:");

            System.out.println("Seleccione la masa:");
            System.out.println("1. Gruesa");
            System.out.println("2. Delgada");

            int opcionMasa = teclado.nextInt();

            Masa masa;

            if (opcionMasa == 1) {
                masa = Masa.Gruesa;
            } else {
                masa = Masa.Delgada;
            }

            System.out.println("Seleccione el sabor:");
            System.out.println("1. Normal");
            System.out.println("2. Picante");
            System.out.println("3. Ranch");
            System.out.println("4. BBQ");
            System.out.println("5. Dulce");

            int opcionSabor = teclado.nextInt();

            Sabor sabor;

            if (opcionSabor == 1) {
                sabor = Sabor.Normal;
            } else if (opcionSabor == 2) {
                sabor = Sabor.Picante;
            } else if (opcionSabor == 3) {
                sabor = Sabor.Ranch;
            } else if (opcionSabor == 4) {
                sabor = Sabor.Bbq;
            } else {
                sabor = Sabor.Dulce;
            }

            System.out.println("Seleccione un ingrediente:");
            System.out.println("1. Pepperoni");
            System.out.println("2. Salchicha");
            System.out.println("3. Jamon");
            System.out.println("4. Chile pimiento");
            System.out.println("5. Anchoas");
            System.out.println("6. Pina");

            int opcionIngrediente = teclado.nextInt();

            Ingrediente ingrediente;

            if (opcionIngrediente == 1) {
                ingrediente = Ingrediente.Peperoni;
            } else if (opcionIngrediente == 2) {
                ingrediente = Ingrediente.Salchicha;
            } else if (opcionIngrediente == 3) {
                ingrediente = Ingrediente.Jamon;
            } else if (opcionIngrediente == 4) {
                ingrediente = Ingrediente.Chile;
            } else if (opcionIngrediente == 5) {
                ingrediente = Ingrediente.Anchoas;
            } else {
                ingrediente = Ingrediente.Pinia;
            }

            System.out.println("Quieres agregarle orilla de queso?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int opcionQueso = teclado.nextInt();

            boolean orillaQueso;

            if (opcionQueso == 1) {
                orillaQueso = true;
            } else {
                orillaQueso = false;
            }

            System.out.println("¿Quieres agregar una bebida?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int opcionBebida = teclado.nextInt();

            boolean bebida;

            if (opcionBebida == 1) {
                bebida = true;
            } else {
                bebida = false;
            }

            Pizza pizza = new Pizza(
                    masa,
                    sabor,
                    ingrediente,
                    orillaQueso
            );


            Orden orden = new Orden(
                    i,
                    pizza,
                    bebida
            );

            cocina.recibirOrden(orden);

            System.out.println("Resumen de la orden:");
            orden.leerOrden();

            cocina.prepararOrden(orden);
            cocina.enviarOrden(orden);
        }
        cocina.mostrarCantidadOrdenes();
        System.out.println("Gracias por ordenar.");

        teclado.close();
    }
}