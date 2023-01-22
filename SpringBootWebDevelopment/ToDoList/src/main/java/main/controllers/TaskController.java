package main.controllers;

import main.model.Task;
import main.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCreationTime(LocalDateTime.now());
        task.setDone(false);
        taskRepository.save(task);
        return new ResponseEntity<Task>(HttpStatus.CREATED);
    }

    @GetMapping(
            value = "/tasks/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Task> getTask(@PathVariable int id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<Task>(taskOptional.get(), HttpStatus.OK);
    }

    @GetMapping(
            value = "/tasks",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Task> listTask() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @PatchMapping("tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, String title, String description, boolean isDone) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task task = taskOptional.get();
        task.setTitle(title);
        task.setDescription(description);
        task.setDone(isDone);
        taskRepository.save(task);
        return new ResponseEntity<Task>(taskOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable int id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        taskRepository.deleteById(id);
        return new ResponseEntity<Task>(taskOptional.get(), HttpStatus.OK);
    }
}
