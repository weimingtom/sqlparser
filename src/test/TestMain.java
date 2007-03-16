package test;

import java.io.StringReader;

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

public class TestMain {
  public static void main(String[] args) {
    TestMain main=new TestMain();
//    main.gettingStart();
    main.testSelect();
    main.testTranslator();
    main.testFragment();
//    System.out.println("a"+(char)32+"b");
  }
  
  private void gettingStart() {
    String str="'test string";
    GSL lexer=new GSL(new StringReader(str));
    GSP parser=new GSP(lexer);
    try {
      parser.startRule();
    } catch (RecognitionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (TokenStreamException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  private void testSelect() {
    String selectStr=
//      "select *, t1.f1, t1.f2, t2.f1, (t2.f2+t1.f1-20)/(3+3)+4*2, avg(adf.f1, f1.t1), t1.faf " +
//      "from t1, t2, t3 " +
//      "where t1.f1=t2.f1 and t1.f2 like 'adf' or t1.f1=t2.f2 " +
//      "group by t1.f1, t2.f2";
//      "select * from t1 where 1=1 union select * from t2 where 2=2";
      "select *, t1.f1 as f from t1 where 1=1 order by t1.f1";
    
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
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (TokenStreamException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  private void testTranslator() {
    String[] testStr=new String[] {
        "表合并 表1，表2 存到 临时表",
        "表比较 表1，表2 存到 tt 条件 不存在 a.字段6 大于 b.字段2 并且 a.字段2 等于 'abcd' 或者 b.字段1 等于 20",
        "查询 所有 来自 表1 条件 表1.字段1 等于 1 并且 表1.字段2 包含 'abcd' 分组 表1.字段2 排序 表.字段1",
        "查询 AI_94传票对照表.行号, AI_94传票对照表.货币码 来自 AI_94传票对照表 条件 AI_94传票对照表.行号 等于 '01' 排序 AI_94传票对照表.行号 分组 AI_94传票对照表.行号",
        "查询 AI_94传票对照表.行号, AI_94传票对照表.货币码, AI_94传票对照表.业务类别  来自 AI_94传票对照表 条件 AI_94传票对照表.行号 等于",
        "查询 [AI_94传票对照表.行号] 作为 tf 来自 [AI_94传票对照表] 条件 [AI_94传票对照表.行号] 等于 \"8047\" 分组 [AI_94传票对照表.行号] 排序 [AI_94传票对照表.行号]"
    };
    
    Translator translator=new Translator();
    for (int i=0; i<testStr.length; i++) {
      translator.setChQuery(testStr[i]);
      System.out.println(translator.getChQuery());
      DbTable[] tables=translator.getTables();
//    set table info
      for (int j=0; j<tables.length; j++) {
        tables[j].setEnName("table"+j);
        tables[j].addDbField("字段1", "field1");
        tables[j].addDbField("字段2", "field2");
        tables[j].addDbField("字段3", "field3");
        tables[j].addDbField("字段4", "field4");
        tables[j].addDbField("钞汇标志", "field5");
        tables[j].addDbField("货币码", "field6");
        tables[j].addDbField("行号", "field7");
        tables[j].addDbField("省/市代号", "field8");
        tables[j].addDbField("业务类别", "field9");
        tables[j].addDbField("公司代码", "field10");
        tables[j].addDbField("帐号", "field11");
        tables[j].addDbField("金额", "field12");
      }
      translator.setTableInfo(tables);
      if (translator.hasError()) {
        ChWrongMessage[] msgs=translator.showWrongMsgs();
        for (int j=0; j<msgs.length; j++)
          System.out.println(msgs[j]);
        continue;
      } else {
        QueryModel model=translator.getQueryModel();
        System.out.println(model.getEnQuery());
      }
    }
  }
  
  private void testFragment() {
    String equation="[a.字/段6] 大于 [b.字段3] 并且 [a.字段2] 等于 'abcd' 或者 [b.字段1] 等于 'abcd'";
    String columnList="[a.字/段6] 加 [b.字段2]+([a.字段2])，[a.字段2]，[b.字段1]";
    String column="[a.字/段6] 加 [b.字段2]+([a.字段2])";
    Translator translator=new Translator();
    translator.setChSegment(Translator.COLUMN, column);
    System.out.println(translator.getChQuery());
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
      System.out.println(translator.getQueryModel().getEnQuery());
    }
  }
}
