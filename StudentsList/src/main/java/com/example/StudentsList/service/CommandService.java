package com.example.StudentsList.service;

import com.example.StudentsList.Student;
import com.example.StudentsList.db.Storage;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;


@ShellComponent
@AllArgsConstructor
public class CommandService {

    private final Storage storage;

    @ShellMethod(key = "all", value = "show all students from database")
    public String showAll() {
        List<Student> students = storage.getAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : students) {
            stringBuilder.append(student.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(key = "save", value = "save student into database, parameters --f first name, --l last name, --a age")
    public void saveStudent(
            @ShellOption(value = "f") String firstName,
            @ShellOption(value = "l") String lastName,
            @ShellOption(value = "a") int age) {
        storage.save(Student.builder()
                .id(storage.getNewId())
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .build());
    }

    @ShellMethod(key = "del", value = "delete student from database, parameters: --id number")
    public void deleteStudent(int id) {
        storage.delete(id);
    }

    @ShellMethod(key = "cl", value = "delete all students from db")
    public String clearAll() {
        storage.clear();
        return "all students were deleted";
    }



}
