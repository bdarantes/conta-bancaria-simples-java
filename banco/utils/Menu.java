package banco.utils;

import java.math.BigDecimal;
import java.util.Scanner;
import banco.models.Conta;
import banco.services.BancoService;

public class Menu {

    private BancoService bancoService = new BancoService();
    private Scanner scanner = new Scanner(System.in);

    public void exibir() {
        while (true) {
            System.out.println("\n --- Menu---");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Listar Contas");
            System.out.println("4. Depositar");
            System.out.println("5. Sacar");
            System.out.println("6. Transferir");
            System.out.println("0. Sair");
            System.out.println("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {

                    case 1 -> criarConta("corrente");
                    case 2 -> criarConta("poupanca");
                    case 3 -> listarContas();
                    case 4 -> depositar();
                    case 5 -> sacar();
                    case 6 -> transferir();
                    case 0 -> {System.out.println("Encerrando...");return;}
                    default -> System.out.println("A Opção não é valida");
                }
            } catch(Exception e) {
                System.out.println("Erro "+e.getMessage());
            }

        }    
    }

    private void criarConta(String tipo) {
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        Conta conta = tipo.equals("corrente") 
            ? bancoService.criarContaCorrente(nome, cpf)
            : bancoService.criarContaPoupanca(nome, cpf);

        System.out.println("Conta criada: "+conta);
    }

    private void listarContas() {
        for (Conta conta: bancoService.listarContas()){
            System.out.println(conta);
        }
    }
    private void depositar() {
        Conta conta = buscarConta();
        System.out.println("Valor: ");
        BigDecimal valor = new BigDecimal(scanner.nextLine());
        conta.depositar(valor);
        System.out.println("Depósito realizado. Novo Saldo: R$ "+conta.getSaldo());
    }
    private void sacar() {
        Conta conta = buscarConta();
        System.out.println("Valor: ");
        BigDecimal valor = new BigDecimal(scanner.nextLine());
        conta.sacar(valor);
        System.out.println("Saquele realizado. Novo saldo: R$ "+conta.getSaldo());
    }

    private void transferir() {
        System.out.println("Conta origem: ");
        int origem = scanner.nextInt();
        System.out.println("Valor: ");
        BigDecimal valor = new BigDecimal(scanner.nextLine());
        
        System.out.println("Conta destino: ");
        int destino = scanner.nextInt();
        scanner.nextLine();
        Conta contaOrigem = bancoService.buscarContaPorNumero(origem);
        Conta contaDestino = bancoService.buscarContaPorNumero(destino);

        if(contaOrigem == null || contaDestino ==null ) {
            throw new RuntimeException("Conta de origem ou destino não encontrada.");
        }
        contaOrigem.transferir(contaDestino, valor);
       
    }
    private Conta buscarConta() {
        System.out.println("Número da conta: ");
        int numero = scanner.nextInt();
        Conta conta = bancoService.buscarContaPorNumero(numero);
        if(conta == null) {
            throw new RuntimeException("Conta não encontrada: ");
            
        }
        return conta;
    }
    
}
