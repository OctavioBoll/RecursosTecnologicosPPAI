package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Cambioestadort {
    private int idCambioEstadoRt;
    private int numeroRt;
    private int idEstado;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Recursotecnologico recursotecnologicoByNumeroRt;
    private Estado estadoByIdEstado;

    @Id
    @Column(name = "idCambioEstadoRT")
    public int getIdCambioEstadoRt() {
        return idCambioEstadoRt;
    }

    public void setIdCambioEstadoRt(int idCambioEstadoRt) {
        this.idCambioEstadoRt = idCambioEstadoRt;
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
        Cambioestadort that = (Cambioestadort) o;
        return idCambioEstadoRt == that.idCambioEstadoRt && numeroRt == that.numeroRt && idEstado == that.idEstado && Objects.equals(fechaHoraAlta, that.fechaHoraAlta) && Objects.equals(fechaHoraBaja, that.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCambioEstadoRt, numeroRt, idEstado, fechaHoraAlta, fechaHoraBaja);
    }

    @ManyToOne
    @JoinColumn(name = "numeroRT", referencedColumnName = "numeroRT", nullable = false)
    public Recursotecnologico getRecursotecnologicoByNumeroRt() {
        return recursotecnologicoByNumeroRt;
    }

    public void setRecursotecnologicoByNumeroRt(Recursotecnologico recursotecnologicoByNumeroRt) {
        this.recursotecnologicoByNumeroRt = recursotecnologicoByNumeroRt;
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
        return "Cambioestadort{" +
                "idCambioEstadoRt=" + idCambioEstadoRt +
                ", numeroRt=" + numeroRt +
                ", idEstado=" + idEstado +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                '}';
    }

    public Boolean esActual(){
        Boolean aux = false;
        if (getFechaHoraBaja() == null){
            aux = true;
        }
        return aux;
    }
}
