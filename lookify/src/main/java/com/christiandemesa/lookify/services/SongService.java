package com.christiandemesa.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christiandemesa.lookify.models.Song;
import com.christiandemesa.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	SongRepository songRepo;
	
	// This method creates a song.
	public Song createSong (Song song) {
		return songRepo.save(song);
	}
	
	// This method returns all the songs.
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	// This method returns one song.
	public Song oneSong(Long id) {
		Optional<Song> optSong = songRepo.findById(id);
		if(optSong.isPresent()) {
			return optSong.get();
		}
		else {
			return null;
		}
	}
	
	// This method returns the top 10 songs by rating.
	public List<Song> topSongs() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
	
	// This method returns all the song with searched artist.
	public List<Song> findSongs(String search) {
		return songRepo.findByArtistContaining(search);
	}
	
	// This method updates a song.
	public Song updateSong(Song song) {
		return songRepo.save(song);
	}
	
	// This method deletes a song.
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
}