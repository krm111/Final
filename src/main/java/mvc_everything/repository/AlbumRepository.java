package mvc_everything.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mvc_everything.model.Album;

public interface AlbumRepository extends CrudRepository<Album, String> {
	List<Album> findAll();
	
	///
	@Query("SELECT * FROM album WHERE name LIKE '%'+:Wasp+'%'")
	List<Album> findByName(@Param("Wasp") String Wasp);
	
	///
}
