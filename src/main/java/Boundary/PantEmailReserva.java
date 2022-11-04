package Boundary;

import javax.swing.*;

public class PantEmailReserva extends Pantalla {
    private JLabel txtCentroInvestigacion;
    private JLabel txtRecTec;
    private JLabel txtTurno;
    public JButton btnAceptar;
    private JPanel mainPanel;
    private JLabel txtCorreo;

    public PantEmailReserva(){
        super("Email Reserva",500,500);

    }

    public void desabilitarPantalla(){cerrarPantalla();}

    public void setearDatos(String centroInvestigacion,String tipoRec,String modelo,String marca,String fechaTurno,String correo){
        txtCentroInvestigacion.setText(centroInvestigacion);
        txtRecTec.setText(tipoRec + " " + marca + " " + modelo);
        txtTurno.setText(fechaTurno);
        txtCorreo.setText(correo);

    }

    public void habilitarPantalla(){mostrarPantalla(mainPanel);}
}


