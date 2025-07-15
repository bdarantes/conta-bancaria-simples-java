package banco.models;

import java.math.BigDecimal;

public abstract class Conta {
    protected static int contadorContas = 1000;

    protected int numero;
    protected BigDecimal saldo = BigDecimal.ZERO;
    protected Cliente cliente;
  
    public Conta(Cliente cliente) {
        this.numero = contadorContas++;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void depositar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) >0 ) {
            saldo = saldo.add(valor);
        } else {
            throw new RuntimeException("O valor digitado não é válido");
        }
    }

    public void sacar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) > 0 && saldo.compareTo(valor) >=0) {
            saldo = saldo.subtract(valor);
        } else {
            throw new RuntimeException("Saldo insuficiente ou o valor não é válido");
        }
    }

    public void transferir(Conta destino, BigDecimal valor) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public abstract String getTipo();

    
@Override
    public String toString() {
        return getTipo() + " Nº " + numero + " - Cliente: " + cliente.getNome() + " - Saldo: R$ " + String.format("%.2f", saldo);
    }
  
   
    
}
