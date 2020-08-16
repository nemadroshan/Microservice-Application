package com.example.demo.controller;

import com.example.demo.generated.curddemo.curddemo.person.Person;
import com.example.demo.generated.curddemo.curddemo.person.PersonImpl;
import com.example.demo.generated.curddemo.curddemo.person.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PersonRestController {
    @Autowired
    PersonManager manager;

    @GetMapping("/getAllPersons")
    public List<Person> getAllPerson() {
        List<Person> personList = manager.stream()
                .collect(Collectors.toList());
        return personList;
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String savePerson(@RequestBody com.example.demo.model.Person person) {
        manager.persist(new PersonImpl()
                .setId(person.getId())
                .setName(person.getName())
                .setAge(person.getAge())
                .setAddress(person.getAddress())
        );
        return "saved ";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deletebyId(@PathVariable("id") Integer id) {
        System.out.println("PersonRestController.deletebyId");
        List<Person> list = manager.stream().collect(Collectors.toList());
        System.out.println("persooon :: " + list);
        Optional<Person> person = manager.stream()
                                    .filter(person1 -> person1.getId()==id).findFirst();
        person.ifPresent(person1 -> manager.remove(person1));
        //list.stream().filter(Person.ID.equal(id)).forEach(manager.remover());
        return "deleted";
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateById(@PathVariable("id") Integer id, @RequestBody com.example.demo.model.Person updatedPerson) {
        Optional<Person> person = manager.stream().filter(Person.ID.equal(id)).findFirst();
        person.ifPresent(p -> {
            p.setId(updatedPerson.getId());
            p.setName(updatedPerson.getName());
            p.setAge(updatedPerson.getAge());
            p.setAddress(updatedPerson.getAddress());
            manager.update(p);
        });

        return "updated";
    }

    @GetMapping(path = "/getPersonById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public com.example.demo.model.Person getPersonById(@PathVariable("id") Integer id) {
        System.out.println("Inside getPersonBY ");
        com.example.demo.model.Person response = new com.example.demo.model.Person();

        Person first = manager.stream().filter(Person.ID.equal(id)).findFirst().get();

        response.setAddress(first.getAddress().get());
        response.setId(id);
        response.setName(first.getName().get());
        response.setAge(first.getAge().getAsInt());

        System.out.println("Person :: " + response);
        return response;
    }
}
