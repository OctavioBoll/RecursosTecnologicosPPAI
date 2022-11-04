package EntityDos;

import DAO.CambioEstadoTurnoDAO;
import DAO.TipoRecursoDAO;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.*;

@Entity
public class Turno {
    private int idTurno;
    private int idAsignacionCientifico;
    private int legajoPc;
    private int numeroRt;
    private Timestamp fechaHoraInicioTurno;
    private String diaSemana;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Collection<Cambioestadoturno> cambioestadoturnosByIdTurno;
    private Asignacioncientificoci asignacioncientificociByIdAsignacionCientifico;
    private Personalcientifico personalcientificoByLegajoPc;
    private Recursotecnologico recursotecnologicoByNumeroRt;

    public Turno( int idAsignacionCientifico, int legajoPc, int numeroRt, Timestamp fechahi, String diaSemana, Timestamp fechaActual) {
        this.idAsignacionCientifico = idAsignacionCientifico;
        this.legajoPc = legajoPc;
        this.numeroRt = numeroRt;
        this.fechaHoraInicioTurno = fechahi;
        this.diaSemana = diaSemana;
        this.fechaHoraAlta = fechaActual;
    }

    public Turno() {

    }

    @Id
    @Column(name = "idTurno")
    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    @Basic
    @Column(name = "idAsignacionCientifico" ,insertable = false, updatable = false)
    public int getIdAsignacionCientifico() {
        return idAsignacionCientifico;
    }

    public void setIdAsignacionCientifico(int idAsignacionCientifico) {
        this.idAsignacionCientifico = idAsignacionCientifico;
    }

    @Basic
    @Column(name = "legajoPC" ,insertable = false, updatable = false)
    public int getLegajoPc() {
        return legajoPc;
    }

    public void setLegajoPc(int legajoPc) {
        this.legajoPc = legajoPc;
    }

    @Basic
    @Column(name = "numeroRT" ,insertable = false, updatable = false)
    public int getNumeroRt() {
        return numeroRt;
    }

    public void setNumeroRt(int numeroRt) {
        this.numeroRt = numeroRt;
    }

    @Basic
    @Column(name = "fechaHoraInicioTurno")
    public Timestamp getFechaHoraInicioTurno() {
        return fechaHoraInicioTurno;
    }

    public void setFechaHoraInicioTurno(Timestamp fechaHoraInicioTurno) {
        this.fechaHoraInicioTurno = fechaHoraInicioTurno;
    }

    @Basic
    @Column(name = "diaSemana")
    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turno turno = (Turno) o;
        return idTurno == turno.idTurno && idAsignacionCientifico == turno.idAsignacionCientifico && legajoPc == turno.legajoPc && numeroRt == turno.numeroRt && Objects.equals(fechaHoraInicioTurno, turno.fechaHoraInicioTurno) && Objects.equals(diaSemana, turno.diaSemana) && Objects.equals(fechaHoraAlta, turno.fechaHoraAlta) && Objects.equals(fechaHoraBaja, turno.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTurno, idAsignacionCientifico, legajoPc, numeroRt, fechaHoraInicioTurno, diaSemana, fechaHoraAlta, fechaHoraBaja);
    }

    @OneToMany(mappedBy = "turnoByIdTurno")
    public Collection<Cambioestadoturno> getCambioestadoturnosByIdTurno() {
        return cambioestadoturnosByIdTurno;
    }

    public void setCambioestadoturnosByIdTurno(Collection<Cambioestadoturno> cambioestadoturnosByIdTurno) {
        this.cambioestadoturnosByIdTurno = cambioestadoturnosByIdTurno;
    }

    @ManyToOne
    @JoinColumn(name = "idAsignacionCientifico", referencedColumnName = "idAsignacionCientificoCI", nullable = false)
    public Asignacioncientificoci getAsignacioncientificociByIdAsignacionCientifico() {
        return asignacioncientificociByIdAsignacionCientifico;
    }

    public void setAsignacioncientificociByIdAsignacionCientifico(Asignacioncientificoci asignacioncientificociByIdAsignacionCientifico) {
        this.asignacioncientificociByIdAsignacionCientifico = asignacioncientificociByIdAsignacionCientifico;
    }

    @ManyToOne
    @JoinColumn(name = "legajoPC", referencedColumnName = "legajoPC", nullable = false)
    public Personalcientifico getPersonalcientificoByLegajoPc() {
        return personalcientificoByLegajoPc;
    }

    public void setPersonalcientificoByLegajoPc(Personalcientifico personalcientificoByLegajoPc) {
        this.personalcientificoByLegajoPc = personalcientificoByLegajoPc;
    }

    @ManyToOne
    @JoinColumn(name = "numeroRT", referencedColumnName = "numeroRT", nullable = false)
    public Recursotecnologico getRecursotecnologicoByNumeroRt() {
        return recursotecnologicoByNumeroRt;
    }

    public void setRecursotecnologicoByNumeroRt(Recursotecnologico recursotecnologicoByNumeroRt) {
        this.recursotecnologicoByNumeroRt = recursotecnologicoByNumeroRt;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "idTurno=" + idTurno +
                ", idAsignacionCientifico=" + idAsignacionCientifico +
                ", legajoPc=" + legajoPc +
                ", numeroRt=" + numeroRt +
                ", fechaHoraInicioTurno=" + fechaHoraInicioTurno +
                ", diaSemana='" + diaSemana + '\'' +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                '}';
    }


    public Boolean esPosteriorAFecha(Date fechaActual){
        boolean aux = false;
        if (this.fechaHoraInicioTurno.after(fechaActual)){
            aux = true;
        }
        return aux;
    }

    public Turno mostrarTurnosIdentifiado(){
        Turno aux = new Turno();

        //Loop cambioEstadoTurno
        for (Cambioestadoturno cambioestadoturno: this.getCambioestadoturnosByIdTurno()){
            //35.esActual()
            if (cambioestadoturno.esActual()){
                aux = this;
            }
        }
        return aux;
    }



    public void reservar(Estado estado){
        //* Loop mientras haya CambioEstadoTurnos
        for (Cambioestadoturno cambioestadoturno : this.getCambioestadoturnosByIdTurno()){
            //44.esActual
            if (cambioestadoturno.esActual()){


                //datos
                Date date = new Date();
                Timestamp dates = new Timestamp(date.getTime());
                int idTurno = this.getIdTurno();

                //45.setFechaHoraHasta()
                cambioestadoturno.setFechaHoraBaja(dates);

                //46.Crear()
                Cambioestadoturno cambioestadoturnonew = new Cambioestadoturno(idTurno,estado.getIdEstado(),dates,this,estado);
                CambioEstadoTurnoDAO cambioEstadoTurnoDAO = new CambioEstadoTurnoDAO();
                cambioEstadoTurnoDAO.insertar(cambioestadoturnonew);


            }
        }


    }

}
