package pl.marczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marczyk.model.Switch;
import pl.marczyk.repository.SwitchRepository;
import pl.marczyk.utils.ScriptRunner;

import java.util.List;

/**
 * Created by marcin.marczyk on 2016-03-24.
 */
@Service
public class SwitchService {

	private SwitchRepository switchRepository;

	@Autowired
	public SwitchService(SwitchRepository switchRepository) {
		this.switchRepository = switchRepository;
	}

	public List<Switch> findAll() {
		return switchRepository.findAll();
	}

	public Switch findOneById(Long id) {
		return switchRepository.findOne(id);
	}

	public void turn(Long id, int state) {
		Switch aSwitch = switchRepository.findOne(id);
		if (state == 0)
			aSwitch.on();
		else if (state == 1)
			aSwitch.off();
		runScript(aSwitch);
		switchRepository.save(aSwitch);
	}

	public int toggle(Long id) {
		Switch aSwitch = switchRepository.findOne(id);
		aSwitch.toggle();
		runScript(aSwitch);
		switchRepository.save(aSwitch);
		return aSwitch.getValue();
	}

	private void runScript(Switch aSwitch) {
		switch (aSwitch.getValue()) {
			case 1:
				ScriptRunner.run(aSwitch.getOnScript());
				break;
			case 0:
				ScriptRunner.run(aSwitch.getOffScript());
				break;
		}
	}

}
