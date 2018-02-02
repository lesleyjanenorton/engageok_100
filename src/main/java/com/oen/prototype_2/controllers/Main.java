package com.oen.prototype_2.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oen.prototype_2.models.Event;
import com.oen.prototype_2.models.Organization;
import com.oen.prototype_2.models.User;
import com.oen.prototype_2.services.UserService;
import com.oen.prototype_2.validator.UserValidator;

@Controller
public class Main {
	private UserService userService;
	private UserValidator userValidator;
	
	public Main(UserService userService, UserValidator uValidator) {
		this.userService = userService;
		this.userValidator = uValidator;
	}
	
	@RequestMapping("/login")
	public String registerForm(@Valid @ModelAttribute("user")User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		System.out.println("---login.jsp---");
		if(error != null) {
			System.out.println("Unsuccessful LOGIN");
			model.addAttribute("errorMessage", "Your credentials are bad!");
		}
		if(logout != null) {
			System.out.println("Successful LOGOUT");
			model.addAttribute("logoutMessage", "You have logged out.");
		}
		return "login.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, Model model, HttpSession session, RedirectAttributes redirectAttributes ) {
		System.out.println("-----1-----");
		userValidator.validate(user, result);
		System.out.println("-----2-----");
		if(result.hasErrors()) {
			return "login.jsp";
		} else {
			System.out.println("1");
			int[] anArray;
			anArray = new int[0];
			System.out.println(anArray);
			System.out.println(userService.findAllUsers());
			if(userService.findAllUsers() == null) {
				System.out.println("saving as ADMIN");
				
				userService.saveUserWithAdminRole(user);
				user.setIsFlagged(false);
				user.setNumberOfOrgs(0);
				user.setNumberOfEvents(0);
				userService.saveUser(user);
				return "redirect:/login";
			}else {
				System.out.println("saving as USER");
				user.setIsFlagged(false);
				user.setNumberOfOrgs(0);
				user.setNumberOfEvents(0);
				userService.saveWithUserRole(user);
				redirectAttributes.addFlashAttribute("regSuc", "Thank you for registering");
				return "redirect:/login";
			}
		}
	}
	
	// ENDLOGIN 		ENDLOGIN		ENDLOGIN		ENDLOGIN
	
	//--------------------------------------------------

		// HOME		HOME		HOME		HOME
	
		@RequestMapping(value = {"/", "/home"})
		public String home(Principal principal, Model model) {
			System.out.println("home");
			String username = principal.getName();
			model.addAttribute("loggedUser", userService.findByEmail(username));
			model.addAttribute("events", userService.findAllEvents());
			return "dashboard.jsp";
		}
	
		@RequestMapping("/about")
		public String about() {
			return "about.jsp";
		}
		
		@RequestMapping("/organization_creation")
		public String orgCreate(Principal principal, @Valid @ModelAttribute("organization")Organization organization, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
			String username = principal.getName();
			model.addAttribute("loggedUser", userService.findByEmail(username));
			
			return "createOrganization.jsp";
		}
		
		@PostMapping("/organization_creation")
		public String createOrg(Principal principal, @Valid @ModelAttribute("organization")Organization organization, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
			String username = principal.getName();
			System.out.println(organization.getName());
			System.out.println('-');
			System.out.println(organization.getDescription());
			User user = userService.findByEmail(username);
			organization.setLocal_admin(user.getId());
			organization.setNumberOfActivists(0);
			
			userService.saveOrganization(organization);
			return "redirect:/";
		}
	
		@RequestMapping("/profile/{id}")
		public String userPage(@PathVariable("id")Long id, Model model) {
			System.out.println("---------user profile------------");
			
			model.addAttribute("user", userService.findOneUser(id));
			model.addAttribute("userOrgs", userService.findAllOrganizations());
			model.addAttribute("userEvents", userService.findAllEvents());
			return "userprofile.jsp";
		}
	
		@RequestMapping("/event_creation/{id}")
		public String eventCreate(@PathVariable("id")Long id, Principal principal, @Valid @ModelAttribute("event")Event event, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
			System.out.println("---------event creation------------");
			
			String username = principal.getName();
			model.addAttribute("loggedUser", userService.findByEmail(username));
			return "createEvent.jsp";
		} 
		
		@PostMapping("/event_creation/event_creation")
		public String createEvent(Principal principal, @Valid @ModelAttribute("event")Event event, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
			System.out.println("---------ATTEMPTING event create---------------");
			String username = principal.getName();
			System.out.println(event.getName());
			System.out.println('-');
			System.out.println(event.getDescription());
			User user = userService.findByEmail(username);
			event.setUser_id(user.getId());
			userService.saveEvent(event);
			return "redirect:/";
		}
		
		@RequestMapping("/eventpage/{id}")
		public String eventPage(Principal principal, @PathVariable("id")Long id, Model model) {
			String username = principal.getName();
			model.addAttribute("loggedUser", userService.findByEmail(username));
			model.addAttribute("event", userService.findOneEvent(id));
			model.addAttribute("userOrgs", userService.findAllOrganizations());
			model.addAttribute("userEvents", userService.findAllEvents());
			Long userStarted = userService.findOneEvent(id).getUser_id();
			User userStartedBy = userService.findOneUser(userStarted);
			model.addAttribute("userStartedBy", userStartedBy);
			return "eventpage.jsp";
		}
		
		@RequestMapping("/editProfile/{id}")
		public String editProfile(Principal principal, @PathVariable("id")Long id, Model model, @Valid @ModelAttribute("user")User user, RedirectAttributes redirectAttributes) {
			String username = principal.getName();
			model.addAttribute("loggedUser", userService.findByEmail(username));
			return "editProfile.jsp";
		}
		
		@PostMapping("/editProfile/editProfile")
		public String profileEdit(Principal principal, @Valid @ModelAttribute("user")User user, BindingResult result, Model model, RedirectAttributes redirectAttributes, @RequestParam(value="first_name")String first_name, @RequestParam(value="last_name")String last_name, @RequestParam(value="zipcode")Integer zipcode, @RequestParam(value="password")String password, @RequestParam(value="username")String username) {
			System.out.println("---------ATTEMPTING EDIT user---------------");
			
			
			String username1 = principal.getName();
			model.addAttribute("loggedUser", userService.findByEmail(username1));
			User userToEdit = userService.findByEmail(username1);
			userToEdit.setFirst_name(first_name);
			userToEdit.setLast_name(last_name);
			userToEdit.setZipcode(zipcode);
			userToEdit.setPassword(password);
			userToEdit.setUsername(username);
			userService.saveUser(userToEdit);
			return "redirect:/";
		}
	
} // END Main.java