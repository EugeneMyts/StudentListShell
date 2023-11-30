package com.example.StudentsList.db;

import com.example.StudentsList.Student;
import com.example.StudentsList.events.EventDeleteStudent;
import com.example.StudentsList.events.EventSaveStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StorageImpl implements Storage {

private final Map<Integer, Student> students = new HashMap<>();
private final ApplicationEventPublisher publisher;

    public StorageImpl(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    private int id = 1;

    @Override
    public Student get(int id) {
        Student student = students.get(id);
        if (student == null) {
            System.out.println("Student not found");
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        Collection<Student> values = students.values();
        if (values.size() == 0) {
            System.out.println("empty");
        }
        return new ArrayList<>(values);
    }

    @Override
    public void save(Student student) {
        Student studentDB = students.put(student.getId(), student);
        if (studentDB == null) {
            publisher.publishEvent(new EventSaveStudent(this, student));
        }

    }

    @Override
    public void delete(int id) {
        students.remove(id);
        publisher.publishEvent(new EventDeleteStudent(this, id));

    }

    @Override
    public void clear() {
        students.clear();

    }

    @Override
    public int getNewId() {
        return id++;
    }
}
