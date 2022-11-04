package Control;

import Boundary.*;
import DAO.EstadosDAO;
import DAO.RecursosTecnologicosDAO;
import DAO.SessionDAO;
import DAO.TipoRecursoDAO;
import EntityDos.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorControl {

    private static List<Tiporecursotecnologico> tipoRecTec;
    private static List<Recursotecnologico> recTec;
    private static List<Recursotecnologico> recTecReservables;
    private static List<Estado> estados;
    private static Recursotecnologico selectRecTec;
    private static List<Turno> turnosRecSelect;
    private static Sesion sesionActual;


    private final PantHome pantHome;
    private PantSelectTipoRT pantSelectTipoRT;
    private PantSelectRT pantSelectRT;
    private PantSelectTurno pantSelectTurno;
    private PantConfirmarReserva pantConfirmarReserva;
    private PantEmailReserva pantEmailReserva;
    private String tipoSelect;

    public GestorControl(){
        //Relacion de Dependencia entre Gestor y las Clases
        obtenerDatos();

        //Habilito las pantallas
        pantHome = new PantHome();
        pantSelectTipoRT = new PantSelectTipoRT();
        pantSelectRT = new PantSelectRT();
        pantSelectTurno = new PantSelectTurno();
        pantConfirmarReserva = new PantConfirmarReserva();
        pantEmailReserva = new PantEmailReserva();

        iniciarEventosPantHome();

    }


    public static void main(String[] args) {
        GestorControl gc = new GestorControl();
        gc.pantHome.habilitarPantalla();
    }

    //Iniciacion de Eventos de cada Pantalla
    public void iniciarEventosPantHome(){
        pantHome.btnNuevaReserva.addActionListener(this::actionPerformed);
    }
    public void iniciarEventosPantSelectTipoRT(){
        pantSelectTipoRT.cmbTipoRT.addActionListener(this::actionPerformed);
        pantSelectTipoRT.btnContinuar.addActionListener(this::actionPerformed);
    }
    public void iniciarEventosPantSelectRT(){
        pantSelectRT.btnSelectRTContinuar.addActionListener(this::actionPerformed);
    }
    public void iniciarEventosPantSelectTurno(){pantSelectTurno.btnContinuar.addActionListener(this::actionPerformed);}
    public void iniciarEventosPantConfirmarReserva(){pantConfirmarReserva.btnContinuar.addActionListener(this::actionPerformed);}
    public void iniciarEventosPantEmailReserva(){pantEmailReserva.btnAceptar.addActionListener(this::actionPerformed);}

    //Linea de vida Del Gestor
    public void actionPerformed(ActionEvent e){
        Object evt = e.getSource();

        //1.Cientifico apreta nueva reserva opcionReserva()
        if (evt.equals(pantHome.btnNuevaReserva)){
            pantHome.desabilitarPantalla();
            pantSelectTipoRT = new PantSelectTipoRT();

            //3.ObtenerTipoRT
            for (Tiporecursotecnologico tiporecursotecnologico: tipoRecTec){
                //4.*mostrarTipoRecurso()
                pantSelectTipoRT.setCmbTipoRT(tiporecursotecnologico);
            }

            //2.habilitarPantalla()
            pantSelectTipoRT.habilitarPantalla();
            //5.pedirSelecionTipoRT
            iniciarEventosPantSelectTipoRT();

        }
        //PANTALLA SELECT TIPO RT
        //6.SeleccionarTipoRT()
        else if(evt.equals(pantSelectTipoRT.btnContinuar)){
            pantSelectTipoRT.desabilitarPantalla();

            //7.tipoRTSeleccionado()
            tipoSelect  = pantSelectTipoRT.cmbTipoRT.getSelectedItem().toString();

            //8.obtenerRTActivoTipoRt
            recTecReservables = obtenerRTActivoDeTipoRT(tipoSelect);

            //22.pedirSeleccionRT()
            pantSelectRT.habilitarPantalla();
            iniciarEventosPantSelectRT();

        }
        //PANTALLA SELECT RT
        //23.seleccionarRT()
        else if(evt.equals(pantSelectRT.btnSelectRTContinuar)){
            pantSelectTipoRT.desabilitarPantalla();
            int idRc = pantSelectRT.selectedRTIndex;

            for (Recursotecnologico recuTec: recTecReservables) {
                if (recuTec.getNumeroRt() == idRc){
                    //24.recursoTSeleccionado()
                    selectRecTec = recuTec;
                }
            }

            //25.verificarCentroDeCientificoLogeado()
            if (verificarCILog()){

                //32.obtenerFechaActual()
                Date fechaActual_ = new Date();
                //LocalDateTime fechaActual = obtenerFechaHoraActual();

                //31.obtenerTurnoReservablesRTSeleccionado()
                turnosRecSelect = obtenerTurnosReservablesRTSeleccionado(selectRecTec,fechaActual_);


                for (Turno turnoRTselect : turnosRecSelect){
                    if (turnoRTselect.getFechaHoraInicioTurno() != null ){
                        for (Cambioestadoturno cambioestadoturno: turnoRTselect.getCambioestadoturnosByIdTurno()){
                            if (cambioestadoturno.esActual() && cambioestadoturno.getIdEstado() == 1){
                                String fecha = new SimpleDateFormat("yyyy/MM/dd").format(turnoRTselect.getFechaHoraInicioTurno());
                                pantSelectTurno.llenarListaRecTec(fecha);
                            }
                        }
                    }

                    //32agruparyOrdenarTurnos()

                }
                pantSelectTurno.setDatos();
                //33.PedirSeleccionDeTurno()
                pantSelectTurno.habilitarPantalla();
                iniciarEventosPantSelectTurno();
            }else{
                JOptionPane.showMessageDialog(null,"El Cientifico no pertenece al mismo Centro de Investigacion");
            }
        }
        //PANTALLA SELECT TURNO Confirmado
        //34.SeleccionarTurno() 35.TurnoSeleccionado()
        else if (evt.equals(pantSelectTurno.btnContinuar)){
            pantSelectTurno.desabilitarPantalla();
            if (pantSelectTurno.verificarFechaSelect(turnosRecSelect)){
                //35.PedirConfirmacion()
                pantConfirmarReserva.setDatos(selectRecTec,pantSelectTurno.lblSelectFecha.getText());
                pantConfirmarReserva.habilitarPantalla();
                iniciarEventosPantConfirmarReserva();

            }
        }
        //pantalla confirmar reserva
        //36.ConfirmarReserva() 37.ReservarTurnoRT
        else if(evt.equals(pantConfirmarReserva.btnContinuar)){
        pantConfirmarReserva.desabilitarPantalla();
            for ( Turno turnoSelect : turnosRecSelect){
                if (turnoSelect.getFechaHoraInicioTurno() != null){

                    String fecha = new SimpleDateFormat("yyyy/MM/dd").format(turnoSelect.getFechaHoraInicioTurno());

                    if (fecha.equals(pantSelectTurno.lblSelectFecha.getText())){
                        //38.generarReservaRTSeleccionado()
                        generarReservaRTSeleccionado(turnoSelect);

                        //47.ObtenerMAilCientifico()
                        String correo = obtenerMailCientifico();

                        //48.EnviarReserva()
                        pantEmailReserva.setearDatos(selectRecTec.getCentrodeinvestigacionByIdCi().getNombre(),
                                tipoSelect,selectRecTec.getModeloByIdModelo().getMarcaByIdMarca().getNombre(),
                                selectRecTec.getModeloByIdModelo().getNombre(),fecha,correo );
                        pantEmailReserva.habilitarPantalla();
                        iniciarEventosPantEmailReserva();
                        //49.FinDeCU
                    }
                }
            }
        }
        else if(evt.equals(pantEmailReserva.btnAceptar)){
            pantEmailReserva.desabilitarPantalla();
            pantConfirmarReserva.desabilitarPantalla();
            pantSelectTurno.desabilitarPantalla();
            pantSelectRT.desabilitarPantalla();
            pantHome.desabilitarPantalla();
            pantSelectTipoRT.desabilitarPantalla();
        }
    }

    public String obtenerMailCientifico(){
        return sesionActual.getUsuarioByUsuario().getPersonalcientificoByLegajoPc().getCorreoElectronicoPersonal();
    }

    public void generarReservaRTSeleccionado(Turno turno){
        //39.obtenerEstadoReservado()
        Estado estado = obtenerEstadoReservado();

        //42.ReservarTurno
        selectRecTec.reservarTurnos(estado,turno);
    }


    public Estado obtenerEstadoReservado(){
        Estado nombreEstado = new Estado();
        for (Estado estado : estados){

            //40.esAmbitoTurno()
            if (estado.getAmbito().equals("Turno")){
                //41.esReservado()
                if (estado.getNombre().equals("No disponible")){
                    nombreEstado = estado;
                }
            }
        }
        return nombreEstado;
    }

    //Obtener la fecha actual del sistema
    public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    //Obtener la fecha y hora actual del sistema
    public LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    //Obtener la hora actual del sistema
    public LocalTime obtenerHoraActual() {
        return LocalTime.now();
    }

    public List<Turno> obtenerTurnosReservablesRTSeleccionado(Recursotecnologico selectRec, Date fechaActual){
        return selectRec.mostrarTurno(fechaActual);

        //32.mostrarTurno()
        //turnosRecSelect = selectRec.mostrarTurno(fechaActual);

        //return turnosRecSelect;
    }

    //session getCientifico
    public Boolean verificarCILog(){
        Boolean aux = false;

        //26.obtenerCiLogeado
        Personalcientifico perCien = sesionActual.obtenerCientificoLogeado();

        //28.elCientificoEsDeMiCI()
        if (selectRecTec.elCientificoEsDeMiCI(perCien)){
            aux = true;
        }
        return aux;
    }

    public Tiporecursotecnologico obtenerTipoRT(String nombre){
        Tiporecursotecnologico aux = null;
        for (Tiporecursotecnologico tiporecursotecnologico : tipoRecTec){
            if (tiporecursotecnologico.getNombre().equals(nombre)){
                aux = tiporecursotecnologico;
                break;
            }
        }
        return aux;
    }


    //Devolver una lista de RecursosTecnologicos

    public List<Recursotecnologico> obtenerRTActivoDeTipoRT(String tipoRt)
    {
        List<Recursotecnologico> aux = new ArrayList<Recursotecnologico>();


        //Loop mientras exista RT
        for (Recursotecnologico recursotecnologico : recTec){

            //9.esDeTipoRT()
            if (recursotecnologico.esDeTipoRT(pantSelectTipoRT.cmbTipoRT.getSelectedItem().toString())
                    || tipoRt == "Todos" ){

                //10.esActivo
                if (recursotecnologico.esActivo()){
                    aux.add(recursotecnologico);
                }
            }
        }
        //Loop RT con estado Reservable = Disponible
        for (Recursotecnologico recursotecnologico : aux){
            //14.mostrarDatos()
            ArrayList<String> nombres = recursotecnologico.mostrarDatos();

            int nroRt = recursotecnologico.getNumeroRt();
            String nombreEstado = nombres.get(0) ;
            String nombreCi = nombres.get(1);
            String marca = nombres.get(2);
            String modelo = nombres.get(3);

            //21.ordenarYAgruparRT()
            pantSelectRT.llenarListaRecTec(nroRt,nombreCi,nombreEstado,modelo,marca);
        }
        pantSelectRT.setDatos();
        return aux;
    }

    public void obtenerDatos(){
        SessionDAO sessionDAO = new SessionDAO();
        sesionActual = sessionDAO.listar();

        TipoRecursoDAO tipoRecursoDAO = new TipoRecursoDAO();
        tipoRecTec = tipoRecursoDAO.listar();

        RecursosTecnologicosDAO recursosTecnologicosDAO = new RecursosTecnologicosDAO();
        recTec = recursosTecnologicosDAO.listar();

        EstadosDAO estadosDAO = new EstadosDAO();
        estados = estadosDAO.listar();
    }
}
