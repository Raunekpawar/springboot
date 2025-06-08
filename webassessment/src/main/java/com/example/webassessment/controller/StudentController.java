package com.example.webassessment.controller;

import com.example.webassessment.model.Student;
import com.example.webassessment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", repo.findAll());
        return "list";
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String searchResult(@RequestParam String name, Model model) {
        List<Student> result = repo.findByNameIgnoreCase(name);
        if (result.isEmpty()) {
            model.addAttribute("error", "No student found with name: " + name);
            return "search";
        } else {
            model.addAttribute("students", result);
            return "result";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id, Model model) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            model.addAttribute("message", "Student deleted successfully.");
        } else {
            model.addAttribute("message", "Student not found.");
        }
        return "home";
    }
}
