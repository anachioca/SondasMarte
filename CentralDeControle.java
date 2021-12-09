public class CentralDeControle {
    private PlanaltoMarte pm;
    private int nSondas = 0;
    private Sonda[] sondas;
    private int[][] mapa;

    public CentralDeControle(){
        pm = new PlanaltoMarte();
        mapa = new int[5][5];
        sondas = new Sonda[5*5];
    }
    
    public CentralDeControle(int x, int y){
        pm = new PlanaltoMarte(x, y);
        mapa = new int[x][y];
        sondas = new Sonda[x*y];
    }

    public void novaSonda(int x, int y, char dir){
        Sonda s = new Sonda(x, y, dir);
        sondas[nSondas] = s;
        posicionarSonda(x, y);
        nSondas += 1;
        System.out.println("Temos " + nSondas + " sondas.\n");
    }

    public void posicionarSonda(int x, int y){
        mapa[x][y] = 1;
    }

    public void moverSonda(int n, char[] movimento){
        Sonda sonda = sondas[n];
        int[] position = new int[2];
        for (char c: movimento){
            sonda.moverSonda(c);
            position = sonda.getPosition();
            if (position[0] < 0 || position[1] < 0 || position[0] >= pm.size()[0] || position[0] > pm.size()[0]){
                System.out.println("Sonda encontrou obstáculo. Movimento não concluído.\n");
                break;
            }
        }
        char dir = sonda.getDirection();
        System.out.println("Sonda na posição: " + position[0] + ", " + position[1] + ".\n");
        System.out.println("Sonda na direção: " + dir + ".\n");
    }

    public void posicaoSondas(){
        for (int i = 0; i < nSondas; i++){
            Sonda s = sondas[i];
            int[] position = s.getPosition();
            char direction = s.getDirection();
            System.out.println("Posição sonda " + i + ": " + position[0] + " " + position[1] + " " + direction + "\n");
        }
    }

    public void verMapa(){
        System.out.println("\nMapa atual do planalto:\n");
        for (int i = 0; i < mapa.length; i++){
            for (int j = 0; j < mapa[i].length; j++){
                System.out.println(mapa[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
