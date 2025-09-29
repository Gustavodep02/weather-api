package weather_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import weather_api.model.Day;
import weather_api.model.Weather;

@RestController
@RequestMapping("/")
public class WeatherController {

    @Value("${weather.api.key}")
    private String apiKey;

    @GetMapping("{location}")
    @Cacheable(value = "weather", key = "#location")
    public String getWeatherForLocation(@PathVariable String location) {
        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                        + location + "?unitGroup=metric&key=" + apiKey,
                Weather.class);
        System.out.println(weather);
        Day current = weather.getCurrentDay();
        return "Weather(" +
                "address=" + weather.getAddress() +
                ", description=" + weather.getDescription() +
                ", datetime=" + (current != null ? current.getDatetime() : null) +
                ", temp=" + (current != null ? current.getTemp() : null) +
                ")";
    }
}
