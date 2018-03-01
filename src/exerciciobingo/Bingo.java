package exerciciobingo;
import java.util.ArrayList;
import java.lang.Math;

public class Bingo {
    public static ArrayList<Cartela> sortearCartela(){
        int numeros[];
        ArrayList<Cartela> cartelas = new ArrayList<Cartela>();
        for(int c = 1; c <= 4; c++){
            numeros = new int[24];
            for(int i = 0; i < 24; i++){
                numeros[i] =  (int) (75 * (Math.random() + 1))/2;
                for(int j = 0; j < i; j++){
                    if(numeros[i] == numeros[j]){
                        i--;
                    }
                } 
            }
            cartelas.add(new Cartela(c, numeros));
        }
        return cartelas;
    }
    
    public static int sortearDezena(){
         return (int) (75 * (Math.random() + 1))/2;
    }
    
    public static boolean temGanhador(int[] pontos, ArrayList<Jogador> jogador, int rodadas){
        for(int i = 0; i < pontos.length; i++){
            if(pontos[i] >= 24){
                if(i < 4){
                    System.out.println("Vencedor: "+ jogador.get(0).getNome());
                    System.out.println("Código da Cartela: " + jogador.get(0).getCartelas()[i].getCodigo());
                    System.out.print("Dezenas Sorteadas:");
                    for(int x = 0; x < jogador.get(0).getCartelas()[i].getDezenas().length; x++){
                        System.out.print(" "+ jogador.get(0).getCartelas()[i].getDezenas()[x]);
                    }
                    System.out.println("\nNúmero de Rodadas: "+ rodadas);
                } else {
                    int y = i-4;
                    System.out.println("Vencedor: "+ jogador.get(1).getNome());
                    System.out.println("Código da Cartela: " + jogador.get(1).getCartelas()[y].getCodigo());
                    System.out.print("Dezenas Sorteadas:");
                    for(int x = 0; x < jogador.get(1).getCartelas()[y].getDezenas().length; x++){
                        System.out.print(" "+ jogador.get(0).getCartelas()[y].getDezenas()[x]);
                    }
                    System.out.println("\nNúmero de Rodadas: "+ rodadas);
                }
                return true;
            }
        }
        return false;
    }
    
    public static void bingo(ArrayList<Jogador> jogador){
        int numCartelas = jogador.get(0).getCartelas().length + jogador.get(1).getCartelas().length;
        int pontos[] = new int[numCartelas];
        int x = 0;
        for(int i = 0; i < numCartelas; i++){
            pontos[i] = 0;
        }
        ArrayList<Integer> rodadas = new ArrayList<Integer>();
        while(temGanhador(pontos, jogador, x) == false){
            int aux = sortearDezena();
            boolean repetido = false;
            for(int i = 0; i < rodadas.size(); i++){
                if(rodadas.get(i).equals(aux)){
                    repetido = true;
                } else {
                    rodadas.add(aux);
                }
            }
            if(repetido){
                continue;
            }
            for (int i = 0; i < jogador.get(0).getCartelas().length; i++) {
                Cartela c1 = jogador.get(0).getCartelas()[i];
                for(int j = 0; j < c1.getDezenas().length; j++){
                    if(c1.getDezenas()[j] == aux){
                        pontos[i]++;
                    }
                }
            } 
            for (int i = 0; i < jogador.get(1).getCartelas().length; i++) {
                Cartela c2 = jogador.get(1).getCartelas()[i];
                for(int j = 0; j < c2.getDezenas().length; j++){
                    if(c2.getDezenas()[j] == aux){
                        pontos[i + jogador.get(0).getCartelas().length]++;
                    }
                }
            }
            x++;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        ArrayList<Cartela> cartela1 = sortearCartela();
        ArrayList<Cartela> cartela2 = sortearCartela();
        jogadores.add(new Jogador("Jogador1", cartela1.toArray(new Cartela[cartela1.size()])));
        jogadores.add(new Jogador("Jogador2", cartela2.toArray(new Cartela[cartela2.size()])));
        bingo(jogadores);
    }
}