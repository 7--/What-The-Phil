package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Steps implements Runnable {

	@GetMapping("/steps")
	public String steps() {
		return "steps";
		
	}

	@GetMapping("/arthur")
	public String arthur() {
		return "arthur";
		
	}
	
	@GetMapping("/twitter")
	public String twitter() {
		return "twitter";
		
	}
	
	@GetMapping("/heythere/*")
	@ResponseBody
	public String arthurall() {
		return "oh noo";
		
	}

	@Override
	public void run() {
		System.out.println("1");// 2113
	}

}
