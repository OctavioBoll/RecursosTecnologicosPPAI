package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuario {
    private String usuario;
    private String clave;
    private int legajoPc;
    private boolean habilitado;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Collection<Sesion> sesionsByUsuario;
    private Personalcientifico personalcientificoByLegajoPc;

    @Id
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "clave")
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
    @Column(name = "habilitado")
    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
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
        Usuario usuario1 = (Usuario) o;
        return legajoPc == usuario1.legajoPc && habilitado == usuario1.habilitado && Objects.equals(usuario, usuario1.usuario) && Objects.equals(clave, usuario1.clave) && Objects.equals(fechaHoraAlta, usuario1.fechaHoraAlta) && Objects.equals(fechaHoraBaja, usuario1.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, clave, legajoPc, habilitado, fechaHoraAlta, fechaHoraBaja);
    }

    @OneToMany(mappedBy = "usuarioByUsuario")
    public Collection<Sesion> getSesionsByUsuario() {
        return sesionsByUsuario;
    }

    public void setSesionsByUsuario(Collection<Sesion> sesionsByUsuario) {
        this.sesionsByUsuario = sesionsByUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "legajoPC", referencedColumnName = "legajoPC", nullable = false)
    public Personalcientifico getPersonalcientificoByLegajoPc() {
        return personalcientificoByLegajoPc;
    }

    public void setPersonalcientificoByLegajoPc(Personalcientifico personalcientificoByLegajoPc) {
        this.personalcientificoByLegajoPc = personalcientificoByLegajoPc;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", legajoPc=" + legajoPc +
                ", habilitado=" + habilitado +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                ", personalcientificoByLegajoPc=" + personalcientificoByLegajoPc +
                '}';
    }
}
