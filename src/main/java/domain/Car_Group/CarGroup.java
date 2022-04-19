package domain.Car_Group;

import util.BusinessValidation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String groupName;
    private int numDoors;
    private double groupPrice;

    public CarGroup(String name, int doors, double price){
        BusinessValidation.nonEmpty(name,"Group name should neither be null nor empty");
        this.groupName = name;

        this.numDoors=doors;

        this.groupPrice=price;
    }

    /* For ORM purposes */
    protected CarGroup(){}


    public boolean sameAs(Object other) {
        return false;
    }


    public String identity() {
        return this.groupName;
    }

    public String toString()
    {
        return "Car_Group( " + this.groupName + " | " + this.numDoors +  " | " + this.groupPrice + " )";
    }
}

