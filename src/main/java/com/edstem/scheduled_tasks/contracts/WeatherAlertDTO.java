package com.edstem.scheduled_tasks.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherAlertDTO {
	private String location;
	private double temperature;
	private double humidity;
	private String alertLevel;
	private LocalDateTime timeStamp;
}
