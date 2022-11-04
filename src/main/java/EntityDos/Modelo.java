package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Modelo {
    private int idModelo;
    private String nombre;
    private int idMarca;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Marca marcaByIdMarca;
    private Collection<Recursotecnologico> recursotecnologicosByIdModelo;

    @Id
    @Column(name = "idModelo")
    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
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
    @Column(name = "idMarca" ,insertable = false, updatable = false)
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
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
        Modelo modelo = (Modelo) o;
        return idModelo == modelo.idModelo && idMarca == modelo.idMarca && Objects.equals(nombre, modelo.nombre) && Objects.equals(fechaHoraAlta, modelo.fechaHoraAlta) && Objects.equals(fechaHoraBaja, modelo.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModelo, nombre, idMarca, fechaHoraAlta, fechaHoraBaja);
    }

    @ManyToOne
    @JoinColumn(name = "idMarca", referencedColumnName = "idMarca", nullable = false)
    public Marca getMarcaByIdMarca() {
        return marcaByIdMarca;
    }

    public void setMarcaByIdMarca(Marca marcaByIdMarca) {
        this.marcaByIdMarca = marcaByIdMarca;
    }

    @OneToMany(mappedBy = "modeloByIdModelo")
    public Collection<Recursotecnologico> getRecursotecnologicosByIdModelo() {
        return recursotecnologicosByIdModelo;
    }

    public void setRecursotecnologicosByIdModelo(Collection<Recursotecnologico> recursotecnologicosByIdModelo) {
        this.recursotecnologicosByIdModelo = recursotecnologicosByIdModelo;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "idModelo=" + idModelo +
                ", nombre='" + nombre + '\'' +
                ", idMarca=" + idMarca +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                ", marcaByIdMarca=" + marcaByIdMarca +
                '}';
    }
}
