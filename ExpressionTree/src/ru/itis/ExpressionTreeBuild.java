package ru.itis;

public class ExpressionTreeBuild {
    class TreeNode{
        char value;
        TreeNode left, right;

        TreeNode(char item){
            value = item;
            left = right = null;
        }
    }

    boolean isOperator(char c){
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^'){
            return true;
        }
        return false;
    }

    void inOrder(TreeNode t){
        if (t !=null){
            inOrder(t.left);
            System.out.println(t.value + "");
            inOrder(t.right);
        }
    }

}
