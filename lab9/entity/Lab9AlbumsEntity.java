package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "albums", schema = "musicalbums")
@NamedQueries({
    @NamedQuery(name = "Albums.findByName",
            query = "SELECT a FROM Lab9AlbumsEntity a WHERE a.name=:name"),

    @NamedQuery(name = "Albums.findByArtist",
            query = "SELECT a FROM Lab9AlbumsEntity a " +
                    "JOIN Lab9ArtistsEntity art ON a.artistId=art.id WHERE art.name=:artist")
})
public class Lab9AlbumsEntity {
    private int id;
    private String name;
    private int artistId;
    private Integer releaseYear;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "artist_id", nullable = false)
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "release_year", nullable = true)
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lab9AlbumsEntity that = (Lab9AlbumsEntity) o;
        return id == that.id &&
                artistId == that.artistId &&
                Objects.equals(name, that.name) &&
                Objects.equals(releaseYear, that.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artistId, releaseYear);
    }
}
