package mvc_everything.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mvc_everything.model.Album;
import mvc_everything.model.Artista;

public interface ArtistaRepository extends CrudRepository<Artista, String>{
  List<Artista> findAll();
  
  
  ///busca por el nombre del artista
  @Query("SELECT * FROM artista WHERE nombre LIKE '%'+:Wasp+'%'")
  List<Artista> findByName(@Param("Wasp") String Wasp);
  
  
  ///encuentra todos los albunes buscando por el nombre del artista
  @Query("SELECT al.id, al.name, al.active, al.id_artist FROM"
  		+ "album al INNER JOIN "
		  + "(SELECT * FROM artista WHERE nombre LIKE '%'+:Wasp+'%') as w1 "
		  + "ON al.id_artist=w1.id"
		  )
  List<Album> findAlbumByArtist(@Param("Wasp") String Wasp);
}
