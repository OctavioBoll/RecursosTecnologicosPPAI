package Boundary;

import EntityDos.Recursotecnologico;
import EntityDos.Turno;

import javax.swing.*;

public class PantConfirmarReserva extends Pantalla {
    private JLabel txtTurno;
    public JButton btnContinuar;
    public JButton btnCancelar;
    private JPanel mainPanel;
    public JComboBox cmbNotificacion;

    public PantConfirmarReserva(){
        super("Confirmar Reserva",500,500);
        cmbNotificacion.addItem("Email");
        cmbNotificacion.addItem("Whatsapp");
    }

    public void habilitarPantalla(){mostrarPantalla(mainPanel);}
    public void desabilitarPantalla(){cerrarPantalla();}

    public void setDatos(Recursotecnologico rec, String fechaTurno){
        int numeroRT = rec.getNumeroRt();
        String marca = rec.getModeloByIdModelo().getMarcaByIdMarca().getNombre();
        String modelo = rec.getModeloByIdModelo().getNombre();


        txtTurno.setText("nro RT: " + numeroRT + " Marca: " + marca + " Modelo: " + modelo +" Fecha Turno: " + fechaTurno);

    }
}
