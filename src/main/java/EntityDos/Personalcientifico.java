package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Personalcientifico {
    private int legajoPc;
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String correoElectronicoInstitucional;
    private String correoElectronicoPersonal;
    private String telefonoCelular;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Collection<Asignacioncientificoci> asignacioncientificocisByLegajoPc;
    private Collection<Turno> turnosByLegajoPc;
    private Collection<Usuario> usuariosByLegajoPc;

    @Id
    @Column(name = "legajoPC")
    public int getLegajoPc() {
        return legajoPc;
    }

    public void setLegajoPc(int legajoPc) {
        this.legajoPc = legajoPc;
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
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "numeroDocumento")
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Basic
    @Column(name = "correoElectronicoInstitucional")
    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    @Basic
    @Column(name = "correoElectronicoPersonal")
    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    @Basic
    @Column(name = "telefonoCelular")
    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
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
        Personalcientifico that = (Personalcientifico) o;
        return legajoPc == that.legajoPc && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(numeroDocumento, that.numeroDocumento) && Objects.equals(correoElectronicoInstitucional, that.correoElectronicoInstitucional) && Objects.equals(correoElectronicoPersonal, that.correoElectronicoPersonal) && Objects.equals(telefonoCelular, that.telefonoCelular) && Objects.equals(fechaHoraAlta, that.fechaHoraAlta) && Objects.equals(fechaHoraBaja, that.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legajoPc, nombre, apellido, numeroDocumento, correoElectronicoInstitucional, correoElectronicoPersonal, telefonoCelular, fechaHoraAlta, fechaHoraBaja);
    }

    @OneToMany(mappedBy = "personalcientificoByLegajoPc")
    public Collection<Asignacioncientificoci> getAsignacioncientificocisByLegajoPc() {
        return asignacioncientificocisByLegajoPc;
    }

    public void setAsignacioncientificocisByLegajoPc(Collection<Asignacioncientificoci> asignacioncientificocisByLegajoPc) {
        this.asignacioncientificocisByLegajoPc = asignacioncientificocisByLegajoPc;
    }

    @OneToMany(mappedBy = "personalcientificoByLegajoPc")
    public Collection<Turno> getTurnosByLegajoPc() {
        return turnosByLegajoPc;
    }

    public void setTurnosByLegajoPc(Collection<Turno> turnosByLegajoPc) {
        this.turnosByLegajoPc = turnosByLegajoPc;
    }

    @OneToMany(mappedBy = "personalcientificoByLegajoPc")
    public Collection<Usuario> getUsuariosByLegajoPc() {
        return usuariosByLegajoPc;
    }

    public void setUsuariosByLegajoPc(Collection<Usuario> usuariosByLegajoPc) {
        this.usuariosByLegajoPc = usuariosByLegajoPc;
    }

    @Override
    public String toString() {
        return "Personalcientifico{" +
                "legajoPc=" + legajoPc +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", correoElectronicoInstitucional='" + correoElectronicoInstitucional + '\'' +
                ", correoElectronicoPersonal='" + correoElectronicoPersonal + '\'' +
                ", telefonoCelular='" + telefonoCelular + '\'' +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                '}';
    }
}
