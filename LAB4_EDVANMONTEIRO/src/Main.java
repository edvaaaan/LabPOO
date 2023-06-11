import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * O Código da Main foi um aproveitamento do LAB3
 * 
 * @author Edvan Monteiro - 121210590
 */

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        MrBet betinho = new MrBet();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        while (true) {
            opcao = menu(scanner);
            opcaoEscolhida(opcao, betinho, scanner);
        }

    }

    private static String menu(Scanner scanner) {
        System.out.print(
                "\n---\nMENU\n" +
                        "(M)Minha inclusão de times\n" +
                        "(R)Recuperar time\n" +
                        "(.)Adicionar campeonato\n" +
                        "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
                        "(E)Exibir campeonatos que o time participa\n" +
                        "(T)Tentar a sorte e status\n" +
                        "(!)Já pode fechar o programa!\n" +
                        "Opção> ");
        return scanner.nextLine().toUpperCase();
    }

    private static void opcaoEscolhida(String opcao, MrBet betinho, Scanner sc) {
        switch (opcao) {
            case "M":
                incluiTime(betinho, sc);
                break;
            case "R":
                recuperaTime(betinho, sc);
                break;
            case ".":
                adicionaCampeonato(betinho, sc);
                break;
            case "B":
                incluiTimeCampeonato(betinho, sc);
                break;
            case "E":
                exibeCampeonatosTime(betinho, sc);
                break;
            case "T":
                tentaSorte(betinho, sc);
                break;
            case "!":
                fecha();
                break;
            default:
                System.out.println("Não existe essa opção, tente novamente!");
        }
    }

    public static void incluiTime(MrBet betinho, Scanner sc) {
        System.out.println("Código: ");
        String codigo = sc.nextLine();
        if (codigo.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        System.out.println("Nome: ");
        String nome = sc.nextLine();
        if (nome.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        System.out.println("Mascote: ");
        String mascote = sc.nextLine();
        if (mascote.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        try {
            System.out.print(betinho.incluiTime(codigo, nome, mascote));
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void recuperaTime(MrBet betinho, Scanner sc) {
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        if (codigo.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        try {
            System.out.print(betinho.recuperaTime(codigo));
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void adicionaCampeonato(MrBet betinho, Scanner sc) {
        System.out.print("Campeonato: ");
        String campeonato = sc.nextLine();
        if (campeonato.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        System.out.print("Participantes: ");
        int participantes = Integer.parseInt(sc.nextLine());

        try {
            System.out.print(betinho.adicionaCampeonato(campeonato, participantes));
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void incluiTimeCampeonato(MrBet betinho, Scanner sc) {
        System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
        String opcao2 = sc.nextLine().toUpperCase();
        if (opcao2.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        switch (opcao2) {
            case "I":
                incluiOpcao2(betinho, sc);
                break;
            case "V":
                verificaTimeCampeonato(betinho, sc);
                break;
        }
    }

    private static void verificaTimeCampeonato(MrBet betinho, Scanner sc) {
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        if (codigo.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        System.out.print("Campeonato: ");
        String campeonato = sc.nextLine();
        if (campeonato.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        try {
            System.out.print(betinho.verificaTimeCampeonato(codigo, campeonato));
        } catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        }

    }

    private static void incluiOpcao2(MrBet betinho, Scanner sc) {
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        if (codigo.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        System.out.print("Campeonato: ");
        String campeonato = sc.nextLine();
        if (campeonato.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        try {
            System.out.print(betinho.incluiTimeCampeonato(campeonato, codigo));
        } catch (IllegalArgumentException | NoSuchElementException | IllegalStateException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void exibeCampeonatosTime(MrBet betinho, Scanner sc) {
        System.out.print("Time: ");
        String codigo = sc.nextLine();
        if (codigo.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        try {
            System.out.print(betinho.getTime(codigo));
        } catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void tentaSorte(MrBet betinho, Scanner sc) {
        System.out.print("(A)Apostar ou (S)Status das Apostas? ");
        String opcao2 = sc.nextLine().toUpperCase();
        if (opcao2.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        switch (opcao2) {
            case "A":
                aposta(betinho, sc);
                break;
            case "S":
                status(betinho, sc);
                break;
        }
    }

    private static void aposta(MrBet betinho, Scanner sc) {
        System.out.print("Código:");
        String codigo = sc.nextLine();
        if (codigo.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        System.out.print("Campeonato: ");
        String campeonato = sc.nextLine();
        if (campeonato.isBlank()) {
            throw new IllegalArgumentException("ERRO!");
        }

        System.out.println("Colocação: ");
        int colocacao = scanner.nextInt();

        System.out.println("Valor: ");
        double valor = scanner.nextDouble();

        try {
            System.out.print(betinho.criaAposta(codigo, campeonato, colocacao, valor));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }

    private static void status(MrBet betinho, Scanner sc) {
        System.out.print(betinho.mostraAposta());
    }

    private static void fecha() {
        System.out.println("\nPor hoje é só pessoal!");
        System.exit(0);
    }
}
