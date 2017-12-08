package mvc_everything.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc_everything.model.Album;
import mvc_everything.service.AlbumService;



@Controller
@RequestMapping("/album")

public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping
    public String listarArtistas(ModelMap model,
      @RequestParam(value = "message", required = false) String message) {
      List<Album> albunes = albumService.getAll();
      model.addAttribute("albunes", albunes);
      model.addAttribute("message", message);
      return "artista/list";
    }

    @RequestMapping("/{id}")
    public String editarArtista(ModelMap model, @PathVariable("id") String id) {
    Album album = albumService.getById(id);
    model.addAttribute("album", album);
    model.addAttribute("Name", String.format("%s", album.getName()));
    return "album/editar";
    }

    @RequestMapping("/new")
    public String nuevoArtista(ModelMap model) {
      Album album = new Album();
      model.addAttribute("album", album);
      model.addAttribute("title", "Nuevo album");
      return "artista/editar";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveArtista(@ModelAttribute Album albumChanged, ModelMap model) {
      albumService.save(albumChanged);
      return "redirect:/artista?message=El artista se actualizo correctamente";
    //retorna la lista de artistas (own)
    }

      
    @RequestMapping("/listar.json")
    @ResponseBody
    public List<Album> listarAlbunes() {
        List<Album> albunes = albumService.getAll();
        return albunes;
    }

    @RequestMapping("/{id}.json")
    @ResponseBody
    public Album album(@PathVariable("id") String Id) {
    	Album album = albumService.getById(Id);
        return album;
    }
    
    ///
    @RequestMapping("/{Wasp}.json")
    @ResponseBody
    public List<Album> n_album(@PathVariable("Wasp") String Wasp) {
        List<Album> albunes = albumService.getByName(Wasp);
        return albunes;
    }
    
    

}
