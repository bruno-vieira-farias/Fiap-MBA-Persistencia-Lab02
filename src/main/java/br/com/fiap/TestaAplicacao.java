package br.com.fiap;

import br.com.fiap.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.Date;

public class TestaAplicacao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaVendas");
        EntityManager em = emf.createEntityManager();
        VendasHelper dao = new VendasHelper(em);
        try {
//Definindo o cliente
            Cliente cliente = new Cliente();
            cliente.setId(10);
            cliente.setEmpresa("Fiap");
//Definindo o Endereco
            Endereco endereco = new Endereco();
            endereco.setRua("Lins de Vasconcelos");
            endereco.setCidade("São Paulo");
            endereco.setCep("01538-001");
            endereco.setCliente(cliente);
//Defnindo o pedido
            PedidosPK pkpedido = new PedidosPK();
            pkpedido.setCodigo(100);
            pkpedido.setCategoria("Livros");
            Pedido pedido = new Pedido();
            pedido.setDataPedido(new Date());
            pedido.setPedidoPK(pkpedido);
            pedido.setCliente(cliente);
//Definindo dois itens
            Item item1 = new Item();
            item1.setQuantidade(2);
            Item item2 = new Item();
            item2.setQuantidade(3);
            //Fazendo as associações
            pedido.getItens().add(item1);
            pedido.getItens().add(item2);
            cliente.getEnderecos().add(endereco);
            cliente.getPedidos().add(pedido);
            dao.salvar(cliente);
            JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}