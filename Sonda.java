public class Sonda {
    private int posX;
    private int posY;
    private char direction;

    public Sonda(int x, int y, char dir){
        this.posX = x;
        this.posY = y;
        this.direction = dir;
    }

    public int[] getPosition(){
        int[] position = {this.posX, this.posY};
        return position;
    }

    public char getDirection(){
        return this.direction;
    }

    private void movimento(){
        if (this.direction == 'N') {
            this.posY = this.posY + 1;
        } 
        else if (this.direction == 'S') {
            this.posY = this.posY - 1;
        } 
        else if (this.direction == 'L') {
            this.posX = this.posX + 1;
        } 
        else if (this.direction == 'O') {
            this.posX = this.posX - 1;
        } 
    }

    private void rotacao(char sentido){
        if (sentido == 'L') { // movimento anti-horário

            if (this.direction == 'N') {
                this.direction = 'O';
            } 
            else if (this.direction == 'S') {
                this.direction = 'L';
            } 
            else if (this.direction == 'L') {
                this.direction = 'N';
            } 
            else if (this.direction == 'O') {
                this.direction = 'S';
            }

        } else if (sentido == 'R') { // movimento horário

            if (this.direction == 'N') {
                this.direction = 'L';
            } 
            else if (this.direction == 'S') {
                this.direction = 'O';
            } 
            else if (this.direction == 'L') {
                this.direction = 'S';
            } 
            else if (this.direction == 'O') {
                this.direction = 'N';
            }
        }
    }

    public void moverSonda(char instrucao){
        if (instrucao == 'M') movimento();    
        else rotacao(instrucao);
    }
    
}
