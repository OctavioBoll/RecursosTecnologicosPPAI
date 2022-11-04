package EntityDos;

import DAO.TurnosxRTDAO;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Recursotecnologico {
    private int numeroRt;
    private int idCi;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private String imagen;
    private String fraccionHorarioTurnos;
    private int idTipoRecursoTec;
    private int idModelo;
    private Collection<Cambioestadort> cambioestadortsByNumeroRt;
    private Centrodeinvestigacion centrodeinvestigacionByIdCi;
    private Tiporecursotecnologico tiporecursotecnologicoByIdTipoRecursoTec;
    private Modelo modeloByIdModelo;
    private Collection<Turno> turnosByNumeroRt;

    @Id
    @Column(name = "numeroRT")
    public int getNumeroRt() {
        return numeroRt;
    }

    public void setNumeroRt(int numeroRt) {
        this.numeroRt = numeroRt;
    }

    @Basic
    @Column(name = "idCI" ,insertable = false, updatable = false)
    public int getIdCi() {
        return idCi;
    }

    public void setIdCi(int idCi) {
        this.idCi = idCi;
    }

    @Basic
    @Column(name = "fechaHoraAlta")
    public Timestamp getFechaHoraAlta() {
        return fechaHoraAlta;
    }

    public void setFechaHoraAlta(Timestamp fechaHoraAlta) {
        this.fechaHoraAlta = fechaHoraAlta;
    }

    @Basic
    @Column(name = "fechaHoraBaja")
    public Timestamp getFechaHoraBaja() {
        return fechaHoraBaja;
    }

    public void setFechaHoraBaja(Timestamp fechaHoraBaja) {
        this.fechaHoraBaja = fechaHoraBaja;
    }

    @Basic
    @Column(name = "imagen")
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Basic
    @Column(name = "fraccionHorarioTurnos")
    public String getFraccionHorarioTurnos() {
        return fraccionHorarioTurnos;
    }

    public void setFraccionHorarioTurnos(String fraccionHorarioTurnos) {
        this.fraccionHorarioTurnos = fraccionHorarioTurnos;
    }

    @Basic
    @Column(name = "idTipoRecursoTec" ,insertable = false, updatable = false)
    public int getIdTipoRecursoTec() {
        return idTipoRecursoTec;
    }

    public void setIdTipoRecursoTec(int idTipoRecursoTec) {
        this.idTipoRecursoTec = idTipoRecursoTec;
    }

    @Basic
    @Column(name = "idModelo" ,insertable = false, updatable = false)
    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recursotecnologico that = (Recursotecnologico) o;
        return numeroRt == that.numeroRt && idCi == that.idCi && idTipoRecursoTec == that.idTipoRecursoTec && idModelo == that.idModelo && Objects.equals(fechaHoraAlta, that.fechaHoraAlta) && Objects.equals(fechaHoraBaja, that.fechaHoraBaja) && Objects.equals(imagen, that.imagen) && Objects.equals(fraccionHorarioTurnos, that.fraccionHorarioTurnos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroRt, idCi, fechaHoraAlta, fechaHoraBaja, imagen, fraccionHorarioTurnos, idTipoRecursoTec, idModelo);
    }

    @OneToMany(mappedBy = "recursotecnologicoByNumeroRt")
    public Collection<Cambioestadort> getCambioestadortsByNumeroRt() {
        return cambioestadortsByNumeroRt;
    }

    public void setCambioestadortsByNumeroRt(Collection<Cambioestadort> cambioestadortsByNumeroRt) {
        this.cambioestadortsByNumeroRt = cambioestadortsByNumeroRt;
    }

    @ManyToOne
    @JoinColumn(name = "idCI", referencedColumnName = "idCI", nullable = false)
    public Centrodeinvestigacion getCentrodeinvestigacionByIdCi() {
        return centrodeinvestigacionByIdCi;
    }

    public void setCentrodeinvestigacionByIdCi(Centrodeinvestigacion centrodeinvestigacionByIdCi) {
        this.centrodeinvestigacionByIdCi = centrodeinvestigacionByIdCi;
    }

    @ManyToOne
    @JoinColumn(name = "idTipoRecursoTec", referencedColumnName = "idTipoRecursoTec", nullable = false)
    public Tiporecursotecnologico getTiporecursotecnologicoByIdTipoRecursoTec() {
        return tiporecursotecnologicoByIdTipoRecursoTec;
    }

    public void setTiporecursotecnologicoByIdTipoRecursoTec(Tiporecursotecnologico tiporecursotecnologicoByIdTipoRecursoTec) {
        this.tiporecursotecnologicoByIdTipoRecursoTec = tiporecursotecnologicoByIdTipoRecursoTec;
    }

    @ManyToOne
    @JoinColumn(name = "idModelo", referencedColumnName = "idModelo", nullable = false)
    public Modelo getModeloByIdModelo() {
        return modeloByIdModelo;
    }

    public void setModeloByIdModelo(Modelo modeloByIdModelo) {
        this.modeloByIdModelo = modeloByIdModelo;
    }

    @OneToMany(mappedBy = "recursotecnologicoByNumeroRt")
    public Collection<Turno> getTurnosByNumeroRt() {
        return turnosByNumeroRt;
    }

    public void setTurnosByNumeroRt(Collection<Turno> turnosByNumeroRt) {
        this.turnosByNumeroRt = turnosByNumeroRt;
    }


    @Override
    public String toString() {
        return "Recursotecnologico{" +
                "numeroRt=" + numeroRt +
                ", idCi=" + idCi +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                ", imagen='" + imagen + '\'' +
                ", fraccionHorarioTurnos='" + fraccionHorarioTurnos + '\'' +
                ", idTipoRecursoTec=" + idTipoRecursoTec +
                ", idModelo=" + idModelo +
                ", cambioestadortsByNumeroRt=" + cambioestadortsByNumeroRt +
                ", turnosByNumeroRt=" + turnosByNumeroRt +
                '}';
    }

    //recursoTEC
    public Boolean esDeTipoRT(String tipoRec){
        Boolean aux = false;


        if (tiporecursotecnologicoByIdTipoRecursoTec.getNombre() == tipoRec){
            aux = true;
        }
        return aux;
    }

    //Condicion es activo cuando fechahorabaja es igual a null
    public Boolean esActivo(){
        Boolean aux = false;
        //loop cambioEstado
        for (Cambioestadort recTec: getCambioestadortsByNumeroRt()){
            //11.esActual()
            if (recTec.esActual()){
                //12.esEstadoActualReservable //13.esReservable() = Disponible
                if (recTec.getEstadoByIdEstado().getNombre().equals("Disponible")){
                    aux=true;
                    break;
                }
            }
        }
        return aux;
    }

    public ArrayList<String> mostrarDatos(){
        ArrayList<String> datos = new ArrayList<>();

        String nombreEstado = null;
        Centrodeinvestigacion centrodeinvestigacion = null;

        for (Cambioestadort cambioestadort1 : this.getCambioestadortsByNumeroRt()){
            //15.mostrarEstado() 16.getNombre()
            nombreEstado = cambioestadort1.getEstadoByIdEstado().getNombre();
        }
        datos.add(nombreEstado);//0

        //17.mostrarCi() 18.getNombre()
        String centroI = this.getCentrodeinvestigacionByIdCi().getNombre();
        datos.add(centroI);//1
        //19.mostrarMarcayModelo() 20.mostrarMarca()

        String marca = this.getModeloByIdModelo().getNombre();
        datos.add(marca);//2

        String modelo = this.getModeloByIdModelo().getMarcaByIdMarca().getNombre();
        datos.add(modelo);//3

        return datos;
    }

    public ArrayList<Turno> mostrarTurno(Date fechaActual){
//        List<Turno> turnos = null;
        ArrayList<Turno> aux = new ArrayList<Turno>();

        //Loop mientras existan Turnos
        for (Turno turno: this.getTurnosByNumeroRt()){

            //33.esPosteriorAFecha
            if (turno.esPosteriorAFecha(fechaActual)){

                //aux.add(turno);
                //34.mostrarTurno()
                aux.add(turno.mostrarTurnosIdentifiado());
            }
        }
        return aux;
    }

    public void reservarTurnos(Estado estado,Turno turno){
            //43.Reservar
            turno.reservar(estado);
            
    }


    //idTurno=autoInc, idAsignacionCientifico=?, legajoPc=?, numeroRt=selectRecTec.getNumeroRt, fhi=fechaTurno
    //diaSemana=Calculable, fhAlta=datenow, fhBaja=null;
    public void reservarTurno(String estado,Date fechahi,Sesion sesionActual ){
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        newDateFormat.applyPattern("EEEE");
        String diaSemana = newDateFormat.format(fechahi);
        Date fechaActual = new Date();


        Timestamp fechahii = new Timestamp(fechahi.getTime());


        System.out.println("isertar Turno: " + diaSemana);
        //Turno turno = new Turno(1,sesionActual.getUsuarioByUsuario().getLegajoPc(),this.getNumeroRt(),fechahi,diaSemana, fechaActual);

        //TurnosxRTDAO turnosxRTDAO = new TurnosxRTDAO();
        //turnosxRTDAO.insertar(turno);


    }

    public Boolean elCientificoEsDeMiCI(Personalcientifico personalcientifico){
        boolean aux = false;
        //29.esTuCientificoActivo
        if (this.getCentrodeinvestigacionByIdCi().esTuCientificoActivo(personalcientifico)){
            aux = true;
        }
        return aux;
    }
}
