import java.util.Scanner;

public class NASA {
    public static void main (String[] args) throws Exception {

        CentralDeControle CC = new CentralDeControle();
        
        Scanner myObj = new Scanner(System.in);

        int x = myObj.nextInt();
        int y = myObj.nextInt();
        char dir = myObj.next().charAt(0);
        System.out.println("You have entered "+ dir);   
        CC.novaSonda(x, y, dir);
        char[] movimento = {'L', 'M', 'R', 'R'};
        CC.moverSonda(0, movimento);
        CC.posicaoSondas();
    }
}
