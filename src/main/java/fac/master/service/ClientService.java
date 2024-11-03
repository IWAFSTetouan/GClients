package fac.master.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fac.master.entities.Client;
import fac.master.entities.ClientsByVille;
import fac.master.entities.Ville;
import fac.master.repository.ClientRepository;
import fac.master.repository.VilleRepository;

@Service
public class ClientService {
@Autowired ClientRepository clientRepository;
@Autowired VilleRepository villeRepository;
public List<Client> getAllClient() {
	return clientRepository.findAll();
}

public Client addClient(Client client) {
	return clientRepository.save(client);
}

public Optional<Client> getClientById(Long id) {
	return clientRepository.findById(id);
}

public void deleteClientById(Long id) {
	String path="src/main/resources/static/photos/"+id+".png";
	File f=new File(path);
	if (f.exists())f.delete();
	clientRepository.deleteById(id);
	
}

public List<Client> getClientByAgeGreaterThan(int age) {
	return clientRepository.findByAgeGreaterThan(age);
}

public List<Client> getAllClientsByVille(String nomville) {
	return clientRepository.findByVilleNom(nomville);
}

public Client addClientToVille(String nomville, Client client) {
	client.setVille(villeRepository.findByNom(nomville));
	return clientRepository.save(client);
}

public Client addClientToVille(Long id, String nom, int age, String nomVille, MultipartFile file) throws IllegalStateException, IOException {
	String path="src/main/resources/static/photos/"+id+".png";
	file.transferTo(Path.of(path));
	String url="localhost:8080/photos/"+id;
	Ville ville=villeRepository.findByNom(nomVille);
	Client client=new Client(id, nom, age, ville, url);
	return clientRepository.save(client);
}

public List<ClientsByVille> getClientCountByVille() {
	// TODO Auto-generated method stub
	return clientRepository.getClientCountByVille();
}

	
}
