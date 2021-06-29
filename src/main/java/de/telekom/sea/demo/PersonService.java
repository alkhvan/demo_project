package de.telekom.sea.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        super();
        System.out.println("PersonService is created: " + this.toString());
        System.out.println("PersonRepository: " + personRepository.toString());
        this.personRepository = personRepository;
    }

    public int size() {
        return personRepository.size();
    }

    public Personen getAll() {
        Personen personen = new Personen();
        for (Person p : personRepository.getAll()) {
            personen.getPersonen().add(p);
        }
        return personen;
    }

    public Person get(int id) {
        return new Person();
    }

    public Person add(Person person) {
        personRepository.add(person);
        System.out.println("Person was added");
        return person;
    }

    public Person delete(int id) {
        System.out.println("Person is removed.");
        personRepository.delete(id);
        return null;
    }

    public Person update(Integer id,Person person) {
        System.out.println("Person was changed!");
        return personRepository.update(id,person);

    }
    public void removeAll() {
        personRepository.removeAll();
    }

}
