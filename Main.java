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

        System.out.print("Cuantas ordenes desea hacer?");
        int cantidad = teclado.nextInt();

        if (cantidad > 5) {
            cantidad = 5;
            System.out.println("Solo se pueden hacer 5 ordenes.");
        }

        for (int i = 1; i <= cantidad; i++) {

            System.out.println();
            System.out.println("Orden #" + i);

            System.out.println();
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

            System.out.println();
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

            System.out.println();
            System.out.println("Desea orilla de queso?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int opcionQueso = teclado.nextInt();

            boolean orillaQueso;

            if (opcionQueso == 1) {
                orillaQueso = true;
            } else {
                orillaQueso = false;
            }

            Pizza pizza = new Pizza(
                    masa,
                    sabor,
                    orillaQueso
            );
            System.out.println();
            System.out.println("Cuantos ingredientes desea?");
            System.out.println("1. Un ingrediente");
            System.out.println("2. Dos ingredientes");
            System.out.println("3. Tres ingredientes");

            int cantidadIngredientes = teclado.nextInt();
            System.out.println();
            System.out.println("Seleccione ingrediente 1:");

            mostrarIngredientes();

            int opcion1 = teclado.nextInt();

            Ingrediente ingrediente1 =
                    seleccionarIngrediente(opcion1);

            if (cantidadIngredientes == 1) {

                pizza.agregarTopping(
                        ingrediente1
                );

            } else if (cantidadIngredientes == 2) {

                System.out.println();
                System.out.println("Seleccione ingrediente 2:");

                mostrarIngredientes();

                int opcion2 = teclado.nextInt();

                Ingrediente ingrediente2 =
                        seleccionarIngrediente(opcion2);

                pizza.agregarTopping(
                        ingrediente1,
                        ingrediente2
                );

            } else {

                System.out.println();
                System.out.println("Seleccione ingrediente 2:");

                mostrarIngredientes();

                int opcion2 = teclado.nextInt();

                Ingrediente ingrediente2 =
                        seleccionarIngrediente(opcion2);


                System.out.println();
                System.out.println("Seleccione ingrediente 3:");

                mostrarIngredientes();

                int opcion3 = teclado.nextInt();

                Ingrediente ingrediente3 =
                        seleccionarIngrediente(opcion3);
                pizza.agregarTopping(
                        ingrediente1,
                        ingrediente2,
                        ingrediente3
                );
            }

            System.out.println();
            System.out.println("Desea bebida?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int opcionBebida = teclado.nextInt();

            boolean bebida;

            if (opcionBebida == 1) {
                bebida = true;
            } else {
                bebida = false;
            }
            Orden orden = new Orden(
                    i,
                    pizza,
                    bebida
            );

            cocina.recibirOrden(orden);

            System.out.println();
            System.out.println("Resumen de la orden:");

            orden.leerOrden();
            cocina.prepararOrden(orden);
            cocina.enviarOrden(orden);

        cocina.mostrarCantidadOrdenes();

        System.out.println("Gracias por ordenar.");

        teclado.close(); }
    }
    public static void mostrarIngredientes() {

        System.out.println("1. Pepperoni");
        System.out.println("2. Salchicha");
        System.out.println("3. Jamon");
        System.out.println("4. Chile pimiento");
        System.out.println("5. Anchoas");
        System.out.println("6. Pina");
    }


    public static Ingrediente seleccionarIngrediente(int opcion) {

        Ingrediente ingrediente;

        if (opcion == 1) {
            ingrediente = Ingrediente.Peperoni;

        } else if (opcion == 2) {
            ingrediente = Ingrediente.Salchicha;

        } else if (opcion == 3) {
            ingrediente = Ingrediente.Jamon;

        } else if (opcion == 4) {
            ingrediente = Ingrediente.Chile;

        } else if (opcion == 5) {
            ingrediente = Ingrediente.Anchoas;

        } else {
            ingrediente = Ingrediente.Pinia;
        }

        return ingrediente;
    }
}