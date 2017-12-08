package mvc_everything.controller;

import java.util.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import mvc_everything.model.Admin;
import mvc_everything.service.AdminService;

@Controller
public class AdminController
{
	@AutoWired
	AdminService adminService;
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	String ShowAdmin(@RequestParam(required=false) Long id, ModelMap model)
	{
		List<Admin> admins=adminService.findAll();
		model.addAttribute("admins",admins);
		return "admins";
	}
	
	@RequestMapping(value="/newadmin",method=RequestMethod.GET)
	String NewAdmin(@RequestParam(required=false)Long id, ModelMap model)
	{
		Admin admin=id=null ? new Admin() : AdminService.get(id);
		model.addAttribute("admins",admin);
		return "NewAdmin";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	String saveAdmnin(@ModelAttribute Admin admin, ModelMap model) {
		System.out.println("guardando: " + admin.getId());
		adminService.save(admin);
		return ShowAdmin(admin.getId(), model);
	}
	
	
}