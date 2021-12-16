// Classe responsável pela criação/aterrissagem de sondas na superfície a ser explorada,
// movimentação das sondas e checagem de validade de cada movimento.

public class ControleSondas {
    private Planalto planalto;
    private int countSondas = 0;
    private int nSondas;
    private Sonda[] sondas;
    
    public ControleSondas(Planalto p, int n){
        this.planalto = p;
        this.nSondas = n;
        this.sondas = new Sonda[nSondas];
    }

    public void posicaoSondas(){
        for (int i = 0; i < this.countSondas; i++){
            Sonda s = sondas[i];
            int[] posicao = s.getPosicao();
            char direcao = s.getDirecao();
            System.out.println("Posição sonda " + i + ": " + posicao[0] + " " + posicao[1] + " " + direcao);
        }
    }

    // Criação e aterrissagem de novas sondas
    public boolean novaSonda(int x, int y, char dir){
        int[] posicao = {x, y};
        
        // Coordenadas de aterrissagem estão dentro dos limites do planalto?
        if (!aterrissagemValida(posicao)){
            System.out.println("Posição de aterrissagem inválida");
            return false;
        }

        // Número pré-definido de sondas já foi alcançado?
        if(this.countSondas + 1 > this.nSondas){
            System.out.println("Número máximo de sondas alcançado");
            return false;
        }

        Sonda s = new Sonda(x, y, dir);
        this.sondas[this.countSondas] = s;
        this.countSondas += 1;
        return true;
    }

    // Controla movimentação das sondas.
    public void moverSonda(int n, char[] movimento){
        Sonda sonda = this.sondas[n];
        int[] posicao = new int[2];
        char direcao = sonda.getDirecao(); // default
        for (char c: movimento){
            posicao = sonda.getPosicao();
            direcao = sonda.getDirecao();
            if (c == 'M' && !movimentoValido(posicao, direcao)){
                System.out.println("Sonda encontrou obstáculo. Movimento não concluído.\n");
                break;
            }
            sonda.moverSonda(c);
        }
    }

    // Checa se as coordenadas de aterrissagem são validas, ou seja, se estão dentro da área definida
    // e se não existem sondas naquela posição.
    private boolean aterrissagemValida(int[] posicao){
        if (!this.planalto.posValida(posicao[0], posicao[1])){
            return false;
        }

        for (int i = 0; i < this.countSondas; i++){
            int[] pos = this.sondas[i].getPosicao();
            if (pos[0] == posicao[0] && pos[1] == posicao[1]){
                return false;
            }
        }

        return true;
    }

    // Checa se o movimento a ser realizado por uma sonda irá levá-la a uma
    // posição válida, ou seja, se a posição está dentro da área definida
    // e se não existem sondas naquela posição.
    private boolean movimentoValido(int[] posicao, char direcao){
        int posX = posicao[0];
        int posY = posicao[1];

        if (direcao == 'N') {
            posY = posY + 1;
        } 
        else if (direcao == 'S') {
            posY = posY - 1;
        } 
        else if (direcao == 'E') {
            posX = posX + 1;
        } 
        else if (direcao == 'W') {
            posX = posX - 1;
        } 

        if (!planalto.posValida(posX, posY)){
            return false;
        }

        for (int i = 0; i < countSondas; i++){
            int[] pos = sondas[i].getPosicao();
            if (pos[0] == posX && pos[1] == posY) return false;
        }

        return true;
    }
}
