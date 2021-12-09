public class PlanaltoMarte {
    private int sizeX;
    private int sizeY;

    // construtor default: planalto de 5x5
    public PlanaltoMarte(){
        sizeX = 5;
        sizeY = 5;
    }

    // construtor planalto de tamanho definido
    public PlanaltoMarte(int x, int y){
        sizeX = x;
        sizeY = y;
    }

    public int[] size(){
        int[] size = {sizeX, sizeY};
        return size;
    }
}
