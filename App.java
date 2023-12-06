import java.util.Scanner;
import java.util.Stack;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma expressão matemática para verificar a parametrização:");
        String expressao = scanner.nextLine();

        if (verificarParametrizacao(expressao)) {
            System.out.println("Expressão correta.");
        } else {
            System.out.println("Expressão incorreta.");
        }

        scanner.close();
    }

    public static boolean verificarParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty() || !parametrosCorrespondentes(pilha.pop(), caractere)) {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }

    private static boolean parametrosCorrespondentes(char aberto, char fechado) {
        return (aberto == '(' && fechado == ')') ||
               (aberto == '[' && fechado == ']') ||
               (aberto == '{' && fechado == '}');
    }
}
