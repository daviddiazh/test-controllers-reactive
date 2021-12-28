package co.com.sofka.demo.service;

import co.com.sofka.demo.model.Person;
import co.com.sofka.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Flux<Person> listAll(){
        return personRepository.findAll();
    }

    public Mono<Void> insert(Person capture){
        return validateBeforeInsert.apply(personRepository,capture)
                .switchIfEmpty(Mono.defer(() -> personRepository.save(capture)))
                .then();
    }

    private final BiFunction<PersonRepository, Person, Mono<Person>> validateBeforeInsert
            = (repo, person) -> repo.findByName(person.getName());

}
