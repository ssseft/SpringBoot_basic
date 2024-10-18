package com.mysite.bbs.contact;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Contact {
	
	@Id//기본기
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	private String id;
	
	
    private String name;
    
    @Column(length = 13)
    private String number;
    
    private String email;
    
    private String address;
    
    private LocalDateTime createdate;
	
	
}
