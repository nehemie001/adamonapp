package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Teacher;
import ci.digitalacademy.adamonapp.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TeacherServiceImplTests {

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Test
    public void whenGetTeacherById_thenReturnTeacher() {
//        when(teacherRepository.findById(50L)).thenReturn(Optional.of(new Teacher(50L, "math", false, "slug")));
    }
}
