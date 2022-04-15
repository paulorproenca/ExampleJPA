package application.Person;

import repository.PersistenceContext;
import repository.Person.PersonRepository;
import domain.Person.Person;

import javax.persistence.*;

public class CreatePersonService {

    private PersonRepository personRepository;
    private EntityManager entityManager = PersistenceContext.Factory("UPskillPU");

    public CreatePersonService(){
        this.personRepository= new PersonRepository(this.entityManager);
    }

    public void save(Person person){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Person p = this.personRepository.save(person);
        tx.commit();
        this.entityManager.close();
    }
}
