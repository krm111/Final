package mvc_everything.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import mvc_everything.model.Timeline;

public interface TimelineRepository extends Repository<Timeline,Long>
{
	//Busca todos
	@Query("SELET a FROM Timeline a")
	List<Timeline> findAll();
	
	//Busca por id
	@Query("SELECT a FROM Timeline a WHERE a.id=:id")
	Timeline searchById(@Param("id") Long id);
	

}