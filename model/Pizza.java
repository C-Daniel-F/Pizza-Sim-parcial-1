package model;
public class Pizza {

    public Masa masa;
    public Sabor sabor;
    public Ingrediente ingrediente;
    public boolean orillaQueso;

    public Pizza(Masa masa, Sabor sabor,
                 Ingrediente ingrediente, boolean orillaQueso) {

        this.masa = masa;
        this.sabor = sabor;
        this.ingrediente = ingrediente;
        this.orillaQueso = orillaQueso;
    }

    public void amasar() {
        System.out.println("Se esta amasando tu pizza... Espera un momento.");
    }

    public void agregarTopping() {
        System.out.println("Agregando " + ingrediente + "...");
    }

    public void cocinar() {
        System.out.println("¡La pizza se esta cocinando!");
    }

    public void mostrarPizza() {
        System.out.println("Masa: " + masa);
        System.out.println("Sabor: " + sabor);
        System.out.println("Ingrediente: " + ingrediente);

        if (orillaQueso == true) {
            System.out.println("Orilla de queso: Si");
        } else {
            System.out.println("Orilla de queso: No");
        }
    }
}