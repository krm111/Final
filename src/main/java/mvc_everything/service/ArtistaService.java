package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc_everything.model.Album;
import mvc_everything.model.Artista;
import mvc_everything.repository.ArtistaRepository;

@Service
public class ArtistaService {

  @Autowired
  ArtistaRepository repository;

  public List<Artista> getAll() {
    return repository.findAll();
  }

  public Artista getById(String id) {
    return repository.findOne(id);
  }
  
  public List<Artista>getByName(String Wasp){
	  return repository.findByName(Wasp);
  }
  ///
  
  public List<Album>getAlbumByArtist(String Wasp){
	  return repository.findAlbumByArtist(Wasp);
  }
  
  
  ///

  public Artista save(Artista artistaChanged) {
    System.out.println("Modificando: " + artistaChanged.getId());
    Artista artista = repository.findOne(artistaChanged.getId().toString());
    if (artista != null) {
    	artista.setNombre(artistaChanged.getNombre());
    } else {
    	artista = artistaChanged;
    }

    return repository.save(artista);
  }
}