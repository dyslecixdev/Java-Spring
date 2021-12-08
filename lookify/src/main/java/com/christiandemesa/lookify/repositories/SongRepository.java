package com.christiandemesa.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christiandemesa.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	// This query retrieves all the songs from the database.
	List<Song> findAll();
	
	// This query orders the top 10 songs by rating in descending order (high then low).
	List<Song> findTop10ByOrderByRatingDesc();
	
	// This query finds a song by the artist.
	List<Song> findByArtistContaining(String search);
	
}