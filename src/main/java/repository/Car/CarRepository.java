package repository.Car;

import domain.Car.Car;
import repository.Shared.BaseRepository;

import javax.persistence.EntityManager;

public class CarRepository extends BaseRepository<String, Car>
{
    public CarRepository(EntityManager theEntityManager){
        super(theEntityManager);
    }
}



