package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tiporecursotecnologico {
    private int idTipoRecursoTec;
    private String nombre;
    private String descripcion;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Collection<Recursotecnologico> recursotecnologicosByIdTipoRecursoTec;

    @Id
    @Column(name = "idTipoRecursoTec")
    public int getIdTipoRecursoTec() {
        return idTipoRecursoTec;
    }

    public void setIdTipoRecursoTec(int idTipoRecursoTec) {
        this.idTipoRecursoTec = idTipoRecursoTec;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        Tiporecursotecnologico that = (Tiporecursotecnologico) o;
        return idTipoRecursoTec == that.idTipoRecursoTec && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(fechaHoraAlta, that.fechaHoraAlta) && Objects.equals(fechaHoraBaja, that.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoRecursoTec, nombre, descripcion, fechaHoraAlta, fechaHoraBaja);
    }

    @OneToMany(mappedBy = "tiporecursotecnologicoByIdTipoRecursoTec")
    public Collection<Recursotecnologico> getRecursotecnologicosByIdTipoRecursoTec() {
        return recursotecnologicosByIdTipoRecursoTec;
    }

    public void setRecursotecnologicosByIdTipoRecursoTec(Collection<Recursotecnologico> recursotecnologicosByIdTipoRecursoTec) {
        this.recursotecnologicosByIdTipoRecursoTec = recursotecnologicosByIdTipoRecursoTec;
    }

    @Override
    public String toString() {
        return "Tiporecursotecnologico{" +
                "idTipoRecursoTec=" + idTipoRecursoTec +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                ", recursotecnologicosByIdTipoRecursoTec=" + recursotecnologicosByIdTipoRecursoTec +
                '}';
    }
}
