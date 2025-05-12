package com.edstem.scheduled_tasks.services;

import com.edstem.scheduled_tasks.contracts.WeatherAlertDTO;
import com.edstem.scheduled_tasks.enums.AlertLevel;
import com.edstem.scheduled_tasks.models.WeatherAlert;
import com.edstem.scheduled_tasks.repositories.WeatherAlertRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class WeatherAlertService {
	private final WeatherAlertRepository weatherAlertRepository;

	public WeatherAlertService(WeatherAlertRepository weatherAlertRepository) {
		this.weatherAlertRepository = weatherAlertRepository;
	}

	public void saveMockWeatherData() {
		String[] locations = {"Mumbai", "Kolkatha", "Pune", "Lucknow"};
		Random random = new Random();

		for (String loc : locations) {
			double temp = random.nextDouble() * 45;
			double humidity = random.nextDouble() * 100;

			AlertLevel level = getAlertLevel(temp);

			WeatherAlert alert = WeatherAlert.builder()
					.location(loc)
					.temperature(temp)
					.humidity(humidity)
					.alertLevel(level)
					.timestamp(LocalDateTime.now())
					.build();

			weatherAlertRepository.save(alert);
		}
	}

	private AlertLevel getAlertLevel(double temperature) {
		if (temperature > 40) return AlertLevel.SEVERE;
		if (temperature > 30) return AlertLevel.MODERATE;
		return AlertLevel.NORMAL;
	}

	public void purgeOldAlerts() {
		LocalDateTime time = LocalDateTime.now().minusDays(30);
		weatherAlertRepository.deleteByTimestampBefore(time);
	}

	public List<WeatherAlertDTO> getCurrentAlerts() {
		LocalDateTime time = LocalDateTime.now().minusHours(1);
		return weatherAlertRepository.findByTimestampAfter(time)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public WeatherAlertDTO convertToDTO(WeatherAlert alert) {
		return WeatherAlertDTO.builder()
				.location(alert.getLocation())
				.temperature(alert.getTemperature())
				.humidity(alert.getHumidity())
				.timeStamp(alert.getTimestamp())
				.alertLevel(String.valueOf(alert.getAlertLevel()))
				.build();
	}
}
