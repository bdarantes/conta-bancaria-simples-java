package banco.services;

import java.util.ArrayList;
import java.util.List;
import banco.models.*;


public class BancoService {

    private List<Conta>contas = new ArrayList<>();

    public ContaCorrente criarContaCorrente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        ContaCorrente conta = new ContaCorrente(cliente);
        contas.add(conta);
        return conta;
    }

    public ContaPoupanca criarContaPoupanca(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        ContaPoupanca conta = new ContaPoupanca(cliente);
        contas.add(conta);
        return conta;
    }

    public Conta buscarContaPorNumero(int numero) {
        return contas.stream()
        .filter(c -> c.getNumero() == numero)
        .findFirst()
        .orElse(null);
    }
    public List<Conta> listarContas() {
        return contas;
    }

}