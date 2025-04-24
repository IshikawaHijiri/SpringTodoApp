package TaskApp1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import TaskApp1.model.Task;
import TaskApp1.repository.TaskRepositoryInterface;

@Service
public class TaskService {
    
    private TaskRepositoryInterface taskRepository;
    
    public TaskService(TaskRepositoryInterface  taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
