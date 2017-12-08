package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc_everything.model.Admin;
import mvc_everything.repository.AdminRepository;

@Service
public class AdminService {

  @Autowired
  AdminRepository repository;

  public List<Admin> getAll() {
    return repository.findAll();
  }

  public Admin getByAdminName(String AdminName) {
    return repository.findOne(AdminName);
  }

  public Admin addAdmin() {
    Admin admin = repository.findOne("rod");
    if(admin==null){
    	admin= new Admin();
    	    admin.setUsername("rod");
		    admin.setPassword("rod");
    		admin.setFirstname("rod");
		    admin.setLastname("rod");
		    return repository.save(admin);
    }
    else{
    	return admin;
    }
  }
  public boolean validate(Admin adminSign) {
	    System.out.println("Login: " + adminSign.getUsername());
	    if(adminSign.getUsername()==""){return false;}
	    Admin admin = repository.findOne(adminSign.getUsername());
	    if(admin==null){return false;}
	    System.out.println("Admin     Password: " + admin.getPassword());
	    System.out.println("AdminSign Password: " + adminSign.getPassword());

	    if(admin != null) {
	      if(admin.getPassword().equals(adminSign.getPassword())) {
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
}
