package com.edstem.scheduled_tasks.controllers;

import com.edstem.scheduled_tasks.contracts.WeatherAlertDTO;
import com.edstem.scheduled_tasks.services.WeatherAlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class WeatherAlertController {
	private final WeatherAlertService weatherAlertService;

	public WeatherAlertController(WeatherAlertService weatherAlertService) {
		this.weatherAlertService = weatherAlertService;
	}

	@GetMapping
	public List<WeatherAlertDTO> getCurrentAlerts() {
		return weatherAlertService.getCurrentAlerts();
	}
}
