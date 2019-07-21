package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@Override
	public void run() {
		System.out.println("1");// 2113
	}

}
