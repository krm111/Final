package mvc_everything.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import isi.model.Song;
import isi.repository.SongRepository;

public class SongService {
	@Autowired
	SongRepository repository;
	
	public Song getById(String id) {
		return repository.findOne(id);
	}
	
	public List<Song> getAll(){
		return repository.findAll();
	}
	
	public List<Song> topSong(int top){
		List<Song> topSong=new ArrayList<Song>();
		List<Song> orderSong=repository.songTop();
		for (int i=0;i<10 && i<orderSong.size();i++){
			topSong.add(orderSong.get(i));
		}
		return topSong;
	}
}
