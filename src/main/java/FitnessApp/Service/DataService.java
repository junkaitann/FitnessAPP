package FitnessApp.Service;


import java.util.List;

import FitnessApp.Entity.DataEntity;
import FitnessApp.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService implements IDataService {

    @Autowired
    private DataRepository repository;

    @Override
    public List<DataEntity> findByNameEndsWith(String name) {

        return (List<DataEntity>) repository.findByNameEndsWith(name);
    }

    @Override
    public List<DataEntity> findByNameEndsWith2() {

        return (List<DataEntity>) repository.findByNameEndsWith2();
    }
}