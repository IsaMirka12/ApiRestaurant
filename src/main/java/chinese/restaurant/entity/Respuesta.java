package chinese.restaurant.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component  // Esto convierte Respuesta en un bean de Spring
public class Respuesta {
    @JsonFormat
    private String message;
    @JsonFormat
    private Boolean status;

    public Respuesta() {}

    public Respuesta(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}
