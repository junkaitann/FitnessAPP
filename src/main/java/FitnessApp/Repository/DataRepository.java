package FitnessApp.Repository;

import FitnessApp.Entity.DataEntity;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<DataEntity, Integer> {

}