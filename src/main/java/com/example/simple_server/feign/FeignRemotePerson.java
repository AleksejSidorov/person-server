package com.example.simple_server.feign;

import com.example.simple_server.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "remote-server", url = "${service.remote_server_url:localhost:8082}")
public interface FeignRemotePerson {

    @RequestMapping(method = RequestMethod.GET, value = "person/generate-person")
    Person getGeneratedPersonFromRemote();

    @RequestMapping(method = RequestMethod.GET, value = "person/generate-person-list?count={count}")
    List<Person> getGeneratedPersonListFromRemote(@PathVariable("count") Long count);
}
