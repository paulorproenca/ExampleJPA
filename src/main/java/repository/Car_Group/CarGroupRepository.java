package repository.Car_Group;

import domain.Car_Group.CarGroup;
import repository.Shared.BaseRepository;

import javax.persistence.EntityManager;

public class CarGroupRepository extends BaseRepository<String, CarGroup>
{
    public CarGroupRepository(EntityManager theEntityManager){
        super(theEntityManager);
    }
}



