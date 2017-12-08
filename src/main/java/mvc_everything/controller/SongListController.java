package mvc_everything.controller;

import java.util.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import mvc_everything.model.SongList;
import mvc_everything.service.SongListService;

@Controller
public class SongListController 
{
	@Autowired
	SongListService songListService;
	@RequestMapping(value="/songList", method=RequestMethod.GET)
	String ShowSongList(@RequestParam(required=false) Long id, ModelMap model)
	{
		List<SongList> songlists=songListService.findAll();
		model.addAttribute("songlists",songlists);
		return "songlists";
	}
	
	@RequestMapping(value="/newSongList",method=RequestMehod.GET)
	String NewSongList(@RequestParam(required=false) Long id, ModelMap model)
	{
		SongList songList=id=null ? new SongList() : songListService.get(id);
		model.addAttribute("songLists",songList);
		return "NewSongList";
	}

}
