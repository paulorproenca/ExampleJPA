package domain.Driver;

import javax.persistence.Embeddable;

@Embeddable
public class DriverLicense{
    private long licenseNumber;
    private String licenseDate;

    public DriverLicense(final long num, final String date){
        this.licenseNumber=num;
        this.licenseDate=date;
    }

    protected DriverLicense(){}

    public String toString()
    {
        return "License( " +  this.licenseNumber +  " | " + this.licenseDate + " )";
    }
}
