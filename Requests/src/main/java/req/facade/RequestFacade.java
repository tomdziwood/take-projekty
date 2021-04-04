/*
 * Kreator Session Beans For Entity Classes z kategorii Persistence utworzył jedynie klasę AbstractFacade.java
 * Poniższą klasę wykonałem z pomocą nagrania z siódmej części drugiego laboratorium Architektury Komputerowej
 * od kolegi informatyka z Uniwersytetu Antioquia, miato Medellin, Kolumbia.
 * https://www.youtube.com/watch?v=SUkgRrzXlPQ
 */
package req.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import req.entities.Request;

/**
 *
 * @author woodpecker
 */
@Stateless
public class RequestFacade extends AbstractFacade<Request> implements RequestFacadeLocal {
    
    @PersistenceContext(unitName = "RequestsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequestFacade() {
        super(Request.class);
    }
}
