package mvc_everything.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.model.Song;
import isi.repository.SongRepository;

public class SongController {
	@Autowired
	SongRepository repository;

}
