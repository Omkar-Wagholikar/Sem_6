import java.util.*;

public class Codechef {
    static String key;
    static class Block{
        char value;
        int index;
        List<Character> val;
        Block(char value){
            this.value = value;
            this.index = -1;
            val = new ArrayList<>();
        }
    }

    public static String encode(String plainText){
        char [] k = key.toCharArray();
        Arrays.sort(k);

        Block [] matrix = new Block[key.length()];
        for(int i=0; i<key.length(); i++) matrix[i] = new Block(key.charAt(i));

        for(int i=0; i<k.length; i++){
            for(Block block: matrix){
                if(block.value == k[i] && block.index == -1){ 
                    block.index = i;
                    break;
                }
            }
        }

        for(int i=0; i<plainText.length(); i++){
            matrix[i%key.length()].val.add(plainText.charAt(i));
        }

        int height = matrix[0].val.size();
        for(int i=0; i<key.length(); i++){
            if(height > matrix[i].val.size()){
                matrix[i].val.add('_');
            }
        }

        for(Block bloc: matrix){
            System.out.println(bloc.value + ": "+ bloc.val.toString());
        }

        Arrays.sort(matrix, (a, b) -> a.index - b.index);

        System.out.println();
        for(Block bloc: matrix){
            System.out.println(bloc.value + ": "+ bloc.val.toString());
        }

        String cypherText = "";
        for(Block bloc: matrix){
            for(char i : bloc.val) cypherText += i;
        }
        return cypherText;
    }
    public static void main(String[] args) {
        key = "EXAMPLE";
        // String plainText = "OMKARISHERE";
        //  E X A M P L E
        //  O M K A R I S 
        //  H E R E _ _ _
        
        //  A E E L M P X
        //  K O S I A R M
        //  R H _ _ E _ E

        // K R O H S _ I _ A E R _ M E
        String cypherText = "KROHS_I_AER_ME";
        System.out.println(cypherText);

        Block [] matrix = new Block[key.length()];        
        for(int i=0; i<key.length(); i++) {
            matrix[i] = new Block(key.charAt(i));
            matrix[i].index = i;
        }
        
        Arrays.sort(matrix, (a, b) -> a.value - b.value);

        int height = cypherText.length() / key.length();

        for(int i=0; i<cypherText.length(); i+=height){
            for(int j=0; j<height; j++){
                matrix[i].val.add(cypherText.charAt(i+j));
            }
        }


        for(Block bloc: matrix){
            System.out.println(bloc.value + ": "+ bloc.val.toString());
        }
    }
}
