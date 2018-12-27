package ru.itis;

import java.util.ArrayList;

public class OptTree {
    private int n, k;
    private ArrayList<Root> tree;

    public OptTree(){
        this.n = this.k = 0;
        this.tree = new ArrayList<Root>();
    }

    public int findOptTree(int k){
        int answer = 0;
        for (int i = 0; i < tree.size(); i ++){
            int count = tree.get(i).getChild();
            if (count > k){
                while (count > 0){
                    answer += count / k;
                    count /=k;
                }
            }
        }
        return answer;
    }

    public void createTree(int [] array, int n){
        this.tree.clear();
        for (int i = 1; i < n; i ++){
            int iRoot = array[i];
            if (tree.contains(new Root(iRoot))){
                tree.get(tree.indexOf(new Root(iRoot))).addChild();
            } else {
                tree.add(new Root(iRoot));
                tree.get(tree.size() - 1).addChild();
            }
        }
    }
}
