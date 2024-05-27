package enums;

public enum StatusPagamento {
    PENDENTE(1),
    APROVADO(2),
    REJEITADO(3);

    private int valor;

    StatusPagamento(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static StatusPagamento deInt(int valor) {
        for (StatusPagamento status : values()) {
            if (status.getValor() == valor) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido para StatusPagamento");
    }
}
