package pl.marczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marczyk.model.RgbLedStrip;
import pl.marczyk.repository.RgbLedStripRepository;

import java.util.List;

/**
 * Created by marcin.marczyk on 2016-03-24.
 */
@Service
public class RgbLedStripService {

	private RgbLedStripRepository rgbLedStripRepository;

	@Autowired
	public RgbLedStripService(RgbLedStripRepository rgbLedStripRepository) {
		this.rgbLedStripRepository = rgbLedStripRepository;
	}

	public List<RgbLedStrip> findAll() {
		return rgbLedStripRepository.findAll();
	}

	public RgbLedStrip findOneById(Long id) {
		return rgbLedStripRepository.findOne(id);
	}

}
