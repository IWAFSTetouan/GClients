package fac.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fac.master.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long>{

	Ville findByNom(String nomville);
}
