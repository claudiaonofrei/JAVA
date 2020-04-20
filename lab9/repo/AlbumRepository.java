package repo;

import entity.Lab9AlbumsEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

public class AlbumRepository {
    public EntityManager em;

    public AlbumRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Lab9AlbumsEntity albumsEntity) {
        em.getTransaction().begin();
        em.persist(albumsEntity);
        em.getTransaction().commit();

    }

    public Lab9AlbumsEntity findById(Integer albumId) {
        em.getTransaction().begin();

        return em.find(Lab9AlbumsEntity.class, albumId);
    }

    public Lab9AlbumsEntity findByName(String name) {
        Lab9AlbumsEntity albumsEntity = (Lab9AlbumsEntity) em.createNamedQuery("Albums.findByName")
                .setParameter("name", name)
                .getSingleResult();

        return albumsEntity;
    }

    public Lab9AlbumsEntity findByArtist(String artist) {
        try {
            Object albumsEntity = em.createNamedQuery("Albums.findByArtist")
                    .setParameter("artist", artist)
                    .getSingleResult();
            return (Lab9AlbumsEntity) albumsEntity;
        } catch (NonUniqueResultException nonUniqueResultException) {
            System.out.println("Not unique");
            return null;
        } catch (NoResultException noResultException) {
            System.out.println("No result");
            return null;
        }
    }
}
