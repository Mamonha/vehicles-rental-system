package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import Helpers.HandleDates;
import controllers.LocacaoController;
import controllers.VeiculoController;
import models.entities.ClienteEntity;
import models.entities.LocacaoEntity;
import models.entities.VeiculoEntity;

import java.util.List;

public class LocacaoView {
    private static Scanner scanner = new Scanner(System.in);
    private static LocacaoController locacaoController = new LocacaoController();

    public static void visualizarLocacoes() {
        List<LocacaoEntity> locacoes = locacaoController.index();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss z");
        String header = String.format("%-10s %-20s %-30s %-40s %-50s %-60s", "ID", "Data inicio", "Data fim", "Valor", "Modelo", "Disponivel");
        System.out.println(header);
        System.out.println("=".repeat(header.length()));
        if(locacoes != null){
            for (LocacaoEntity locacao : locacoes) {
                LocalDate dataInicioFormatada = HandleDates.convertToLocalDateViaInstant(locacao.getDataInicio());
                LocalDate dataFimFormatada = HandleDates.convertToLocalDateViaInstant(locacao.getDataFim());
                String row = String.format("%-10d %-20s %-30s %-40s %-50s %-60s",
                        locacao.getId(),
                        dataInicioFormatada,
                        dataFimFormatada,
                        locacao.getValorTotal(),
                        locacao.getVeiculo().getModelo(),
                        locacao.getVeiculo().isDisponivel()
                );
                System.out.println(row);
            }
        }else{
            System.out.println("Nenhum cliente cadastrado!");
        }
    }

    public  static void registrarLocacao(){
        float custoTotal = 0;
        LocacaoEntity locacao = new LocacaoEntity();
        ClienteEntity cliente = new ClienteEntity();

        System.out.print("Data de Início (dd/MM/yyyy):");
        String dataInicio = scanner.nextLine();
        System.out.print("Data de Fim (dd/MM/yyyy): ");
        String dataFim = scanner.nextLine();
        VeiculoView.visualizarVeiculos();
        System.out.print("Escolha o ID do veiculo que deseja locar:");
        Long veiculoId = scanner.nextLong();
        scanner.nextLine();
        ClienteView.visualizarClientes();
        System.out.print("Escolha o ID do cliente:");
        Long clienteId = scanner.nextLong();
        scanner.nextLine();
        Long diffInDays = HandleDates.diffInDays(dataInicio, dataFim);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicioParsed = new Date();
        Date dataFimParsed = new Date();
        try{
           dataInicioParsed = dateFormat.parse(dataInicio);
           dataFimParsed= dateFormat.parse(dataFim);

        }catch (ParseException err){
            err.printStackTrace();
        }

        VeiculoController veiculoController = new VeiculoController();
        VeiculoEntity veiculoEscolhido = veiculoController.findById(veiculoId);

        if(veiculoEscolhido != null && veiculoEscolhido.isDisponivel()){
            custoTotal = diffInDays * veiculoEscolhido.getCustoPorDia();
        }


        cliente.setId(clienteId);
        locacao.setDataInicio(dataInicioParsed);
        locacao.setDataFim(dataFimParsed);
        locacao.setValorTotal(custoTotal);
        locacao.setVeiculo(veiculoEscolhido);
        locacao.setCliente(cliente);
        locacaoController.create(locacao);
        System.out.println("Veiculo "+ veiculoEscolhido.getModelo() + " alocado até o dia " + dataFim );
        System.out.println("Com valor total de: R$"+ custoTotal);
    }

    public static void encerrarLocacao(){
        visualizarLocacoes();
        System.out.print("Digite o ID da locação que deseja encerrar:");
        Long idLocacao = scanner.nextLong();
        scanner.nextLine();

        locacaoController.encerrarLocacao(idLocacao);

    }
}
