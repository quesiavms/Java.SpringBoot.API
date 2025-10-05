package first.project.java.api.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    private List<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "/tasks")
    public ResponseEntity<String> listTasks() throws JsonProcessingException {
        return  ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping(path = "/tasks")
    public ResponseEntity<String> createTask(@RequestBody String task){
        String cleanTask = task.replace("\"", "");
        tasks.add(cleanTask);
        return ResponseEntity.ok("Task: " +cleanTask+" was added succesfully");
    }

    @DeleteMapping(path = "/tasks")
    public ResponseEntity<String> clearTaksk(){
        tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }

}