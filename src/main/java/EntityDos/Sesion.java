package EntityDos;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Sesion {
    private int idSesion;
    private String usuario;
    private Timestamp fechaHoraAlta;
    private Timestamp fechaHoraBaja;
    private Usuario usuarioByUsuario;




    @Id
    @Column(name = "idSesion")
    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    @Basic
    @Column(name = "usuario" ,insertable = false, updatable = false)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        Sesion sesion = (Sesion) o;
        return idSesion == sesion.idSesion && Objects.equals(usuario, sesion.usuario) && Objects.equals(fechaHoraAlta, sesion.fechaHoraAlta) && Objects.equals(fechaHoraBaja, sesion.fechaHoraBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSesion, usuario, fechaHoraAlta, fechaHoraBaja);
    }

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    public Usuario getUsuarioByUsuario() {
        return usuarioByUsuario;
    }

    public void setUsuarioByUsuario(Usuario usuarioByUsuario) {
        this.usuarioByUsuario = usuarioByUsuario;
    }

    @Override
    public String toString() {
        return "Sesion{" +
                "idSesion=" + idSesion +
                ", usuario='" + usuario + '\'' +
                ", fechaHoraAlta=" + fechaHoraAlta +
                ", fechaHoraBaja=" + fechaHoraBaja +
                ", usuarioByUsuario=" + usuarioByUsuario +
                '}';
    }

    public Personalcientifico obtenerCientificoLogeado(){
        //27.obtenerCientifico()
        return this.getUsuarioByUsuario().getPersonalcientificoByLegajoPc();

    }
}
