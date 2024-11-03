package fac.master.controller;

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

import fac.master.entities.Client;
import fac.master.entities.ClientsByVille;
import fac.master.service.ClientService;

@RestController
@RequestMapping("ventes")
public class ClientController {
	@Autowired ClientService clientService;
	//Get All clients
	@GetMapping("clients")
	public List<Client> getAllClients(){
		return clientService.getAllClient();
	}
	//Get client by Id
	@GetMapping("clients/{id}")
	public Optional<Client> getClientById(@PathVariable Long id) {
		return clientService.getClientById(id);
	}
	//Delete client by Id
	@DeleteMapping("clients/{id}")
	public void deleteClientById(@PathVariable Long id) {
		clientService.deleteClientById(id);
	}
	//get client by age>?
	@GetMapping("clients/agefilter")
	public List<Client> getClientByAgeGreaterThan(@RequestParam int age) {
		return clientService.getClientByAgeGreaterThan(age);
	}
	//get nombre de clients par ville
	@GetMapping("clients/villes")
	public List<ClientsByVille> getClientCountByVille() {
		return clientService.getClientCountByVille();
	}
}
