package TaskApp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import TaskApp1.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>, TaskRepositoryInterface  {
}
