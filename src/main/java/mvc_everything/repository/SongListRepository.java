package mvc_everything.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import mvc_everything.model.SongList;

public interface SongListRepository extends Repository<SongList,Long>
{
	//Busca todos
	@Query("SELECT a FROM SongList a")
	List<SongList> findAll();
	
	//Busca por id
	@Query("SELECT a FROM Songlist a WHERE id=:id")
	SongList SearchById(@Param(id) Long id);
	
	
}