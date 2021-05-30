package FitnessApp.Service;

import FitnessApp.Entity.DataEntity;

import java.util.List;

public interface IDataService {

    List<DataEntity> findByNameEndsWith(String Exercise);
}