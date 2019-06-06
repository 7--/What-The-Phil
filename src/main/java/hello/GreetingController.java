package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController implements Runnable {

	@GetMapping("/")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		Thread t = new Thread(new GreetingController());
		t.start();
		System.out.println("2");
		t.run();
		System.out.println("3");
		return "greeting";//ok
	}


	@Override
	public void run() {
		System.out.println("1");// 2113
	}

}
