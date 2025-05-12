package com.edstem.scheduled_tasks.repositories;

import com.edstem.scheduled_tasks.models.WeatherAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherAlertRepository extends JpaRepository<WeatherAlert,Long> {

}
