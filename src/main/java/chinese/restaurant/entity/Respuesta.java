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
    @JsonFormat
    private Number idPedido;
    @JsonFormat
    private String tipo;
    @JsonFormat
    private Number idUsuario;

    public Respuesta() {}

    public Respuesta(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public Respuesta(String message, boolean status, String tipo, Number idUsuario) {
        this.message = message;
        this.status = status;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
    }


    public Respuesta(String message, boolean status, Number idPedido) {
        this.message = message;
        this.status = status;
        this.idPedido = idPedido;
    }
}
