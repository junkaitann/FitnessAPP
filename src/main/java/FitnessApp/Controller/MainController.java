package FitnessApp.Controller;

import FitnessApp.Repository.DataRepository;
import FitnessApp.Entity.DataEntity;
import FitnessApp.Service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MainController {
    @Autowired
    private DataRepository dataRepository;

    @Autowired
    IDataService dataService;

    @RequestMapping("/")
    String home() {
        System.out.println("Testtest");
        return "Hello, World!";
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam Integer id,@RequestParam String exercise
            , @RequestParam String type, @RequestParam String category, @RequestParam Integer score){

        DataEntity n = new DataEntity();
        n.setId(id);
        n.setExercise(exercise);
        n.setType(type);
        n.setCategory(category);
        n.setScore(score);
        dataRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<DataEntity> getAllUsers() {
        return dataRepository.findAll();
    }

    @GetMapping(path="/all2")
    public @ResponseBody Iterable<DataEntity> findExerciseNameEndsWith(Model model, @RequestParam String Exercise) {

        model.addAttribute("cities", (List<DataEntity>) dataService.findByNameEndsWith(Exercise));

        return dataService.findByNameEndsWith(Exercise);
    }

    @GetMapping(path="/all3")
    public @ResponseBody Iterable<DataEntity> findExerciseNameEndsWith( @RequestParam String Exercise) {


        return dataService.findByNameEndsWith(Exercise);
    }





}