package fac.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fac.master.entities.Client;
import fac.master.entities.ClientsByVille;

public interface ClientRepository extends JpaRepository<Client, Long>{
List<Client> findByAgeGreaterThan(int age);

List<Client> findByVilleNom(String nomville);

@Query("SELECT c.ville.nom as villename, COUNT(c) as countclient FROM Client c GROUP BY c.ville")
public List<ClientsByVille> getClientCountByVille();
}
