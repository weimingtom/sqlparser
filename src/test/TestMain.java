package test;

import java.io.StringReader;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.DocumentException;

import junit.framework.TestCase;

import parser.L;
import parser.P;
import parser.T;
import translator.Translator;
import translator.model.ChWrongMessage;
import translator.model.DbField;
import translator.model.DbFieldAlias;
import translator.model.DbTable;
import translator.model.FromListVO;
import translator.model.QueryModel;
import translator.model.SelectListVO;
import translator.model.SelectModel;
import translator.model.WhereListVO;

import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;

public class TestMain extends TestCase {
  public static void main(String[] args) {
    TestMain main=new TestMain();
//    main.gettingStart();
//    main.myTestEnQuery();
    main.myTestChQuery();
//    main.testEfficiency();
//    main.otherTest();
//    main.myTestChSegment();

//    String src="查询 表1.字段1 来自 表1 条件查询 1 等于 1";
//    String from="查询";
//    String to="FROM";
//    System.out.println(main.replace(src, from, to));
  }
  
  public void myTestChQuery() {
    String selectStr=
      "[查询] [所有], ([求和](表1.字段2) + [求和](表2.字段2)) [作为] c, 表2.字段1, a.字段2 [来自] 表1 [作为] a, 表2, 表3 [作为] y " +
      "[条件] 表1.字段1 [等于] 'TEST' [并且] a.字段3 [包含] '%HJD%' [并且] 表2.字段2 [大于] 6";
    Translator t=new Translator();
    t.setChQuery(selectStr);
    System.out.println(t.getParser().getAST().toStringList());
    SelectListVO[] _selectListVOArr = t.getSelectListVOArr();
    FromListVO[] _fromListVOArr = t.getFromListVOArr();
    WhereListVO[] _whereListVO = t.getWhereListVOArr();
    DbFieldAlias[] _gDbFieldAliasArr = t.getDbFieldAlias();
    t.setTableInfo(setTableInfo(t.getTables()));
    t.setDbFieldAlias(setDbFieldAliasInfo(t.getDbFieldAlias()));
    String _rXMLStr = t.getQueryModel().getXmlString();
    if (t.hasError()) {
      ChWrongMessage[] msgs=t.showWrongMsgs();
      for (int i=0; i<msgs.length; i++)
        System.out.println(msgs[i]);
    } else {
      QueryModel _queryModel = t.getQueryModel();
      SelectModel _selectModel = (SelectModel) _queryModel;
      System.out.println(_queryModel.toString());
      System.out.println(_queryModel.getEnQuery());
      
      SelectListVO[] _rSelectListVOArr = _selectModel.getSelectListArr();
      for (int i = 0; i < _rSelectListVOArr.length; i++){
        System.out.println("字段名" + (i + 1) + ": " + _rSelectListVOArr[i].getCnColumnEquElem() +  " || " +
            "别名" + (i + 1) + ": " + _rSelectListVOArr[i].getCnFieldAlias());
      }
      
      FromListVO[] _rFromListVOArr = _selectModel.getFromListVOArr();
      for (int i = 0; i < _rFromListVOArr.length; i++){
        System.out.println("表名"+(i+1)+": " + _rFromListVOArr[i].getCnTableName() +  " || " +
            "表别名"+(i+1)+": " + _rFromListVOArr[i].getCnTAbleAlias());
      }
      
      WhereListVO[] _rWhereListVOArr = _selectModel.getWhereListVOArr();
      for (int i = 0; i < _rWhereListVOArr.length; i++){
        System.out.println("条件表达式"+(i+1)+": " + _rWhereListVOArr[i].getCnWhereEquElem() +  " || " +
            "关系运算符"+(i+1)+": " + _rWhereListVOArr[i].getCnComparSymbol() + " || " + "条件为: " + _rWhereListVOArr[i].getCnWhereValue());
      }
    }
    
    
    try{
      
      QueryModel _queryModel = QueryModel.createModelFromXml(_rXMLStr);
      SelectModel _selectMode = (SelectModel) _queryModel;
      
      SelectListVO[] _rSelectListVOArr = _queryModel.getSelectListArr();
      for (int i = 0; i < _rSelectListVOArr.length; i++){
        System.out.println("字段名" + (i + 1) + ": " + _rSelectListVOArr[i].getCnColumnEquElem() +  " || " +
            "别名" + (i + 1) + ": " + _rSelectListVOArr[i].getCnFieldAlias());
      }
      
      FromListVO[] _rFromListVOArr = _queryModel.getFromListVOArr();
      for (int i = 0; i < _rFromListVOArr.length; i++){
        System.out.println("表名"+(i+1)+": " + _rFromListVOArr[i].getCnTableName() +  " || " +
            "表别名"+(i+1)+": " + _rFromListVOArr[i].getCnTAbleAlias());
      }
      
      WhereListVO[] _rWhereListVOArr = _queryModel.getWhereListVOArr();
      for (int i = 0; i < _rWhereListVOArr.length; i++){
        System.out.println("条件表达式"+(i+1)+": " + _rWhereListVOArr[i].getCnWhereEquElem() +  " || " +
            "关系运算符"+(i+1)+": " + _rWhereListVOArr[i].getCnComparSymbol() + " || " + "条件为: " + _rWhereListVOArr[i].getCnWhereValue());
      }
    }catch (DocumentException e){
      e.printStackTrace();
    }
  }
  
  public String replace(String src, String from, String to) {
    String ret=src;
//    if (src.indexOf(from)>=0) {
    String lastResult="";
    do {
      lastResult=ret;
      String splitter="[\n| |\t]";
      String f="\\Q"+from+"\\E";
      String fromRegex=
        "("+splitter+f+splitter+
        "|^"+f+splitter+
        "|"+splitter+f+"$"+
        "|"+f+"$)";
      String t=" "+to+" ";
      ret=ret.replaceFirst(fromRegex, t);
    } while (!lastResult.equals(ret));
    return ret;
  }
  
  public void myTestEnQuery() {
    String selectStr=
      "select * from t1 order by t1.f1 asc";
    
    System.out.println(selectStr);
    L lexer=new L(new StringReader(selectStr));
    P parser=new P(lexer);
    try {
      parser.statement();
      CommonAST t=(CommonAST)parser.getAST();
      System.out.println(t.toStringTree());
      T tree=new T();
      System.out.println(tree.statement(t));
    } catch (RecognitionException e) {
      e.printStackTrace();
    } catch (TokenStreamException e) {
      e.printStackTrace();
    }
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
        "[查询] [所有], 表1.字段1 [不乘] 10 [来自] 表1 [条件] 表1.字段1 [等于] 1 [并且] 表1.字段2 [包含] 'abcd' [分组] 表1.字段2",
        "[查询] AI_94传票对照表.行号, AI_94传票对照表.货币码 [来自] AI_94传票对照表 [条件] AI_94传票对照表.行号 [等于] '01' [分组] AI_94传票对照表.行号 [排序] AI_94传票对照表.行号",
        "[查询] AI_94传票对照表.行号, AI_94传票对照表.货币码, AI_94传票对照表.业务类别 [来自] AI_94传票对照表 [条件] AI_94传票对照表.行号 [等于]",
        "[查询] AI_94传票对照表.行号 [作为] tf [来自] AI_94传票对照表 [条件] AI_94传票对照表.行号 [等于] \"80]47\" [分组] AI_94传票对照表.行号",
        "[查询] t1.字段1, t2.字段1 [来自] t1 [条件] 1=1"
    };
    String[] output={
        "CREATE TABLE [临时表] (line_num, field6, code, field4, field2, field5, field3, field1);INSERT INTO [临时表] (line_num, field6, code, field4, field2, field5, field3, field1) SELECT line_num, field6, code, field4, field2, field5, field3, field1 FROM table0 UNION ALL SELECT line_num, field6, code, field4, field2, field5, field3, field1 FROM table1",
        "", "",
        "SELECT table0.line_num,table0.code FROM table0 WHERE table0.line_num = '01' GROUP BY table0.line_num ORDER BY table0.line_num",
        "",
        "SELECT table0.line_num as tf FROM table0 WHERE table0.line_num = \"80]47\" GROUP BY table0.line_num",
        ""
    };
    int[] errNum={0, 2, 1, 0, 1, 0, 1};
    Translator translator=new Translator();
    for (int i=0; i<input.length; i++) {
      translator.setChQuery(input[i]);
      translator.setTableInfo(
          setTableInfo(translator.getTables()));
      if (translator.hasError()) {
        ChWrongMessage[] msgs = translator.showWrongMsgs();
        assertEquals(msgs.length, errNum[i]);
      }
      else {
        QueryModel model=translator.getQueryModel();
        assertEquals(model.getEnQuery(), output[i]);
      }
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
      if (translator.hasError()) {
        ChWrongMessage[] msgs=translator.showWrongMsgs();
        assertEquals(msgs.length, errNum[i]);
      }
      else {
        QueryModel model=translator.getQueryModel();
        assertEquals(model.getEnQuery(), output[i]);
      }
    }
  }
  
  public void testModelSave() {
    String[] input={
        "[表合并] 表1，表2 [存到] 临时表",
        "[表比较] 表1，表2 [存到] tt [条件] [不存在] 表1.字段1 [大于] 表2.字段2",
        "[查询] [所有], 表1.字段1 [乘] 10 [来自] 表1 [条件] 表1.字段1 [等于] 1"
    };
    
    String[] output={
        "CREATE TABLE [临时表] (field6, line_num, code, field4, field2, field5, field3, field1);INSERT INTO [临时表] (field6, line_num, code, field4, field2, field5, field3, field1) SELECT field6, line_num, code, field4, field2, field5, field3, field1 FROM table0 UNION ALL SELECT field6, line_num, code, field4, field2, field5, field3, field1 FROM table1",
        "SELECT * INTO [tt] FROM table0 WHERE NOT EXIST (SELECT * FROM table2 WHERE table0.field1 > table2.field2)",
        "SELECT (*),table0.field1*10 FROM table0 WHERE table0.field1 = 1",
    };
    Translator translator=new Translator();
    for (int i=0; i<input.length; i++) {
      translator.setChQuery(input[i]);
      translator.setSegmentTableInfo(
          setTableInfo(translator.getTables()));
      QueryModel model=translator.getQueryModel();
      String xml=model.getXmlString();
      try {
        QueryModel recModel=QueryModel.createModelFromXml(xml);
        assertEquals(recModel.getEnQuery(), output[i]);
      } catch (DocumentException e) {
        e.printStackTrace();
      }
    }
  }

  public void testEfficiency() {
    String template="[查询] [所有], 表1.字段1, 表2.字段1, 表3.字段1 [来自] 表1 [条件] 表1.字段1 [等于] 1 [并且] 表1.字段2 [包含] 'abcd' [分组] 表1.字段2";
    int size=500;
    String[] xml=new String[size];
    Date parseStart=new Date();
    for (int i=0; i<size; i++) {
      Translator t=new Translator();
      t.setChQuery(template);
      t.setTableInfo(setTableInfo(t.getTables(), 100));
      QueryModel model=t.getQueryModel();
      xml[i]=model.getXmlString();
    }
    Date parseEnd=new Date();
    long parseTime=parseEnd.getTime()-parseStart.getTime();
    
    for (int i=0; i<size; i++) {
      try {
        QueryModel model=QueryModel.createModelFromXml(xml[i]);
        assertNotNull(model);
      } catch (DocumentException e) {
        e.printStackTrace();
      }
    }
    Date saveEnd=new Date();
    long saveTime=saveEnd.getTime()-parseEnd.getTime();
    
    assertTrue(parseTime+saveTime<10000);
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
      tables[j].addDbField("行号", "line_num");
      tables[j].addDbField("货币码", "code");
    }
    return tables;
  }
  
  private DbFieldAlias[] setDbFieldAliasInfo(DbFieldAlias[] _iDbFieldAlias) {
    for (int j = 0; j < _iDbFieldAlias.length; j++) {
      _iDbFieldAlias[j].setEnFieldAlias("en_field_alias_" + (j + 1));
    }
    return _iDbFieldAlias;
  }
  
  private DbTable[] setTableInfo(DbTable[] tables, int fieldSize) {
    for (int i=0; i<tables.length; i++) {
      tables[i].setEnName("table"+i);
      for (int j=0; j<fieldSize; j++) 
        tables[i].addDbField("字段"+j, "field"+j);
    }
    return tables;
  }
  
  public void otherTest() {
    String xml="<query class=\"translator.model.UnionModel\"><property name=\"ch_table1\" value=\"表1\"/><property name=\"ch_table2\" value=\"表2\"/><property name=\"ch_into\" value=\"[临时表]\"/><db_info_list><db_info ch_name=\"表1\" en_name=\"table0\" exist_in_form=\"true\"><db_field ch_name=\"行号\" en_name=\"line_num\"/><db_field ch_name=\"字/段6\" en_name=\"field6\"/><db_field ch_name=\"货币码\" en_name=\"code\"/><db_field ch_name=\"字段4\" en_name=\"field4\"/><db_field ch_name=\"字段2\" en_name=\"field2\"/><db_field ch_name=\"字段5\" en_name=\"field5\"/><db_field ch_name=\"字段3\" en_name=\"field3\"/><db_field ch_name=\"字段1\" en_name=\"field1\"/></db_info><db_info ch_name=\"表2\" en_name=\"table1\" exist_in_form=\"true\"><db_field ch_name=\"行号\" en_name=\"line_num\"/><db_field ch_name=\"字/段6\" en_name=\"field6\"/><db_field ch_name=\"货币码\" en_name=\"code\"/><db_field ch_name=\"字段4\" en_name=\"field4\"/><db_field ch_name=\"字段2\" en_name=\"field2\"/><db_field ch_name=\"字段5\" en_name=\"field5\"/><db_field ch_name=\"字段3\" en_name=\"field3\"/><db_field ch_name=\"字段1\" en_name=\"field1\"/></db_info><db_info ch_name=\"临时表\" en_name=\"table2\" exist_in_form=\"true\"><db_field ch_name=\"行号\" en_name=\"line_num\"/><db_field ch_name=\"字/段6\" en_name=\"field6\"/><db_field ch_name=\"货币码\" en_name=\"code\"/><db_field ch_name=\"字段4\" en_name=\"field4\"/><db_field ch_name=\"字段2\" en_name=\"field2\"/><db_field ch_name=\"字段5\" en_name=\"field5\"/><db_field ch_name=\"字段3\" en_name=\"field3\"/><db_field ch_name=\"字段1\" en_name=\"field1\"/></db_info></db_info_list><map_en_ch><en_to_ch en=\"into\" ch=\"[存到]\"/><en_to_ch en=\"t_union\" ch=\"[表合并]\"/><en_to_ch en=\",\" ch=\"，\"/></map_en_ch><ch_query value=\"[表合并] 表1，表2 [存到] 临时表\"/></query>";
    QueryModel model;
    try {
      model = QueryModel.createModelFromXml(xml);
      System.out.println(model);
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }
}
