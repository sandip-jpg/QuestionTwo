package org.personal.calculator.controller;

import java.util.Stack;

public class Calculation {
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }


    public static StringBuilder infixToPreFix(String equation){

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(equation);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char c = charsExp[i];

            //check if char is operator or operand
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor "("
                result.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }

    public static Boolean isOperand(char c){
        // If the character is a digit
        // then it must be an operand
        if (c >= 48 && c <= 57)
            return true;
        else
            return false;
    }

    public static double evaluatePrefix(String exprsn){

        Stack<Double> Stack = new Stack<Double>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {

            // Push operand to Stack
            // To convert exprsn[j] to digit subtract
            // '0' from exprsn[j].
            if (isOperand(exprsn.charAt(j)))
                Stack.push((double)(exprsn.charAt(j) - 48));

            else {

                // Operator encountered
                // Pop two elements from Stack
                double o1 = Stack.peek();
                Stack.pop();
                double o2 = Stack.peek();
                Stack.pop();

                // Use switch case to operate on o1
                // and o2 and perform o1 O o2.
                switch (exprsn.charAt(j)) {
                    case '+':
                        Stack.push(o1 + o2);
                        break;
                    case '-':
                        Stack.push(o1 - o2);
                        break;
                    case '*':
                        Stack.push(o1 * o2);
                        break;
                    case '/':
                        Stack.push(o1 / o2);
                        break;
                }
            }
        }
        return Stack.peek();
    }
}
