package banco.models;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override

    public String getTipo() {
        return "Conta Corrente";
    }
    
}
