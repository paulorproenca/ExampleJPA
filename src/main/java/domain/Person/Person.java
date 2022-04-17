package domain.Person;

import util.BusinessValidation;

import javax.persistence.*;

@Entity
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String XidentificationNumber;
    private String Xnome;
    private String Xemail;

    public Person(String identificationNumber, String name, String email){
        BusinessValidation.nonEmpty(identificationNumber,"identification number should neither be null nor empty");
        this.XidentificationNumber = identificationNumber;

        BusinessValidation.nonEmpty(name,"person name should neither be null nor empty");
        this.Xnome=name;

        BusinessValidation.nonEmpty(email,"email address  should neither be null nor empty");
        BusinessValidation.isEmail(email,"Invalid E-mail format");
        this.Xemail=email;
    }

    /* For ORM purposes */
    protected Person(){}


    public boolean sameAs(Object other) {
        return false;
    }


    public String identity() {
        return this.XidentificationNumber;
    }

    public String toString()
    {
        return "Person( " + this.Xnome + " | " + this.Xemail +  " | " + this.XidentificationNumber + " )";
    }
}

