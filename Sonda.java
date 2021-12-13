// Classe que define e implementa as funções da sonda.

public class Sonda {
    private int posX;
    private int posY;
    private int direcao; // index do vetor 'direcoes' referente a direcao da sonda
    private char[] direcoes = {'N', 'E', 'S', 'W'};

    public Sonda(int x, int y, char dir){
        this.posX = x;
        this.posY = y;
        for (int i = 0; i < direcoes.length; i++){
            if (direcoes[i] == dir){
                direcao = i;
                break;
            }
        }
    }

    public int[] getPosicao(){
        int[] posicao = {this.posX, this.posY};
        return posicao;
    }

    public char getDirecao(){
        return this.direcoes[direcao];
    }

    // movimenta a sonda em uma unidade.
    private void movimento(){
        char dir = direcoes[direcao];
        if (dir == 'N') {
            this.posY = this.posY + 1;
        } 
        else if (dir == 'S') {
            this.posY = this.posY - 1;
        } 
        else if (dir == 'E') {
            this.posX = this.posX + 1;
        } 
        else if (dir == 'W') {
            this.posX = this.posX - 1;
        } 
    }

    // rotaciona a sonda.
    private void rotacao(char sentido){
        if (sentido == 'L') { // movimento anti-horário, decrementa 'direcao'
            direcao -= 1;
            if (direcao < 0) direcao = direcoes.length - 1;
        } else if (sentido == 'R') { // movimento horário, incrementa 'direcao'
            direcao += 1;
            if (direcao >= direcoes.length) direcao = 0;
        }
    }

    public void moverSonda(char instrucao){
        if (instrucao == 'M') movimento();    
        else rotacao(instrucao);
    }
    
}
