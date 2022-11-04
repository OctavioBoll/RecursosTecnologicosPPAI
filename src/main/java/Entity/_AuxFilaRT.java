package Entity;

public class _AuxFilaRT {

    int idNumeroInv;
    String nombreci;
    String modelo;
    String marca;
    String nombreEstado;

    public _AuxFilaRT( int idNumeroInv,String nombreci, String modelo, String marca,String nombreEstado) {

        this.idNumeroInv = idNumeroInv;
        this.nombreci = nombreci;
        this.modelo = modelo;
        this.marca = marca;
        this.nombreEstado = nombreEstado;
    }

    @Override
    public String toString() {
        return "_AuxFilaRT{" +
                "idNumeroInv=" + idNumeroInv +
                ", nombreci='" + nombreci + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", nombreEstado='" + nombreEstado + '\'' +
                '}';
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }


    public int getIdNumeroInv() {
        return idNumeroInv;
    }

    public void setIdNumeroInv(int idNumeroInv) {
        this.idNumeroInv = idNumeroInv;
    }

    public String getNombreci() {
        return nombreci;
    }

    public void setNombreci(String nombreci) {
        this.nombreci = nombreci;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
