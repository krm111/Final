package mvc_everything.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import isi.model.Song;

public interface SongRepository extends CrudRepository<Song,String>{
	List<Song> findAll();
	
	@Query("SELECT c FROM Song c order by timesPlayed")
	List<Song> songTop();
}
