package com.webspring.web.repository;

import com.webspring.web.contactModel.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface repository extends JpaRepository<contact,Integer> {
    
}
