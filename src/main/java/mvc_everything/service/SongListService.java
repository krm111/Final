package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc_everything.model.SongList;
import mvc_everything.repository.SongListRepository;

@Service
public class SongListService
{
	@Autowired
	SongListRepository repository;
	
	public List<SongList> findAll()
	{
		return repository.findAll();
	}
	
	public SongList getById(Long id)
	{
		return repository.SearchById(id);
	}
	
	
}
