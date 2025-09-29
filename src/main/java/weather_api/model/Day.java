package weather_api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Day {
    private String datetime;
    private Double temp;
    private String conditions;
}
