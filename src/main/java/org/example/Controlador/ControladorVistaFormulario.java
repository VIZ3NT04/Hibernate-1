package org.example.Controlador;

import org.example.Model.Empleado;
import org.example.Model.EmpleadoDAO;
import org.example.Vista.VistaFormulario;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorVistaFormulario implements ActionListener {
    private VistaFormulario vista;
    private EmpleadoDAO model;

    public ControladorVistaFormulario(VistaFormulario vista, EmpleadoDAO model) {
        this.vista = vista;
        this.model = model;
        generear();
        vista.btInsertar.addActionListener(this);
        vista.btBorrar.addActionListener(this);
        vista.btListar.addActionListener(this);
    }







    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btInsertar) {
            String dni = vista.tfDni.getText();
            String nombre = vista.tfNombre.getText();
            String apellido = vista.tfApellidos.getText();
            int edad = Integer.parseInt(vista.tfEdad.getText());
            int salario =  Integer.parseInt(vista.tfSalario.getText());
            Empleado empleado = new Empleado(dni,nombre,apellido,edad,salario);
            if (model.insert(empleado) == 0) {
                System.out.println("S'ha insertat el empleado correctament");
            }

        }

        if (e.getSource() == vista.btListar) {
            generear();
        }

        if (e.getSource() == vista.btBorrar) {
            String dni = vista.tfDni.getText();
            Empleado empleado = new Empleado(dni,"","",0,0);
            if (model.delete(empleado) == 0) {
                System.out.println("El empleat s'ha eliminat correctament");
            }
        }
    }

    public void generear() {
        DefaultTableModel modeloT = new DefaultTableModel();
        vista.table1.setModel(modeloT);

        modeloT.addColumn("DNI");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("Edad");
        modeloT.addColumn("Salario");

        Object[] columna = new Object[5];
        List<Empleado> empleados = model.getAll();


        int numRegistros = empleados.size();

        for (Empleado empleado : empleados) {
            columna[0] = empleado.getDni();
            columna[1] = empleado.getNombre();
            columna[2] = empleado.getApellido();
            columna[3] = empleado.getEdad();
            columna[4] = empleado.getSalario();

            modeloT.addRow(columna);
        }
    }
}
