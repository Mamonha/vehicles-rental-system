package views;
import java.util.Scanner;

import controllers.LocadoraController;
import controllers.VeiculoController;
import models.entities.ClienteEntity;
import models.entities.LocadoraEntity;
import models.entities.VeiculoEntity;

import java.util.List;

public class VeiculoView {
    private static Scanner scanner = new Scanner(System.in);
    private static VeiculoController veiculoController = new VeiculoController();
    private static LocadoraController locadoraController = new LocadoraController();

    public static void cadastrarVeiculo() {
        VeiculoEntity veiculo = new VeiculoEntity();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Disponível (true/false): ");
        boolean disponivel = scanner.nextBoolean();
        System.out.print("Custo por dia: ");
        float custoPorDia = scanner.nextFloat();
        System.out.print("Quilometragem: ");
        int quilometragem = scanner.nextInt();
        LocadoraView.visualizarLocadoras();
        System.out.print("ID da Locadora: ");
        Long locadoraId = scanner.nextLong();
        LocadoraEntity locadora =  locadoraController.findById(locadoraId);

        scanner.nextLine();

        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculo.setPlaca(placa);
        veiculo.setDisponivel(disponivel);
        veiculo.setCustoPorDia(custoPorDia);
        veiculo.setQuilometragem(quilometragem);
        veiculo.setLocadora(locadora);
        veiculoController.create(veiculo);
    }

    public static void visualizarVeiculos() {
        List<VeiculoEntity> veiculos = veiculoController.index();
        System.out.println(veiculos);
        String header = String.format("%-10s %-20s %-30s %-40s %-50s", "ID", "Modelo", "Ano", "Placa","Quilometragem");
        System.out.println(header);
        System.out.println("=".repeat(header.length()));

        for (VeiculoEntity veiculo : veiculos) {
            String row = String.format("%-10s %-20s %-30s %-40s %-50s",
                    veiculo.getId(),
                    veiculo.getModelo(),
                    veiculo.getAno(),
                    veiculo.getPlaca(),
                    veiculo.getQuilometragem()
            );
            System.out.println(row);
        }

    }

    public  static void deletarVeiculo() {
        visualizarVeiculos();
        System.out.println("Digite o ID do veiculo que deseja remover:");
        Long veiculoId = scanner.nextLong();
        scanner.nextLine();
        VeiculoEntity veiculoToRemove = veiculoController.findById(veiculoId);
        if (veiculoToRemove != null) {
            veiculoController.delete(veiculoToRemove);
        } else {
            System.out.println("O Veiculo nao existe na base de dados!");
        }
    }

    public static void editarVeiculo(){
        VeiculoEntity veiculo = new VeiculoEntity();
        visualizarVeiculos();
        System.out.println("Digite o ID do Veiculo que deseja editar:");
        Long veiculoId = scanner.nextLong();
        VeiculoEntity newVeiculo = veiculoController.findById(veiculoId);
        scanner.nextLine();
        System.out.println("Digite o novo Modelo (atual: " + newVeiculo.getModelo() + "):");
        String novoModelo = scanner.nextLine();
        System.out.println("Digite o novo Ano (atual: " + newVeiculo.getAno() + "):");
        int novoAno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a nova Placa (atual: " + newVeiculo.getPlaca() + "):");
        String novaPlaca = scanner.nextLine();
        System.out.println("Veiculo estará disponivel?(true/false) (atual: " + newVeiculo.isDisponivel() + "):");
        boolean isDisponivel = scanner.nextBoolean();
        System.out.println("Custo por dia do veiculo (atual: R$ " + newVeiculo.getCustoPorDia() + "):");
        float custoPorDia = scanner.nextFloat();
        System.out.println("Digite a nova Quilometragem do veiculo(atual: " + newVeiculo.getQuilometragem() + "):");
        int novaQuilometragem = scanner.nextInt();
        LocadoraView.visualizarLocadoras();
        System.out.println("Digite o ID de qual Locadora esse veiculo pertence: ");
        Long locadoraId = scanner.nextLong();

        LocadoraController locadoraController = new LocadoraController();
        LocadoraEntity locadora = locadoraController.findById(locadoraId);

        veiculo.setId(newVeiculo.getId());
        veiculo.setAno(novoAno);
        veiculo.setModelo(novoModelo);
        veiculo.setQuilometragem(novaQuilometragem);
        veiculo.setDisponivel(isDisponivel);
        veiculo.setPlaca(novaPlaca);
        veiculo.setCustoPorDia(custoPorDia);
        veiculo.setLocadora(locadora);
        veiculoController.update(veiculo);
    }
}