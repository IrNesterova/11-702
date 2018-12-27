package ru.itis;


import java.util.LinkedHashMap;

public class Analyzer {
    int state = 0;

    public void analyze(String input) throws SyntaxException {
        state = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (state) {
                case 0:
                    if (Character.isLetter(c)) {
                        state++;
                    } else {
                        throw new SyntaxException("На позиции " + i + " ожидалась буква");
                    }
                    break;
                case 1:
                    if (Character.isDigit(c)) {
                        state++;
                    } else {
                        throw new SyntaxException("На позиции " + i + " ожидалось число");
                    }
                    break;
                case 2:
                    if (c == ':') {
                        state++;
                    } else {
                        throw new SyntaxException("На позиции " + i + " ожидалось двоеточие");
                    }
                    break;
                case 3:
                    if (c == '=') {
                        state++;
                    } else {
                        throw new SyntaxException("На позиции " + i + " ожидалось равно");
                    }
                    break;
                case 4:
                    if (Character.isLetter(c)) {
                        state = 7;
                    } else if (Character.isDigit(c)) {
                        state = 5;
                    } else {
                        throw new SyntaxException("На позиции " + i + " ожидалась буква или цифра");
                    }
                    break;
                case 5:
                    if (c == ';') {
                        state = 0;
                    } else if (!Character.isDigit(c)) {
                        throw new SyntaxException("На позиции " + i + " ожидалось двоеточие или цифры");
                    }
                    break;
                case 7:
                    if (Character.isDigit(c)) {
                        state = 8;
                    } else {
                        throw new SyntaxException("На позиции " + i + " ожидалась цифра");
                    }
                    break;
                case 8:
                    if (c == '+' || c == '-' || c == '*' || c == '/') {
                        state = 9;
                    } else if (c == ';') {
                        state = 0;
                    } else {
                        throw new SyntaxException("На позиции " + i + " ожидалось ';' или знак арифметической операции");
                    }
                    break;
                case 9:
                    if (Character.isLetter(c)) {
                        state = 7;
                    } else {
                        throw new SyntaxException("На позиции " + i + " ожидалась буква");
                    }
                    break;
            }
        }
        if (state != 0) {
            throw new SyntaxException("На позиции " + (input.length() - 1) + " ожидалось ';'");
        }
    }

    LinkedHashMap<String, Integer> process(String input){
        analyze(input);
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        int indexL = -1, indexR = -1;
        while(indexR != input.length() - 1){
            indexL = input.indexOf(':', indexL + 1);
            String num = input.substring((indexR == 0) ? 0 : indexR + 1, indexL);
            indexR = input.indexOf(';', indexR + 1);
            int value = 0;
            if (result.containsKey(num))
                result.remove(num);
            try{
                value = Integer.parseInt(input.substring(indexL + 2, indexR));
            }
            catch (Exception e){
                char operator = ' ';
                StringBuilder part = new StringBuilder();
                boolean minus = false;
                for (int i = indexL + 2; i <= indexR; i++){
                    char current = input.charAt(i);
                    if (current != ';' && current != '+' && current != '-' && current != '*' && current != '/'){
                        part.append(current);
                    } else {
                        if (!result.containsKey(part.toString()) && (!part.toString().equals("") && current != '-'))
                            throw new NotFoundVariableException();
                        int partValue;
                        if (part.toString().equals("") && current == '-')
                            minus = true;
                        if (!part.toString().equals("")) {
                            partValue = (minus) ? -result.get(part.toString()) : result.get(part.toString());
                            minus = false;
                            switch (operator) {
                                case '-': {
                                    value -= partValue;
                                    break;
                                }
                                case '+': {
                                    value += partValue;
                                    break;
                                }
                                case '*': {
                                    value *= partValue;
                                    break;
                                }
                                case '/': {
                                    if (result.get(part.toString()) == 0)
                                        throw new RuntimeException();
                                    value /= partValue;
                                    break;
                                }
                                case ' ': {
                                    value = partValue;
                                }
                            }
                            if (current != ';')
                                operator = current;
                            part = new StringBuilder();
                        }
                    }
                }
            }
            result.put(num, value);
        }
        return result;
    }

    public int getState(){
        return state;
    }
}
