package application.Contract;

import application.Car.CarService;
import application.Person.PersonService;
import domain.Car.Car;
import domain.Person.Person;
import domain.Contract.Contract;



public class ContractController {

    private final ContractService theService = new ContractService();

    public ContractController(){}

    public Contract createContract(final Long personID, final String plate) {

        PersonService thePersonService = new PersonService();
        Person person=thePersonService.findById(personID);

        CarService theCarService = new CarService();
        Car car=theCarService.findById(plate);

        final Contract contract = new Contract(person,car);
        this.theService.save(contract);
        return contract;
    }

    public Contract findContract(final Long id) {
        return this.theService.findById(id);
    }

    public Iterable<Contract> findAllCar(){
        return this.theService.findAll();
    }

    public void removeCar(Contract c){
        this.theService.removeContract(c);
    }
}
