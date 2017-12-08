package mvc_everything.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import mvc_everything.model.Artista;

import mvc_everything.service.ArtistaService;

@Controller
@RequestMapping("/artista")
public class ArtistaController {

    @Autowired
    ArtistaService artistaService;

    @RequestMapping
    public String listarArtistas(ModelMap model,
      @RequestParam(value = "message", required = false) String message) {
        List<Artista> artistas = artistaService.getAll();
        model.addAttribute("artista", artistas);
        model.addAttribute("message", message);
        return "artista/list";
    }

    @RequestMapping("/{id}")
    public String editarArtista(ModelMap model, @PathVariable("id") String id) {
        Artista artista = artistaService.getById(id);
        model.addAttribute("artista", artista);
        model.addAttribute("fullName", String.format("%s", artista.getNombre()));
        return "artista/editar";
    }

    @RequestMapping("/new")
    public String nuevoArtista(ModelMap model) {
        Artista artista = new Artista();
        model.addAttribute("artista", artista);
        model.addAttribute("title", "Nuevo Artista");
        return "artista/editar";
    }



    @RequestMapping("/listar.json")
    @ResponseBody
    public List<Artista> listarArtistas() {
        List<Artista> artistas = artistaService.getAll();
        return artistas;
    }

    @RequestMapping("/{id}.json")
    @ResponseBody
    public Artista artista(@PathVariable("id") String Id) {
        Artista artista = artistaService.getById(Id);
        return artista;
    }
    
    @RequestMapping("/{Wasp}.json")
    @ResponseBody
    public List<Artista> n_artista(@PathVariable("Wasp") String Wasp) {
        List<Artista> artistas = artistaService.getByName(Wasp);
        return artistas;
    }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveArtista(@ModelAttribute Artista artistaChanged, ModelMap model) {
	artistaService.save(artistaChanged);
    return "redirect:/artista?message=El artista se actualizo correctamente";
    //retorna la lista de artistas (own)
  }

}
