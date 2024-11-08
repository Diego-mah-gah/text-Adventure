import model.Cena;
import model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Cena currentScene;
    private ArrayList<Produto> inventario;

    public Main() {
        inventario = new ArrayList<>();
        currentScene = new Cena1();
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("José Luiz queria fazer algo especial para sua mãe, Ana. Decidiu preparar um bolo para surpreendê-la.");
        System.out.println("A caminho da cozinha, sentiu uma leve preguiça. 'Vou descansar no quarto um pouco, ou sigo para a cozinha?', pensou.");
        System.out.println("Digite 'quarto' para descansar ou 'cozinha' para seguir em frente:");
        System.out.println("COMANDO: USE");

        while (currentScene != null) {
            currentScene.executarCena(scanner);
        }
    }

    public ArrayList<Produto> getInventario() {
        return inventario;
    }

    public void mudarCena(Cena novaCena) {
        currentScene = novaCena;
    }
    private class Cena1 extends Cena {
        @Override
        public void executarCena(Scanner scanner) {
            String comando = scanner.nextLine().toUpperCase();
            if (comando.equals("USE COZINHA")) {
                System.out.println("Você foi até a cozinha.");
                mudarCena(new Cena2());
            } else if (comando.equals("USE QUARTO")) {
                System.out.println("Oloco, vai deixar sua mãe sem bolinho mesmo?");
            } else {
                System.out.println("COMANDO INVÁLIDO");
            }
        }
    }
    private class Cena2 extends Cena {
        private ArrayList<Produto> itensNecessarios;

        public Cena2() {
            itensNecessarios = new ArrayList<>();
            itensNecessarios.add(new Produto("FORMA"));
            itensNecessarios.add(new Produto("BATEDEIRA"));
            itensNecessarios.add(new Produto("TIGELA"));
        }
        @Override
        public void executarCena(Scanner scanner) {
            System.out.println("Já na cozinha, José Luiz decidiu que era hora de começar a preparação!");
            System.out.println("Ele começou a pensar nos utensílios domésticos que seriam necessários para o processo.");
            System.out.println("Olhou para o armário e viu uma FORMA, algumas TIGELAs e também a BATEDEIRA.");
            System.out.println("Com seu conhecimento sobre bolos, ele achou que esses itens seriam suficientes...");
            System.out.println("Ajude José a coletar os utensílios necessários!");
            System.out.println("Digite GET [ITEM] para pegar um item.");
            while (getInventario().size() < 3) {
                String comando = scanner.nextLine().toUpperCase();
                boolean itemEncontrado = false;

                for (Produto item : itensNecessarios) {
                    if (comando.equals("GET " + item.getNome()) && !getInventario().contains(item)) {
                        getInventario().add(item);
                        System.out.println(item.getNome() + " em mãos!");
                        itemEncontrado = true;
                        break;
                    }
                }
                if (!itemEncontrado) {
                    System.out.println("COMANDO INVÁLIDO. Tente pegar a FORMA, BATEDEIRA ou TIGELA.");
                }
            }
            System.out.println("Todos os utensílios foram coletados, PARABÉNS!");
            mudarCena(new Cena3());
        }
    }
    private class Cena3 extends Cena {
        private ArrayList<String> ingredientesAdicionados;

        public Cena3() {
            ingredientesAdicionados = new ArrayList<>();
        }
        @Override
        public void executarCena(Scanner scanner) {
            System.out.println("José Luiz posicionou todos os utensílios sobre a mesa e começou a separar os ingredientes.");
            System.out.println("Ele pegou o OVO, o OLEO, a FARINHA, o ACUCAR e a MASSA para bolos com sabor de baunilha.");
            System.out.println("Agora, ele precisa adicionar esses ingredientes na tigela para começar a mistura.");
            System.out.println("Ajude José Luiz adicionando os ingredientes na tigela!");
            System.out.println("Digite USE [INGREDIENTE] para pegar e adicionar o ingrediente na tigela.");
            String[] ingredientes = {"OVO", "OLEO", "FARINHA", "ACUCAR", "MASSA"};
            while (ingredientesAdicionados.size() < ingredientes.length) {
                String comando = scanner.nextLine().toUpperCase();
                boolean comandoValido = false;

                for (String ingrediente : ingredientes) {
                    if (comando.equals("USE " + ingrediente)) {
                        if (!ingredientesAdicionados.contains(ingrediente)) {
                            ingredientesAdicionados.add(ingrediente);
                            System.out.println(ingrediente + " adicionado!");
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
            mudarCena(new Cena4());
        }
    }
    private class Cena4 extends Cena {
        @Override
        public void executarCena(Scanner scanner) {
            System.out.println("Percebeu que com aqueles ingredientes, só seria possível a realização de um bolinho simples.");
            System.out.println("Deciciu então fazer uma cobertura saborosa, para valorizar seu bolinho...");
            System.out.println("ficou indeciso sobre usar CREME DE NINHO ou CHOCOLATE.");
            System.out.println("Ajude o José Luiz a escolher a melhor cobertura!");
            System.out.println("COMANDO USE");

            while (true) {
                String comando = scanner.nextLine().toUpperCase();
                if (comando.equals("USE CHOCOLATE")) {
                    System.out.println("Vishhhh, mas a mamãe não gosta de cobertura de chocolate!!!!");
                } else if (comando.equals("USE CREME DE NINHO")) {
                    System.out.println("Creme de Ninho é a favorita da mamãe!!!");
                    mudarCena(new Cena5());
                    break;
                } else {
                    System.out.println("COMANDO INVALIDO");
                }
            }
        }
    }
    private class Cena5 extends Cena {
        @Override
        public void executarCena(Scanner scanner) {
            System.out.println("Com a massa pronta, você untou a forma e despejou a massa.");
            System.out.println("Agora precisa preparar a cobertura de CREME DE NINHO.");

            while (true) {
                String comando = scanner.nextLine().toUpperCase();
                if (comando.equals("USE CREME DE NINHO")) {
                    System.out.println("Cobertura Finalizada...");
                    System.out.println("PRONTINHO... AGORA É SÓ SABOREAR ESSE DELICIOSO BOLINHO!!!");
                    mudarCena(null);
                    break;
                } else {
                    System.out.println("COMANDO INVALIDO");
                }
            }
        }
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }
}