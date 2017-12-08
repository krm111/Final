package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc_everything.model.Admin;
import mvc_everything.repository.AdminRepository;


@Service
public class AdminService 
{
	@Autowired
	AdminRepository repository;
	
	public boolean find_adm(Long id)
	{
		if(repository.searchById(id)==null) return false;
		return true;
	}
	
	public List<Admin> findAll()
	{
		return repository.findAll();
	}
	
	public Admin getById(Long id)
	{
		return repository.searchById(id);
	}
	
	public void save(Admin admin)
	{
		Long id=admin.getId();
		if(find_adm(id)==false)
		{
			repository.save(admin);
		}
		else
		{
			mvc_everything.repository.AdminRepository.setFixedAdmin(id);
		}
	}
	
	
}
