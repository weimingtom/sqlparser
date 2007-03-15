package test;

import java.io.StringReader;
import java.util.regex.Pattern;

import parser.L;
import parser.P;
import parser.T;
import translator.Translator;
import translator.model.ChWrongMessage;
import translator.model.DbTable;
import translator.model.QueryModel;

import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;

public class TestMain {
  public static void main(String[] args) {
    TestMain main=new TestMain();
    main.testSelect();
//    main.testTranslator();
//    main.testEquations();
    
//    String str="a[bc]abcdede";
//    String from=Pattern.quote("[bc]");
//    String to="_[bc]_";
//    System.out.println(from+" "+to+" "+str.replaceAll(from, to));
  }
  
  private void testSelect() {
    String selectStr=
      "select *, t1.f1, t1.f2, t2.f1, (t2.f2+t1.f1-20)/(3+3)+4*2 " +
      "from t1, t2, t3 " +
      "where t1.f1=t2.f1 and t1.f2 like 'asdf' or t1.f1=t2.f2";
//      "select ** from t1 where t1.f1 like 'asdf'";
    System.out.println(selectStr);
    L lexer=new L(new StringReader(selectStr));
    P parser=new P(lexer);
    try {
      parser.statement();
      CommonAST t=(CommonAST)parser.getAST();
      System.out.println(t.toStringList());
      T tree=new T();
      System.out.println(tree.statement(t).toString());
      
    } catch (RecognitionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (TokenStreamException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  private void testTranslator() {
    String[] testStr=new String[] {
        "联合 表1， 表2 存到 临时表",
        "比较 表1，表2 存到 tt 条件 存在 a.字段6 大于 b.字段2 并且 a.字段2 等于 'abcd' 或者 b.字段1 等于 20",
        "查询 所有 来自 表1 条件 表1.字段1 等于 1 并且 表1.字段2 包含 'abcd'"
    };
    
    Translator translator=new Translator();
    translator.getChKeywords();
    for (int i=0; i<testStr.length; i++) {
      translator.setChQuery(testStr[i]);
      DbTable[] tables=translator.getTables();
//    set table info
      for (int j=0; j<tables.length; j++) {
        tables[j].setEnName("table"+j);
        tables[j].addDbField("字段1", "field1");
        tables[j].addDbField("字段2", "field2");
        tables[j].addDbField("字段3", "field3");
        tables[j].addDbField("字段4", "field4");
        tables[j].addDbField("字段5", "field5");
        tables[j].addDbField("字段6", "field6");
      }
      translator.setTableInfo(tables);
      if (translator.hasError()) {
        ChWrongMessage[] msgs=translator.showWrongMsgs();
        for (int j=0; j<msgs.length; j++)
          System.out.println(msgs[j]);
        continue;
      } else {
        System.out.println(translator.getChQuery());
        QueryModel model=translator.getQueryModel();
        System.out.println(model.getEnQuery());
      }
    }
  }
  
  private void testEquations() {
    String equation="a.字/段6 大于 b.字段3 且 a.字段2 等于 'abcd' 或 b.字段1 等于 'abcd'";
    Translator translator=new Translator();
    translator.setChEquation(equation);
    
    DbTable[] tables=translator.getTables();
//    DbTable[] tables=new DbTable[] {
//        new DbTable("a", null),
//        new DbTable("b", null)
//    };
//  set table info
    for (int j=0; j<tables.length; j++) {
      tables[j].setEnName("table"+j);
      tables[j].addDbField("字段1", "field1");
      tables[j].addDbField("字段2", "field2");
      tables[j].addDbField("字段3", "field3");
      tables[j].addDbField("字段4", "field4");
      tables[j].addDbField("字段5", "field5");
      tables[j].addDbField("字/段6", "field6");
    }
    translator.setTableInfo(tables);

    if (translator.hasError()) {
      ChWrongMessage[] msgs=translator.showWrongMsgs();
      for (int j=0; j<msgs.length; j++)
        System.out.println(msgs[j]);
    } else {
      System.out.println(translator.getChQuery());
      System.out.println(translator.getQueryModel().getEnQuery());
    }
  }
}
