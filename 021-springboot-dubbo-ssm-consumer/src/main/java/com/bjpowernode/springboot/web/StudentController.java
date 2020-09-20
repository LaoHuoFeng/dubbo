package com.bjpowernode.springboot.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.springboot.model.Student;
import com.bjpowernode.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Reference(interfaceName = "com.bjpowernode.springboot.service.StudentService", version = "1.0.0", check = false)
    private StudentService studentService;

    @RequestMapping(value = "/student/detail/{id}")
    public String StudentDetail(Model model, @PathVariable("id") Integer id){
        //根据学生详情查询学生
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student", student);
        return "studentDetail";
    }
}
