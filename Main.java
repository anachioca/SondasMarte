import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception {

        boolean novaMissao = true;
        int x, y, horizontal, vertical, nSondas;
        char dir;

        while(novaMissao){
            System.out.println("Bem Vindo ao Sistema de Exploração de Marte!\n");
            System.out.println("Quais as medidas do planalto que deseja explorar? (horizontal x vertical)");

            Scanner myObj = new Scanner(System.in);
            horizontal = myObj.nextInt();
            vertical = myObj.nextInt();
            Planalto planalto = new Planalto(horizontal, vertical);

            System.out.println("Quantas sondas deseja enviar para Marte?");

            nSondas = myObj.nextInt();
            CentralDeControle CC = new CentralDeControle(planalto, nSondas);
            
            for (int i = 0; i < nSondas; i++){
                System.out.println("Quais as coordenadas e direção de aterrisagem da " + (i+1) + "a sonda?");
                x = myObj.nextInt();
                y = myObj.nextInt();
                dir = myObj.next().charAt(0);
                CC.novaSonda(x, y, dir);

                String aux = myObj.nextLine();
                System.out.println("Qual a sequência de instruções a serem seguidas pela " + (i+1) + "a sonda?");
                String linha = myObj.nextLine();
                System.out.println("voce digitou: " + linha);

                char[] instrucoes = new char[linha.length()];
                for (int j = 0; j < linha.length(); j++) {
                    instrucoes[j] = linha.charAt(j);
                }

                CC.moverSonda(i, instrucoes);
            }

            CC.posicaoSondas();

            System.out.println("Aperte S para realizar uma nova missão ou N para encerrar o sistema.");
            char c = myObj.next().charAt(0);
            if (c == 'N' || c == 'c') novaMissao = false;
        }

        System.out.println("Sistema encerrado.\n");
    }
}
