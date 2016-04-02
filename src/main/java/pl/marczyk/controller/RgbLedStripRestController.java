package pl.marczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.marczyk.model.RgbLedStrip;
import pl.marczyk.service.RgbLedStripService;

import java.util.List;

/**
 * Created by marcin.marczyk on 2016-03-24.
 */
@RestController
@RequestMapping("/api/rgbled")
public class RgbLedStripRestController {

	private RgbLedStripService switchService;

	@Autowired
	public RgbLedStripRestController(RgbLedStripService switchService) {
		this.switchService = switchService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<RgbLedStrip> findAll() {
		return switchService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RgbLedStrip findById(@PathVariable Long id) {
		return switchService.findOneById(id);
	}

}
