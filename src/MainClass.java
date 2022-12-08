import java.util.ArrayList;

public class MainClass {
    class Wrapper{
        String profile;
        String amino_acids;
        Wrapper(String profile , String amino_acids){
            this.profile = profile;
            this.amino_acids = amino_acids;
        }
    }
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

    def create_PSSM_matrix(sequences):
    num_of_seqs = len(sequences)
    seq_length = len(sequences[0])
    amino_acids = find_amino_acids(sequences)

    profile = np.zeros((len(amino_acids), seq_length))

            for amino_i in range(len(amino_acids)):
            for i in range(seq_length):
    profile[amino_i][i] = find_num_occurences(amino_acids[amino_i], i, sequences)

    profile = profile + PSEUDOCOUNT
            profile = profile / (num_of_seqs + len(amino_acids) * PSEUDOCOUNT)

    for row_i in range(profile.shape[0]):
    profile[row_i] = profile[row_i] / (profile[row_i].sum() / seq_length)

    profile = np.log2(profile)

            return profile, amino_acids

    public Wrapper create_PSSM_matrix(String sequences[]){
        int num_of_seqs = sequences.length;
        int seq_length = sequences[0].length();

    }
}
