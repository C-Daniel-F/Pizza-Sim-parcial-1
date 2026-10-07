import model.Cocina;
import model.Orden;
import model.Pizza;
import model.Masa;
import model.Sabor;
import model.Ingrediente;

import javax.swing.*;
import java.awt.*;

public class Juego extends JFrame {

    Masa masa;
    Sabor sabor;
    Ingrediente ingrediente;
    int numeroOrden = 0;

    Cocina cocina = new Cocina();

    JCheckBox queso = new JCheckBox("Orilla de queso");
    JCheckBox bebida = new JCheckBox("Bebida");

    JTextArea vistaOrden = new JTextArea();
    JLabel mensaje = new JLabel("Arma tu pizza");
    String ultimaOrden = "";

    public Juego() {
        setTitle("Jack's Pizza Chef");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel ventana = new JPanel(new BorderLayout(0, 10));

        JPanel opciones = new JPanel();
        opciones.setLayout(new BoxLayout(opciones, BoxLayout.Y_AXIS));

        JPanel panelMasas = new JPanel();
        panelMasas.setBorder(BorderFactory.createTitledBorder("1. Elige la masa"));
        agregarMasa(panelMasas, "Gruesa", Masa.Gruesa);
        agregarMasa(panelMasas, "Delgada", Masa.Delgada);
        opciones.add(panelMasas);

        JPanel panelSabores = new JPanel();
        panelSabores.setBorder(BorderFactory.createTitledBorder("2. Elige el sabor"));
        agregarSabor(panelSabores, "Normal", Sabor.Normal);
        agregarSabor(panelSabores, "Picante", Sabor.Picante);
        agregarSabor(panelSabores, "Ranch", Sabor.Ranch);
        agregarSabor(panelSabores, "BBQ", Sabor.Bbq);
        agregarSabor(panelSabores, "Dulce", Sabor.Dulce);
        opciones.add(panelSabores);

        JPanel panelIngredientes = new JPanel();
        panelIngredientes.setBorder(
                BorderFactory.createTitledBorder("3. Elige un ingrediente")
        );
        agregarIngrediente(
                panelIngredientes, "Pepperoni", Ingrediente.Peperoni
        );
        agregarIngrediente(
                panelIngredientes, "Salchicha", Ingrediente.Salchicha
        );
        agregarIngrediente(panelIngredientes, "Jamón", Ingrediente.Jamon);
        agregarIngrediente(panelIngredientes, "Chile", Ingrediente.Chile);
        agregarIngrediente(
                panelIngredientes, "Anchoas", Ingrediente.Anchoas
        );
        agregarIngrediente(panelIngredientes, "Piña", Ingrediente.Pinia);
        opciones.add(panelIngredientes);

        JPanel panelExtras = new JPanel();
        panelExtras.setBorder(BorderFactory.createTitledBorder("4. Extras"));
        panelExtras.add(queso);
        panelExtras.add(bebida);
        opciones.add(panelExtras);

        queso.addActionListener(e -> actualizarVista());
        bebida.addActionListener(e -> actualizarVista());

        JButton ordenar = new JButton("Hacer orden");
        ordenar.addActionListener(e -> crearOrden());
        opciones.add(ordenar);
        opciones.add(mensaje);

        JPanel panelVista = new JPanel(new BorderLayout());
        panelVista.setBorder(
                BorderFactory.createTitledBorder("Tu orden")
        );

        vistaOrden.setEditable(false);
        vistaOrden.setFont(new Font("Times News Roman", Font.PLAIN, 16));
        panelVista.add(new JScrollPane(vistaOrden), BorderLayout.CENTER);

        ventana.add(new JScrollPane(opciones), BorderLayout.CENTER);

        panelVista.setPreferredSize(new Dimension(0, 180));
        ventana.add(panelVista, BorderLayout.SOUTH);

        add(ventana);
        actualizarVista();
    }

    private void agregarMasa(JPanel panel, String texto, Masa valor) {
        JButton boton = new JButton(texto);

        boton.addActionListener(e -> {
            masa = valor;
            actualizarVista();
        });

        panel.add(boton);
    }

    private void agregarSabor(JPanel panel, String texto, Sabor valor) {
        JButton boton = new JButton(texto);

        boton.addActionListener(e -> {
            sabor = valor;
            actualizarVista();
        });

        panel.add(boton);
    }

    private void agregarIngrediente(
            JPanel panel, String texto, Ingrediente valor
    ) {
        JButton boton = new JButton(texto);

        boton.addActionListener(e -> {
            ingrediente = valor;
            actualizarVista();
        });

        panel.add(boton);
    }

    private void actualizarVista() {
        vistaOrden.setText(
                "Realiza tu orden!\n\n"
                + "Masa: " + mostrar(masa) + "\n"
                + "Sabor: " + mostrar(sabor) + "\n"
                + "Ingrediente: " + mostrar(ingrediente) + "\n"
                + "Orilla de queso: "
                + (queso.isSelected() ? "Sí" : "No") + "\n"
                + "Bebida: "
                + (bebida.isSelected() ? "Sí" : "No") + "\n\n"
                + ultimaOrden
        );
    }

    private String mostrar(Object valor) {
        if (valor == null) {
            return "Sin elegir";
        }
        return valor.toString();
    }

    private void crearOrden() {
        if (masa == null || sabor == null || ingrediente == null) {
            mensaje.setText("Falta elegir masa, sabor o ingrediente");
            return;
        }

        if (numeroOrden == 5) {
            mensaje.setText("Solo se permiten 5 órdenes");
            return;
        }

        Pizza pizza = new Pizza(masa, sabor, queso.isSelected());
        pizza.agregarTopping(ingrediente);

        numeroOrden++;
        Orden orden = new Orden(
                numeroOrden, pizza, bebida.isSelected()
        );

        cocina.recibirOrden(orden);
        orden.leerOrden();
        cocina.prepararOrden(orden);
        cocina.enviarOrden(orden);

        ultimaOrden = "Orden realizada: #" + numeroOrden;
        mensaje.setText("¡Orden #" + numeroOrden + " creada!");
        actualizarVista();
    }

    public static void main(String[] args) {
        Juego ventana = new Juego();
        ventana.setVisible(true);
    }
}