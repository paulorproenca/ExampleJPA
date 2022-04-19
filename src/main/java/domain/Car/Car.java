package domain.Car;

import domain.Car_Group.CarGroup;
import util.BusinessValidation;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String carPlate;
    private String carBrand;
    private String carModel;
    private int carCylinder;
    private int yearOfAquisition;
    private int yaerOfManufacture;
    @OneToOne
    private CarGroup carGroup;

    public Car(String plate, String brand, String model,int cylinder, int yAquisistion, int yManufacture, CarGroup group){
        BusinessValidation.nonEmpty(plate,"Plate should neither be null nor empty");
        this.carPlate = plate;

        BusinessValidation.nonEmpty(model,"Model should neither be null nor empty");
        this.carModel=model;

        BusinessValidation.nonEmpty(brand,"Brand should neither be null nor empty");
        this.carBrand=brand;

        this.carCylinder=cylinder;
        this.yearOfAquisition=yAquisistion;
        this.yaerOfManufacture=yManufacture;

        this.carGroup=group;
    }

    /* For ORM purposes */
    protected Car(){}


    public boolean sameAs(Object other) {
        return false;
    }


    public String identity() {
        return this.carPlate;
    }

    public String toString()
    {
        return "Car( " + this.carPlate + " | " + this.carBrand +  " | " + this.carModel +  " | " + this.carCylinder +  " | " +this.carGroup.toString() + " )";
    }
}

