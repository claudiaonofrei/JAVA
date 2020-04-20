package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static PersistenceUtil single_instance = null;

    private EntityManager em;

    // private constructor restricted to this class itself
    private PersistenceUtil() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(
                        "MusicAlbumsPU");
        this.em = factory.createEntityManager();
    }

    // static method to create instance of Singleton class
    public static PersistenceUtil getInstance()
    {
        if (single_instance == null)
            single_instance = new PersistenceUtil();

        return single_instance;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
