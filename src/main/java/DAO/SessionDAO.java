package DAO;

import EntityDos.Sesion;

import jakarta.persistence.Query;

import java.util.List;

public class SessionDAO extends GenericDAO{

    public Sesion listar(){
        em = getEntityManager();
        Query query = em.createQuery("From Sesion Where idSesion=1");
        return (Sesion) query.getSingleResult();
    }
}
