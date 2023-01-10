package hackerrank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FurnitureController {

	@RequestMapping(value ="/health",method= RequestMethod.GET)
	public String checkHealth(){
		return "Furniture Application up and running";
	}
}
