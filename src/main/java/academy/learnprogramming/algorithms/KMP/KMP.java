package academy.learnprogramming.algorithms.KMP;

public class KMP {
    private int[] computeLPSArray(String pat) {
        int M = pat.length();
        int[] table = new int[M];
        int j = 0;
        int i = 1;
        table[0] = 0; // table[0] is always 0


        while (i < M) {
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
                table[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = table[j - 1];
                } else {
                    table[i] = 0;
                    i++;
                }
            }
        }
        return table;
    }

    public int kmpSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int[] lps = computeLPSArray(pat);
        int i = 0;
        int j = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                return i - j; // Pattern found
            }
            if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return -1; // Pattern not found
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMP kmp = new KMP();
        int result = kmp.kmpSearch(pat, txt);
        if (result == -1) {
            System.out.println("Pattern not found");
        } else {
            System.out.println("Pattern found at index " + result);
        }
    }
}

