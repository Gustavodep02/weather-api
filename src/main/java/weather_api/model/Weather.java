package weather_api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
public class Weather implements Serializable {
    String address;
    String description;
    String datetime;
    Double temp;
    private List<Day> days;

    public Day getCurrentDay() {
        return (days != null && !days.isEmpty()) ? days.get(0) : null;
    }
}
