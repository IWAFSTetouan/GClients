package fac.master.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fac.master.entities.Client;
import fac.master.entities.Ville;
import fac.master.service.ClientService;
import fac.master.service.VilleService;

@RestController
@RequestMapping("ventes")
public class VilleController {
	@Autowired VilleService villeService;
	@Autowired ClientService clientService;
	//Get All villes
	@GetMapping("villes")
	public List<Ville> getAllVilles(){
		return villeService.getAllVille();
	}
	//Add Ville
	@PostMapping("villes")
	public Ville addVille(@RequestBody Ville ville) {
		return villeService.addVille(ville);
	}
	//Get ville by Id
	@GetMapping("villes/{id}")
	public Optional<Ville> getVilleById(@PathVariable Long id) {
		return villeService.getVilleById(id);
	}
	//Delete ville by Id
	@DeleteMapping("villes/{id}")
	public void deleteVilleById(@PathVariable Long id) {
		villeService.deleteVilleById(id);
	}
	//Get All clients By Ville
	@GetMapping("villes/{nomville}/clients")
	public List<Client> getAllClientByVille(@PathVariable String nomville){
		return clientService.getAllClientsByVille(nomville);
	}
//	@PostMapping("villes/{nomville}/clients")
//	public Client addClientToVille(@PathVariable String nomville, @RequestBody Client client) {
//		return clientService.addClientToVille(nomville,client);
//	}
	
	@PostMapping("villes/{nomVille}/clients")
	public Client addClientToVille(
			@RequestParam Long id,
			@RequestParam String nom,
			@RequestParam int age,
			@PathVariable String nomVille,
			@RequestParam MultipartFile file
			) throws IllegalStateException, IOException {
		return clientService.addClientToVille(id, nom,age,nomVille,file);
	}
}
