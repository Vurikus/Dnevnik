package my.web.controller;

import my.web.model.Mark;
import my.web.model.SchoolClass;
import my.web.model.Subject;
import my.web.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private CRUDService crudService;
    private int idTeacher = 1;
    private Map<String, Object> attributes = new HashMap<>();

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
        model.addAttribute("listSubject", crudService.getAllSubject(idTeacher, idClass));
        model.addAttribute("idClass", idClass);
        if(action != null) {
            switch (action) {
                case "select":
                    return "teacher/subjectPage";
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

        crudService.addSubject(new Subject(nameSubject, idTeacher, idClass));
        return "redirect:/teacher/subject/" + idClass;
    }

    @GetMapping("/subject/{idClass}/{idSubject}")
    public String getClassBySubject (@PathVariable(value = "idClass", required = false) int idClass,
                                     @PathVariable(value = "idSubject", required = false) int idSubject,
                                     @RequestParam(value = "newMark", defaultValue = "0", required = false) String mark,
                                     @RequestParam(value = "thisLearner", defaultValue = "0", required = false) String idLearner,
                                     @RequestParam(value = "action", required = false) String action,
                                     Model model){
        if(mark != null) {
            Mark m = new Mark();
            m.setMark(Integer.parseInt(mark));
            m.setDateMark(LocalDate.now());
            m.setIdLearner(Integer.parseInt(idLearner));
            m.setIdSubject(idSubject);
            crudService.addMark(m);
        }
        attributes.put("idClass", idClass);
        attributes.put("className", crudService.getSchoolClass(idClass).getNameClass());
        attributes.put("idSubject", idSubject);
        attributes.put("listLearner", crudService.getAllLearner(idClass));
        attributes.put("nameSubject", crudService.getSubject(idSubject).getNameSubject());
        model.addAllAttributes(attributes);
        if(action != null) {
            switch (action) {
                case "select":
                    return "teacher/learnerPage";
                case "delete":
                    crudService.deleteSubject(idSubject);
                    return "redirect:/teacher/subject/" + idClass;
            }
        }

        return "teacher/learnerPage";
    }
}
