package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Asignacioncientificoci {
    private int idAsignacionCientificoCi;
    private int idCi;
    private int legajoPc;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Centrodeinvestigacion centrodeinvestigacionByIdCi;
    private Personalcientifico personalcientificoByLegajoPc;
    private Collection<Turno> turnosByIdAsignacionCientificoCi;

    @Id
    @Column(name = "idAsignacionCientificoCI")
    public int getIdAsignacionCientificoCi() {
        return idAsignacionCientificoCi;
    }

    public void setIdAsignacionCientificoCi(int idAsignacionCientificoCi) {
        this.idAsignacionCientificoCi = idAsignacionCientificoCi;
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
    @Column(name = "legajoPC" ,insertable = false, updatable = false)
    public int getLegajoPc() {
        return legajoPc;
    }

    public void setLegajoPc(int legajoPc) {
        this.legajoPc = legajoPc;
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
        Asignacioncientificoci that = (Asignacioncientificoci) o;
        return idAsignacionCientificoCi == that.idAsignacionCientificoCi && idCi == that.idCi && legajoPc == that.legajoPc && Objects.equals(fechaHoraAlta, that.fechaHoraAlta) && Objects.equals(fechaHoraBaja, that.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignacionCientificoCi, idCi, legajoPc, fechaHoraAlta, fechaHoraBaja);
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
    @JoinColumn(name = "legajoPC", referencedColumnName = "legajoPC", nullable = false)
    public Personalcientifico getPersonalcientificoByLegajoPc() {
        return personalcientificoByLegajoPc;
    }

    public void setPersonalcientificoByLegajoPc(Personalcientifico personalcientificoByLegajoPc) {
        this.personalcientificoByLegajoPc = personalcientificoByLegajoPc;
    }

    @OneToMany(mappedBy = "asignacioncientificociByIdAsignacionCientifico")
    public Collection<Turno> getTurnosByIdAsignacionCientificoCi() {
        return turnosByIdAsignacionCientificoCi;
    }

    public void setTurnosByIdAsignacionCientificoCi(Collection<Turno> turnosByIdAsignacionCientificoCi) {
        this.turnosByIdAsignacionCientificoCi = turnosByIdAsignacionCientificoCi;
    }

    @Override
    public String toString() {
        return "Asignacioncientificoci{" +
                "idAsignacionCientificoCi=" + idAsignacionCientificoCi +
                ", idCi=" + idCi +
                ", legajoPc=" + legajoPc +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                ", centrodeinvestigacionByIdCi=" + centrodeinvestigacionByIdCi +
                ", personalcientificoByLegajoPc=" + personalcientificoByLegajoPc +
                '}';
    }

    public Boolean esTuCientificoActivo(Personalcientifico personalcientifico){
        boolean aux = false;
        if (this.getLegajoPc() == personalcientifico.getLegajoPc()){
            aux = true;
        }
        return aux;
    }
}
