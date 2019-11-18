package br.com.fiap.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="pedidos")
public class Pedido {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private PedidosPK pedidoPK;

    @Temporal(value= TemporalType.TIMESTAMP)
    @Column(name="DATAPEDIDO")
    private Date dataPedido;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDCLIENTE")
    private Cliente cliente;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="pedido")
    private Set<Item> itens = new LinkedHashSet<Item>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public PedidosPK getPedidoPK() {
        return pedidoPK;
    }

    public void setPedidoPK(PedidosPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }
}
