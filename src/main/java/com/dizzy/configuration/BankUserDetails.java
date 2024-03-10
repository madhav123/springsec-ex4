package com.dizzy.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dizzy.model.Customer;
import com.dizzy.model.CustomerRepository;

@Service
public class BankUserDetails implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName=null, password = null;
		List<GrantedAuthority> authorities = null;
		List<Customer> customer = customerRepository.findByName(username);
		if (customer.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		} else {
			userName = customer.get(0).getName();
			password = customer.get(0).getPwd();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
		}
		return new User(username, password, authorities);
    }

}


/**
insert into customer(customer_id,name,email,mobile_number,pwd,role) 
values(2,'madhav','gmrdummy@gmail.com','87909090909','123','admin');

**/