package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Marca {
    private int idMarca;
    private String nombre;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Collection<Modelo> modelosByIdMarca;

    @Id
    @Column(name = "idMarca")
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
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
        Marca marca = (Marca) o;
        return idMarca == marca.idMarca && Objects.equals(nombre, marca.nombre) && Objects.equals(fechaHoraAlta, marca.fechaHoraAlta) && Objects.equals(fechaHoraBaja, marca.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarca, nombre, fechaHoraAlta, fechaHoraBaja);
    }

    @OneToMany(mappedBy = "marcaByIdMarca")
    public Collection<Modelo> getModelosByIdMarca() {
        return modelosByIdMarca;
    }

    public void setModelosByIdMarca(Collection<Modelo> modelosByIdMarca) {
        this.modelosByIdMarca = modelosByIdMarca;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "idMarca=" + idMarca +
                ", nombre='" + nombre + '\'' +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                '}';
    }
}
