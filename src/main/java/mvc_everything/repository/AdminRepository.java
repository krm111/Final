package mvc_everything.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import mvc_everything.model.Admin;

public interface AdminRepository extends Repository<Admin,Long>
{
	
	Admin save(Admin admin);
	
	//Busca todos
	@Query("SELECT a FROM Admin a")
	List<Admin> findAll();
	
	//Busca por id
	@Query("SELECT a FROM Admin a WHERE a.id=:id")
	Admin searchById(@Param("id") Long id);
	
	//Collect
	@Query("SELECT c FROM Admin c")
	{
		Collection<Admin> Admin CollectionAdmin();
	}
	
	@Modifying
	@Query("UPDATE Admin c SET c.id=?1 WHERE c.id=?1")
	static
	void setFixedAdmin(Long id)
	{
		// TODO auto-generated method stub
	}
	
}