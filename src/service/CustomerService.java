package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Customer;

public class CustomerService {

	private Map<String, Customer> customers;

	private static final CustomerService instance = new CustomerService();

	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);

	}

	public static CustomerService getInstance() {
		return instance;
	}

	public Customer findCustomer(String id) {
		
		Iterator i =customers.keySet().iterator();
		
		for(;i.hasNext();){
			String key = (String)i.next();
			if(customers.get(key).getId().equals(id)) return customers.get(key);
		}
		return null;
	}

	public Customer login(String id, String password) {
		Customer check = findCustomer(id);
		if(check.getPassword().equals(password)){
			return check;
		}
		else return null;
	}

}
