package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc_everything.model.Timeline;
import mvc_everything.repository.TimelineRepository;

@Service
public class TimelineService 
{
	@Autowired
	TimelineRepository repository;
	
	public List<Timeline> findAll()
	{
		return repository.findAll();
	}
	
	public Timeline getById(Long id)
	{
		return repository.searchById(id);
	}
}
