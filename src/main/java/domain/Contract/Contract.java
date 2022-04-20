package domain.Contract;

import domain.Car.Car;
import domain.Person.Person;
import util.BusinessValidation;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contractID;
    @OneToOne
    private Car car;
    @OneToOne
    private Person person;

    public Contract(Person p, Car c){
        this.person=p;
        this.car=c;
    }

    /* For ORM purposes */
    protected Contract(){}

    public boolean sameAs(Object other) {
        return false;
    }

    public Long identity() {
        return this.contractID;
    }

    public String toString()
    {
        return "Contact( " +  this.person.toString() +  " | " + this.car.toString() + " )";
    }
}

