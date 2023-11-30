package com.example.StudentsList.service;

import com.example.StudentsList.Student;
import com.example.StudentsList.db.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class StudentInit {
    private final Storage storage;

    @EventListener(ApplicationStartedEvent.class)
    public void startInit() {
        int count = 5 * (int) (Math.random() * 10);
        saveStudents(count);
    }

    private void saveStudents(int count) {
        for (int i = 1; i < count + 1; i++) {
            storage.save(Student.builder()
                    .id(storage.getNewId())
                    .firstName("SomeStudentFirstName" + i)
                    .lastName("SomeStudentLastName" + i)
                    .age(18 + i)
                    .build());
        }
    }
}
