package com.edstem.scheduled_tasks.repositories;

import com.edstem.scheduled_tasks.models.WeatherAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, Long> {

	List<WeatherAlert> findByTimestampAfter(LocalDateTime time);

	void deleteByTimestampBefore(LocalDateTime time);
}
