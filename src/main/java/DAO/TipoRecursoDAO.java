package DAO;

import EntityDos.Tiporecursotecnologico;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TipoRecursoDAO extends GenericDAO{

    public List<Tiporecursotecnologico> listar(){

        em = getEntityManager();
        Query query = em.createQuery("From Tiporecursotecnologico ");
        return query.getResultList();
    }
}
