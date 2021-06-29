package de.telekom.sea.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private List<Person> personen = new ArrayList<Person>();

    public PersonRepository() {
        super();
        System.out.println("PersonRepository is instantiated: " + this.toString());

    }
    public int size() {
        return personen.size();
    }

    public boolean add(Person person) {
        return personen.add(person);
    }

    public List<Person> getAll() {
        return personen;
    }


    public void delete(int id) {
        System.out.println("Size: " + personen.size());
        for (int i = 0; i < personen.size(); i++) {
            if (personen.get(i).getID() == id) {
                System.out.println(String.format("Id: %s will removed",personen.get(i).getID()));
                personen.remove(i);
            }
        }
        System.out.println("Size: " + personen.size());
    }

    public Person update(int id, Person p) {
        for (int i = 0; i < personen.size(); i++) {
            if (personen.get(i).getID() == p.getID()) {
                System.out.println(String.format("Id: %s is updated",personen.get(i).getID()));
                return personen.set(i, p);
            }
        }
        return null;
    }

    public void removeAll() {
        personen.removeAll(getAll());
    }
}
