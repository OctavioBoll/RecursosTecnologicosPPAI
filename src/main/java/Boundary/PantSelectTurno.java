package Boundary;


import Entity._AuxFilaRT;
import Entity._AuxFiltrarTurnos;
import EntityDos.Turno;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PantSelectTurno extends Pantalla {
    private JPanel mainPanel;
    public JButton btnContinuar;

    private JTable tblNoDisponibles;
    public JLabel lblSelectFecha;
    DefaultTableModel dtmNoDispo = new DefaultTableModel();
    ArrayList<_AuxFiltrarTurnos> listaTurnos = new ArrayList();
    private _AuxFiltrarTurnos selectedFecha;
    public int selectedFechaIndex;



    public PantSelectTurno(){
        super("Seleccionar Tipo Recurso Tec", 500,300);
        //Calendario


        tblNoDisponibles.getSelectionModel().addListSelectionListener(e -> {
            if (!tblNoDisponibles.getSelectionModel().isSelectionEmpty()){

                selectedFechaIndex = tblNoDisponibles.convertRowIndexToModel(tblNoDisponibles.getSelectedRow());
                selectedFecha = listaTurnos.get(selectedFechaIndex);
                setSelect(selectedFecha.getFecha());

            }
        });

        setModelo();
    }

    private void setModelo(){
        String[] cabeceras = {"FECHA"};
        dtmNoDispo.setColumnIdentifiers(cabeceras);
        tblNoDisponibles.setModel(dtmNoDispo);
    }

    private void setSelect(String fecha){
        lblSelectFecha.setText(fecha);

    }

    public void llenarListaRecTec(String fecha){
        _AuxFiltrarTurnos aux = new _AuxFiltrarTurnos(fecha);
        listaTurnos.add(aux);
    }

    public  void setDatos(){
        Object[] datos = new Object[dtmNoDispo.getColumnCount()];

        for (_AuxFiltrarTurnos aux : listaTurnos){
            datos[0] = aux.getFecha();
            dtmNoDispo.addRow(datos);
        }
        tblNoDisponibles.setModel(dtmNoDispo);
    }




    public Boolean verificarFechaSelect(List<Turno> rectecTurnos){
        boolean aux= false;
            for (Turno turno : rectecTurnos){
                if (turno.getFechaHoraInicioTurno() != null){
                    String fecha = new SimpleDateFormat("yyyy/MM/dd").format(turno.getFechaHoraInicioTurno());
                    if (lblSelectFecha.getText().equals(fecha)){
                        aux = true;
                        return aux;
                    }else{
                        aux = false;
                    }
                }

            }
        return aux;

        //String fecha = new SimpleDateFormat("yyyy/MM/dd").format(dataechos.getDate());
        //String[] dateParts = fecha.split("/");
        //String ano = dateParts[0],
        //        mes = dateParts[1],
        //        dia = dateParts[2];

        //String[] dateActual =  LocalDate.now().toString().split("-");
        //System.out.println("fecha Select:" + fecha);
        //System.out.println("año: "+ ano + " mes: " + mes + " dia: " + dia);

        //String anoActual = dateActual[0],
        //        mesActual = dateActual[1],
        //        diaActual = dateActual[2];

        //if (Integer.parseInt(anoActual) <= Integer.parseInt(ano)
        //        && Integer.parseInt(mesActual) <= Integer.parseInt(mes)
        //        && Integer.parseInt(diaActual) < Integer.parseInt(dia))
        //{
        //    System.out.println("if Exitoso");
        //    aux = true;
        //}else{
        //    JOptionPane.showMessageDialog(null,"Ingrese una fecha superior a la actual");
        //}
    }


    public void habilitarPantalla() {
        mostrarPantalla(mainPanel);
    }

    public void desabilitarPantalla(){cerrarPantalla();}
}
