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
@RequestMapping("/teacher")
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
    public String addSchoolClass(@RequestParam(value = "newClass") String nameClass){
        crudService.addSchoolClass(new SchoolClass(nameClass));
        return "redirect:/teacher/class";
    }
    @GetMapping("/subject/{idClass}")
    public String getSubjectPage(@PathVariable (value = "idClass", required = false) int idClass,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model){

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setIdClass(idClass);
        model.addAttribute("className", crudService.getSchoolClass(idClass).getNameClass());
        model.addAttribute("listSubject", crudService.getAllSubject(idTeacher));
        if(action != null) {
            switch (action) {
                case "select":
                    return "teacher/subjectPage";
                case "edit":
                    crudService.updateSchoolClass(schoolClass);
                    return "teacher/edit";

                case "delete":
                    crudService.deleteSchoolClass(schoolClass);
                    return "redirect:/teacher/class";
            }
        }
        return "teacher/subjectPage";
    }

    @PostMapping("/subject/{idClass}")
    public String addSubject(@RequestParam(value = "newSubject") String nameSubject,
                             @PathVariable(value = "idClass", required = false) int idClass){

        crudService.addSubject(new Subject(nameSubject, idTeacher));
        return "redirect:/teacher/subject/" + idClass;
    }
}
