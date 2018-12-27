package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

public class AnalyzerTest {
    private Analyzer analyzer;
    private LinkedHashMap<String, Integer> map;

    @Before
    public void setUp(){
        analyzer = new Analyzer();
        map = new LinkedHashMap<>();
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyzer1(){
        String input = "X1:==208; X2:=224; X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer2(){
        String input = "X1:=208=;X2:=224;X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer3(){
        String input = "x1:=208;X2:=224;X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer4(){
        String input = "X1:=208;=X2:=224;X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer5(){
        String input = "X1:=208;X2:=2b24;X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer6(){
        String input = "X1:=208;X2:=224;X3:=X1+2X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer7(){
        String input = "X1:=208;X2:=224;X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer8(){
        String input = "X1:=208;X2:=224;X3:=X1)X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer9(){
        String input = "X1:=208;X2:=224;X3:=X1++X2";
        analyzer.analyze(input);
    }
    @Test
    public void testAnalyzer10(){
        String input = "X1:=208;X2:=224;X3:=X1+X2;";
        analyzer.analyze(input);
        Assert.assertEquals(0, analyzer.getState());
    }
    @Test
    public void testAnalyzer11(){
        String input = "X1:=22244;Y2:=Z2-T5;Z1:=X1+Y2;C2:=G5/H5;";
        analyzer.analyze(input);
        Assert.assertEquals(0, analyzer.getState());
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer12(){
        String input = "X1:=208;X2:=224;X3:=X1+X2;A";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer13(){
        String input = "X1:=208;X2:=224;X3:=Xa1+X2;";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer14(){
        String input = "X1:=208;XX:=224;X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer15(){
        String input = "+X1:=208;X2:=224;X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test(expected = SyntaxException.class)
    public void testAnalyzer16(){
        String input = "1:=208;X2:=224;X3:=X1+X2";
        analyzer.analyze(input);
    }
    @Test
    public void testAnalyze17(){
        String input = "X1:=124548;Y2:=Z2;Z1:=X1+Y2;C2:=G5/H5;";
        analyzer.analyze(input);
        Assert.assertEquals(0, analyzer.getState());
    }
    @Test(expected = NotFoundVariableException.class)
    public void testProcess1(){
        String input = "X1:=12;Y2:=24;C3:=5;V4:=X1-C3*Y2/Y2*Z1;Z1:=X1+Y2;Z2:=Y2/X1;Z3:=Z1-Z2;Z4:=X1;X1:=34;Z4:=Z2*Y2;";
        analyzer.process(input);
    }
    @Test(expected = NotFoundVariableException.class)
    public void testProcess2(){
        String input = "X1:=12;Y2:=24;C3:=5;V4:=X1-C3*Y2/Y2*X1;Z1:=X1+Y2;Z2:=Y2/T1;Z3:=Z1-Z2;Z4:=X1;X1:=34;Z4:=Z2*Y2;";
        analyzer.process(input);
    }
    @Test
    public void testProcess3(){
        String input = "X1:=12;Y2:=24;C3:=5;V4:=X1-C3*Y2/Y2*X1;Z1:=X1+Y2;Z2:=Y2/X1;Z3:=Z1-Z2;Z4:=X1;X1:=34;Z4:=Z2*Y2;";
        map.put("Y2", 24);
        map.put("C3", 5);
        map.put("V4", 84);
        map.put("Z1", 36);
        map.put("Z2", 2);
        map.put("Z3", 34);
        map.put("X1", 34);
        map.put("Z4", 48);
        Assert.assertEquals(map, analyzer.process(input));
    }
    @Test
    public void testProcess4(){
        String input = "X1:=124;Y2:=0;Z1:=Y2;C2:=Y2/X1;Z3:=X1*Y2;C4:=Y2+X1-Y2;C5:=Y2+Y2+Y2-Y2*Y2;";
        map.put("X1", 124);
        map.put("Y2", 0);
        map.put("Z1", 0);
        map.put("C2", 0);
        map.put("Z3", 0);
        map.put("C4", 124);
        map.put("C5", 0);
        Assert.assertEquals(map, analyzer.process(input));
    }
    @Test(expected = RuntimeException.class)
    public void testProcess5(){
        String input = "X1:=124548;Y2:=X1-X1;Z1:=0;C2:=X1/Z1;";
        analyzer.process(input);
    }
}
