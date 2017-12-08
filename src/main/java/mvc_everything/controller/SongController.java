package mvc_everything.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc_everything.model.Song;
import mvc_everything.service.SongService;


public class SongController {
	@Autowired
	SongService songService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSong(@ModelAttribute Song songChanged, ModelMap model) {
		songService.save(songChanged);
	    return "redirect:/song?message=La cancion se actualizo correctamente";
	}
	
	@RequestMapping(value = "/topSong", method= RequestMethod.GET)
	String showSong(ModelMap model){
		List<Song> canciones = songService.topSong(10);
		model.addAttribute("canciones",canciones);
		return "canciones";
	}
	

}
