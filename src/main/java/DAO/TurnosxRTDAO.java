package DAO;


import EntityDos.Cambioestadoturno;
import EntityDos.Turno;
import jakarta.persistence.Query;

import java.util.List;

public class TurnosxRTDAO extends GenericDAO {

    public List<Turno> listar(int numeroRT) {
        System.out.println(numeroRT);
        em = getEntityManager();
        Query query = em.createQuery("From Turno t Where t.numeroRt = :numeroRt ");
        query.setParameter("numeroRt",numeroRT);
        return query.getResultList();
    }

    public void insertar(Turno turno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
