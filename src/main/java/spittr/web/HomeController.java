package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//����һ��������
@Controller
@RequestMapping("/")
public class HomeController {

	//����ԡ�/����GET����
	@RequestMapping(method=RequestMethod.GET)
	public String home()
	{
	return "home";
	}
}
