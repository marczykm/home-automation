package pl.marczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marczyk.service.RgbLedStripService;
import pl.marczyk.service.SwitchService;

/**
 * Created by marcin.marczyk on 2016-03-23.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private SwitchService switchService;

	@Autowired
	private RgbLedStripService rgbLedStripService;

	@RequestMapping

	public String home(Model model) {
		model.addAttribute("switches", switchService.findAll());
		model.addAttribute("rgbleds", rgbLedStripService.findAll());
		return "home";
	}

}
