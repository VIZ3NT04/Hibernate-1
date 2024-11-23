package org.example.Main;

import org.example.Controlador.ControladorVistaFormulario;
import org.example.Model.EmpleadoDAO;
import org.example.Vista.VistaFormulario;

public class Main {
    public static void main(String[] args) {
        EmpleadoDAO model = new EmpleadoDAO();
        VistaFormulario vista = new VistaFormulario();

        ControladorVistaFormulario controladorVistaFormulario = new ControladorVistaFormulario(vista,model);
        vista.setVisible(true);
    }
}