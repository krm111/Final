package mvc_everything;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import mvc_everything.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EverythingApplicationTests {

  @Autowired
  UserRepository repo;

  @Test
  public void contextLoads() {
    repo.count();
  }

}
