package exerciciobingo;

public class Cartela {
    private int codigo;
    private int[] dezenas;
    
    public Cartela(int codigo, int[] dezenas){
        this.codigo = codigo;
        this.dezenas = dezenas;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int[] getDezenas() {
        return dezenas;
    }

    public void setDezenas(int[] dezenas) {
        this.dezenas = dezenas;
    } 
}
