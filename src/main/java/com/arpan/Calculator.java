package com.arpan;

import java.util.ArrayList;
import java.util.List;


import com.arpan.logging.OperationLogger;
import com.arpan.operators.Adder;
import com.arpan.operators.DefaultAdder;
import com.arpan.operators.DefaultDivider;
import com.arpan.operators.DefaultMultiplier;
import com.arpan.operators.DefaultSubtractor;
import com.arpan.operators.Divider;
import com.arpan.operators.ExpressionParser;
import com.arpan.operators.Multiplier;
import com.arpan.operators.Subtractor;

public class Calculator {
    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;
    private Divider divider;
    private CalculationMode calculationMode = CalculationMode.DEFAULT;
    private List<Operation> operationList = new ArrayList<>();
    private LoggingStrategy loggingStrategy;
    private OperationLogger operationLogger = new OperationLogger();
    
    private Calculator(Builder builder) {
        this.adder = builder.adder;
        this.subtractor = builder.subtractor;
        this.divider = builder.divider;
        this.multiplier = builder.multiplier;
        this.calculationMode = builder.calculationMode;
        this.loggingStrategy = builder.loggingStrategy;
    }

    public static class Builder {

        private Adder adder = new DefaultAdder();
        private Subtractor subtractor = new DefaultSubtractor();
        private Multiplier multiplier = new DefaultMultiplier();
        private Divider divider = new DefaultDivider();
        private CalculationMode calculationMode = CalculationMode.DEFAULT;
        private LoggingStrategy loggingStrategy;
         
        public Builder addAdder(Adder adder) {
            this.adder = adder;
            return this;
        }

        public Builder addSubtractor(Subtractor subtractor) {
            this.subtractor = subtractor;
            return this;
        }

        public Builder addMultiplier(Multiplier multiplier) {
            this.multiplier = multiplier;
            return this;
        }

        public Builder addDivider(Divider divider) {
            this.divider = divider;
            return this;
        }

        public Builder setCalculationMode(CalculationMode calculationMode) {
            this.calculationMode = calculationMode;
            return this;            
        }

        public Builder setLoggingStrategy(LoggingStrategy loggingStrategy) {
            this.loggingStrategy = loggingStrategy;
            return this;
        }

        public Calculator build() {
            // TODO validation check
            if (this.calculationMode.equals(CalculationMode.DEFAULT)) {
                this.adder = new DefaultAdder();
                this.subtractor = new DefaultSubtractor();
                this.multiplier = new DefaultMultiplier();
                this.divider = new DefaultDivider();
            }

            return new Calculator(this);
        }
    }

    public Integer add(List<Integer> numList) {
        Integer sum=null;
        try {
            sum = this.adder.add(numList);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        for (int numIterator=1; numIterator<numList.size(); numIterator++) {
            operationList.add(new Operation(numList.get(numIterator-1), numList.get(numIterator), "sum"));
        }
        return sum;
    }

    public Integer multiply(List<Integer> numList) {
        Integer product=null;
        try {
            product = this.multiplier.multiply(numList);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        for (int numIterator=1; numIterator<numList.size(); numIterator++) {
            operationList.add(new Operation(numList.get(numIterator-1), numList.get(numIterator), "multiply"));
        }
        return product;
    }

    public Integer subtract(Integer a, Integer b) {
        operationList.add(new Operation(a, b, "subtract"));
        return this.subtractor.subtract(a, b);
    }

    public Integer divide(Integer a, Integer b) {
        operationList.add(new Operation(a, b, "divide"));
        return this.divider.divide(a, b);
    }

    public void sendResults() {
        operationLogger.logOperations(operationList, loggingStrategy);
    }

    public Integer calculateExpression(String expressionString) {
        ExpressionParser expParser = new ExpressionParser();
        return expParser.evaluateExpression(this, expressionString);
    }

    public List<Operation> getOperationList() {
        return this.operationList;
    }


}