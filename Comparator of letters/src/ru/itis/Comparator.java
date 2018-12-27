package ru.itis;

public class Comparator implements java.util.Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        char[] chars1 = o1.toCharArray();
        char[] chars2 = o2.toCharArray();
        int max1 = findMaxSequence(chars1);
        int max2 = findMaxSequence(chars2);
        return max2 - max1;
    }

    public int findMaxSequence(char[] chars){
        int max = 0; int count = 0;
        for (int i = 0; i < chars.length-1; i++){
            if (chars[i] < chars[i+1]){
                count ++;
            } else {
                if (count > max){
                    max = count;
                }
            }
        }
        if (max==0){
            return count;
        }
        return max;
    }
}
