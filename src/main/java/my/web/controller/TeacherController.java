package my.web.controller;

import my.web.model.SchoolClass;
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

    @GetMapping("/start")
    public String getStartPage(Model model){
        return "startPage";
    }

    @GetMapping("/")
    public String getTeacherPage(Model model){
        model.addAttribute("listSchoolClass", crudService.getAllSchoolClass());
        return "teacher/teacherPage";
    }

    @PostMapping("/")
    public String addSchoolClass(@RequestParam(value = "nameClass") String nameClass){
        crudService.addSchoolClass(new SchoolClass(nameClass));
        return "redirect:/";
    }
}
