package com.my.challenge.app.dao;

import java.util.List;

import com.my.challenge.app.model.Client;

public interface clientDAO {
	
	public List<Client> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int theId);

	public void deleteClient(int theId);

}
