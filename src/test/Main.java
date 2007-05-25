package test;

import java.io.StringReader;
import java.util.Iterator;

import model.parser.AliasModel;
import model.parser.ChWrongMessage;
import model.parser.OrderAliasModel;
import model.parser.ParamModel;
import model.parser.QueryModel;
import model.parser.TableAliasModel;
import parser.L;
import parser.P;
import parser.T;
import translator.AppDbField;
import translator.AppDbTable;
import translator.DbField;
import translator.DbTable;
import translator.FromListVO;
import translator.GroupByListVO;
import translator.OrderByListVO;
import translator.SelectListVO;
import translator.Translator;
import translator.WhereListVO;
import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;

public class Main {
  public static void main(String[] args) {
  	int mNum = 0;
  	if (args.length > 0){
  		mNum = Integer.parseInt(args[0]);
  	}
  	if (mNum == 1 || mNum == 2 || mNum == 3 || mNum == 4 || mNum == 5){
  		FunctionsTestMain functionsTestMain = new FunctionsTestMain();
    	functionsTestMain.FunctionsTest(mNum);
  	}else{
  		Main main = new Main();
  		main.customQueryTest();
//  		main.testTranslator();
//      main.testUnion();
//      main.testCompare();
//      main.testSegment();
  	}
  }
 
  public void testSegment(){
    String[] segmentArr = new String[]{"求和(AI_94传票对照表.省/市代号) 作为 c", "(AI_94传票对照表.金额 加 AI_94传票对照表.货币码) 乘 AI_94传票对照月表.金额"};
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
    
//    segmentArr = new String[]{"AI_94传票对照表.省/市代号 + AI_94传票对照表.金额 大于 30", "AI_94传票对照月表.货币码 包含 'abcd'", "字符串右截( 字符串截取(AI_通用分户帐0701.省/市代号,1,4),1) 等于 '1'"};
    segmentArr = new String[]{"字符串右截( 字符串截取(AI_通用分户帐0701.省/市代号,1,4),1) 等于 '1'"};
    t = new Translator();
    for (int i = 0; i < segmentArr.length; i++){
      t.setChSegment(t.WHERE, segmentArr[i]);
      DbTable[] ts = t.getTables();
      t.addDbTable("AI_通用分户帐0701", "CNF");
      t.addDbField("AI_通用分户帐0701", "省/市代号", "CNF01");
      t.addDbField("AI_通用分户帐0701", "行号", "CNF02");
      t.addDbField("AI_通用分户帐0701", "金额", "CNF03");
      t.addDbField("AI_通用分户帐0701", "货币码", "CNF04");
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
    String str = "表比较 AI_94传票对照表, AI_94传票对照月表 条件 not exists AI_94传票对照表.省/市代号 等于 AI_94传票对照月表.省/市代号 并且 AI_94传票对照表.行号 大于 5 并且 AI_94传票对照表.行号 < 2";
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
//    String xml = t.getXmlString();
//    System.out.println("TO DB XML: " + xml);
    
    /*
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
    */
  }
  
  public void testUnion(){
  	String xml = "";
    String str = "表合并 表1, 表2, 表3, 表4";
    
    Translator t = new Translator();
    t.setChQuery(str);
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
    t.addDbTable("表3", "CNF_TEST3");
    t.addDbField("表3", "省/市代号", "CNF0111");
    t.addDbField("表3", "行号", "CNF0222");
    t.addDbField("表3", "金额", "CNF0333");
    t.addDbField("表3", "货币码", "CNF0444");
    t.addDbTable("表4", "CNF_TEST4");
    t.addDbField("表4", "省/市代号", "CNF01111");
    t.addDbField("表4", "行号", "CNF02222");
    t.addDbField("表4", "金额", "CNF03333");
    t.addDbField("表4", "货币码", "CNF04444");
    DbTable[] ts = t.getTables();
    t.updateDbTables(t, ts);
    if (t.hasError()){
      ChWrongMessage[] msgs = t.showWrongMsgs();
      for (int i = 0; i < msgs.length; i++){
        System.out.println(msgs[i]);
      }
      return;
    }else{
	    System.out.println(t.getChQuery());
	    System.out.println(t.getQueryModel().getEnString());
	    System.out.println(t.getQueryModel().getEmptyExecuteEnString("CNF2087803"));
	    System.out.println(t.getQueryModel().getExecuteEnString("CNF2087803"));
//	    xml = t.getXmlString();
//	    System.out.println("TO DB XML: " + xml);
    }
    
    /*
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
        String[] tableCnNameArr = t1.getQueryModel().getDbTableModel().getTablesNameArr();
        
        for (int i = 0; i < appDbTableArr.length; i++){
          AppDbTable appDbTable = appDbTableArr[i];
          AppDbField[] appDbFieldArr = appDbTable.getFields();
          System.out.println(appDbTable.getTableName());
        }
      }
    }catch (DocumentException e){
      e.printStackTrace();
    }
    */
  }
  
  public void customQueryTest(){
  	String[] strArr = new String[]{
  			"查询 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, AI_94传票对照表.金额 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 (AI_94传票对照表.利率(百分比%) 大于 0.123 并且 AI_94传票对照表.利%率 大于 0.5)" +
  			"	或者 (AI_94传票对照表.利率% 等于 0.88 并且 AI_94传票对照表.利率 小于 0.99)" +
  			" 排序 省/市代号, 行号",
  			
  			"查询 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, AI_94传票对照表.金额 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 字符串右截(字符串截取(AI_94传票对照表.省/市代号, 1, 4), 1) 等于 '1'",
  	};
  	
  	String[] strArr1 = new String[]{
  			"查询 数据类型转化(AI_94传票对照表.省/市代号 as char) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.省/市代号 为 char(10)) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.省/市代号 为 character) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.省/市代号 为 character(10)) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.省/市代号 为 varchar) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.省/市代号 为 varchar(20)) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.省/市代号 为 uniqueidentifierstr) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 bigint) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 int) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 integer) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 smallint) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 tinyint) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 decimal) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 decimal(10)) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 decimal(10, 2)) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化('89.09' 为 numeric) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 numeric(10)) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 numeric(10, 2)) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 double) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 float) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 float(12)) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.金额 为 real) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.内容 为 binary) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.内容 为 binary(200)) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.内容 为 varbinary) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.内容 为 varbinary(200)) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化('2007-01-01' 为 date) 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化('2007-01-01' 为 datetime) 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化('2007-01-01' 为 smalldatetime) 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化('2007-01-01' 为 time) 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化('2007-01-01' 为 timestamp) 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转化(AI_94传票对照表.标识 为 bit) 作为 标识 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  	};
  	
  	String[] strArr2 = new String[]{
  			"查询 将数据类型转化为(char, AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(char(10), AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(char(10), 字符串右截(AI_94传票对照表.省/市代号, 10)) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(character, AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(character(10), AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(varchar, AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(varchar(20), AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(uniqueidentifierstr, AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(bigint, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(int, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(integer, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(smallint, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(tinyint, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(decimal, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(decimal(10), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(decimal(10, 2), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(numeric, '89.09') 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(numeric(10), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(numeric(10, 2), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(double, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(float, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(float(12), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(real, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(binary, AI_94传票对照表.内容) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(binary(200), AI_94传票对照表.内容) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(varbinary, AI_94传票对照表.内容) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(varbinary(200), AI_94传票对照表.内容) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(date, '2007-01-01') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(date, '2007-01-01', 120) 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(datetime, '2007-01-01 12:01:21') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(smalldatetime, '2007-01-01') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(time, '2007-01-01') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(timestamp, '2007-01-01') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 将数据类型转化为(bit, AI_94传票对照表.标识) 作为 标识 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 convert(bit, AI_94传票对照表.标识) 作为 标识 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  		};
  	
  	
  	
  	Translator t = new Translator();
  	
  	System.out.println("==========convert函数测试========");
    for (int i = 0; i < strArr1.length; i++){
    	System.out.println("convert函数测试" + (i + 1) + "：");
    	t.setChQuery(strArr1[i]);
    	if (t.hasError()){
        ChWrongMessage[] msgs = t.showWrongMsgs();
        for (int j = 0; j < msgs.length; j++){
          System.out.println("【测试错误】" + msgs[j]);
        }
      }else{
      	t.addDbTable("AI_94传票对照表", "CNF");
        t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
        t.addDbField("AI_94传票对照表", "行号", "CNF02");
        t.addDbField("AI_94传票对照表", "金额", "CNF03");
        t.addDbField("AI_94传票对照表", "货币码", "CNF04");
        t.addDbField("AI_94传票对照表", "日期", "CNF05");
        t.addDbField("AI_94传票对照表", "日期1", "CNF05_1");
        t.addDbField("AI_94传票对照表", "日期2", "CNF05_2");
        t.addDbField("AI_94传票对照表", "标识", "CNF10");
        t.addDbField("AI_94传票对照表", "内容", "CNF50");
        t.addDbField("AI_94传票对照表", "利率", "CNF96");
        t.addDbField("AI_94传票对照表", "利率%", "CNF97");
        t.addDbField("AI_94传票对照表", "利%率", "CNF98");
        t.addDbField("AI_94传票对照表", "利率(百分比%)", "CNF99");
        t.updateDbTables(t, t.getTables());
        
        System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
        System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
        //System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
        //System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
      }
    	System.out.println();
    }
    
    System.out.println("==========cast函数测试========");
    for (int i = 0; i < strArr2.length; i++){
    	System.out.println("cast函数测试" + (i + 1) + "：");
    	t.setChQuery(strArr2[i]);
    	if (t.hasError()){
        ChWrongMessage[] msgs = t.showWrongMsgs();
        for (int j = 0; j < msgs.length; j++){
          System.out.println("【测试错误】" + msgs[j]);
        }
      }else{
      	t.addDbTable("AI_94传票对照表", "CNF");
        t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
        t.addDbField("AI_94传票对照表", "行号", "CNF02");
        t.addDbField("AI_94传票对照表", "金额", "CNF03");
        t.addDbField("AI_94传票对照表", "货币码", "CNF04");
        t.addDbField("AI_94传票对照表", "日期", "CNF05");
        t.addDbField("AI_94传票对照表", "日期1", "CNF05_1");
        t.addDbField("AI_94传票对照表", "日期2", "CNF05_2");
        t.addDbField("AI_94传票对照表", "标识", "CNF10");
        t.addDbField("AI_94传票对照表", "内容", "CNF50");
        t.addDbField("AI_94传票对照表", "利率", "CNF96");
        t.addDbField("AI_94传票对照表", "利率%", "CNF97");
        t.addDbField("AI_94传票对照表", "利%率", "CNF98");
        t.addDbField("AI_94传票对照表", "利率(百分比%)", "CNF99");
        t.updateDbTables(t, t.getTables());
        
        System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
        System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
        //System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
        //System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
      }
    	System.out.println();
    }
    
    System.out.println("============自定义查询测试==========");
    for (int i = 0; i < strArr.length; i++){
    	System.out.println("自定义查询测试" + (i + 1) + "：");
    	t.setChQuery(strArr[i]);
    	if (t.hasError()){
        ChWrongMessage[] msgs = t.showWrongMsgs();
        for (int j = 0; j < msgs.length; j++){
          System.out.println("【测试错误】" + msgs[j]);
        }
      }else{
      	t.addDbTable("AI_94传票对照表", "CNF");
        t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
        t.addDbField("AI_94传票对照表", "行号", "CNF02");
        t.addDbField("AI_94传票对照表", "金额", "CNF03");
        t.addDbField("AI_94传票对照表", "货币码", "CNF04");
        t.addDbField("AI_94传票对照表", "日期", "CNF05");
        t.addDbField("AI_94传票对照表", "日期1", "CNF05_1");
        t.addDbField("AI_94传票对照表", "日期2", "CNF05_2");
        t.addDbField("AI_94传票对照表", "标识", "CNF10");
        t.addDbField("AI_94传票对照表", "内容", "CNF50");
        t.addDbField("AI_94传票对照表", "利率", "CNF96");
        t.addDbField("AI_94传票对照表", "利率%", "CNF97");
        t.addDbField("AI_94传票对照表", "利%率", "CNF98");
        t.addDbField("AI_94传票对照表", "利率(百分比%)", "CNF99");
        t.updateDbTables(t, t.getTables());
        
        System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
        System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
        //System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
        //System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
      }
    	System.out.println();
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
          " 条件 非 (" +
          " (AI_94传票对照表.金额 大于 5000 或者 AI_94传票对照表.金额 < -9000)" + 
          " 或者 (AI_94传票对照表.行号 等于 '3' 并且 AI_94传票对照表.省/市代号 not like '001')" +
          " 并且 (AI_94传票对照表.金额 加 50) 大于 -50000" +
          " 并且 数值转字符串(AI_94传票对照表.金额) 等于 -5" +
          " 并且 AI_94传票对照表.行号 等于 '3' 并且 AI_94传票对照表.省/市代号 like '%HJD%'" +
          " 并且 AI_94传票对照表.省/市代号 非空" +
          " 并且 字符串截取(AI_94传票对照表.省/市代号, 1, 20) 等于 '355'" + 
          " 并且 (AI_94传票对照表.省/市代号 范围 1 3)" + 
          " 并且 AI_94传票对照表.金额 is not null" +
          " 并且 AI_94传票对照表.金额 左连接 AI_94传票对照表.金额" +
          ")" + 
          " 分组 数值转字符串(AI_94传票对照表.行号), 求平方根(AI_94传票对照表.省/市代号), AI_94传票对照表.行号, 字符串截取(AI_94传票对照表.金额, 1, 3)" + 
          " 排序 AI_94传票对照表.行号 降序, 金额 降序, AI_94传票对照表.行号 降序";
    
    str = " select 所有" +
			    " 来自 AI_94传票对照表 作为 CNF" + 
			    " 条件 (" +
			    " 字符串截取(AI_94传票对照表.利率%, 1, 3) = 'XYZ'" +
			    ")";
    
//  str = " 查询 now(*)" +
//  " 来自 AI_94传票对照表 作为 CNF" + 
//  " 条件 字符串右截( 字符串截取(AI_94传票对照表.省/市代号,1,4),1) 等于 '1'" +
//  " 条件 字符串截取(字符串右截(AI_通用分户帐0701.省/市代号, 4), 1, 3) 等于 '1'" +
//  " 条件 非 (" +
//  " (AI_94传票对照表.金额 大于 5000)" + 
//  " 或者 (AI_94传票对照表.行号 等于 '3')" +
//  " 或者 格式化日期(日期相加(day, 20, 将数据类型转化为(char(10), AI_94传票对照表.日期, 120)), day) 等于 '2007-01-01'" +
//  ")" + 
//  " 分组 AI_94传票对照表.省/市代号, 求字符串的长度(字符串左截(AI_94传票对照表.行号, 4)), AI_94传票对照表.日期" + 
//  " 排序 AI_94传票对照表.行号 降序, 金额 降序, AI_94传票对照表.行号 降序";
    
    

    Translator t = new Translator();
    t.setChQuery(str);
    
    QueryModel[] tableAliasModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(TableAliasModel.class);
    for (int i = 0; i < tableAliasModelArr.length; i++){
      TableAliasModel aliasModel = (TableAliasModel) tableAliasModelArr[i];
      aliasModel.setEnAlias("CNF20070101");
    }
    t.addDbTable("AI_94传票对照表", "CNF");
    t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
    t.addDbField("AI_94传票对照表", "行号", "CNF02");
    t.addDbField("AI_94传票对照表", "金额", "CNF03");
    t.addDbField("AI_94传票对照表", "货币码", "CNF04");
    t.addDbField("AI_94传票对照表", "日期", "CNF05");
    t.addDbField("AI_94传票对照表", "日期1", "CNF05_1");
    t.addDbField("AI_94传票对照表", "日期2", "CNF05_2");
    
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
    
    /*
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
    */
    
    System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
    System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
    System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
    System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//    String xml1 = t.getXmlString();
//    System.out.println("TO DB XML: " + xml1);
    
    /*
    Translator t1 = new Translator();
    String rXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "<query><ch_query_string>查询 唯一 所有 , 求和(e.字段2) 作为 a , 表1.字段1 , ( 表2.字段3 加 表2.字段4 ) 乘 表2.字段5 , 表3.字段1 加 表3.字段2 , 求平方根(表4.字段3)  来自 表1 作为 e, 表2 作为 f, 表3, 表4 条件 1 等于 1 并且 e.字段1 + e.字段2 大于 '30' 或者 表2.字段3 包含 'abcd' 或者 表3.字段1 非空 或者 表3.字段2 范围 1 2 分组 表1.字段1, 字符串截取(表1.字段3, 1, 4), 数值转字符串(表2.字段3), 表2.字段3 加 表2.字段4 排序  a, 表1.字段1 升序, 数值转字符串(表2.字段3), 求和(表2.字段4) 降序, 字符串截取(表1.字段3, 1, 4)</ch_query_string><db_info ch_name=\"表1\" en_name=\"table0\"><db_field ch_name=\"字段2\" en_name=\"field2\"/><db_field ch_name=\"字段3\" en_name=\"field3\"/><db_field ch_name=\"字段1\" en_name=\"field1\"/></db_info><db_info ch_name=\"表2\" en_name=\"table1\"><db_field ch_name=\"字段4\" en_name=\"field4\"/><db_field ch_name=\"字段5\" en_name=\"field5\"/><db_field ch_name=\"字段3\" en_name=\"field3\"/></db_info><db_info ch_name=\"表3\" en_name=\"table2\"><db_field ch_name=\"字段2\" en_name=\"field2\"/><db_field ch_name=\"字段1\" en_name=\"field1\"/></db_info><db_info ch_name=\"表4\" en_name=\"table3\"><db_field ch_name=\"字段3\" en_name=\"field3\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"a\" enAlias=\"enAlias0\"/><aliasListVO alias=\"e\" enAlias=\"enAlias1\"/><aliasListVO alias=\"f\" enAlias=\"enAlias2\"/></aliasListEqu><orderAliasListEqu><orderAliasListVO alias=\"a\" enAlias=\"enOrderAlias0\"/></orderAliasListEqu></query>";
    rXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
      + "<query><ch_query_string>查询 AI_94传票对照表.省/市代号 作为 省/市代号 , AI_94传票对照表.行号 作为 行号 , 求和(AI_94传票对照表.金额) 作为 金额  来自 AI_94传票对照表 条件 AI_94传票对照表.省/市代号 等于 '0200' 分组 AI_94传票对照表.省/市代号, AI_94传票对照表.行号 排序 求和(AI_94传票对照表.金额) 升序, AI_94传票对照表.行号 降序</ch_query_string><db_info ch_name=\"AI_94传票对照表\" en_name=\"CNF\" flag=\"casdb2\" tableParam=\"\"><db_field ch_name=\"行号\" en_name=\"CNF02\" fieldParam=\"\"/><db_field ch_name=\"货币码\" en_name=\"CNF04\" fieldParam=\"\"/><db_field ch_name=\"省/市代号\" en_name=\"CNF01\" fieldParam=\"\"/><db_field ch_name=\"金额\" en_name=\"CNF03\" fieldParam=\"\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"1\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"省/市代号\" enAlias=\"enAlias0\"/><aliasListVO alias=\"行号\" enAlias=\"enAlias1\"/><aliasListVO alias=\"金额\" enAlias=\"enAlias2\"/></aliasListEqu><orderAliasListEqu/></query>";
    rXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
      + "<query><ch_query_string circleType=\"1\">查询 AI_94传票对照表.省/市代号 作为 省/市代号 , AI_94传票对照表.行号 作为 行号 , 求和(AI_94传票对照表.金额) 作为 金额  来自 AI_94传票对照表 条件 AI_94传票对照表.省/市代号 等于 '0200' 分组 AI_94传票对照表.省/市代号, AI_94传票对照表.行号 排序 求和(AI_94传票对照表.金额) 升序, AI_94传票对照表.行号 降序</ch_query_string><db_info ch_name=\"AI_94传票对照表\" en_name=\"CNF\" flag=\"casdb2\" tableParam=\"CNF_table_Param\"><db_field ch_name=\"行号\" en_name=\"CNF02\" fieldParam=\"\"/><db_field ch_name=\"货币码\" en_name=\"CNF04\" fieldParam=\"\"/><db_field ch_name=\"省/市代号\" en_name=\"CNF01\" fieldParam=\"\"/><db_field ch_name=\"金额\" en_name=\"CNF03\" fieldParam=\"\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"1\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"省/市代号\" enAlias=\"enAlias0\"/><aliasListVO alias=\"行号\" enAlias=\"enAlias1\"/><aliasListVO alias=\"金额\" enAlias=\"enAlias2\"/></aliasListEqu><orderAliasListEqu/></query>";
    rXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
       + "<query><ch_query_string>查询 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, 求和(AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF, AI_94传票对照表 作为 标2 条件 非 ( ( AI_94传票对照表.金额 大于 5000 或者 AI_94传票对照表.金额 &lt; -9000 ) 或者 ( AI_94传票对照表.行号 等于 '3' 并且 AI_94传票对照表.省/市代号 不包含 '001' ) 并且 ( AI_94传票对照表.金额 加 50 ) 大于 -50000 并且 数值转字符串(AI_94传票对照表.金额) 等于 -5 并且 AI_94传票对照表.行号 等于 '3' 并且 AI_94传票对照表.省/市代号 不包含 '001' 并且 AI_94传票对照表.省/市代号 非空 并且 字符串截取(AI_94传票对照表.省/市代号, 1, 20) 等于 '355' 并且 AI_94传票对照表.省/市代号 范围 1 3 并且 AI_94传票对照表.金额 在于 (23, 12, 34, 350) ) 分组 数值转字符串(AI_94传票对照表.行号), 求平方根(AI_94传票对照表.省/市代号), AI_94传票对照表.行号, 字符串截取(AI_94传票对照表.金额, 1, 3) 排序 AI_94传票对照表.行号 降序, 金额 降序, AI_94传票对照表.行号 降序</ch_query_string><db_info ch_name=\"AI_94传票对照表\" en_name=\"CNF\" flag=\"\" tableParam=\"\"><db_field ch_name=\"省/市代号\" en_name=\"CNF01\" fieldParam=\"\"/><db_field ch_name=\"行号\" en_name=\"CNF02\" fieldParam=\"\"/><db_field ch_name=\"金额\" en_name=\"CNF03\" fieldParam=\"\"/><db_field ch_name=\"货币码\" en_name=\"CNF04\" fieldParam=\"\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/><SelectListVO fieldDataType=\"String\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/><WhereListVO checkedFlag=\"1\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"省/市代号\" enAlias=\"enAlias0\"/><aliasListVO alias=\"行号\" enAlias=\"enAlias1\"/><aliasListVO alias=\"金额\" enAlias=\"enAlias2\"/></aliasListEqu><tableAliasListEqu><tableAliasListVO alias=\"CNF\" enAlias=\"CNF20070101\"/><tableAliasListVO alias=\"标2\" enAlias=\"CNF20070101\"/></tableAliasListEqu><orderAliasListEqu><orderAliasListVO alias=\"金额\" enAlias=\"enOrderAlias0\"/></orderAliasListEqu></query>";
    try{
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
    */
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
