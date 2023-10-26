package br.com.fiap.musicas.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.musicas.model.Musica;

public class MusicaDao {
	
	List<Musica> musicas = new ArrayList<>();
	
	public MusicaDao() {
		musicas = List.of(
				new Musica(1, "The Scientist", "Coldplay", "A Rush of Blood To The Head"),
				new Musica(2, "Yellow", "Coldplay", "Yellow"),
				new Musica(3, "Don't Panic", "Coldplay", "Yellow"),
				new Musica(4, "Paradise", "Coldplay", "Mylo & Xyloto"),
				new Musica(5, "Misery Business", "Paramore", "Riot"),
				new Musica(6, "Rewind", "Paramore", "Riot")
			);
	}
	
	public List<Musica> findAll(){
		return musicas;
	}

	public Musica findById(Long id) {
		return musicas
					.stream()
					.filter(musica -> musica.id() == id)
					.findFirst()
					.orElse(null);
					
	}
	    
    
}

