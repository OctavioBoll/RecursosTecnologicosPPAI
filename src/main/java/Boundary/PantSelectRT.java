package Boundary;

import Entity._AuxFilaRT;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PantSelectRT  extends Pantalla{
    public JButton btnSelectRTContinuar;
    private JPanel mainPanel;
    private JTable tbRecTec;
    private JLabel lblSeleccion;
    DefaultTableModel dtmRecTec = new DefaultTableModel();
    ArrayList<_AuxFilaRT> listaRecTec = new ArrayList();
    private _AuxFilaRT selectedRecTec;
    public int selectedRTIndex;


    public PantSelectRT(){
        super("Seleccionar Recurso Tecnologico", 700,500);
        setModelo();
        tbRecTec.getSelectionModel().addListSelectionListener(e -> {
             if (!tbRecTec.getSelectionModel().isSelectionEmpty()){

                 selectedRTIndex = tbRecTec.convertRowIndexToModel(tbRecTec.getSelectedRow());
                 selectedRecTec = listaRecTec.get(selectedRTIndex);
                 setSelect(selectedRecTec.getIdNumeroInv());

             }
        });
    }

    private void setModelo(){
        String[] cabeceras = {"Numero RT Inventario","Centro investigacion","Marca","Modelo","Estado"};
        dtmRecTec.setColumnIdentifiers(cabeceras);
        tbRecTec.setModel(dtmRecTec);
    }

    private void setSelect(int idSelect){
        lblSeleccion.setText(String.valueOf(idSelect));
        selectedRTIndex = idSelect;
    }

    public void llenarListaRecTec(int numeroInventario,String nombreCi,String modelo,String marca,String estado){
        _AuxFilaRT aux = new _AuxFilaRT(numeroInventario,nombreCi,marca,modelo,estado);
        listaRecTec.add(aux);
    }

    public  void setDatos(){
        Object[] datos = new Object[dtmRecTec.getColumnCount()];
        for (_AuxFilaRT aux:listaRecTec){
            datos[0] = aux.getIdNumeroInv();
            datos[1] = aux.getNombreci();
            datos[2] = aux.getMarca();
            datos[3] = aux.getModelo();
            datos[4] = aux.getNombreEstado();
            dtmRecTec.addRow(datos);
        }
        tbRecTec.setModel(dtmRecTec);
    }


    public void habilitarPantalla() {
        mostrarPantalla(mainPanel);
    }

    public void desabilitarPantalla(){cerrarPantalla();}


}


