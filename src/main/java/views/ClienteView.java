package views;
import java.util.Scanner;

import controllers.ClienteController;
import controllers.EnderecoController;
import controllers.LocadoraController;
import models.entities.ClienteEntity;
import models.entities.EnderecoAPI;
import models.entities.EnderecoEntity;


import java.util.List;

public class ClienteView {
    private static Scanner scanner = new Scanner(System.in);
    private static ClienteController clienteController = new ClienteController();
    private static LocadoraController locadoraController = new LocadoraController();
    private static EnderecoController enderecoController = new EnderecoController();

    public static void cadastrarCliente() {
        System.out.print("Nome: ");

        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        LocadoraView.visualizarLocadoras();
        System.out.print("ID da Locadora: ");
        Long locadoraId = scanner.nextLong();
        scanner.nextLine();
        ClienteEntity cliente = new ClienteEntity();
        cliente.setTelefone(telefone);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setLocadora( locadoraController.findById(locadoraId));
        Long clienteId = (Long) clienteController.create(cliente);
        menuEndereco(clienteId);
    }

    public static List<ClienteEntity> visualizarClientes() {
        List<ClienteEntity> clientes = clienteController.index();
        if(clientes != null){
        String header = String.format("%-10s %-30s %-50s %-70s", "ID", "Nome", "Telefone", "Email");
        System.out.println(header);
        System.out.println("=".repeat(header.length()));
            for (ClienteEntity cliente : clientes) {
                String row = String.format("%-10d %-30s %-50s %-70s",
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getTelefone(),
                        cliente.getEmail()
                );
                System.out.println(row);
            }
            return clientes;
        }
        scanner.nextLine();
        return null;
    }

    public static boolean deletarCliente(){
        List <ClienteEntity> clientes = visualizarClientes();
        if(clientes != null){
            System.out.println("Digite o ID do usuario que deseja remover:");
            Long locadoraId = scanner.nextLong();
            scanner.nextLine();

            ClienteEntity clienteToRemove = clienteController.findById(locadoraId);
            if(clienteToRemove != null){
                clienteController.delete(clienteToRemove);
                return true;
            }else {
                System.out.println("O cliente nao existe na base de dados!");
            }
        }
        return false;
    }


    public static void editarCliente(){

        visualizarClientes();
        System.out.println("Digite o ID do Cliente que deseja editar:");
        Long clienteId = scanner.nextLong();
        scanner.nextLine();
        ClienteEntity newCliente = clienteController.findById(clienteId);
        System.out.println(newCliente.getLocadora());
        System.out.println("Digite o novo nome (atual: " + newCliente.getNome() + "):");
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo email (atual: " + newCliente.getEmail() + "):");
        String novoEmail = scanner.nextLine();
        System.out.println("Digite o novo telefone (atual: " + newCliente.getTelefone() + "):");
        String novoTelefone = scanner.nextLine();

        newCliente.setEmail(novoEmail);
        newCliente.setTelefone(novoTelefone);
        newCliente.setNome(novoNome);

        clienteController.update(newCliente);

    }


    public static void menuEndereco(Long clienteId){
        try {
            System.out.println("Digite o CEP:");
            String cep = scanner.nextLine();

            EnderecoAPI enderecoResponse = enderecoController.findEndereco(cep);
            EnderecoEntity newEndereco = new EnderecoEntity();
            ClienteEntity cliente = clienteController.findById(clienteId);

            newEndereco.setCliente(cliente);
            newEndereco.setEstado(enderecoResponse.getUf());
            newEndereco.setComplemento(enderecoResponse.getComplemento());
            newEndereco.setCidade(enderecoResponse.getLocalidade());
            newEndereco.setBairro(enderecoResponse.getBairro());
            newEndereco.setDdd(enderecoResponse.getDdd());
            newEndereco.setLogradouro(enderecoResponse.getLogradouro());
            newEndereco.setCep(cep);
            enderecoController.create(newEndereco);

        } catch (NullPointerException e) {
            MainMenu.exibirMenu();
        }
    }

}