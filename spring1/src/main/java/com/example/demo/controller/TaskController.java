package com.example.demo.controller;

import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/task")
    @ResponseBody
    public String addTask(@RequestParam String name,
                          @RequestParam String description,
                          @RequestParam Integer priority) {

        Task task = new Task();
        Date date = new Date();
        task.setName(name);
        task.setDescription(description);
        task.setPriority(priority);
        task.setStatus(Status.NEW);
        task.setDate(date);

        taskService.save(task);
        return "save string" + task;
    }

    @GetMapping("/task")
    public String getTask(@RequestParam(name = "getId") Long id) {

        Task task = taskService.getTask(id);
        System.out.println(task);

        return task.toString();
    }

    @DeleteMapping("/task")
    public void deleteID(@RequestParam Long id) {
        taskService.delete(id);
    }

    @PatchMapping("/task")
    public String patchTask(@RequestParam(required = false) String name,  //(required = false) указывает что данный параметр является необязательным при вызове метода в postman'e
                            @RequestParam(required = false) String description,
                            @RequestParam(required = false) String status,
                            @RequestParam(name = "getId") Long id) {
        System.out.println("input patch method");
        Task task = taskService.getTask(id);
        if (name != null) {
            task.setName(name);
        }
        if (description != null) {
            task.setDescription(description);
        }
        if (status != null) {
            Status resultValue = Status.valueOfLabel(status);
            boolean resultStatusClose = taskService.checkStatusClose(id);
            if (resultStatusClose == true && resultValue != null) {
                task.setStatus(resultValue);
                taskService.save(task);
            } else {
                System.out.println("Статус не соответствует требованиям");
            }
        }

        taskService.save(task);
        return task.toString();

    }

}
