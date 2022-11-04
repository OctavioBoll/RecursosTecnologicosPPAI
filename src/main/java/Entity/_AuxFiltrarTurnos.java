package Entity;



public class _AuxFiltrarTurnos {

    String fecha;


    public _AuxFiltrarTurnos(String fecha) {
        this.fecha = fecha;

    }

    @Override
    public String toString() {
        return "_AuxFiltrarTurnos{" +
                "fecha=" + fecha + '\'' +
                '}';
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}
