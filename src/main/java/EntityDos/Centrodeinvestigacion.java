package EntityDos;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Centrodeinvestigacion {
    private int idCi;
    private String nombre;
    private String sigla;
    private String direccion;
    private String edificio;
    private Integer piso;
    private Integer coordenadas;
    private String telefonoContacto;
    private String correoElectronico;
    private Integer numeroResolucionCreacion;
    private Date fechaResolucionCreacion;
    private String reglamento;
    private String caracteristicasGenerales;
    private Date fechaAlta;
    private Date tiempoAntelacionReserva;
    private Date fechaBaja;
    private String motivoBaja;
    private Collection<Asignacioncientificoci> asignacioncientificocisByIdCi;
    private Collection<Recursotecnologico> recursotecnologicosByIdCi;

    @Id
    @Column(name = "idCI")
    public int getIdCi() {
        return idCi;
    }

    public void setIdCi(int idCi) {
        this.idCi = idCi;
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
    @Column(name = "sigla")
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Basic
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "edificio")
    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    @Basic
    @Column(name = "piso")
    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    @Basic
    @Column(name = "coordenadas")
    public Integer getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Integer coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Basic
    @Column(name = "telefonoContacto")
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Basic
    @Column(name = "correoElectronico")
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Basic
    @Column(name = "numeroResolucionCreacion")
    public Integer getNumeroResolucionCreacion() {
        return numeroResolucionCreacion;
    }

    public void setNumeroResolucionCreacion(Integer numeroResolucionCreacion) {
        this.numeroResolucionCreacion = numeroResolucionCreacion;
    }

    @Basic
    @Column(name = "fechaResolucionCreacion")
    public Date getFechaResolucionCreacion() {
        return fechaResolucionCreacion;
    }

    public void setFechaResolucionCreacion(Date fechaResolucionCreacion) {
        this.fechaResolucionCreacion = fechaResolucionCreacion;
    }

    @Basic
    @Column(name = "reglamento")
    public String getReglamento() {
        return reglamento;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    @Basic
    @Column(name = "caracteristicasGenerales")
    public String getCaracteristicasGenerales() {
        return caracteristicasGenerales;
    }

    public void setCaracteristicasGenerales(String caracteristicasGenerales) {
        this.caracteristicasGenerales = caracteristicasGenerales;
    }

    @Basic
    @Column(name = "fechaAlta")
    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Basic
    @Column(name = "tiempoAntelacionReserva")
    public Date getTiempoAntelacionReserva() {
        return tiempoAntelacionReserva;
    }

    public void setTiempoAntelacionReserva(Date tiempoAntelacionReserva) {
        this.tiempoAntelacionReserva = tiempoAntelacionReserva;
    }

    @Basic
    @Column(name = "fechaBaja")
    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Basic
    @Column(name = "motivoBaja")
    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Centrodeinvestigacion that = (Centrodeinvestigacion) o;
        return idCi == that.idCi && Objects.equals(nombre, that.nombre) && Objects.equals(sigla, that.sigla) && Objects.equals(direccion, that.direccion) && Objects.equals(edificio, that.edificio) && Objects.equals(piso, that.piso) && Objects.equals(coordenadas, that.coordenadas) && Objects.equals(telefonoContacto, that.telefonoContacto) && Objects.equals(correoElectronico, that.correoElectronico) && Objects.equals(numeroResolucionCreacion, that.numeroResolucionCreacion) && Objects.equals(fechaResolucionCreacion, that.fechaResolucionCreacion) && Objects.equals(reglamento, that.reglamento) && Objects.equals(caracteristicasGenerales, that.caracteristicasGenerales) && Objects.equals(fechaAlta, that.fechaAlta) && Objects.equals(tiempoAntelacionReserva, that.tiempoAntelacionReserva) && Objects.equals(fechaBaja, that.fechaBaja) && Objects.equals(motivoBaja, that.motivoBaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCi, nombre, sigla, direccion, edificio, piso, coordenadas, telefonoContacto, correoElectronico, numeroResolucionCreacion, fechaResolucionCreacion, reglamento, caracteristicasGenerales, fechaAlta, tiempoAntelacionReserva, fechaBaja, motivoBaja);
    }

    @OneToMany(mappedBy = "centrodeinvestigacionByIdCi")
    public Collection<Asignacioncientificoci> getAsignacioncientificocisByIdCi() {
        return asignacioncientificocisByIdCi;
    }

    public void setAsignacioncientificocisByIdCi(Collection<Asignacioncientificoci> asignacioncientificocisByIdCi) {
        this.asignacioncientificocisByIdCi = asignacioncientificocisByIdCi;
    }

    @OneToMany(mappedBy = "centrodeinvestigacionByIdCi")
    public Collection<Recursotecnologico> getRecursotecnologicosByIdCi() {
        return recursotecnologicosByIdCi;
    }

    public void setRecursotecnologicosByIdCi(Collection<Recursotecnologico> recursotecnologicosByIdCi) {
        this.recursotecnologicosByIdCi = recursotecnologicosByIdCi;
    }

    public boolean esTuCientificoActivo(Personalcientifico personalcientifico){
        boolean aux = false;
        for (Asignacioncientificoci asignacioncientificoci : this.getAsignacioncientificocisByIdCi()){
            //30.*esTuCientificoActivo
            if (asignacioncientificoci.esTuCientificoActivo(personalcientifico)){
                aux = true;
            }
        }

        return aux;

    }
}
