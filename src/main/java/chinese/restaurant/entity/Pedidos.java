package chinese.restaurant.entity;

import jakarta.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cliente_id")
    private int clienteId;

    @Column(name = "mozo_id")
    private int mozoId;

    @Column(name = "fecha_pedido")
    private Date fechaPedido;


    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoPedido estado;


    @Column(name = "estadoP")
    @JsonFormat
    private boolean estadoP = true;

    public boolean getEstadoP(){
        return this.estadoP;
    }
    public void  setEstadoP(Boolean estadoP){
        this.estadoP = estadoP;
    }

    public Pedidos() {
    }

    // Constructor con parámetros
    public Pedidos(int clienteId, int mozoId, Date fechaPedido, EstadoPedido estado) {
        this.clienteId = clienteId;
        this.mozoId = mozoId;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getMozoId() {
        return mozoId;
    }

    public void setMozoId(int mozoId) {
        this.mozoId = mozoId;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}
