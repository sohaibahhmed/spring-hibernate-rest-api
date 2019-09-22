package com.my.challenge.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.challenge.app.model.Client;
@Repository
//using repository annotation not need to mannage sql exception
public class ClientDAOImpl implements clientDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Client> getClients() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by id
		Query<Client> theQuery = 
				currentSession.createQuery("from Client order by id",
											Client.class);
		
		// execute query and get result list
		List<Client> clients = theQuery.getResultList();
				
		// return the results		
		return clients;
	}

	@Override
	public void saveClient(Client theClient) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the client ... 
		currentSession.saveOrUpdate(theClient);
		
	}

	@Override
	public Client getClient(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Client theCustomer = currentSession.get(Client.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteClient(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Client theClient = currentSession.get(Client.class, theId);
		// delete object with primary key
		currentSession.delete(theClient);		
	}

}
