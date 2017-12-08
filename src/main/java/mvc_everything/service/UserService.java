package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc_everything.model.User;
import mvc_everything.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository repository;

  public List<User> getAll() {
    return repository.findAll();
  }

  public User getByUsername(String username) {
    return repository.findOne(username);
  }

  public boolean validate(User userSign) {
    System.out.println("Login: " + userSign.getUsername());
    if(userSign.getUsername()==""){return false;}
    User user = repository.findOne(userSign.getUsername());
    System.out.println("User     Password: " + user.getPassword());
    System.out.println("UserSign Password: " + userSign.getPassword());

    if(user != null) {
      if(user.getPassword().equals(userSign.getPassword())) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }

  }

  public User save(User userChanged) {
    System.out.println("Register: " + userChanged.getUsername());
    User user = repository.findOne(userChanged.getUsername());
    if (user != null) {
      user.setPassword(userChanged.getPassword());
      user.setFirstname(userChanged.getFirstname());
      user.setLastname(userChanged.getLastname());
      user.setGender(userChanged.getGender());
    } else {
      user = userChanged;
    }

    return repository.save(user);
  }
}
