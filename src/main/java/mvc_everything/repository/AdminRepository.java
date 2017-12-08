package mvc_everything.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import mvc_everything.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, String>{
  List<Admin> findAll();
}
