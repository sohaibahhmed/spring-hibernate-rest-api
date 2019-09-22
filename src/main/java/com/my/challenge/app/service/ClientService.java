package com.my.challenge.app.service;

import java.util.List;

import com.my.challenge.app.model.Client;

public interface ClientService {
	public List<Client> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int theId);

	public void deleteClient(int theId);

}
