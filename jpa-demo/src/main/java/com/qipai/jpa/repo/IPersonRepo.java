package com.qipai.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qipai.jpa.domain.Person;

@Repository
public interface IPersonRepo extends JpaRepository<Person, String>{

}
