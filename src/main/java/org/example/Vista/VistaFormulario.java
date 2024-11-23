package org.example.Vista;

import javax.swing.*;

public class VistaFormulario extends JFrame {
    public JPanel pnPrincipal;
    public JPanel pnTop;
    public JPanel pnBot;
    public JTable table1;
    public JPanel pnEsquerre;
    public JPanel psDreta;
    public JTextField tfDni;
    public JTextField tfNombre;
    public JTextField tfApellidos;
    public JTextField tfEdad;
    public JTextField tfSalario;
    public JButton btListar;
    public JButton btInsertar;
    public JButton btBorrar;

    public VistaFormulario() {
        setContentPane(pnPrincipal);
        setTitle("Titulo");
        pack();
        // setsize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
