package com.my.challenge.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.challenge.app.dao.clientDAO;
import com.my.challenge.app.model.Client;

@Service
public class ClientServiceImpl implements ClientService {

	// need to inject client dao
	@Autowired
	private clientDAO clientDAO;
	
	@Override
	@Transactional  // after using this not need to create and close session factory
	public List<Client> getClients() {
		return clientDAO.getClients();
	}

	@Override
	@Transactional
	public void saveClient(Client theClient) {

		clientDAO.saveClient(theClient);
	}

	@Override
	@Transactional
	public Client getClient(int theId) {
		
		return clientDAO.getClient(theId);
	}

	@Override
	@Transactional
	public void deleteClient(int theId) {
		
		clientDAO.deleteClient(theId);
	}

}
