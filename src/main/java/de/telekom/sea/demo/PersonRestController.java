package de.telekom.sea.demo;


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
    public int getSize() {
        return personService.size();
    }

    @GetMapping("/json/person/{id}")	// {id}
    public Person getPerson(@PathVariable("id") int id) {
        return personService.get(id);
    }

    @PostMapping("/json/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.add(person);
    }

    @DeleteMapping("/json/person/{id}")
    public Person deletePerson(@PathVariable("id") int id) {

        return personService.delete(id);
    }

    @PutMapping("/json/person/{id}")
    public Person updatePerson(@PathVariable("id") int id ,@RequestBody Person person) {
        return personService.update(id,person);
    }

    @DeleteMapping("/json/person/all")
    public void removeAllPersons() {personService.removeAll();
    }

}
