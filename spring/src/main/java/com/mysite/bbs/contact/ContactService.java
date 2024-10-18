package com.mysite.bbs.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ContactService {
	private final ContactRepository contactRepository;
	
	
	 public Contact save(Contact contact) {
	        return contactRepository.save(contact);
	    }
	
	 public List<Contact> getList() {
	        return contactRepository.findAll();
	 	}
	 
	 
	 public Contact getContact(int no) {
		    Optional<Contact> contact = contactRepository.findById(no);
		    if (contact.isPresent()) {
		        return contact.get();
		    } else {
		        return null;
		    }
		}

	
	 public Contact updateContact(Contact contact) {
	        return contactRepository.save(contact);
	    }
	
	 public void deleteContact(int no) {
	        contactRepository.deleteById(no);
	    }
	
}
