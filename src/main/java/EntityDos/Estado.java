package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Estado {
    private int idEstado;
    private String nombre;
    private String descripcion;
    private String ambito;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Collection<Cambioestadort> cambioestadortsByIdEstado;
    private Collection<Cambioestadoturno> cambioestadoturnosByIdEstado;

    @Id
    @Column(name = "idEstado")
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
    @Column(name = "ambito")
    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
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
        Estado estado = (Estado) o;
        return idEstado == estado.idEstado && Objects.equals(nombre, estado.nombre) && Objects.equals(descripcion, estado.descripcion) && Objects.equals(ambito, estado.ambito) && Objects.equals(fechaHoraAlta, estado.fechaHoraAlta) && Objects.equals(fechaHoraBaja, estado.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, nombre, descripcion, ambito, fechaHoraAlta, fechaHoraBaja);
    }

    @OneToMany(mappedBy = "estadoByIdEstado")
    public Collection<Cambioestadort> getCambioestadortsByIdEstado() {
        return cambioestadortsByIdEstado;
    }

    public void setCambioestadortsByIdEstado(Collection<Cambioestadort> cambioestadortsByIdEstado) {
        this.cambioestadortsByIdEstado = cambioestadortsByIdEstado;
    }

    @OneToMany(mappedBy = "estadoByIdEstado")
    public Collection<Cambioestadoturno> getCambioestadoturnosByIdEstado() {
        return cambioestadoturnosByIdEstado;
    }

    public void setCambioestadoturnosByIdEstado(Collection<Cambioestadoturno> cambioestadoturnosByIdEstado) {
        this.cambioestadoturnosByIdEstado = cambioestadoturnosByIdEstado;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ambito='" + ambito + '\'' +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                '}';
    }
}
