package com.arpan;

public class Operation {
    private int leftOperand;
    private int rightOperand;
    private String operationType;
    
    public Operation(int leftOperand, int rightOperand, String operationType) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operationType = operationType;
    }

    public Integer getLeftOperand() {
        return this.leftOperand;
    }

    public Integer getRightOperand() {
        return this.rightOperand;
    }

    public String getOperationType() {
        return this.operationType;
    }

    @Override
    public String toString() {
        return "Operation={" +
                " leftOperand=" + leftOperand +
                ", rightOperand=" + rightOperand +
                ", operation='" + operationType + "\'" +
                "}";
    }
}