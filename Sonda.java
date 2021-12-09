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

    public void moverSonda(char movement){
        if (movement == 'M') {

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

        } else if (movement == 'L') { // movimento anti-horário

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

        } else if (movement == 'R') { // movimento horário

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
}
