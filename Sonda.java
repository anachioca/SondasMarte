// Classe que define e implementa as funções da sonda.

public class Sonda {
    private int posX;
    private int posY;
    private char direcao;

    public Sonda(int x, int y, char dir){
        this.posX = x;
        this.posY = y;
        this.direcao = dir;
    }

    public int[] getPosicao(){
        int[] posicao = {this.posX, this.posY};
        return posicao;
    }

    public char getDirecao(){
        return this.direcao;
    }

    private void movimento(){
        if (this.direcao == 'N') {
            this.posY = this.posY + 1;
        } 
        else if (this.direcao == 'S') {
            this.posY = this.posY - 1;
        } 
        else if (this.direcao == 'L') {
            this.posX = this.posX + 1;
        } 
        else if (this.direcao == 'O') {
            this.posX = this.posX - 1;
        } 
    }

    private void rotacao(char sentido){
        if (sentido == 'L') { // movimento anti-horário

            if (this.direcao == 'N') {
                this.direcao = 'O';
            } 
            else if (this.direcao == 'S') {
                this.direcao = 'L';
            } 
            else if (this.direcao == 'L') {
                this.direcao = 'N';
            } 
            else if (this.direcao == 'O') {
                this.direcao = 'S';
            }

        } else if (sentido == 'R') { // movimento horário

            if (this.direcao == 'N') {
                this.direcao = 'L';
            } 
            else if (this.direcao == 'S') {
                this.direcao = 'O';
            } 
            else if (this.direcao == 'L') {
                this.direcao = 'S';
            } 
            else if (this.direcao == 'O') {
                this.direcao = 'N';
            }
        }
    }

    public void moverSonda(char instrucao){
        if (instrucao == 'M') movimento();    
        else rotacao(instrucao);
    }
    
}
