package com.wuchang.thrift.demo;

import com.wuchang.thrift.demo.thrift.Calculator;
import com.wuchang.thrift.demo.thrift.Work;
import org.apache.thrift.TException;

// Generated code
import com.wuchang.thrift.demo.thrift.*;

import java.util.HashMap;

public class CalculatorHandler implements Calculator.Iface {

    public void ping() {
        System.out.println("ping()");
    }

    public int add(int n1, int n2) {
        System.out.println("add(" + n1 + "," + n2 + ")");
        return n1 + n2;
    }

    public int calculate(int logid, Work work) throws InvalidOperation {
        System.out.println("calculate(" + logid + ", {" + work.op + "," + work.num1 + "," + work.num2 + "})");
        int val = 0;
        switch (work.op) {
            case ADD:
                val = work.num1 + work.num2;
                break;
            case SUBTRACT:
                val = work.num1 - work.num2;
                break;
            case MULTIPLY:
                val = work.num1 * work.num2;
                break;
            case DIVIDE:
                if (work.num2 == 0) {
                    InvalidOperation io = new InvalidOperation();
                    io.whatOp = work.op.getValue();
                    io.why = "Cannot divide by 0";
                    throw io;
                }
                val = work.num1 / work.num2;
                break;
            default:
                InvalidOperation io = new InvalidOperation();
                io.whatOp = work.op.getValue();
                io.why = "Unknown operation";
                throw io;
        }

        return val;
    }

    public void zip() {
        System.out.println("zip()");
    }

}