import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private String currentScene;
    private ArrayList<String> inventario;

    public Game() {
        currentScene = "Cena1";
        inventario = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("José Luiz é um menino muito esforçado, e o seu desejo é agradar sua Mãe Ana...");
        System.out.println("Ele pensou... E então decidiu fazer um bolinho saboroso para deixar ela ainda mais feliz.");
        System.out.println("Levantou do sofá e foi caminhando em direção à cozinha.");
        System.out.println("Mas, no percurso bateu aquele cansaço...");
        while (true) {
            switch (currentScene) {
                case "Cena1":
                    cena1(scanner);
                    break;
                case "Cena2":
                    cena2(scanner);
                    break;
                case "Cena3":
                    cena3(scanner);
                    break;
                case "Cena4":
                    cena4(scanner);
                    break;
                case "Cena5":
                    cena5(scanner);
                    break;
                default:
                    System.out.println("Cena desconhecida.");
            }
        }
    }

    private void cena1(Scanner scanner) {
        System.out.println("Vou até a COZINHA ou sigo para o QUARTO me deitar?");
        String comando = scanner.nextLine().toUpperCase();
        if (comando.equals("USE COZINHA")) {
            System.out.println("Você foi até a cozinha.");
            currentScene = "Cena2";
        } else if (comando.equals("USE QUARTO")) {
            System.out.println("Oloco, vai deixar sua mãe sem bolinho mesmo?");
        } else {
            System.out.println("COMANDO INVALIDO");
        }
    }

    private void cena2(Scanner scanner) {
        System.out.println("Sobre a mesa ele posicionou alguns ingredientes, pegou a farinha, o ovo, o açúcar, o óleo, escolheu a massa de Baunilha.");
        System.out.println("Mas percebeu que ainda faltavam alguns utensílios domésticos para a preparação.");
        System.out.println("Ele se direcionou até o armário para pegar a FORMA, a BATEDEIRA e a TIGELA.");
        System.out.println("Digite GET [ITEM] para pegar um dos itens necessários.");

        while (inventario.size() < 3) {
            String comando = scanner.nextLine().toUpperCase();

            switch (comando) {
                case "GET FORMA":
                    if (!inventario.contains("FORMA")) {
                        inventario.add("FORMA");
                        System.out.println("Forma em mãos!!!");
                    } else {
                        System.out.println("Você já pegou a forma.");
                    }
                    break;

                case "GET BATEDEIRA":
                    if (!inventario.contains("BATEDEIRA")) {
                        inventario.add("BATEDEIRA");
                        System.out.println("Essa batedeira é bem potente...");
                    } else {
                        System.out.println("Você já pegou a batedeira.");
                    }
                    break;

                case "GET TIGELA":
                    if (!inventario.contains("TIGELA")) {
                        inventario.add("TIGELA");
                        System.out.println("Essa tigela vai ser ótima para misturar tudo!!!");
                    } else {
                        System.out.println("Você já pegou a tigela.");
                    }
                    break;

                default:
                    System.out.println("COMANDO INVÁLIDO. Tente pegar a FORMA, BATEDEIRA ou TIGELA.");
                    break;
            }

        }
        System.out.println("Todos os utensílios foram coletados");

         currentScene = "Cena3";
    }

    private void cena3(Scanner scanner) {
        System.out.println("Sobre a mesa ele posicionou tudo que seria utilizado para preparação de seu bolo.");
        System.out.println("Percebeu que com aqueles ingredientes, só seria possivel a realização de um bolinho simples :( ");
        System.out.println("Como sua intenção era agradar a sua mãe, decidiu então fazer uma deliciosa cobertura!!! ");
        System.out.println("Mas ficou indeciso sobre usar CREME DE NINHO ou CHOCOLATE.");

            while(true) {
                String comando = scanner.nextLine().toUpperCase();

                if (comando.equals("USE CHOCOLATE")) {
                    System.out.println("Vishhhh, mas a mamãe não gosta de cobertura de chocolate!!!!");
                } else if (comando.equals("USE CREME DE NINHO")) {
                    System.out.println("Creme de Ninho é a favorita da mamãe!!!.");
                    currentScene = "Cena4";
                    break;
                } else {
                    System.out.println("COMANDO INVALIDO");
                }
            }

    }


    private void cena4(Scanner scanner) {
        System.out.println("José então decide partir para a preparação do bolo...");
        System.out.println("Ajude ele adicionando os ingredientes na tigela...");
        System.out.println("Comandos: USE OVO, USE OLEO, USE FARINHA, USE ACUCAR, USE MASSA.");

        ArrayList<String> ingredientesAdicionados = new ArrayList<>();
        String[] ingredientes = {"OVO", "OLEO", "FARINHA", "ACUCAR", "MASSA"};

        while (ingredientesAdicionados.size() < 5) {
            String comando = scanner.nextLine().toUpperCase();
            boolean comandoValido = false;

            for (String ingrediente : ingredientes) {
                if (comando.equals("USE " + ingrediente)) {
                    if (!ingredientesAdicionados.contains(ingrediente)) {
                        ingredientesAdicionados.add(ingrediente);
                        System.out.println(ingrediente + " TODOS FORAM ADICIONADOS... PARABÉNS!");
                    }
                    comandoValido = true;
                    break;
                }
            }

            if (!comandoValido) {
                System.out.println("PRESTA ATENÇÃO AMIGUINHO...");

            }
        }
        System.out.println("Você misturou tudo com a batedeira.");
        currentScene = "Cena5";
    }

    private void cena5(Scanner scanner) {
        System.out.println("Com a massa pronta, você untou a forma e despejou a massa.");
        System.out.println("Agora precisa preparar a cobertura de CREME_DE_NINHO.");
        System.out.println("Digite USE CREME_DE_NINHO.");

        while (true) {
            String comando = scanner.nextLine().toUpperCase();
            if (comando.equals("USE CREME DE NINHO")) {
                System.out.println("Cobertura Finalizada...");
                System.out.println("PRONTINHO... AGORA É SÓ SABOREAR ESSE DELICIOSO BOLINHO!!!");
                break;
            } else {
                System.out.println("COMANDO INVALIDO");
            }
        }

        System.exit(0);
    }
}
