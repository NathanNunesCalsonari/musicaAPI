package service;


import java.util.List;

import br.com.fiap.musicas.data.MusicaDao;
import br.com.fiap.musicas.model.Musica;

public class MusicaService {
	
	private MusicaDao dao = new MusicaDao();

	public List<Musica> findAll() {
		
		return dao.findAll();
	}

	public Musica findById(Long id) {
		return dao.findById(id);
	}
	
	public void delete(Musica musica) {
		
	}

	public boolean save(Musica musica) {
		if (musica.id() == 0) return false;
		if (musica.nomeDaMusica().length() < 3) return false;
		if (musica.banda().length() < 2) return false;
		
		return true;
		
	}

	public boolean update(Musica musica) {

		return true;
	}

}
