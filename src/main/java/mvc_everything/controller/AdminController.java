package mvc_everything.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import mvc_everything.model.Admin;
import mvc_everything.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  AdminService adminService;

  @RequestMapping
  public String Home(ModelMap model, @RequestParam(value = "message", required = false) String message) {
    model.addAttribute("message", message);
    return "admin/home";
  }

  @RequestMapping("/login")
  public String loginAdmin(ModelMap model, @RequestParam(value = "message", required = false) String message) {
    Admin admin = new Admin();
    model.addAttribute("admin", admin);
    model.addAttribute("title", "Login");
    model.addAttribute("message", message);
    return "admin/sign";
  }

  @RequestMapping(value = "/signIn", method = RequestMethod.POST)
  public String signInAdmin(@ModelAttribute Admin adminSession, ModelMap model) {
    if(adminService.validate(adminSession) == true) {
      return "redirect:/admin?message=Signed In";
    }
    else {
      return "redirect:/admin?message=Username or Password is wrong!";
    }
  }

  @RequestMapping("/register")
  public String registerUser(ModelMap model) {
	adminService.addAdmin();
    return "redirect:/admin/login?message=Root Existente";
  }
/*
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveUser(@ModelAttribute User userRegistered, ModelMap model) {
    userService.save(userRegistered);
    return "redirect:/user?message=Usuario Registrado";
  }

  /*
  @RequestMapping
  public String listarUsuarios(ModelMap model,
                               @RequestParam(value = "message", required = false) String message) {
    List<User> users = userService.getAll();
    model.addAttribute("users", users);
    model.addAttribute("message", message);
    return "user/list";
  }
  */

}
