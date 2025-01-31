
package chinese.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonFormat
    private int id;
    @JsonFormat
    private int pedido_id;

    @Column(name = "monto")
    @JsonFormat
    private double monto;

    @JsonFormat
    private String metodo_pago;
    @JsonFormat
    private Date fecha_pago;


}
