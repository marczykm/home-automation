package pl.marczyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marczyk.model.Switch;

/**
 * Created by marcin.marczyk on 2016-03-24.
 */
@Repository
public interface SwitchRepository extends JpaRepository<Switch, Long> {

}
