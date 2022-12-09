import java.util.ArrayList;

public class MainClass {
    int MAX_SEQUENCE_LENGTH = 10;
   int  PSEUDOCOUNT = 2;
    class Wrapper{
        double[][] profile;
        char[] amino_acids;
        Wrapper(double[][] profile , char[] amino_acids){
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

//    def create_PSSM_matrix(sequences):
//    num_of_seqs = len(sequences)
//    seq_length = len(sequences[0])
//    amino_acids = find_amino_acids(sequences)
//
//    profile = np.zeros((len(amino_acids), seq_length))
//
//            for amino_i in range(len(amino_acids)):
//            for i in range(seq_length):
//    profile[amino_i][i] = find_num_occurences(amino_acids[amino_i], i, sequences)
//
//    profile = profile + PSEUDOCOUNT
//            profile = profile / (num_of_seqs + len(amino_acids) * PSEUDOCOUNT)
//
//    for row_i in range(profile.shape[0]):
//    profile[row_i] = profile[row_i] / (profile[row_i].sum() / seq_length)
//
//    profile = np.log2(profile)
//
//            return profile, amino_acids

    public Wrapper create_PSSM_matrix(String sequences[]){
        int num_of_seqs = sequences.length;
        int seq_length = sequences[0].length();
        char[] amino_acids = find_amino_acids(sequences);
        double profile[][] = new double[amino_acids.length][seq_length];
        for(int  amino_i=0;amino_i<amino_acids.length;amino_i++){
            for(int i=0;i<seq_length;i++){
                profile[amino_i][i] = find_num_occurences(amino_acids[amino_i] , i , sequences);
            }
        }

        for(int i=0;i< profile.length;i++){
            for(int j =0;j<profile[0].length;j++){
                profile[i][j] +=PSEUDOCOUNT;
            }
        }


        for(int i=0;i< profile.length;i++){
            for(int j =0;j<profile[0].length;j++){
                profile[i][j] =profile[i][j]/(num_of_seqs + amino_acids.length * PSEUDOCOUNT);
            }
        }

        for(int row_i=0;row_i<profile[0].length;row_i++){
            double sum=0;
            for(int i=0;i<profile[row_i].length;i++){
                sum+=profile[row_i][i];
            }
            for(int i=0;i<profile[row_i].length;i++){
                profile[row_i][i] = profile[row_i][i] /(sum / seq_length);
            }

        }


        for(int i=0;i< profile.length;i++){
            for(int j =0;j<profile[0].length;j++){
                profile[i][j] =Math.log(profile[i][j]);
            }
        }


        return new Wrapper(profile, amino_acids);



    }
}
