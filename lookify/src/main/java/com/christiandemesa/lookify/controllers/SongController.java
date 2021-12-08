package com.christiandemesa.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.christiandemesa.lookify.models.Song;
import com.christiandemesa.lookify.services.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songServ;
	
	// Routes to the index page.
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// Routes to the dashboard page.
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songServ.allSongs();
		model.addAttribute("songs", songs);
		return "songs/dashboard.jsp";
	}
	
	// Routes to the create page.
	@RequestMapping("/songs/new")
	public String createPage(@ModelAttribute("song") Song song) {
		return "songs/new.jsp";
	}
	
	// Creates a new song.
	@PostMapping("/songs/new")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		// Routes to the create page with errors.
		if(result.hasErrors()) {
			return "songs/new.jsp";
		}
		// Routes to the dashboard, and adds the created song to the table.
		else {
			songServ.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	// Routes to the show song page.
	@RequestMapping("/songs/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Song song = songServ.oneSong(id);
		model.addAttribute("song", song);
		return "/songs/show.jsp";
	}
	
	// Deletes a song.
	@DeleteMapping("/songs/{id}")
	public String delete(@PathVariable("id") Long id) {
		songServ.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	// Routes to the top ten songs page.
	@RequestMapping("/search/topTen")
	public String showTopTen(Model model) {
		List<Song> songs = songServ.topSongs();
		model.addAttribute("songs", songs);
		return "/songs/topTen.jsp";
	}
	
	// Routes to the songs by artist page.
	// Figure out how to change the route to "/search/{artist}".
	@PostMapping("/search")
	public String search(Model model, @RequestParam("artist") String artist) {
		List<Song> songs = songServ.findSongs(artist);
		model.addAttribute("songs", songs);
		return "songs/search.jsp";
	}
	
}