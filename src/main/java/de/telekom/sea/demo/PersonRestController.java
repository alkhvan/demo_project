package de.telekom.sea.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonRestController {

    private PersonService personService;


    @Autowired
    public PersonRestController(PersonService personService) {
        super();
        this.personService = personService;
    }

    //** @see URL: <a href="http://localhost:8080/json/persons/all">http://localhost:8080/json/persons/all</a> */
    @GetMapping("/json/persons/all")
    public Personen getAll() {
        Personen personen = personService.getAll();
        return personen;
    }

    @GetMapping("/json/persons/size")
    public Long getSize() {
        return personService.size();
    }

    @GetMapping("/json/person/{id}")	// {id}
    public Person getPerson(@PathVariable("id") Long id) {
        return personService.get(id);
    }

    @PostMapping("/json/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.add(person);
    }

    @DeleteMapping("/json/person/{id}")
    public Person deletePerson(@PathVariable("id") Long id) {
        return personService.delete(id);
    }

    @PutMapping("/json/person")
    public Person updatePerson(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/json/person/deleteAll")
    public Person deleteAllPerson() {
        return personService.clear();
    }


}
