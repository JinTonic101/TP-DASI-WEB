package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Activite;

public class ActiviteDAO {

    public Activite findById(long id) throws Exception {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Activite activite = null;
        try {
            activite = em.find(Activite.class, id);
        } catch (Exception e) {
            throw e;
        }
        return activite;
    }

    public List<Activite> findByDenomination(String denomination) throws Exception {
        EntityManager em = JpaUtil.obtenirEntityManager();
        List<Activite> demandes = null;
        try {
            Query q = em.createQuery("SELECT a FROM Activite a WHERE a.denomination = :denom");
            q.setParameter("denom", denomination);
            demandes = (List<Activite>) q.getResultList();
        } catch (Exception e) {
            throw e;
        }

        return demandes;
    }

    public List<Activite> findAll() throws Exception {
        EntityManager em = JpaUtil.obtenirEntityManager();
        List<Activite> activites = null;
        try {
            Query q = em.createQuery("SELECT a FROM Activite a");
            activites = (List<Activite>) q.getResultList();
        } catch (Exception e) {
            throw e;
        }

        return activites;
    }

}
