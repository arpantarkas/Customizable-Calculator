package com.arpan.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.arpan.Calculator;
import com.arpan.Operation;

public class ExpressionParser {
    /* Create stacks for operators and operands */

    private List<Operation> operationList = new ArrayList<>();
    public Integer evaluateExpression(Calculator calcInstance, String expressionString) {
        
        Stack<Integer> opStack = new Stack<>();
        Stack<Integer> valStack = new Stack<>();

        /* Create temporary stacks for operators and operands */
        Stack<Integer> opStackTmp = new Stack<>();
        Stack<Integer> valStackTmp = new Stack<>();

        expressionString = "0" + expressionString;
        expressionString = expressionString.replace("-", "+-");

        /* Store operands and operators in respective stacks */
        String temp = "";
        for (int i = 0; i < expressionString.length(); i++) {
            char ch = expressionString.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' && ch != '*' && ch != '/')
                temp = temp + ch;
            else {
                valStack.push(Integer.parseInt(temp));
                opStack.push((int) ch);
                temp = "";
            }
        }
        valStack.push(Integer.parseInt(temp));

        /* Create char array of operators as per precedence */
        /* Precedence order :- BODMAS Rule -> Division > Multiplication > addition > subtraction

        /* -ve sign is already taken care of while storing */
        char [] operators = { '/', '*', '+' };

        /* Evaluation of expression */
        for (int i = 0; i < operators.length; i++) {
            boolean it = false;
            while (!opStack.isEmpty()) {
                int optr = opStack.pop();
                int v1 = valStack.pop();
                int v2 = valStack.pop();
                if (optr == operators[i]) {
                    /* if operator matches evaluate and store in temporary stack */
                    if (i == 0) {
                        valStackTmp.push(calcInstance.divide(v2, v1));
                        it = true;
                        break;

                    } else if (i == 1) {
                        valStackTmp.push(calcInstance.multiply(Arrays.asList(v2, v1)));
                        it = true;
                        break;

                    } else if (i == 2) {
                        valStackTmp.push(calcInstance.add(Arrays.asList(v2, v1)));
                        it = true;
                        break;
                    }
                } else {
                    valStackTmp.push(v1);
                    valStack.push(v2);
                    opStackTmp.push(optr);
                }
            }

            /* Push back all elements from temporary stacks to main stacks */
            while (!valStackTmp.isEmpty())
                valStack.push(valStackTmp.pop());
            while (!opStackTmp.isEmpty())
                opStack.push(opStackTmp.pop());
            /* Iterate again for same operator */
            if (it) {
                i--;
            }
        }

        return valStack.pop();
    }

    public List<Operation> getOperationList() {
        return this.operationList;
    }

}