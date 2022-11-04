package DAO;

import EntityDos.Estado;

import jakarta.persistence.Query;

import java.util.List;

public class EstadosDAO extends GenericDAO{

    public List<Estado> listar(){

        em = getEntityManager();
        Query query = em.createQuery("From Estado");

        return query.getResultList();
    }
}
