package DAO;

import EntityDos.Cambioestadoturno;

import EntityDos.Turno;
import jakarta.persistence.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class CambioEstadoTurnoDAO extends GenericDAO{

    public List<Cambioestadoturno> actualTurno(int nroActualTurno){

        em = getEntityManager();
        Query query = em.createQuery("From Cambioestadoturno c where c.idTurno = :nroActualTurno");
        query.setParameter("nroActualTurno",nroActualTurno);

        return query.getResultList();
    }

    public void actualizar(int idCambioEstadoTurno){
        try {
            Date date = new Date();
            Timestamp dates = new Timestamp(date.getTime());
            em = getEntityManager();
            Query query = em.createQuery("update Cambioestadoturno c set c.fechaHoraBaja = :fechaHoraBaja where c.idCambioEstadoTurno = :id");
            query.setParameter("fechaHoraBaja",dates);
            query.setParameter("id", idCambioEstadoTurno);
        }catch(Exception ex){
            System.out.println(ex);

        }
    }

    public void insertar(Cambioestadoturno cambioestadoturno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.persist(cambioestadoturno);
            em.getTransaction().commit();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
