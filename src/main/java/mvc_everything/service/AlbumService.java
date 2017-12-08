package mvc_everything.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc_everything.model.Album;
import mvc_everything.repository.AlbumRepository;

@Service
public class AlbumService {

	  @Autowired
	  AlbumRepository repository;

	  public List<Album> getAll() {
	    return repository.findAll();
	  }

	  public Album getById(String id) {
	    return repository.findOne(id);
	  }
	  
	  ///
	  
	  public List<Album> getByName(String Wasp){
		  return repository.findByName(Wasp);
	  }
	  
	  ///

	  public Album save(Album albumChanged) {
	    System.out.println("Modificando: " + albumChanged.getId());
	    Album album = repository.findOne(albumChanged.getId().toString());
	    if (album != null) {
	    	album.setName(albumChanged.getName());
	    } else {
	    	album = albumChanged;
	    }

	    return repository.save(album);
	  }
}
