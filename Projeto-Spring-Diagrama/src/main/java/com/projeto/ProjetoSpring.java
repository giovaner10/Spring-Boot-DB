package com.projeto;

import com.projeto.domain.Cliente;
import com.projeto.domain.ItemPedido;
import com.projeto.domain.enums.EstadoPagamento;
import com.projeto.domain.enums.TipoCliente;
import com.projeto.domain.item.Categoria;
import com.projeto.domain.local.Cidade;
import com.projeto.domain.local.Endereco;
import com.projeto.domain.local.Estado;
import com.projeto.domain.item.Produto;
import com.projeto.domain.pedido.Pagamento;
import com.projeto.domain.pedido.PagamentoComBoleto;
import com.projeto.domain.pedido.PagamentoComCartao;
import com.projeto.domain.pedido.Pedido;
import com.projeto.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication @AllArgsConstructor
public class ProjetoSpring implements CommandLineRunner {

	private final CategoriaRepository categoriaRepository;
	private final ProdutoRepository produtoRepository;
	private final CidadeRepository cidadeRepository;
	private final EstadoRepository estadoRepository;
	private  final ClienteRepository clienteRepository;
	private final EnderecoRepository enderecoRepository;
	private final PedidoRepository pedidoRepository;
	private final PagamentoRepository pagamentoRepository;
	private final ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpring.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informaticaa");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		Cliente cli1 = new Cliente(null, "Maria", "maria@gmail", "123456789", TipoCliente.PESSOA_FISICA);

		cli1.getTelefones().addAll(Arrays.asList("155353526","3783645"));

		Endereco e1 =  new Endereco(null, "rua flores", "300" , "apt 330", "jardim", "3636636", cli1, c1);
		Endereco e2 =  new Endereco(null, "av matos", "105" , "sala 800", "centro", "88264646", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		Pedido ped1 = new Pedido(null, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("30/09/2017 10:32"),
				cli1,e1);

		Pedido ped2 = new Pedido(null, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("10/10/2017 19:35"),
				cli1,e2);

		Pagamento pagto1 =  new PagamentoComCartao(null, EstadoPagamento.QUITADO,ped1, 6);
		Pagamento pagto2 =  new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,ped2, new SimpleDateFormat
				("dd/MM/yyyy HH:mm").parse("20/10/2017 00:00"), null);

		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);


		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped1.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));









		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2, ip3));


	}
}
