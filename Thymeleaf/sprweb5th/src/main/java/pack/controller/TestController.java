package pack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "thleaf/")
public class TestController {
	@GetMapping("ex1")
	public String abc1(Model model) {
		DataDto dto = new DataDto();
		dto.setId("kbs1");
		dto.setName("공기밥");
		dto.setPrice(1000);
		dto.setRegDate(LocalDate.now());
		
		model.addAttribute("dto", dto);
		return "show1";
	}
	
	@GetMapping("ex2")
	public ModelAndView adb2() {
		List<DataDto> list = new ArrayList<DataDto>();
		
		for(int i=1; i <= 3; i++) {
			DataDto dto = new DataDto();
			dto.setId("ks" + i);
			dto.setName("신상품" + i);
			dto.setPrice(2000 * i);
			dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		
		ModelAndView andView = new ModelAndView("show2");
		andView.addObject("dtos", list);
		return andView;
	}
	
	@GetMapping("ex3")
	public String adb3(Model model) {
		List<DataDto> list = new ArrayList<DataDto>();
		
		for(int i=1; i <= 3; i++) {
			DataDto dto = new DataDto();
			dto.setId("ks" + i);
			dto.setName("신상품" + i);
			dto.setPrice(2000 * i);
			dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		
		model.addAttribute("dtos", list);
		return "show3";
	}

	@GetMapping("ex4")
	public String abc4(Model model,
					   @RequestParam("param1") String param1,
					   @RequestParam("param2") String param2) {
		System.out.println(param1 + " " + param2);
		model.addAttribute("arg1", param1);
		model.addAttribute("arg2", param2);
		return "show4";
	}

	// layout
	@GetMapping("ex5")
	public String abc5(){

		return "show5";
	}

	@GetMapping("ex5_1")
	public String abc5etc(){
		return "show5-1";
	}
}
