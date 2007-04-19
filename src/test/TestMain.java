package test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;

import model.parser.ParamModel;
import model.parser.SelectStatementModel;
import model.parser.TableCompareModel;

import parser.*;
import translator.*;
import model.parser.*;

import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.Tool;

public class TestMain {
  public static void main(String[] args) {
    TestMain main = new TestMain();
    main.testTranslator();
//    main.testUnion();
//    main.testCompare();
//    main.testSegment();
  }
  
  public void testSegment(){
    String[] segmentArr = new String[]{"求和 (AI_94传票对照表.省/市代号) 作为 c", "(AI_94传票对照表.金额 加 AI_94传票对照表.货币码) 乘 AI_94传票对照月表.金额"};
    Translator t = new Translator();
    for (int i = 0; i < segmentArr.length; i++){
      t.setChSegment(t.COLUMN, segmentArr[i]);
      DbTable[] ts = t.getTables();
      t.addDbTable("AI_94传票对照表", "CNF");
      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
      t.addDbField("AI_94传票对照表", "行号", "CNF02");
      t.addDbField("AI_94传票对照表", "金额", "CNF03");
      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
      t.addDbTable("AI_94传票对照月表", "CNF_TEST");
      t.addDbField("AI_94传票对照月表", "省/市代号", "CNF01");
      t.addDbField("AI_94传票对照月表", "行号", "CNF02");
      t.addDbField("AI_94传票对照月表", "金额", "CNF03");
      t.addDbField("AI_94传票对照月表", "货币码", "CNF04");
      t.updateDbTables(t, ts);
      if (t.hasError()){
        ChWrongMessage[] msgs = t.showWrongMsgs();
        for (int j = 0; j < msgs.length; j++){
          System.out.println(msgs[j]);
        }
      }
      System.out.println(t.getQueryModel().getChSegment(t.COLUMN));
      System.out.println(t.getQueryModel().getEnSegment(t.COLUMN));
    }
    
    segmentArr = new String[]{"AI_94传票对照表.省/市代号 + AI_94传票对照表.金额 大于 30", "AI_94传票对照月表.货币码 包含 'abcd'"};
    t = new Translator();
    for (int i = 0; i < segmentArr.length; i++){
      t.setChSegment(t.WHERE, segmentArr[i]);
      DbTable[] ts = t.getTables();
      t.addDbTable("AI_94传票对照表", "CNF");
      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
      t.addDbField("AI_94传票对照表", "行号", "CNF02");
      t.addDbField("AI_94传票对照表", "金额", "CNF03");
      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
      t.addDbTable("AI_94传票对照月表", "CNF_TEST");
      t.addDbField("AI_94传票对照月表", "省/市代号", "CNF01");
      t.addDbField("AI_94传票对照月表", "行号", "CNF02");
      t.addDbField("AI_94传票对照月表", "金额", "CNF03");
      t.addDbField("AI_94传票对照月表", "货币码", "CNF04");
      t.updateDbTables(t, ts);
      if (t.hasError()){
        ChWrongMessage[] msgs = t.showWrongMsgs();
        for (int j = 0; j < msgs.length; j++){
          System.out.println(msgs[j]);
        }
      }
      System.out.println(t.getQueryModel().getChSegment(t.WHERE));
      System.out.println(t.getQueryModel().getEnSegment(t.WHERE));
    }
    
  }
  
  public void testCompare(){
    String str = "表比较 AI_94传票对照表, AI_94传票对照月表 条件 不存在 AI_94传票对照表.省/市代号 等于 AI_94传票对照月表.省/市代号 并且 AI_94传票对照表.行号 大于 5";
    Translator t = new Translator();
    System.out.println(t.getCnKeyWordByValue(t.ENVALUE_COMPARE));
    System.out.println(t.getCnKeyWords(""));
    t.setChQuery(str);
    t.addDbTable("AI_94传票对照表", "CNF");
    t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
    t.addDbField("AI_94传票对照表", "行号", "CNF02");
    t.addDbField("AI_94传票对照表", "金额", "CNF03");
    t.addDbField("AI_94传票对照表", "货币码", "CNF04");
    t.addDbTable("AI_94传票对照月表", "CNF_TEST");
    t.addDbField("AI_94传票对照月表", "省/市代号", "CNF01");
    t.addDbField("AI_94传票对照月表", "行号", "CNF02");
    t.addDbField("AI_94传票对照月表", "金额", "CNF03");
    t.addDbField("AI_94传票对照月表", "货币码", "CNF04");
    DbTable[] ts = t.getTables();
    t.updateDbTables(t, ts);
    if (t.hasError()){
      ChWrongMessage[] msgs = t.showWrongMsgs();
      for (int i = 0; i < msgs.length; i++){
        System.out.println(msgs[i]);
      }
      return;
    }
    
    System.out.println(t.getChFromStr());
    System.out.println(t.getChWhereStr());
    
    AppDbTable[] appDbTableArr = t.getInfo().getDbTableInfoToAppTableArr();
    for (int i = 0; i < appDbTableArr.length; i++){
      AppDbTable appDbTable = appDbTableArr[i];
      AppDbField[] appDbFieldArr = appDbTable.getFields();
      System.out.println(appDbTable.getTableName());
    }
    System.out.println(t.getChQuery());
    System.out.println(t.getQueryModel().getEnString());
    System.out.println(t.getQueryModel().getEmptyExecuteEnString("CNF238494"));
    System.out.println(t.getQueryModel().getExecuteEnString("CNF238494"));
    String xml = t.getXmlString();
    System.out.println("TO DB XML: " + xml);
    
    Translator t1 = new Translator();
    try{
      QueryModel queryModel = t1.loadModelFromXML(xml);
      if (queryModel instanceof TableCompareModel){
        t1.clearInfo();
        t1.addDbTable("AI_94传票对照表", "CNF_HJD_2007");
        t1.addDbTable("AI_94传票对照月表", "CNF_TEST_HJD_2007");
        t1.addDbField("AI_94传票对照表", "省/市代号", "CNF011");
        t1.addDbField("AI_94传票对照表", "行号", "CNF021");
        t1.addDbField("AI_94传票对照表", "金额", "CNF031");
        t1.addDbField("AI_94传票对照表", "货币码", "CNF041");
        t1.addDbField("AI_94传票对照月表", "省/市代号", "CNF01_1");
        t1.addDbField("AI_94传票对照月表", "行号", "CNF02_1");
        t1.addDbField("AI_94传票对照月表", "金额", "CNF03_1");
        t1.addDbField("AI_94传票对照月表", "货币码", "CNF04_1");
        t1.updateDbTables(t1, t1.getTables());
        System.out.println(t1.getQueryModel().getEnString());
        System.out.println(t1.getQueryModel().getExecuteEnString("CNF070403"));
        TableCompareModel tableCompareModel = (TableCompareModel) queryModel;
        System.out.println(tableCompareModel.getChCompareMethod());
        System.out.println(t1.getChWhereStr());
      }
    }catch (DocumentException e){
      e.printStackTrace();
    }
    
  }
  
  public void testUnion(){
    String str = "表合并 表1, 表2";
    
    Translator t = new Translator();
    t.setChQuery(str);
    System.out.println(t.getChQuery());
    t.addDbTable("表1", "CNF");
    t.addDbField("表1", "省/市代号", "CNF01");
    t.addDbField("表1", "行号", "CNF02");
    t.addDbField("表1", "金额", "CNF03");
    t.addDbField("表1", "货币码", "CNF04");
    t.addDbTable("表2", "CNF_TEST");
    t.addDbField("表2", "省/市代号", "CNF011");
    t.addDbField("表2", "行号", "CNF022");
    t.addDbField("表2", "金额", "CNF033");
    t.addDbField("表2", "货币码", "CNF044");
    DbTable[] ts = t.getTables();
    t.updateDbTables(t, ts);
    System.out.println(t.getChFromStr());
    System.out.println(t.getChQuery());
    System.out.println(t.getQueryModel().getEnString());
    System.out.println(t.getQueryModel().getEmptyExecuteEnString("CNF2087803"));
    System.out.println(t.getQueryModel().getExecuteEnString("CNF2087803"));
    String xml = t.getXmlString();
    System.out.println("TO DB XML: " + xml);
    Translator t1 = new Translator();
    try{
      QueryModel queryModel = t1.loadModelFromXML(xml);
      if (queryModel instanceof TableUnionModel){
        t1.addDbTable("表1", "CNF_HJD_2007");
        t1.addDbTable("表2", "CNF_TEST_HJD_2007");
        t1.updateDbTables(t1, t1.getTables());
        System.out.println(t1.getQueryModel().getEnString());
        System.out.println(t1.getQueryModel().getExecuteEnString("CNF070403"));
        AppDbTable[] appDbTableArr = t1.getInfo().getDbTableInfoToAppTableArr();
        for (int i = 0; i < appDbTableArr.length; i++){
          AppDbTable appDbTable = appDbTableArr[i];
          AppDbField[] appDbFieldArr = appDbTable.getFields();
          System.out.println(appDbTable.getTableName());
        }
      }
    }catch (DocumentException e){
      e.printStackTrace();
    }
  }
  
  public void testTranslator() {
    String str = "查询 唯一 所有, 求和(e.字段2) 作为 a, 表1.字段1, (表2.字段3 加 表2.字段4) 乘 表2.字段5, 表3.字段1 加 表3.字段2, 求平方根(表4.字段3) \r\n"
        + "来自 表1 作为 e, 表2 作为 f, 表3, 表4 \r\n"
        + "条件 1 等于 1 并且 e.字段1+e.字段2 大于 '30' 或者 表2.字段3 包含 'abcd' 或者 表3.字段1 非空 或者 表3.字段2 范围 1 2 \r\n"
        + "分组 表1.字段1 加 表2.字段2, 表2.字段1 \r\n" + "排序 表1.字段1 升序, a 降序\r\n";
    str = "查询 唯一 所有, 求和(e.字段2) 作为 a, 表1.字段1, (表2.字段3 加 表2.字段4) 乘 表2.字段5, 表3.字段1 加 表3.字段2, 求平方根(表4.字段3) "
        + "来自 表1 作为 e, 表2 作为 f, 表3, 表4 "
        + "条件 1 等于 1 并且 e.字段1+e.字段2 大于 '30' 或者 表2.字段3 包含 'abcd' 或者 表3.字段1 非空 或者 表3.字段2 范围 1 2 "
        + "分组 表1.字段1, 字符串截取(表1.字段3, 1, 4), 数值转字符串(表2.字段3), 表2.字段3 加 表2.字段4 "
        + "排序 a, 表1.字段1 升序, 数值转字符串(表2.字段3), 求和(表2.字段4) 降序, 字符串截取(表1.字段3, 1, 4)";
    str = " 查询 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, 求和(AI_94传票对照表.金额) 作为 金额" +
          " 来自 AI_94传票对照表 作为 CNF, AI_94传票对照表 作为 标2" + 
//          " 条件 (" +
          " 条件 " +
          " AI_94传票对照表.金额 大于 -5000" + 
//          " ((AI_94传票对照表.金额) 大于 5000)" + 
//          " 或者 AI_94传票对照表.行号 等于 '3' 并且 AI_94传票对照表.省/市代号 不包含 '001'" +
//          " 并且 (AI_94传票对照表.金额 加 50) 大于 -50000" +
//          " 并且 数值转字符串(AI_94传票对照表.金额) 等于 -5" +
//          " 并且 AI_94传票对照表.行号 等于 '3' 并且 AI_94传票对照表.省/市代号 不包含 '001'" +
//          " 并且 AI_94传票对照表.省/市代号 非空" +
//          " 并且 字符串截取(AI_94传票对照表.省/市代号, 1, 20) 等于 '355'" + 
//          " 并且 AI_94传票对照表.省/市代号 范围 1 3" + 
//          " 并且 AI_94传票对照表.金额 在于(23, 12, 34, 350)" +
//          ")";
//    str = "查询 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, AI_94传票对照表.货币码 作为 货币码 " +
//        "来自 AI_94传票对照表 条件 AI_94传票对照表.省/市代号 等于 02 排序 AI_94传票对照表.省/市代号 升序";
//          " 条件 (AI_94传票对照表.金额  加 20) 大于 10000";
//          " 条件 非 (AI_94传票对照表.金额 - 45) > 0 c 并且 求平方根(AI_94传票对照表.金额) 大于 -5" +
          " 分组 数值转字符串(AI_94传票对照表.行号), 求平方根(AI_94传票对照表.省/市代号), AI_94传票对照表.行号, 字符串截取(AI_94传票对照表.金额, 1, 3)" +
          " 排序 AI_94传票对照表.行号 降序, 金额 降序, AI_94传票对照表.行号 降序";
//    str = "查询 AI_94传票对照表.金额 来自 AI_94传票对照表 条件 AI_94传票对照表.省/市代号 等于 -5";
    
    Translator t = new Translator();
    t.setChQuery(str);
    System.out.println(t.getChQuery());
    if (t.hasError()){
      ChWrongMessage[] msgs = t.showWrongMsgs();
      for (int i = 0; i < msgs.length; i++){
        System.out.println(msgs[i]);
      }
      return;
    }
    
    QueryModel[] tableAliasModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(TableAliasModel.class);
    for (int i = 0; i < tableAliasModelArr.length; i++){
      System.out.println(tableAliasModelArr[i].getChString());
      TableAliasModel aliasModel = (TableAliasModel) tableAliasModelArr[i];
      aliasModel.setEnAlias("CNF20070101");
      System.out.println(tableAliasModelArr[i].getEnString());
    }
    t.addDbTable("AI_94传票对照表", "CNF");
    t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
    t.addDbField("AI_94传票对照表", "行号", "CNF02");
    t.addDbField("AI_94传票对照表", "金额", "CNF03");
    t.addDbField("AI_94传票对照表", "货币码", "CNF04");
//  t.addDbTable("AI_94传票对照表", "CNF", "casdb2");
//  t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
//  t.addDbField("AI_94传票对照表", "行号", "CNF02");
//  t.addDbField("AI_94传票对照表", "金额", "CNF03");
//  t.addDbField("AI_94传票对照表", "货币码", "CNF04");
//  t.addDbTable("表2", "CNF_TEST");
//  t.addDbField("表2", "省/市代号", "CNF01");
//  t.addDbField("表2", "行号", "CNF02");
//  t.addDbField("表2", "金额", "CNF03");
//  t.addDbField("表2", "货币码", "CNF04");
    DbTable[] ts = t.getTables();
    t.updateDbTables(t, ts);
    
    //获取循环语句条件变量参数
    QueryModel[] paramModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(ParamModel.class);
    for (int i = 0; i < paramModelArr.length; i++){
      ParamModel paramModel = (ParamModel) paramModelArr[i];
      System.out.println(paramModelArr[i].getEnString());
      paramModel.setParamValue("01");
      System.out.println(paramModelArr[i].getEnString());
    }
    System.out.println(t.getQueryModel().getEnString());
    
    String selectStr = t.getChSelectStr();
    String fromStr = t.getChFromStr();
    String whereStr = t.getChWhereStr();
    String groupByStr = t.getChGroupByStr();
    String orderByStr = t.getChOrderByStr();
    
    //进行翻译后的英文表名及字段名
    System.out.println("============DB Table============");
    for (int i = 0; i < ts.length; i++){
      System.out.println(ts[i].getChName());
      System.out.println(ts[i].getEnName());
      for (Iterator it = ts[i].getFields().iterator(); it.hasNext();){
        DbField dbField = (DbField) it.next();
        System.out.println(dbField.getChName());
        System.out.println(dbField.getEnName());
      }
    }
    
    //各子句内容
    System.out.println("============Segment SQL===========");
    System.out.println(t.getChSelectStr());
    System.out.println(t.getChFromStr());
    System.out.println(t.getChWhereStr());
    System.out.println(t.getChGroupByStr());
    System.out.println(t.getChOrderByStr());
    
    SelectListVO[] _selectListVOArr = t.getSelectListVOArr();
    FromListVO[] _fromListVOArr = t.getFromListVOArr();
    WhereListVO[] _whereListVOArr = t.getWhereListVOArr();
    GroupByListVO[] _groupListVOArr = t.getGroupByListVOArr();
    OrderByListVO[] _orderListVOArr = t.getOrderByListVOArr();
    
    System.out.println("============SELECT EQUEM===========");
    for (int i = 0; i < _selectListVOArr.length; i++){
      System.out.println(_selectListVOArr[i].getCnColumnEquElem());
      _selectListVOArr[i].setCnFieldAlias("代号" + i);
      _selectListVOArr[i].setFieldDataType("String");
    }
    t.setSelectListVOArr(_selectListVOArr);
    
//  t.setSelectListVOArrToModel(_selectListVOArr);
    AliasModel[] aliasModels = t.getAliasModelListVOArrByModel();
    for (int i = 0; i < aliasModels.length; i++){
      System.out.println(aliasModels[i].getChString());
    }
    
    
    System.out.println("============WHERE EQUEM===========");
    for (int i = 0; i < _whereListVOArr.length; i++){
      System.out.println(_whereListVOArr[i].getCnAllWhereStr());
      _whereListVOArr[i].setCheckedFlag("1");
    }
    t.setWhereListVOArr(_whereListVOArr);
    
    System.out.println("============COLUNM ALIAS===========");
    QueryModel[] aliasModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(AliasModel.class);
    for (int i = 0; i < aliasModelArr.length; i++){
      System.out.println(aliasModelArr[i].getChString());
      AliasModel aliasModel = (AliasModel) aliasModelArr[i];
      aliasModel.setEnAlias("enAlias" + i);
    }
    aliasModels = t.getAliasModelListVOArrByModel();
    for (int i = 0; i < aliasModels.length; i++){
      System.out.println(aliasModels[i].getChString());
    }
    _selectListVOArr = t.getSelectListVOArr();
    
    System.out.println("============ORDER ALIAS===========");
    QueryModel[] orderAliasModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(OrderAliasModel.class);
    for (int i = 0; i < orderAliasModelArr.length; i++){
      System.out.println(orderAliasModelArr[i].getChString());
      OrderAliasModel orderAliasModel = (OrderAliasModel) orderAliasModelArr[i];
      orderAliasModel.setEnAlias("enOrderAlias" + i);
    }
    System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
    System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
    System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
    System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
    String xml1 = t.getXmlString();
    System.out.println("TO DB XML: " + xml1);
    
    Translator t1 = new Translator();
    String rXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "<query><ch_query_string>查询 唯一 所有 , 求和(e.字段2) 作为 a , 表1.字段1 , ( 表2.字段3 加 表2.字段4 ) 乘 表2.字段5 , 表3.字段1 加 表3.字段2 , 求平方根(表4.字段3)  来自 表1 作为 e, 表2 作为 f, 表3, 表4 条件 1 等于 1 并且 e.字段1 + e.字段2 大于 '30' 或者 表2.字段3 包含 'abcd' 或者 表3.字段1 非空 或者 表3.字段2 范围 1 2 分组 表1.字段1, 字符串截取(表1.字段3, 1, 4), 数值转字符串(表2.字段3), 表2.字段3 加 表2.字段4 排序  a, 表1.字段1 升序, 数值转字符串(表2.字段3), 求和(表2.字段4) 降序, 字符串截取(表1.字段3, 1, 4)</ch_query_string><db_info ch_name=\"表1\" en_name=\"table0\"><db_field ch_name=\"字段2\" en_name=\"field2\"/><db_field ch_name=\"字段3\" en_name=\"field3\"/><db_field ch_name=\"字段1\" en_name=\"field1\"/></db_info><db_info ch_name=\"表2\" en_name=\"table1\"><db_field ch_name=\"字段4\" en_name=\"field4\"/><db_field ch_name=\"字段5\" en_name=\"field5\"/><db_field ch_name=\"字段3\" en_name=\"field3\"/></db_info><db_info ch_name=\"表3\" en_name=\"table2\"><db_field ch_name=\"字段2\" en_name=\"field2\"/><db_field ch_name=\"字段1\" en_name=\"field1\"/></db_info><db_info ch_name=\"表4\" en_name=\"table3\"><db_field ch_name=\"字段3\" en_name=\"field3\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"a\" enAlias=\"enAlias0\"/><aliasListVO alias=\"e\" enAlias=\"enAlias1\"/><aliasListVO alias=\"f\" enAlias=\"enAlias2\"/></aliasListEqu><orderAliasListEqu><orderAliasListVO alias=\"a\" enAlias=\"enOrderAlias0\"/></orderAliasListEqu></query>";
    rXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
      + "<query><ch_query_string>查询 AI_94传票对照表.省/市代号 作为 省/市代号 , AI_94传票对照表.行号 作为 行号 , 求和(AI_94传票对照表.金额) 作为 金额  来自 AI_94传票对照表 条件 AI_94传票对照表.省/市代号 等于 '0200' 分组 AI_94传票对照表.省/市代号, AI_94传票对照表.行号 排序 求和(AI_94传票对照表.金额) 升序, AI_94传票对照表.行号 降序</ch_query_string><db_info ch_name=\"AI_94传票对照表\" en_name=\"CNF\" flag=\"casdb2\" tableParam=\"\"><db_field ch_name=\"行号\" en_name=\"CNF02\" fieldParam=\"\"/><db_field ch_name=\"货币码\" en_name=\"CNF04\" fieldParam=\"\"/><db_field ch_name=\"省/市代号\" en_name=\"CNF01\" fieldParam=\"\"/><db_field ch_name=\"金额\" en_name=\"CNF03\" fieldParam=\"\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"1\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"省/市代号\" enAlias=\"enAlias0\"/><aliasListVO alias=\"行号\" enAlias=\"enAlias1\"/><aliasListVO alias=\"金额\" enAlias=\"enAlias2\"/></aliasListEqu><orderAliasListEqu/></query>";
    rXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
      + "<query><ch_query_string circleType=\"1\">查询 AI_94传票对照表.省/市代号 作为 省/市代号 , AI_94传票对照表.行号 作为 行号 , 求和(AI_94传票对照表.金额) 作为 金额  来自 AI_94传票对照表 条件 AI_94传票对照表.省/市代号 等于 '0200' 分组 AI_94传票对照表.省/市代号, AI_94传票对照表.行号 排序 求和(AI_94传票对照表.金额) 升序, AI_94传票对照表.行号 降序</ch_query_string><db_info ch_name=\"AI_94传票对照表\" en_name=\"CNF\" flag=\"casdb2\" tableParam=\"CNF_table_Param\"><db_field ch_name=\"行号\" en_name=\"CNF02\" fieldParam=\"\"/><db_field ch_name=\"货币码\" en_name=\"CNF04\" fieldParam=\"\"/><db_field ch_name=\"省/市代号\" en_name=\"CNF01\" fieldParam=\"\"/><db_field ch_name=\"金额\" en_name=\"CNF03\" fieldParam=\"\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"1\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"省/市代号\" enAlias=\"enAlias0\"/><aliasListVO alias=\"行号\" enAlias=\"enAlias1\"/><aliasListVO alias=\"金额\" enAlias=\"enAlias2\"/></aliasListEqu><orderAliasListEqu/></query>";
    rXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
       + "<query><ch_query_string circleType=\"2\">查询 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, 求和(AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF_AS_D 条件 AI_94传票对照表.省/市代号 等于 {机构变量} 并且 求平方根(AI_94传票对照表.金额) 大于 40 分组 AI_94传票对照表.省/市代号, AI_94传票对照表.行号 排序  金额 升序, AI_94传票对照表.行号 降序</ch_query_string><db_info ch_name=\"AI_94传票对照表\" en_name=\"CNF\" flag=\"\" tableParam=\"\"><db_field ch_name=\"行号\" en_name=\"CNF02\" fieldParam=\"\"/><db_field ch_name=\"货币码\" en_name=\"CNF04\" fieldParam=\"\"/><db_field ch_name=\"省/市代号\" en_name=\"CNF01\" fieldParam=\"\"/><db_field ch_name=\"金额\" en_name=\"CNF03\" fieldParam=\"\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"省/市代号\" enAlias=\"enAlias0\"/><aliasListVO alias=\"行号\" enAlias=\"enAlias1\"/><aliasListVO alias=\"金额\" enAlias=\"enAlias2\"/></aliasListEqu><tableAliasListEqu><tableAliasListVO alias=\"CNF_AS_D\" enAlias=\"CNF20070101\"/></tableAliasListEqu><orderAliasListEqu><orderAliasListVO alias=\"金额\" enAlias=\"enOrderAlias0\"/></orderAliasListEqu></query>";
    try{
      System.out.println(rXML);
      QueryModel m = t1.loadModelFromXML(rXML);
      t1.setAliasModelListVOArrByXML();
      t1.setTableAliasModelListVOArrByXML();
      t1.setOrderAliasModelListVOArrByXML();
      System.out.println(m.getCircleType());
      SelectListVO[] r_selectListVOArr = t1.getSelectListVOArr();
      FromListVO[] r_fromListVOArr = t1.getFromListVOArr();
      WhereListVO[] r_whereListVOArr = t1.getWhereListVOArr();
      GroupByListVO[] r_groupListVOArr = t1.getGroupByListVOArr();
      OrderByListVO[] r_orderListVOArr = t1.getOrderByListVOArr();
      DbTable[] dbTables = t1.getTables();
      t1.updateDbTables(t1, dbTables);
      for (int i = 0; i < dbTables.length; i++){
        System.out.println(dbTables[i].getChName());
        System.out.println(dbTables[i].getEnName());
        for (Iterator it = dbTables[i].getFields().iterator(); it.hasNext();){
          DbField dbField = (DbField) it.next();
          System.out.println(dbField.getChName());
          System.out.println(dbField.getEnName());
        }
      }
      AppDbTable[] appDbTables = t1.getInfo().getDbTableInfoToAppTableArr();
      
//      for (int i = 0; i < r_selectListVOArr.length; i++){
//        r_selectListVOArr[i].setFieldDataType("Date");
//      }
//      t1.setSelectListVOArr(r_selectListVOArr);
     aliasModels = t1.getAliasModelListVOArrByModel();
      TableAliasModel[] tableAliasModels = t1.getTableAliasModelListVOArrByModel();
      tableAliasModels[0].setEnAlias("CNF00000");
      t1.updateDbTables(t1, t1.getTables());
      System.out.println(m.getChString());
      System.out.println(m.getEnString());
      System.out.println(m.getExecuteEnString("xxx"));
      System.out.println(t1.getXmlString());
    }catch (DocumentException e){
      e.printStackTrace();
    }
  }
  
  public void testGettingStart() {
    String str = "查询 字段 来自 表";
    GSL l = new GSL(new StringReader(str));
    GSP p = new GSP(l);
    try{
      p.startRule();
      CommonAST ast = (CommonAST) p.getAST();
      System.out.println(ast.toStringList());
    }catch (RecognitionException e){
      e.printStackTrace();
    }catch (TokenStreamException e){
      e.printStackTrace();
    }
  }

  public void testQueryParser() {
    String str = "select distinct *, 求和(表1.字段2) 作为 a, 表1.字段1, (表2.字段3 加 表2.字段4) * 表2.字段5, 表3.字段1 加 表3.字段2, 求平方根(表4.字段3) "
        + "from 表1 作为 e, 表2 作为 f, 表3, 表4 "
        + "where 1 等于 1 并且 e.字段1+e.字段2 大于 '30' 或者 表2.字段3 包含 'abcd' 或者 表3.字段1 非空 或者 表3.字段2 范围 1 2 "
        + "group by 表1.字段1 加 表2.字段2, 表2.字段1 " + "order by 表1.字段1 升序, a 降序";
    System.out.println(str);
    L lexer = new L(new StringReader(str));
    P parser = new P(lexer);
    try{
      parser.select_statement();
      CommonAST ast = (CommonAST) parser.getAST();
      System.out.println(ast.toStringList());
      T t = new T();
      QueryModel m = t.select_statement(ast);
      System.out.println(m.getChString());
    }catch (RecognitionException e){
      e.printStackTrace();
    }catch (TokenStreamException e){
      e.printStackTrace();
    }
  }

  private static void setTableInfo(DbTable[] tables) {
    for (int j = 0; j < tables.length; j++){
      System.out.println(tables[j].getChName());
      tables[j].setEnName("table" + j);
      tables[j].addDbField("字段1", "field1");
      tables[j].addDbField("字段2", "field2");
      tables[j].addDbField("字段3", "field3");
      tables[j].addDbField("字段4", "field4");
      tables[j].addDbField("字段5", "field5");
      tables[j].addDbField("字段6", "field6");
      tables[j].addDbField("金额", "field5");
      tables[j].addDbField("省/市代号", "field6");
      tables[j].addDbField("行号", "line_num");
      tables[j].addDbField("货币码", "code");
    }
  }
}
