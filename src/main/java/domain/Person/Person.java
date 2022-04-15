package domain.Person;

import util.BusinessValidation;

import javax.persistence.*;

@Entity
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String _identificationNumber;
    private String _nome;
    private String _email;

    public Person(String identificationNumber, String name, String email){
        BusinessValidation.nonEmpty(identificationNumber,"identification number should neither be null nor empty");
        this._identificationNumber = identificationNumber;

        BusinessValidation.nonEmpty(name,"person name should neither be null nor empty");
        this._nome=name;

        BusinessValidation.nonEmpty(email,"email address  should neither be null nor empty");
        BusinessValidation.isEmail(email,"Invalid E-mail format");
        this._email=email;
    }

    /* For ORM purposes */
    protected Person(){}


    public boolean sameAs(Object other) {
        return false;
    }


    public String identity() {
        return this._identificationNumber;
    }

    public String toString()
    {
        return "Person( " + this._nome + " | " + this._email +  " | " + this._identificationNumber + " )";
    }
}

