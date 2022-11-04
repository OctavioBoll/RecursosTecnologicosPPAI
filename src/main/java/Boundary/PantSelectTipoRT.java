package Boundary;

import EntityDos.Tiporecursotecnologico;

import javax.swing.*;
import java.util.List;

public class PantSelectTipoRT extends Pantalla{
    private JPanel mainPanel;
    public JComboBox cmbTipoRT;
    public JButton btnContinuar;

    public PantSelectTipoRT(){
        super("Seleccionar Tipo Recurso Tec", 500,300);
        cmbTipoRT.addItem("Todos");
    }

    public void setCmbTipoRT(Tiporecursotecnologico tiporec){
        cmbTipoRT.addItem(tiporec.getNombre());
    }


    public void habilitarPantalla() {
        mostrarPantalla(mainPanel);
    }

    public void desabilitarPantalla(){cerrarPantalla();}

}
