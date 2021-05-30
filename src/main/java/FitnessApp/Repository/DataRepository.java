package FitnessApp.Repository;

import FitnessApp.Entity.DataEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface DataRepository extends CrudRepository<DataEntity, String> {

    @Query("select c from DataEntity c where c.Exercise like %?1")
//    @Query("select c from DataEntity c where c.Exercise = 'Bench Press'")
    List<DataEntity> findByNameEndsWith(String chars);



}

