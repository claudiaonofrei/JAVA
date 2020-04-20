package app;

import entity.Lab9AlbumsEntity;
import repo.AlbumRepository;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class AlbumManager {
    public static void main(String[] args) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        EntityManager em = persistenceUtil.getEm();
        AlbumRepository albumRepository = new AlbumRepository(em);

        Lab9AlbumsEntity alb1 = albumRepository.findByArtist("artist_gica");
        System.out.println(alb1);
        if (alb1 != null) {
            System.out.println(alb1.getName());
        }

        Lab9AlbumsEntity albumsEntity = new Lab9AlbumsEntity();
        albumsEntity.setName("nou_album1");
        albumsEntity.setReleaseYear(1112);
        albumsEntity.setArtistId(1);

        albumRepository.create(albumsEntity);


    }
}
