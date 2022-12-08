import java.util.ArrayList;

public class MainClass {

    char[] find_amino_acids(String sequences[]) {
       ArrayList<Character> amino_acids = new ArrayList<>();
        for (String seq : sequences) {
            for(char c : seq.toCharArray()){
                if(!amino_acids.contains(c)){
                    amino_acids.add( c);
                }
            }
        }
        int  n =amino_acids.size();
        char[] res=  new char[n];
        for(int i=0;i<n;i++){
            res[i] = amino_acids.get(i);
        }
        return res;
    }
}
