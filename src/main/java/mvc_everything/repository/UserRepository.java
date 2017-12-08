package mvc_everything.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import mvc_everything.model.User;

public interface UserRepository extends CrudRepository<User, String>{
  List<User> findAll();
}
