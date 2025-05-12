package com.edstem.scheduled_tasks.models;

import com.edstem.scheduled_tasks.enums.AlertLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "weather_alerts")
public class WeatherAlert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String location;
	private double temperature;
	private double humidity;
	private LocalDateTime timestamp;

	@Enumerated(EnumType.STRING)
	private AlertLevel alertLevel;

}