package views;
import java.util.Scanner;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Clientes");
            System.out.println("2. Locadoras");
            System.out.println("3. Locações");
            System.out.println("4. Veículos");
            System.out.println("5. Pagamentos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuLocadoras();
                    break;
                case 3:
                    menuLocacoes();
                    break;
                case 4:
                    menuVeiculos();
                    break;
                case 5:
                    menuPagamentos();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Obrigado por utilizar o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuClientes() {
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menu Clientes ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Visualizar Clientes");
            System.out.println("3. Remover Clientes");
            System.out.println("4. Editar Clientes");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ClienteView.cadastrarCliente();
                    break;
                case 2:
                    ClienteView.visualizarClientes();
                    break;
                case 3:
                    ClienteView.deletarCliente();
                    break;
                case 4:
                    ClienteView.editarCliente();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuLocadoras() {
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menu Locadoras ===");
            System.out.println("1. Criar Locadora");
            System.out.println("2. Visualizar Locadoras");
            System.out.println("3. Editar Dados Locadora");
            System.out.println("4. Remover Locadora");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LocadoraView.criarLocadora();
                    break;
                case 2:
                    LocadoraView.visualizarLocadoras();
                    break;
                case 3:
                    LocadoraView.editarLocadora();
                    break;
                case 4:
                    LocadoraView.deletarLocadora();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuLocacoes() {
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menu Locações ===");
            System.out.println("1. Realizar Locação");
            System.out.println("2. Visualizar Locações");
            System.out.println("3. Encerrar Locação");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LocacaoView.registrarLocacao();
                    break;
                case 2:
                    LocacaoView.visualizarLocacoes();
                    break;
                case 3:
                    LocacaoView.encerrarLocacao();
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuVeiculos() {
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menu Veículos ===");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Visualizar Veículos");
            System.out.println("3. Remover Veiculo");
            System.out.println("4. Editar Veiculos");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    VeiculoView.cadastrarVeiculo();
                    break;
                case 2:
                    VeiculoView.visualizarVeiculos();
                    break;
                case 3:
                    VeiculoView.deletarVeiculo();
                    break;
                case 4:
                    VeiculoView.editarVeiculo();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuPagamentos() {
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menu Pagamentos ===");
            System.out.println("1. Historico de Pagamentos");
            System.out.println("2. Atualizar status de Pagamentos");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    PagamentoView.historicoPagamentos();
                    break;
                case 2:
                    PagamentoView.autalizarStatusPagamento();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}