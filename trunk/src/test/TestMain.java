package test;

import java.io.StringReader;

import junit.framework.TestCase;

import parser.GSL;
import parser.GSP;
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

public class TestMain extends TestCase {
  public static void main(String[] args) {
    TestMain main=new TestMain();
    main.gettingStart();
//    main.myTestEnQuery();
//    main.myTestChQuery();
//    main.myTestChSegment();
    
  }
  
  public void gettingStart() {
    String str="开始";
    GSL l=new GSL(new StringReader(str));
    GSP p=new GSP(l);
    try {
      p.startRule();
    } catch (RecognitionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (TokenStreamException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void myTestEnQuery() {
    String selectStr=
      "ch_select *, t1.f1 as f, sqrt(t1.f1)+sqrt(t1.f2) \nfrom t1 where 1=1 order by t1.f1";
    
    System.out.println(selectStr);
    L lexer=new L(new StringReader(selectStr));
    P parser=new P(lexer);
    try {
      parser.statement();
      CommonAST t=(CommonAST)parser.getAST();
      System.out.println(t.toStringList());
      T tree=new T();
      System.out.println(tree.statement(t));
    } catch (RecognitionException e) {
      e.printStackTrace();
    } catch (TokenStreamException e) {
      e.printStackTrace();
    }
  }
  
  public void myTestChQuery() {
    String selectStr=
      "[查不询] 表1.字段1 [来自] 表1 [条件] 1 [等于] 1";
    Translator t=new Translator();
    t.setChQuery(selectStr);
    t.setTableInfo(setTableInfo(t.getTables()));
    ChWrongMessage[] msgs=t.showWrongMsgs();
    for (int i=0; i<msgs.length; i++)
      System.out.println(msgs[i]);
  }
  
  public void myTestChSegment() {
    String str="[表1.字/段6] [大于] [表2.字段3] [并且] [表1.字段2] [等于] 'abcd' [或者] [表1.字段1] [等于] 'abcd'";
    Translator t=new Translator();
    t.setChSegment(Translator.WHERE, str);
    t.setSegmentTableInfo(
        setTableInfo(t.getTables()));
    System.out.println(t.getQueryModel().getEnQuery());
  }
  
  public void testTranslatorStatement() {
    String[] input={
        "[表合并] 表1，表2 [存到] 临时表",
        "[表比较] 表1，表2 [存到] tt [条件] [不存在] a.字段1 [大于] b.字段2 [并且] a.字段2 [等于] 'abcd' [或者] b.字段1 [等于] 20",
        "[查询] [所有], 表1.字段1 [乘] 10 [来自] 表1 [条件] 表1.字段1 [等于] 1 [并且] 表1.字段2 [包含] 'abcd' [分组] 表1.字段2",
        "[查询] AI_94传票对照表.行号, AI_94传票对照表.货币码 [来自] AI_94传票对照表 [条件] AI_94传票对照表.行号 [等于] '01' [分组] AI_94传票对照表.行号 [排序] AI_94传票对照表.行号",
        "[查询] AI_94传票对照表.行号, AI_94传票对照表.货币码, AI_94传票对照表.业务类别 [来自] AI_94传票对照表 [条件] AI_94传票对照表.行号 [等于]",
        "[查询] [AI_94传票对照表.行号] [作为] tf [来自] [AI_94传票对照表] [条件] [AI_94传票对照表.行号] [等于] \"8047\" [分组] [AI_94传票对照表.行号] [排序] [AI_94传票对照表.行号]",
        "[查询] t1.字段1, t2.字段1 [来自] t1 [条件] 1=1"
    };
    String[] output={
        "CREATE TABLE [临时表] (field6, field4, field2, field5, field3, field1);INSERT INTO [临时表] (field6, field4, field2, field5, field3, field1) SELECT field6, field4, field2, field5, field3, field1 FROM table0 UNION ALL SELECT field6, field4, field2, field5, field3, field1 FROM table1",
        "SELECT * INTO [tt] FROM table0 WHERE NOT EXIST (SELECT * FROM table3 WHERE table1.field1 > table4.field2 and table1.field2 = 'abcd' or table4.field1 = 20)",
        "SELECT (*),table0.field1*10 FROM table0 WHERE table0.field1 = 1 and table0.field2 like 'abcd' GROUP BY table0.field2",
        "SELECT table0.null,table0.null FROM table0 WHERE table0.null = '01' GROUP BY table0.null ORDER BY table0.null",
        "SELECT table0.null,table0.null FROM table0 WHERE table0.null = '01' GROUP BY table0.null ORDER BY table0.null",
        "SELECT table0.null as tf FROM table0 WHERE table0.null = \"8047\" GROUP BY table0.null ORDER BY table0.null",
        "SELECT table0.field1,table1.field1 FROM table0 WHERE 1 = 1"
    };
    int[] errNum={0, 2, 0, 2, 1, 1, 1};
    Translator translator=new Translator();
    for (int i=0; i<input.length; i++) {
      translator.setChQuery(input[i]);
      translator.setTableInfo(
          setTableInfo(translator.getTables()));
      QueryModel model=translator.getQueryModel();
      if (translator.hasError()) {
        ChWrongMessage[] msgs = translator.showWrongMsgs();
        assertEquals(msgs.length, errNum[i]);
        for (int j=0; j<msgs.length; j++)
          System.out.println(msgs[j]);
      }
      else
        assertEquals(model.getEnQuery(), output[i]);
    }
  }
  
  public void testTranslatorSegment() {
    String[] segementType={
      Translator.WHERE, Translator.SELECT, Translator.COLUMN
    };
    String[] input={
        "[a.字/段6] [大于] [b.字段3] [并且] [a.字段2] [等于] 'abcd' [或者] [b.字段1] [等于] 'abcd'",
        "[a.字/段6] [加] [b.字段2]+([a.字段2])，[a.字段2]，[b.字段1]",
        "[a.字/段6] [加] [b.字段2]+([a.字段2])"
    };
    String[] output={
        "table0.field6 > table1.field3 and table0.field2 = 'abcd' or table1.field1 = 'abcd'",
        "table0.field6+table1.field2+(table0.field2),table0.field2,table1.field1",
        "table0.field6+table1.field2+(table0.field2)"
    };
    int[] errNum={0, 0, 0};
    
    Translator translator=new Translator();
    for (int i=0; i<input.length; i++) {
      translator.setChSegment(segementType[i], input[i]);
      translator.setSegmentTableInfo(
          setTableInfo(translator.getTables()));
      QueryModel model=translator.getQueryModel();

      if (translator.hasError()) {
        assertEquals(translator.showWrongMsgs().length, errNum[i]);
        ChWrongMessage[] msgs = translator.showWrongMsgs();
        for (int j=0; j<msgs.length; j++)
          System.out.println(msgs[j]);
      }
      else
        assertEquals(model.getEnQuery(), output[i]);
    }
  }
  
  private DbTable[] setTableInfo(DbTable[] tables) {
    for (int j=0; j<tables.length; j++) {
      tables[j].setEnName("table"+j);
      tables[j].addDbField("字段1", "field1");
      tables[j].addDbField("字段2", "field2");
      tables[j].addDbField("字段3", "field3");
      tables[j].addDbField("字段4", "field4");
      tables[j].addDbField("字段5", "field5");
      tables[j].addDbField("字/段6", "field6");
    }
    return tables;
  }
}
