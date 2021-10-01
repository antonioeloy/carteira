package br.com.alura.carteira.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {

	private int id;
	private String ticker;
	private BigDecimal preco;
	private int quantidade;
	private LocalDate data;
	private TipoTransacao tipo;

	public Transacao() {
	}

	public Transacao(String ticker, BigDecimal preco, int quantidade, LocalDate data, TipoTransacao tipo) {
		this.ticker = ticker;
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
		this.tipo = tipo;
	}
	
	public Transacao(int id, String ticker, BigDecimal preco, int quantidade, LocalDate data, TipoTransacao tipo) {
		this.id = id;
		this.ticker = ticker;
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Transacao [ticker=" + ticker + ", preco=" + preco + ", quantidade=" + quantidade + ", data=" + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", tipo=" + tipo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public TipoTransacao getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}

}
