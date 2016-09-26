package peoplesHealth;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/peoplesHealth")
public class SearchController {

	@RequestMapping(value = "/searchFoodByName" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> searchFoodByName(@RequestParam String searchString){
		ResponseEntity<String> foodDetails =  new ResponseEntity<String>("ok",  HttpStatus.OK);

		return foodDetails;
		
	}
}
