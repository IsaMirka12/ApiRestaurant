
package chinese.restaurant.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonFormat
    private int id;
    @JsonFormat
    private String nombre;

    @Column(name = "email")
    @JsonFormat
    private String email;

    @JsonFormat
    private String dni;
    @JsonFormat
    private String rol;

    @Getter
    @JsonFormat
    private String clave;

    @JsonFormat
    private String telefono;

    @JsonFormat
    private boolean estado = true;

    public String getNombre(){
        return this.nombre;
    }

    public boolean getEstado(){
        return this.estado;
    }
    public void  setEstado(Boolean estado){
        this.estado = estado;
    }

    public Number getId(){
        return this.id;
    }
}
