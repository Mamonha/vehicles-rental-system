package views;

import java.util.Scanner;

import controllers.LocadoraController;
import models.entities.ClienteEntity;
import models.entities.LocadoraEntity;

import java.util.List;

public class LocadoraView {
    private static Scanner scanner = new Scanner(System.in);
    private static LocadoraController locadoraController = new LocadoraController();

    public static void criarLocadora() {

        LocadoraEntity locadora = new LocadoraEntity();

        System.out.print("Nome:");
        String nome = scanner.nextLine();
        System.out.print("CNPJ:");
        String cnpj = scanner.nextLine();
        System.out.print("Telefone:");
        String telefone = scanner.nextLine();
        System.out.print("Email:");
        String email = scanner.nextLine();

        if (!nome.isEmpty()) locadora.setNome(nome);
        if (!cnpj.isEmpty()) locadora.setCnpj(cnpj);
        if (!telefone.isEmpty()) locadora.setTelefone(telefone);
        if (!email.isEmpty()) locadora.setEmail(email);

        locadoraController.create(locadora);
    }

    public static void visualizarLocadoras() {
        List<LocadoraEntity> locadoras = locadoraController.index();
        String header = String.format("%-10s %-20s %-30s %-40s %-50s", "ID", "Nome", "CNPJ", "Telefone", "Email");
        System.out.println(header);
        System.out.println("=".repeat(header.length()));

        for (LocadoraEntity locadora : locadoras) {
            String row = String.format("%-10s %-20s %-30s %-40s %-50s",
                    locadora.getId(),
                    locadora.getNome(),
                    locadora.getCnpj(),
                    locadora.getTelefone(),
                    locadora.getEmail());
            System.out.println(row);
        }
        scanner.nextLine();
    }

    public static void editarLocadora(){
        visualizarLocadoras();
        System.out.println("Digite o ID da Locadora que deseja editar:");
        Long locadoraId = scanner.nextLong();
        LocadoraEntity newLocadora = locadoraController.findById(locadoraId);
        scanner.nextLine();
        System.out.println("Digite o novo nome (atual: " + newLocadora.getNome() + "):");
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo CNPJ (atual: " + newLocadora.getCnpj() + "):");
        String novoCnpj = scanner.nextLine();
        System.out.println("Digite o novo telefone (atual: " + newLocadora.getTelefone() + "):");
        String novoTelefone = scanner.nextLine();
        System.out.println("Digite o novo email (atual: " + newLocadora.getEmail() + "):");
        String novoEmail = scanner.nextLine();


        newLocadora.setCnpj(novoCnpj);
        newLocadora.setEmail(novoEmail);
        newLocadora.setTelefone(novoTelefone);
        newLocadora.setNome(novoNome);
        locadoraController.update(newLocadora);
    }

    public static void deletarLocadora(){
        visualizarLocadoras();
        System.out.println("Digite o ID da locadora que deseja deletar:");
        Long locadoraId = scanner.nextLong();
        scanner.nextLine();

        LocadoraEntity locadora = locadoraController.findById(locadoraId);
        if (locadora != null) {
            locadoraController.delete(locadora);
        } else {
            System.out.println("Locadora não encontrada.");
        }
    }
}

