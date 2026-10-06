package model;

public class Pizza {

    private Masa masa;
    private Sabor sabor;
    private Ingrediente[] ingredientes;
    private boolean orillaQueso;

    public Pizza(Masa masa, Sabor sabor, boolean orillaQueso) {
        this.masa = masa;
        this.sabor = sabor;
        this.orillaQueso = orillaQueso;

        ingredientes = new Ingrediente[3];
    }

    public void agregarTopping(Ingrediente ingrediente) {
        ingredientes[0] = ingrediente;
    }

    public void agregarTopping(Ingrediente ingrediente1, Ingrediente ingrediente2) {

        ingredientes[0] = ingrediente1;
        ingredientes[1] = ingrediente2;
    }

    public void agregarTopping(Ingrediente ingrediente1,Ingrediente ingrediente2, Ingrediente ingrediente3) {

        ingredientes[0] = ingrediente1;
        ingredientes[1] = ingrediente2;
        ingredientes[2] = ingrediente3;
    }


    public void amasar() {
        System.out.println("Se esta amasando la pizza...");
    }


    public void cocinar() {
        System.out.println("La pizza se esta cocinando...");
    }


    public void mostrarPizza() {

        System.out.println("Masa: " + masa);
        System.out.println("Sabor: " + sabor);

        System.out.println("Ingredientes:");

        for (int i = 0; i < ingredientes.length; i++) {

            if (ingredientes[i] != null) {
                System.out.println("- " + ingredientes[i]);
            }
        }

        if (orillaQueso == true) {
            System.out.println("Orilla de queso: Si");
        } else {
            System.out.println("Orilla de queso: No");
        }
    }
}