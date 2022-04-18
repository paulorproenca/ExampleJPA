package domain.Person;

import util.BusinessValidation;

import javax.persistence.*;

@Entity
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String personIdentificationNumber;
    private String personName;
    private String personEmail;

    public Person(String identificationNumber, String name, String email){
        BusinessValidation.nonEmpty(identificationNumber,"identification number should neither be null nor empty");
        this.personIdentificationNumber = identificationNumber;

        BusinessValidation.nonEmpty(name,"person name should neither be null nor empty");
        this.personName=name;

        BusinessValidation.nonEmpty(email,"email address  should neither be null nor empty");
        BusinessValidation.isEmail(email,"Invalid E-mail format");
        this.personEmail=email;
    }

    /* For ORM purposes */
    protected Person(){}


    public boolean sameAs(Object other) {
        return false;
    }


    public String identity() {
        return this.personIdentificationNumber;
    }

    public String toString()
    {
        return "Person( " + this.personName + " | " + this.personEmail +  " | " + this.personIdentificationNumber + " )";
    }
}

