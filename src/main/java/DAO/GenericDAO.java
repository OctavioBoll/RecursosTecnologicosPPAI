package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class GenericDAO {
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "ppai01";

    public GenericDAO(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("ppai01");
        }
    }

    protected EntityManager getEntityManager(){
        if (em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
}
