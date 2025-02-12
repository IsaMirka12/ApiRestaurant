
package chinese.restaurant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "carta")
public class Carta {

    @JsonFormat
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull()
    @JsonFormat
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @JsonFormat
    @Column(name = "descripcion")
    private String descripcion;
    @JsonFormat
    @Column(name = "precio")
    private double precio;
    @JsonFormat
    @Column(name = "categoria")
    private String categoria;

    @Setter
    @JsonFormat
    @Column(name = "disponible")
    private boolean disponible = true;

    @JsonFormat
    private boolean estado = true;

    public boolean getEstado(){
        return this.estado;
    }
    public void  setEstado(Boolean estado){
        this.estado = estado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

}
