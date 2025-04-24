package TaskApp1;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import TaskApp1.controller.TaskController;
import TaskApp1.model.Task;
import TaskApp1.service.TaskService;

@WebMvcTest(TaskController.class)
public class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    public void testListTasks() throws Exception {
        Task task = new Task();
        task.setTitle("Integration Task");
        task.setCompleted(false);

        when(taskService.getAllTasks()).thenReturn(List.of(task));

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("tasks"))
            .andExpect(view().name("index"));  // View名は実際のテンプレートに合わせて調整
    }
}
