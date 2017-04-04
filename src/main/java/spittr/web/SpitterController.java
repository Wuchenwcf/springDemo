package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private SpitterRepository spitterRepository;
	
	//自动注入
	@Autowired
	public SpitterController(SpitterRepository sp)
	{
		this.spitterRepository=sp;
	}
	//处理对“/spitter/register”的请求
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegistrationForm()
	{
		System.out.println("REgisterForm");
		return "registerForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(Spitter spitter)
	{
		spitterRepository.save(spitter);
		return "redirect:/spitter/"+spitter.getUserName();
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username,Model model)
	{
		Spitter spitter=spitterRepository.findByUserName(username);
		model.addAttribute(spitter);
		return "profile";
	}
}
