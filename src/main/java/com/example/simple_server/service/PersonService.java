package com.example.simple_server.service;

import com.example.simple_server.entity.Person;
import com.example.simple_server.feign.FeignRemotePerson;
import com.example.simple_server.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final FeignRemotePerson feignRemotePerson;

    public Long add(Person person) {
        return personRepository.add(person);
    }

    public Map<Long, Person> findAll() {
        return personRepository.findAll();
    }

    public Map<Long, Person> find(Long id) {
        return personRepository.findById(id);
    }

    public Person delete(Person person) {
        return personRepository.delete(person);
    }

    public Person deleteById(Long id) {
        return personRepository.deleteById(id);
    }

    public Person addGeneratedPersonFromRemote() {
        Person person = feignRemotePerson.getGeneratedPersonFromRemote();
        personRepository.add(person);
        return person;
    }

    public Map<Long, Person> addGeneratedPersonListFromRemote(Long count) {
        List<Person> personList = feignRemotePerson.getGeneratedPersonListFromRemote(count);
        return personRepository.addPersonList(personList);
    }
}
