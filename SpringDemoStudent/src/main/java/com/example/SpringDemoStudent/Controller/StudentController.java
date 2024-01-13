package com.example.SpringDemoStudent.Controller;

import com.example.SpringDemoStudent.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student(1, "RAHUL","9876543210","LONAVALA",500,400));
        studentList.add(new Student(2, "ROHIT","9876543211","NAGPUR",500,410));
        studentList.add(new Student(3, "VIJAY","9876543212","NASHIK",500,100));
        studentList.add(new Student(4, "RUSHABH","9876543213","PUNE",500,430));
        studentList.add(new Student(5, "SWATI","9876543214","PUNE",500,440));
    }
    @GetMapping("/display")
    public String displayStudentData(Model model) {
        model.addAttribute("studentData", studentList);
        return "displayStudentData";
    }
    @GetMapping("/addStudent")
    public String createObject(Model model) {
        model.addAttribute("studentObject", new Student());
        return "studentForm";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        studentList.add(student);
        return "redirect:/display";
    }

    @GetMapping("/updateStudent/{id}")
    public String fetchObject(@PathVariable int id, Model model) {
        for (Student s:studentList) {
            if (s.getStudentRollNumber()==id) {
                model.addAttribute("matchObject", s);
                break;
            }
        }
        return "updateStudent";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(Student updatedstudent) {
        for (Student s:studentList) {
            if (s.getStudentRollNumber()==updatedstudent.getStudentRollNumber()) {
                studentList.set(studentList.indexOf(s), updatedstudent);
                break;
            }
        }
        return "redirect:/display";
    }

    @GetMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        for (Student s:studentList) {
            if (s.getStudentRollNumber()==id){
                studentList.remove(s);
                break;
            }
        }
        return "redirect:/display";
    }
}
