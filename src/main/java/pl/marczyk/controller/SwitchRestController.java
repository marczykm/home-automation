package pl.marczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.marczyk.model.Switch;
import pl.marczyk.service.SwitchService;

import java.util.List;

/**
 * Created by marcin.marczyk on 2016-03-24.
 */
@RestController
@RequestMapping("/api/switch")
public class SwitchRestController {

	private SwitchService switchService;

	@Autowired
	public SwitchRestController(SwitchService switchService) {
		this.switchService = switchService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Switch> findAll() {
		return switchService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Switch findById(@PathVariable Long id) {
		return switchService.findOneById(id);
	}

	@RequestMapping(value = "/{id}/{state}", method = RequestMethod.GET)
	public String on(@PathVariable Long id, @PathVariable int state) {
		switchService.turn(id, state);
		return "ok";
	}

	@RequestMapping(value = "/{id}/toggle", method = RequestMethod.GET)
	public int toggle(@PathVariable Long id) {
		return switchService.toggle(id);
	}

}
