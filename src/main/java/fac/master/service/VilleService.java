package fac.master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fac.master.entities.Ville;
import fac.master.repository.VilleRepository;

@Service
public class VilleService {
@Autowired VilleRepository villeRepository;

public List<Ville> getAllVille() {
	return villeRepository.findAll();
}

public Ville addVille(Ville ville) {
	return villeRepository.save(ville);
}

public Optional<Ville> getVilleById(Long id) {
	return villeRepository.findById(id);
}

public void deleteVilleById(Long id) {
	villeRepository.deleteById(id);
	
}
	
}
