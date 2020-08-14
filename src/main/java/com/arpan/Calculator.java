package com.arpan;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;

import com.arpan.logging.OperationLogger;
import com.arpan.operators.Adder;
import com.arpan.operators.DefaultAdder;
import com.arpan.operators.DefaultMultiplier;
import com.arpan.operators.Divider;
import com.arpan.operators.Multiplier;
import com.arpan.operators.Subtractor;

public class Calculator {
    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;
    private Divider divider;
    private CalculationMode calculationMode;
    private List<Operation> operationList;
    private LoggingStrategy loggingStrategy;
    private OperationLogger operationLogger;
    
    private Calculator(Builder builder) {
        this.adder = builder.adder;
        this.subtractor = builder.subtractor;
        this.divider = builder.divider;
        this.multiplier = builder.multiplier;
        this.calculationMode = builder.calculationMode;
    }

    public static class Builder {

        private Adder adder = new DefaultAdder();
        private Subtractor subtractor;
        private Multiplier multiplier = new DefaultMultiplier();
        private Divider divider;
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
        return product;
    }

    public void sendResults() {
        operationLogger.logOperations(operationList, loggingStrategy);
    }

    public void calculateExpression(String expressionString) {
        
        //TO DO
    }


}