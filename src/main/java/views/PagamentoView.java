package views;

import controllers.PagamentoController;
import enums.StatusPagamento;

import models.entities.PagamentoEntity;
import java.util.Scanner;
import java.util.List;

public class PagamentoView {
    private static PagamentoController pagamentoController = new PagamentoController();
    private static Scanner scanner = new Scanner(System.in);
    public static void historicoPagamentos() {

        List<PagamentoEntity> pagamentos = pagamentoController.index();
        if(pagamentos != null){
            String header = String.format("%-10s %-20s %-30s %-40s %-50s", "ID","Cliente", "Total(R$)", "Status", "Data");
            System.out.println(header);
            System.out.println("=".repeat(header.length()));
                for (PagamentoEntity pagamento : pagamentos) {
                    String row = String.format("%-10s %-20s %-30s %-40s %-50s",
                            pagamento.getId(),
                            pagamento.getCliente().getNome(),
                            pagamento.getTotal(),
                            StatusPagamento.deInt(pagamento.getStatus()),
                            pagamento.getData()
                    );
                    System.out.println(row);
                }
        }
    }

    public static void autalizarStatusPagamento() {
        historicoPagamentos();
        System.out.println("Escolha o ID do pagamento que deseja atualizar o status: ");
        Long veiculoId = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Escolha o novo status do pagamento: ");
        System.out.println("1 - Pendente");
        System.out.println("2 - Aprovado");
        System.out.println("3 - Rejeitado");
        int status = scanner.nextInt();
        scanner.nextLine();
        pagamentoController.updateStatus(veiculoId, status);
    }
}
