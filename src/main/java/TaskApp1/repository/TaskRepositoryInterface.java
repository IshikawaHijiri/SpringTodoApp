package TaskApp1.repository;

import java.util.List;
import java.util.Optional;

import TaskApp1.model.Task;

public interface TaskRepositoryInterface {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task task);
    void deleteById(Long id);
}