/*
 * Kreator Session Beans For Entity Classes z kategorii Persistence utworzył jedynie klasę AbstractFacade.java
 * Poniższy interfejs wykonałem z pomocą nagrania z siódmej części drugiego laboratorium Architektury Komputerowej
 * od kolegi informatyka z Uniwersytetu Antioquia, miato Medellin, Kolumbia.
 * https://www.youtube.com/watch?v=SUkgRrzXlPQ
 */
package req.facade;

import java.util.List;
import javax.ejb.Local;
import req.entities.Request;

/**
 *
 * @author woodpecker
 */
@Local
public interface RequestFacadeLocal {
    
    void create(Request request);
    
    void edit(Request request);
    
    void remove(Request request);
    
    Request find(Object id);
    
    List<Request> findAll();
    
    List<Request> findRange(int[] range);
    
    int count();
    
}
