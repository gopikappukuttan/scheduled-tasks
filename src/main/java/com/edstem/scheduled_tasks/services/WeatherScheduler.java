package com.edstem.scheduled_tasks.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class WeatherScheduler {
	private final WeatherAlertService weatherAlertService;

	@Scheduled(fixedRate = 1800000)
	public void generateWeatherAlerts() {
		try {
			weatherAlertService.saveMockWeatherData();
			log.info("Weather alerts generated successfully.");
		} catch (Exception e) {
			System.err.println("weather fetch failed: " + e.getMessage());
		}
	}

	@Scheduled(cron = "0 0 0 * * *")
	public void purgeAlerts() {
		try {
			weatherAlertService.purgeOldAlerts();
			log.info("Old weather alerts purged.");
		} catch (Exception e) {
			System.err.println("Alert purge failed: " + e.getMessage());
		}
	}
}

