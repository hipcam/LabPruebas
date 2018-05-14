package com.tecsup.gestion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.gestion.model.Department;
import com.tecsup.gestion.services.DepartmentService;
   
/**
 * Handles requests for the application home page.
 */
@Controller
public class DepartmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping("/admin/menu")
	public String menu() {

		return "/admin/menu";
	}
	
	
	@GetMapping("/admin/dep/list")
	public String list(@ModelAttribute("SpringWeb") Department department, ModelMap model) {

		try {
			model.addAttribute("departments", departmentService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/dep/list";
	}
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{department_id}")
	public ModelAndView home(@PathVariable int department_id, ModelMap model) {

		ModelAndView modelAndView = null;
		Department dep = new Department();
		try {
			dep = departmentService.find(department_id);
			logger.info(dep.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", dep);

		return modelAndView;
	}
	
}
