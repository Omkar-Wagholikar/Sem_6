import java.util.*;

public class t {
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

        Arrays.sort(matrix, (a, b) -> a.index - b.index);
		
        String cypherText = "";
        for(Block bloc: matrix){
            for(char i : bloc.val) cypherText += i;
        }
        return cypherText;
    }

    public static String decode(String cypherText){
        Block [] matrix = new Block[key.length()];        
        for(int i=0; i<key.length(); i++) {
            matrix[i] = new Block('_');
            matrix[i].value = key.charAt(i);
            matrix[i].index = i;
        }
        
        Arrays.sort(matrix, (a, b) -> a.value - b.value);
        
        int cypherTextLength = cypherText.length();
        int height = cypherTextLength / key.length();
		
        for(int i=0; i<key.length(); i++){
            for(int j=0; j<height; j++){
                matrix[i].val.add(cypherText.charAt(height*i+j));
            }
        }

        Arrays.sort(matrix, (a,b)->a.index-b.index);

        StringBuilder res = new StringBuilder();
        for(int i=0; i<matrix[0].val.size(); i++){
            for(int r =0; r<key.length(); r++){
                char temp = matrix[r].val.get(i);
                if(temp != '_') res.append(temp);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        // key = "EXAMPLE";

        // String plainText = "OMKARISHERE";
        // String c = encode(plainText);
        // System.out.println("Cypher text: "+ c);
		// String p = decode(c);
        // System.out.println("Plain text: " + p);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key: ");
		key = sc.nextLine();
		int v= 4;
		while(v-- > 0){
			System.out.print("Enter Plain text: ");
			String p = sc.nextLine();
			String c = encode(p);
			System.out.println("Cypher text: "+c);
			p = decode(c);
			System.out.println("Plain text:  "+p);

		}
        // //  E X A M P L E
        // //  O M K A R I S 
        // //  H E R E _ _ _
        
        // //  A E E L M P X
        // //  K O S I A R M
        // //  R H _ _ E _ E

        // //  0 2 4 6 8 0 2
        // //  1 3 5 7 9 1 3

        // // K R O H S _ I _ A E R _ M E
        // // 0 1 2 3 4 5 6 7 8 9 0 1 2 3
    }
}
