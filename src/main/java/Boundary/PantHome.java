package Boundary;

import javax.swing.*;

public class PantHome extends Pantalla{
    public JButton btnNuevaReserva;
    private JPanel mainPanel;


    public PantHome(){
        super("Home",200,200);
    }

    public void habilitarPantalla(){mostrarPantalla(mainPanel);}

    public void desabilitarPantalla(){cerrarPantalla();}


}
