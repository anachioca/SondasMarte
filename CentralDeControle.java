public class CentralDeControle {
    private PlanaltoMarte pm;
    private int countSondas = 0;
    private int nSondas;
    private Sonda[] sondas;

    public CentralDeControle(){
        pm = new PlanaltoMarte();
        sondas = new Sonda[1];
        nSondas = 0;
    }
    
    public CentralDeControle(int x, int y, int n){
        pm = new PlanaltoMarte(x, y);
        sondas = new Sonda[x*y];
        nSondas = n;
    }

    private boolean aterrisagemValida(int[] position){
        if (position[0] < 0 || position[1] < 0 || position[0] >= pm.size()[0] || position[1] >= pm.size()[0]){
            return false;
        }

        for (int i = 0; i < countSondas; i++){
            int[] pos = sondas[i].getPosition();
            if (pos[0] == position[0] && pos[1] == position[1]){
                return false;
            }
        }

        return true;
    }

    public void novaSonda(int x, int y, char dir){
        int[] position = {x, y};
        
        if (!aterrisagemValida(position)){
            System.out.println("Posição de aterrisagem inválida");
            return;
        }

        if(countSondas + 1 > nSondas){
            System.out.println("Número máximo de sondas alcançado");
            return;
        }

        Sonda s = new Sonda(x, y, dir);
        sondas[countSondas] = s;
        countSondas += 1;
        System.out.println("Temos " + countSondas + " sondas.\n");
    }

    private boolean movimentoValido(int[] posicao, char direction){
        int posX = posicao[0];
        int posY = posicao[1];

        if (direction == 'N') {
            posY = posY + 1;
        } 
        else if (direction == 'S') {
            posY = posY - 1;
        } 
        else if (direction == 'L') {
            posX = posX + 1;
        } 
        else if (direction == 'O') {
            posX = posX - 1;
        } 

        if (posX < 0 || posY < 0 || posX >= pm.size()[0] || posY >= pm.size()[0]){
            return false;
        }

        for (int i = 0; i < countSondas; i++){
            int[] pos = sondas[i].getPosition();
            if (pos[0] == posX && pos[1] == posY) return false;
        }

        return true;
    }

    public void moverSonda(int n, char[] movimento){
        Sonda sonda = sondas[n];
        int[] position = new int[2];
        char dir = sonda.getDirection(); // default
        for (char c: movimento){

            position = sonda.getPosition();
            dir = sonda.getDirection();
            if (c == 'M' && !movimentoValido(position, dir)){
                System.out.println("Sonda encontrou obstáculo. Movimento não concluído.\n");
                break;
            }
            sonda.moverSonda(c);
        }
    }

    public void posicaoSondas(){
        for (int i = 0; i < countSondas; i++){
            Sonda s = sondas[i];
            int[] position = s.getPosition();
            char direction = s.getDirection();
            System.out.println("Posição sonda " + i + ": " + position[0] + " " + position[1] + " " + direction + "\n");
        }
    }
}
