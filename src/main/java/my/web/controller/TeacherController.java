package my.web.controller;

import my.web.model.SchoolClass;
import my.web.model.Subject;
import my.web.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private CRUDService crudService;
    private int idTeacher = 1;

    @GetMapping("/start")
    public String getStartPage(Model model){
        return "startPage";
    }

    @GetMapping("/class")
    public String getTeacherPage(Model model){
        model.addAttribute("listSchoolClass", crudService.getAllSchoolClass());
        return "teacher/teacherPage";
    }

    @PostMapping("/class")
    public String addSchoolClass(@RequestParam(value = "nameClass") String nameClass){
        crudService.addSchoolClass(new SchoolClass(nameClass));
        return "redirect:/class";
    }
    @GetMapping("/subject")
    public String getSubjectPage(Model model){
        model.addAttribute("listSubject", crudService.getAllSubject(idTeacher));
        return "teacher/subjectPage";
    }

    @PostMapping("/subject")
    public String addSubject(@RequestParam(value = "newSubject") String nameSubject){
        crudService.addSubject(new Subject(nameSubject, idTeacher));
        return "redirect:/subject";
    }
}
