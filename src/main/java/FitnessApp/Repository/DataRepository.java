package FitnessApp.Repository;

import FitnessApp.Entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DataRepository extends JpaRepository<DataEntity, String> {

    @Query("select c from DataEntity c where c.Exercise like %?1")
    List<DataEntity> findByNameEndsWith(String chars);

    @Query(value = "select c from DataEntity c where Exercise = 'Bench Press'")
    List<DataEntity> findByNameEndsWith2();

}

