package com.example.demo.service;

import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service //так же как сущности @Controller/@Repository - части родительской сущности @Component
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() { //getAll() – метод, возвращающий все задачи, отсортированные в порядке возрастания даты и порядке убывания приоритета.
        return taskRepository.findAll(Sort.by(Sort.Order.desc("priorityId")));
    }

    public Task save(Task task) { //save(Task task) – метод создания новой задачи.
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task getTask(Long id) {
        Task task = taskRepository.getById(id);
        return task;
    }

    public boolean checkStatusClose(Long id) {
        Task task = taskRepository.getById(id);
        if(task.getStatus() == Status.CLOSE) {
            return false;
        }
        return true;
    }
}
