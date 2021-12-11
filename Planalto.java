public class Planalto {
    private int sizeX;
    private int sizeY;

    // construtor default: planalto de 5x5
    public Planalto(){
        sizeX = 5;
        sizeY = 5;
    }

    // construtor planalto de tamanho definido
    public Planalto(int x, int y){
        sizeX = x;
        sizeY = y;
    }

    public int[] size(){
        int[] size = {sizeX, sizeY};
        return size;
    }
}
