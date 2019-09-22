package com.my.challenge.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.challenge.app.model.Client;
import com.my.challenge.app.service.ClientService;

@RestController
public class ClientRestController {
	// autowire the ClientService
	@Autowired
	private ClientService clientService;
	
	//get all records
	// add mapping for GET /clients
	@GetMapping("/client")
	public List<Client> getClient() {
		
		return clientService.getClients();
		
	}
	
	//get records with respect to id
	// add mapping for GET /clients/{clientId}
	@GetMapping("/client/{clientId}")
	public Client getClient(@PathVariable int clientId) {
		
		Client theClient = clientService.getClient(clientId);
		if (theClient == null) {
			throw new NotFoundException("Client id not found - " + theClient);
		}
		return theClient;
	}
	
	//delete record with respect to id
	// add mapping for DELETE/clients/{clientId}
	@DeleteMapping("/client/{clientId}")
	public String deleteClient(@PathVariable int clientId) {
		
		Client theClient = clientService.getClient(clientId);
		
		if (theClient == null) {
			throw new NotFoundException("Client id not found - " + theClient);
		}
		
		clientService.deleteClient(clientId);
		
		return "Deleted client id - " + clientId;
	}
		
	
	// add mapping for PUT /client - update existing client
	@PutMapping("/client")
	public Client updateClient(@RequestBody Client theClient) {
		
		clientService.saveClient(theClient);
		
		return theClient;
		
	}
	
	// add mapping for POST /client - Insert new client
	@PostMapping("/client")
	public Client addCustomer(@RequestBody Client theClient) {
		
		// set id to 0
		// this is force a save of new item ... instead of update
		theClient.setId(0);
		clientService.saveClient(theClient);
		return theClient;
	}

}
