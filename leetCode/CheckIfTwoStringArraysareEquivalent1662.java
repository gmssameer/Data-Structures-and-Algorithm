public class CheckIfTwoStringArraysareEquivalent1662 {

    public static boolean  arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder a1=new StringBuilder();
        StringBuilder a2=new StringBuilder();
        for(String a: word1 ){
            a1.append(a);
        }
        for(String a: word2 ){
            a2.append(a);
        }
        return a1.compareTo(a2) == 0;
    }
    public static void main(String[] args) {
        String[] word1 = {"a", "cb"}, word2 = {"ab", "c"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
}
