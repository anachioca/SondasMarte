// Classe que representa a área a ser explorada. Neste caso, um retângulo ou quadrado.
// Separando o planalto a ser explorado em uma classe e delegando a esta classe a responsabilidade
// de definir as posições válidas para acesso da sonda, podemos criar novos formatos de planaltos, 
// adicionar obstáculos, etc. sem precisar mudar outras classes.

public class Planalto {
    private int tamX;
    private int tamY;
    private int[][] posValidas;

    // construtor default: planalto de 5x5
    public Planalto(){
        this.tamX = 5;
        this.tamY = 5;
        this.posValidas = new int[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                this.posValidas[i][j] = 1;
            }
        }
    }

    // construtor planalto de tamanho definido
    public Planalto(int x, int y){
        this.tamX = x;
        this.tamY = y;
        this.posValidas = new int[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                this.posValidas[i][j] = 1;
            }
        }
    }

    // coordenada (x, y) faz parte do planalto?
    public boolean posValida(int x, int y){
        if (x >= this.tamX || y >= this.tamY || x < 0 || y < 0) return false;
        if (this.posValidas[x][y] == 1) return true;
        else return false;
    }
}
