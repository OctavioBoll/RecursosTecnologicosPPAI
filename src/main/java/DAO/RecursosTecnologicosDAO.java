package DAO;

import EntityDos.Recursotecnologico;

import jakarta.persistence.Query;

import java.util.List;

public class RecursosTecnologicosDAO extends GenericDAO{

    public List<Recursotecnologico> listar(){

        em = getEntityManager();
        Query query = em.createQuery("From Recursotecnologico ");

        return query.getResultList();
    }
}
