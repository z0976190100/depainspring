package com.depainspring.proj.controller;

import com.depainspring.proj.service.DepartmentService;
import com.depainspring.proj.service.dto.DepartmentDto;
import com.depainspring.proj.service.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private MessageManager messageManager;
    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service, MessageManager messageManager) {
        this.service = service;
        this.messageManager = messageManager;
    }

    @GetMapping
    public String getListDepartments(Map<String, Object> model) {
        List<DepartmentDto> departmentList = service.getDepartmentDtoList();
        model.put("departmentsList", departmentList);
        Map<String, String> responseMessages = new HashMap<>();
        String message = messageManager.getEnvironment().getProperty("hui");
        responseMessages.put("DEP_RECORD_UPDATE_SUCCESS_MESSAGE", message);
        model.put("responseMessages", responseMessages);
        return "departments_list";
    }

    @GetMapping("/department_update_page")
    public String getDepartmentUpdatePage(Map<String, Object> model,
                                          @RequestParam(name = "departmentId") long id,
                                          @RequestParam(name = "departmentTitle")String title)
    {
        model.put("departmentId", id);
        model.put("departmentTitle", title);
        return "department_update_form";
    }

    @PostMapping
    public String saveDepartment(Map<String, Object> model, @RequestParam(name = "newDepartmentTitle") String title) {
        service.saveDepartment(title);
        List<DepartmentDto> departmentList = service.getDepartmentDtoList();
        model.put("departmentsList", departmentList);
        return "departments_list";
    }

    @PostMapping("/delete/{id}")
    public String deleteDepartment(Map<String, Object> model, @PathVariable(name = "id") long id) {
        service.removeDepartment(id);
        List<DepartmentDto> departmentList = service.getDepartmentDtoList();
        model.put("departmentsList", departmentList);
        return "departments_list";
    }

    @PostMapping("/update/{id}")
    public String updateDepartment(Map<String, Object> model,
                                   @PathVariable(name = "id") long id,
                                   @RequestParam(name = "title") String title)
    {

        service.updateDepartment(id, title);
        List<DepartmentDto> departmentList = service.getDepartmentDtoList();
        model.put("departmentsList", departmentList);
        return "departments_list";
    }



}

/*@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/user2/{id}")
    public @ResponseBody
    User getById2(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return userService.getById(id);
    }

    @GetMapping("/addUser")
    public String createUserPage() {
        return "createUser";
    }


    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) throws Exception {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}*/
