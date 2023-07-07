package com.example.simple_server.controller.local;

import com.example.simple_server.entity.Person;
import com.example.simple_server.service.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "Сервис для работы с Person")
@RestController("person")
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/add")
    public Long add(@RequestBody Person person) {
        return personService.add(person);
    }

    @GetMapping("/find-all")
    public Map<Long, Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/find")
    public Map<Long, Person> find(Long id) {
        return personService.find(id);
    }

    @DeleteMapping("/delete-by-person")
    public Person delete(@RequestBody Person person) {
        return personService.delete(person);
    }

    @DeleteMapping("/delete-person-by-id")
    private Person deleteById(Long id) {
        return personService.deleteById(id);
    }
}
