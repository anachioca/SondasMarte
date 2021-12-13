import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception {

        boolean novaMissao = true;
        char dir = 'N', c;
        String linha;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem Vindo ao Sistema de Exploração de Marte!");

        while(novaMissao){
            System.out.println("\nNova missão espacial iniciada...");
            int x = -1, y = -1, horizontal = -1, vertical = -1, nSondas = -1;

            // definição e criação do planalto a ser explorado.
            do {
                System.out.println("\nQuais as coordenadas do ponto superior direito do planalto que deseja explorar? (Apenas números inteiros e positivos.)");
                try {
                    horizontal = scanner.nextInt();
                    vertical = scanner.nextInt();
                } catch (java.util.InputMismatchException e) { // se o usuário digitar algo que não é um inteiro
                    scanner.next();
                }
            } while (horizontal < 0 || vertical < 0);
            
            Planalto planalto = new Planalto(horizontal+1, vertical+1);

            // definição da quantidade de sondas a serem enviadas e criação da central de controle responsável pela missão.
            do {
                System.out.println("\nQuantas sondas deseja enviar para Marte? (Apenas números inteiros e positivos.)");
                try {
                    nSondas = scanner.nextInt();
                } catch (java.util.InputMismatchException e) { // se o usuário digitar algo que não é um inteiro
                    scanner.next();
                }
            } while (nSondas < 0);
            
            ControleSondas CC = new ControleSondas(planalto, nSondas);
            
            // aterrissagem e movimentação de cada sonda.
            for (int i = 0; i < nSondas; i++){
                
                do {
                    System.out.println("\nQuais as coordenadas e direção de aterrissagem da " + (i+1) + "a sonda? (ex.: 1 1 N)");
                    try {
                        x = scanner.nextInt();
                        y = scanner.nextInt();
                        dir = scanner.next().charAt(0);

                    } catch (java.util.InputMismatchException e) { // se o usuário digitar algo que não é um inteiro
                        scanner.next();
                    }
                } while (x < 0 || y < 0);

                // Se nova sonda for criada e aterrissada com sucesso, continuar operação de exploração.
                if (CC.novaSonda(x, y, dir)){
                    linha = scanner.nextLine(); // consumindo o \n que está no scanner.
                    System.out.println("\nQual a sequência de instruções a serem seguidas pela " + (i+1) + "a sonda?");
                    linha = scanner.nextLine();

                    char[] instrucoes = new char[linha.length()];
                    for (int j = 0; j < linha.length(); j++) {
                        instrucoes[j] = linha.charAt(j);
                    }
                    CC.moverSonda(i, instrucoes);
                }                
            }

            System.out.println("\nPosição final das sondas:");
            CC.posicaoSondas();

            System.out.println("\nAperte S para realizar uma nova missão ou N para encerrar o sistema.");
            while(true){
                c = scanner.next().charAt(0);
                if (c == 'N' || c == 'n') {
                    novaMissao = false;
                    break;
                }
                else if (c == 'S' || c == 's') {
                    novaMissao = true;
                    break;
                } 
                else continue;
            }
        }

        System.out.println("Sistema encerrado.\n");
        scanner.close();
    }
}
