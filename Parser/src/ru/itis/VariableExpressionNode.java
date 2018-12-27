package ru.itis;

public class VariableExpressionNode implements ExpressionNode {
    private String name;
    private double value;
    private boolean valueSet;

    public VariableExpressionNode(String name){
        this.name = name;
        valueSet = false;
    }
    public void setValue(double value) {
        this.value = value;
        this.valueSet = valueSet;
    }

    @Override
    public int getType() {
        return ExpressionNode.VARIABLE_NODE;
    }

    @Override
    public double getValue() {
        if (valueSet) return value;
        else
            throw new ParserException("blah-blah-blah");
    }
}
