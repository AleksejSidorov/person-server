package com.example.simple_server.repository;

import com.example.simple_server.entity.Person;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PersonRepository {

    private Long sequence = 6L;
    private final static Long START_ID = 5L;
    private Map<Long, Person> personMap = new HashMap<>();

    {
        personMap.put(1L, new Person( 32L, "Peter", "Falk"));
        personMap.put(2L, new Person( 27L, "Jenny", "Smith"));
        personMap.put(3L, new Person( 8L, "Jonny", "Boy"));
        personMap.put(4L, new Person( 45L, "Bender", "Rodriges"));
        personMap.put(5L, new Person( 21L, "Philip", "Fry"));
    }

    public Long add(Person person) {
        personMap.put(sequence++, person);
        return sequence;
    }

    public Person delete(Person person) {
        Person deletedPerson = new Person();
        Optional<Map.Entry<Long, Person>> optional = personMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(person))
                .findFirst();
        if (optional.isPresent()) {
            deletedPerson = optional.get().getValue();
            personMap.remove(optional.get().getKey());
        }
        return deletedPerson;
    }

    public Map<Long, Person> findAll() {
        return personMap;
    }

    public Map<Long, Person> findById(Long id) {
        return Map.of(id, personMap.get(id));
    }

    public Person deleteById(Long id) {
        if (id > sequence && id < START_ID) {
            return new Person();
        }
        return personMap.remove(id);
    }

    public Map<Long, Person> addPersonList(List<Person> personList) {
        Long sequence = this.sequence;
        Map<Long, Person> personMap = new HashMap<>();
        for(Person person : personList) {
            personMap.put(sequence++, person);
        }
        this.personMap.putAll(personMap);
        return personMap;
    }
}
