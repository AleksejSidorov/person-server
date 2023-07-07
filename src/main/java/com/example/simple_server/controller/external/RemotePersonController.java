package com.example.simple_server.controller.external;

import com.example.simple_server.entity.Person;
import com.example.simple_server.service.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Map;

@Tag(name = "Сервис для генерирования Person")
@RestController
@RequestMapping("remote-server")
@RequiredArgsConstructor
public class RemotePersonController {

    private final PersonService personService;

    @GetMapping("/add-person")
    public Person addAndGetGeneratePerson() {
        return personService.addGeneratedPersonFromRemote();
    }

    @GetMapping("/add-person-list")
    public Map<Long, Person> addAndGetGeneratePerson(@PathParam("count") Long count) {
        return personService.addGeneratedPersonListFromRemote(count);
    }
}
