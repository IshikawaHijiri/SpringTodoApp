package TaskApp1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import TaskApp1.model.Task;
import TaskApp1.repository.TaskRepositoryInterface;
import TaskApp1.service.TaskService;

public class TaskServiceUnitTest {

    @Test
    public void testGetAllTasks() {
        TaskRepositoryInterface mockRepo = mock(TaskRepositoryInterface.class);
        TaskService taskService = new TaskService(mockRepo);

        Task task = new Task();
        task.setTitle("Unit Test Task");
        
        when(mockRepo.findAll()).thenReturn(List.of(task));

        List<Task> result = taskService.getAllTasks();

        assertEquals(1, result.size());
        assertEquals("Unit Test Task", result.get(0).getTitle());
    }

    @Test
    public void testCreateTask() {
        TaskRepositoryInterface mockRepo = mock(TaskRepositoryInterface.class);
        TaskService taskService = new TaskService(mockRepo);

        Task task = new Task();
        task.setTitle("Create Task");
        
        when(mockRepo.save(task)).thenReturn(task);

        Task result = taskService.createTask(task);

        assertEquals("Create Task", result.getTitle());
        verify(mockRepo).save(task);
    }
}