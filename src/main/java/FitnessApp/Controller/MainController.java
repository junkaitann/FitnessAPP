package FitnessApp.Controller;

import FitnessApp.Repository.DataRepository;
import FitnessApp.Entity.DataEntity;
import FitnessApp.Service.IDataService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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

    // Extract data based on input paraameter
    @GetMapping(path="/all2")
    public @ResponseBody Iterable<DataEntity> findExerciseNameEndsWith(Model model, @RequestParam String Exercise) {

        model.addAttribute("cities", (List<DataEntity>) dataService.findByNameEndsWith(Exercise));

        return dataService.findByNameEndsWith(Exercise);
    }

    // Extract data based on Query
    @GetMapping(path="/all3")
    public @ResponseBody Iterable<DataEntity> findExerciseNameEndsWith2() {

        JSONArray jsonArray = new JSONArray(dataService.findByNameEndsWith2());

        return dataService.findByNameEndsWith2();
    }

    // Extract Exercise from Query as List
    @GetMapping(path="/all4")
    public List<String> getExercise() {
        JSONArray jsonArray = new JSONArray(dataService.findByNameEndsWith2());
        List<String> Exercise = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString("exercise"))
                .collect(Collectors.toList());
        return Exercise;
    }

    // Extract Score from Query as Integer
    @GetMapping(path="/all5")
    public Integer getScore() {
        JSONArray jsonArray = new JSONArray(dataService.findByNameEndsWith2());
        List<Integer> Score = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optInt("score"))
                .collect(Collectors.toList());
        Integer sum = Score.stream()
                .reduce(0, Integer::sum);

        return sum;
    }

    //SUM all Score in MySQL database
    @GetMapping(path="/all6")
    public Integer getTotalScore() {
        JSONArray jsonArray = new JSONArray(dataRepository.findAll());
        List<Integer> Score = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optInt("score"))
                .collect(Collectors.toList());
        Integer sum = Score.stream()
                .reduce(0, Integer::sum);

        return sum;
    }


}