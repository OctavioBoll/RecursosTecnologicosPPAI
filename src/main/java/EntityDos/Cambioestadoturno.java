package EntityDos;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Cambioestadoturno {
    private int idCambioEstadoTurno;
    private int idTurno;
    private int idEstado;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Turno turnoByIdTurno;
    private Estado estadoByIdEstado;

    public Cambioestadoturno(int idCambioEstadoTurno, int idTurno, int idEstado, Timestamp dates, Timestamp fechaHoraBaja, Turno turno, Estado estado) {
        this.idCambioEstadoTurno = idCambioEstadoTurno;
        this.idTurno = idTurno;
        this.idEstado = idEstado;
        this.fechaHoraAlta = dates;
        this.turnoByIdTurno = turno;
        this.estadoByIdEstado = estado;
        this.fechaHoraBaja = fechaHoraBaja;

    }

    public Cambioestadoturno(int idTurno, int idEstado, Timestamp dates, Turno turno, Estado estado) {
        this.idTurno = idTurno;
        this.idEstado = idEstado;
        this.fechaHoraAlta = dates;
        this.turnoByIdTurno = turno;
        this.estadoByIdEstado = estado;


    }

    public Cambioestadoturno() {

    }

    @Id
    @Column(name = "idCambioEstadoTurno")
    public int getIdCambioEstadoTurno() {
        return idCambioEstadoTurno;
    }

    public void setIdCambioEstadoTurno(int idCambioEstadoTurno) {
        this.idCambioEstadoTurno = idCambioEstadoTurno;
    }

    @Basic
    @Column(name = "idTurno" ,insertable = false, updatable = false)
    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    @Basic
    @Column(name = "idEstado" ,insertable = false, updatable = false)
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
        Cambioestadoturno that = (Cambioestadoturno) o;
        return idCambioEstadoTurno == that.idCambioEstadoTurno && idTurno == that.idTurno && idEstado == that.idEstado && Objects.equals(fechaHoraAlta, that.fechaHoraAlta) && Objects.equals(fechaHoraBaja, that.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCambioEstadoTurno, idTurno, idEstado, fechaHoraAlta, fechaHoraBaja);
    }

    @ManyToOne
    @JoinColumn(name = "idTurno", referencedColumnName = "idTurno", nullable = false)
    public Turno getTurnoByIdTurno() {
        return turnoByIdTurno;
    }

    public void setTurnoByIdTurno(Turno turnoByIdTurno) {
        this.turnoByIdTurno = turnoByIdTurno;
    }

    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = false)
    public Estado getEstadoByIdEstado() {
        return estadoByIdEstado;
    }

    public void setEstadoByIdEstado(Estado estadoByIdEstado) {
        this.estadoByIdEstado = estadoByIdEstado;
    }

    @Override
    public String toString() {
        return "Cambioestadoturno{" +
                "idCambioEstadoTurno=" + idCambioEstadoTurno +
                ", idTurno=" + idTurno +
                ", idEstado=" + idEstado +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                ", turnoByIdTurno=" + turnoByIdTurno +
                ", estadoByIdEstado=" + estadoByIdEstado +
                '}';
    }

    public Boolean esActual(){
        boolean aux = false;


        if (this.getFechaHoraBaja() == null){
            //36.mostrarEstado() 37.getNombre()
            aux = true;
        }
        return aux;
    }

    public void esActualTurno(){

    }
}
