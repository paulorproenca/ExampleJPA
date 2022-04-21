package domain.Driver;

import javax.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driverID;
    private String driverName;
    @Embedded
    private DriverLicense driverLicense;

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public Driver(final String name, final long licenseNumber, final String licenseDate){
        this.driverName=name;
        this.driverLicense = new DriverLicense(licenseNumber, licenseDate);
    }

    protected Driver(){}

    public boolean sameAs(Object other) {
        return false;
    }

    public Long identity() {
        return this.driverID;
    }

    public String toString()
    {
        return "Driver( " +  this.driverName +  " | " + this.driverLicense.toString() + " )";
    }
}
