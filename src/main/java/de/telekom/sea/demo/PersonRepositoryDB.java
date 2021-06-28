package de.telekom.sea.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryDB extends CrudRepository<Person, Long> {
    @Query(value="SELECT * from persons",nativeQuery=true )
    Iterable<Person> selectPersonen();
}
