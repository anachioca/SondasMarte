import java.util.Scanner;

public class NASA {
    public static void main (String[] args) throws Exception {

        CentralDeControle CC = new CentralDeControle(5, 5, 1);
        
        Scanner myObj = new Scanner(System.in);

        int x = myObj.nextInt();
        int y = myObj.nextInt();
        char dir = myObj.next().charAt(0);
        CC.novaSonda(x, y, dir);

        x = myObj.nextInt();
        y = myObj.nextInt();
        dir = myObj.next().charAt(0); 
        CC.novaSonda(x, y, dir);

        char[] movimento = {'L', 'M'};
        CC.moverSonda(0, movimento);
        CC.posicaoSondas();
    }
}
