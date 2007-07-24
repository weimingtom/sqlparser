package test;

import java.io.StringReader;
import java.util.Iterator;

//import org.dom4j.DocumentException;

import model.parser.AliasModel;
import model.parser.ChWrongMessage;
import model.parser.OrderAliasModel;
import model.parser.ParamModel;
import model.parser.QueryModel;
import model.parser.TableAliasModel;
import model.parser.common.DataBaseType;
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

public class Main {
  public static void main(String[] args) {
  	int mNum = 0;
  	if (args.length > 0){
  		mNum = Integer.parseInt(args[0]);
  	}
  	if (mNum == 1 || mNum == 2 || mNum == 3 || mNum == 4 
  			|| mNum == 5 || mNum == 6 || mNum == 7){
  		FunctionsTestMain functionsTestMain = new FunctionsTestMain();
    	functionsTestMain.FunctionsTest(mNum);
  	}else{
  		Main main = new Main();
  		main.testSegment();
  		main.testUnion();
      main.testCompare();
//  		main.customQueryTest();
  		main.testTranslator();
  	}
  }
 
  public void testSegment(){
    String[] segmentArr = new String[]{"求总和(AI_94传票对照表.省/市代号) 作为 c", "((AI_94传票对照表.金额 加 AI_94传票对照表.货币码) 乘 AI_94传票对照月表.金额)"};
    Translator t = new Translator();
    
    System.out.println("SELECT子句测试：");
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
      System.out.println("CN SQL IS: " + t.getQueryModel().getChSegment(t.COLUMN));
      System.out.println("EN SQL IS: " + t.getQueryModel().getEnSegment(t.COLUMN));
      System.out.println("");
    }
    
    segmentArr = new String[]{"右截字符串( 字符串截取(AI_通用分户帐0701.省/市代号,1,4),1) 等于 '1'"};
    t = new Translator();
    System.out.println("WHERE子句测试：");
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
      System.out.println("CN SQL IS: " + t.getQueryModel().getChSegment(t.WHERE));
      System.out.println("EN SQL IS: " + t.getQueryModel().getEnSegment(t.WHERE));
    }
    System.out.println("");
  }
  
  public void testCompare(){
    String str = "表比较 AI_94传票对照表, AI_94传票对照月表 条件 存在 AI_94传票对照表.省/市代号 等于 AI_94传票对照月表.省/市代号";
    Translator t = new Translator();
    System.out.println("比较语句测试：");
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
    
//    System.out.println(t.getChFromStr());
//    System.out.println(t.getChWhereStr());
    
    AppDbTable[] appDbTableArr = t.getInfo().getDbTableInfoToAppTableArr();
    for (int i = 0; i < appDbTableArr.length; i++){
      AppDbTable appDbTable = appDbTableArr[i];
      AppDbField[] appDbFieldArr = appDbTable.getFields();
//      System.out.println(appDbTable.getTableName());
    }

    System.out.println("IN SQL IS: " + t.getQueryModel().getChQuery());
    System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
    System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
    System.out.println("EMPTY SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("CNF238494"));
    System.out.println("EXECUTE SQL IS: " + t.getQueryModel().getExecuteEnString("CNF238494"));
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
    System.out.println("");
  }
  
  public void testUnion(){
  	String xml = "";
    String str = "表合并 表1, 表2, 表3, 表4";
    System.out.println("追加语句测试：");
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
    System.out.println("");
  }
  
  public void customQueryTest(){
  	String[] strArr = new String[]{
  			"SeLECT distinct AI_94传票对照表.行号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 前N条 10 AI_94传票对照表.行号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 top 20 AI_94传票对照表.行号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 唯一 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, AI_94传票对照表.金额 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 (AI_94传票对照表.利率(百分比%) 大于 0.123 并且 AI_94传票对照表.利%率 大于 0.5)" +
  			"	或者 (AI_94传票对照表.利率% 等于 0.88 并且 AI_94传票对照表.利率 小于 0.99)" +
  			" 排序 省/市代号, 行号",
  			
  			"查询 distinct top 20 abs(-900), AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, AI_94传票对照表.金额 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 右截字符串(字符串截取(AI_94传票对照表.省/市代号, 1, 4), 1) 等于 '1'",
  			
  			"查询 唯一 前N条 30 AI_94传票对照表.行号, (求幂(2, 3) 加 45), (AI_94传票对照表.金额 加 AI_94传票对照表.货币码) 乘 AI_94传票对照表.金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 右截字符串(字符串截取(AI_94传票对照表.省/市代号, 1, 4), 1) 等于 '1'",
  			
  			" 查询 distinct 前N条 10 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, 求总和(AI_94传票对照表.金额) 作为 金额" +
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
		    " 并且 AI_94传票对照表.金额 为空" +
		    " 并且 AI_94传票对照表.金额 左连接 AI_94传票对照表.金额" +
		    ")" + 
		    " 分组 AI_94传票对照表.省/市代号, AI_94传票对照表.行号" + 
		    " 排序 AI_94传票对照表.行号 降序, 金额 降序, AI_94传票对照表.行号 降序",
  			
		    " 查询 测试过渡一.出票日期 作为 出票日期, 测试过渡一.出票人代码 作为 出票人代码, 测试过渡一.机构编码 作为 机构编码, 求总和(测试过渡一.汇票金额) 作为 汇票金额" +
		    " 来自 测试过渡一" +
		    " 分组 测试过渡一.机构编码, 测试过渡一.出票人代码, 测试过渡一.出票日期" +
		    " 排序 测试过渡一.机构编码 升序, 测试过渡一.出票人代码 升序, 测试过渡一.出票日期 升序",
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
  			"查询 数据类型转换(char, AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(char(10), AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(char(10), 右截字符串(AI_94传票对照表.省/市代号, 120)) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(character, AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(character(10), AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(varchar, AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(varchar(20), AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(uniqueidentifierstr, AI_94传票对照表.省/市代号) 作为 省/市代号 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(bigint, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(int, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(integer, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(smallint, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(tinyint, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(decimal, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(decimal(10), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(decimal(10, 2), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(numeric, '89.09') 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(numeric(10), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(numeric(10, 2), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(double, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(float, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(float(12), AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(real, AI_94传票对照表.金额) 作为 金额 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(binary, AI_94传票对照表.内容) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(binary(200), AI_94传票对照表.内容) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(varbinary, AI_94传票对照表.内容) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(varbinary(200), AI_94传票对照表.内容) 作为 内容 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(date, '2007-01-01') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(DATE, '2007-01-01', 120) 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(datetime, '2007-01-01 12:01:21') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(smalldatetime, '2007-01-01') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(time, '2007-01-01') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(timestamp, '2007-01-01') 作为 日期 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 数据类型转换(bit, AI_94传票对照表.标识) 作为 标识 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  			
  			"查询 convert(bit, AI_94传票对照表.标识) 作为 标识 来自 AI_94传票对照表 作为 CNF" +
  			" 条件 AI_94传票对照表.省/市代号 等于 '1'",
  		};
  	
  	Translator t = new Translator();
  	
  	System.out.println("==========cast函数测试========");
    for (int i = 0; i < strArr1.length; i++){
    	System.out.println("cast函数测试" + (i + 1) + "：");
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
    
    System.out.println("==========convert函数测试========");
    for (int i = 0; i < strArr2.length; i++){
    	System.out.println("convert函数测试" + (i + 1) + "：");
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
    
    
    str = " select 所有, -780, abs(-900) + 400, AI_94传票对照表.省/市代号 as 省/市代号, AI_94传票对照表.行号 作为 行号, 求总和(AI_94传票对照表.金额) 作为 金额" +
			    " 来自 AI_94传票对照表 作为 CNF, AI_94传票对照表 作为 标2" + 
			    " 条件 not (" +
			    " (AI_94传票对照表.金额 大于 5000 或者 AI_94传票对照表.金额 小于 -9000)" + 
			    " or (AI_94传票对照表.行号 等于 '3' 并且 AI_94传票对照表.省/市代号 not like '001')" +
			    " or (AI_94传票对照表.金额 * 50) 大于 -50000" +
			    " 并且 str(AI_94传票对照表.金额) 等于 -5" +
			    " 并且 AI_94传票对照表.行号 等于 '3' 并且 AI_94传票对照表.省/市代号 like '%HJD%'" +
			    " 并且 AI_94传票对照表.省/市代号 is NOT null" +
			    " 并且 字符串截取(AI_94传票对照表.省/市代号, 1, 20) 等于 '355'" + 
			    " 并且 (AI_94传票对照表.省/市代号 between 1 AND 3)" + 
			    " 并且 AI_94传票对照表.金额% 非空" +
			    " 并且 AI_94传票对照表.金额 左连接 AI_94传票对照表.金额" +
			    ")" + 
			    " 分组 AI_94传票对照表.省/市代号, AI_94传票对照表.行号, abs(-900) + 400" + 
			    " 排序 AI_94传票对照表.行号 降序, 金额 降序, AI_94传票对照表.行号 降序";
  
//    str = "查询 AI_94传票对照表.省/市代号 作为 省/市代号,AI_94传票对照表.行号 作为 行号, 取绝对值(AI_94传票对照表.金额) 作为 金额" +
//    " 来自 AI_94传票对照表 作为 CNF" +
//    " 条件 not(" +
//    "	(AI_94传票对照表.金额 大于 1000000) 并且 (AI_94传票对照表.行号 not in('232', '390', '900'))" +
//    "	并且 AI_94传票对照表.货币码 not exists(select distinct AI_94传票对照表.货币码 from AI_94传票对照表)" +
//    ")";
    
    str = " 查询 AI_94传票对照表.省/市代号 作为 省/市代号, AI_94传票对照表.行号 作为 行号, 取绝对值(AI_94传票对照表.金额) 作为 金额 " +
    		  " 来自 AI_94传票对照表 作为 CNF 条件 非 ( " +
    		  "( AI_94传票对照表.金额 大于 1000000 ) " +
    		  "并且 ( AI_94传票对照表.行号 不在于 ('232', '390', '900') ) " +
    		  "并且 AI_94传票对照表.货币码 不存在 (查询 唯一 AI_94传票对照表.货币码 来自 AI_94传票对照表) " +
    		  "并且 AI_94传票对照表.货币码 NOT IN(查询 唯一 AI_94传票对照表.货币码 来自 AI_94传票对照表 where AI_94传票对照表.行号 exists (select distinct AI_94传票对照表.行号 from AI_94传票对照表) )" +
    		  ")";
    
    str = "查询 AI_94传票对照表.省/市代号 作为 省/市代号,AI_94传票对照表.行号 作为 行号, 取绝对值(AI_94传票对照表.金额) 作为 金额" +
					" 来自 AI_94传票对照表 作为 CNF"+
    			" 条件 AI_94传票对照表.行号 > 100";
//    str = "查询 AI_94传票对照表.省/市代号 来自 AI_94传票对照表 条件 AI_94传票对照表.省/市代号 大于 '50' 并且 求行号 小于等于 10000";
    
    Translator t = new Translator();
    t.setDatabaseType(DataBaseType.MS_SQLSERVER2000);
//    String _cnKeyWords = t.getCnKeyWords(Translator.CNKEY_WORDS);
//    String _cnKeyLogic = t.getCnKeyWords(Translator.CNKEY_LOGICSYMBOL);
//		String _cnKeyFun = t.getCnKeyWords(Translator.CNKEY_FUNC);
//		String _cnKeyOper = t.getCnKeyWords(Translator.CNKEY_OPERSYMBOL);
//		String _cnKeyNumber = t.getCnKeyWords(Translator.CNKEY_NUMBERSYMBOL);
    
    System.out.println("自定义查询测试：");
    t.setChQuery(str, false);
    if (t.hasError()){
      ChWrongMessage[] msgs = t.showWrongMsgs();
      for (int j = 0; j < msgs.length; j++){
        System.out.println("【测试错误】" + msgs[j]);
      }
      return;
    }
    
    QueryModel[] tableAliasModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(TableAliasModel.class);
    for (int i = 0; i < tableAliasModelArr.length; i++){
      TableAliasModel aliasModel = (TableAliasModel) tableAliasModelArr[i];
      aliasModel.setEnAlias("CNF20070101");
    }
    t.addDbTable("通用分户帐2007", "CNF");
    t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
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
    
    if (t.hasError()){
      ChWrongMessage[] msgs = t.showWrongMsgs();
      for (int j = 0; j < msgs.length; j++){
        System.out.println("【测试错误】" + msgs[j]);
      }
      return;
    }
    
    //获取循环语句条件变量参数
    QueryModel[] paramModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(ParamModel.class);
    for (int i = 0; i < paramModelArr.length; i++){
      ParamModel paramModel = (ParamModel) paramModelArr[i];
      System.out.println(paramModelArr[i].getEnString());
      paramModel.setParamValue("01");
      System.out.println(paramModelArr[i].getEnString());
    }
    
//    String selectStr = t.getChSelectStr();
//    String fromStr = t.getChFromStr();
//    String whereStr = t.getChWhereStr();
//    String groupByStr = t.getChGroupByStr();
//    String orderByStr = t.getChOrderByStr();
//    
//    //进行翻译后的英文表名及字段名
//    System.out.println("============DB Table============");
//    for (int i = 0; i < ts.length; i++){
//      System.out.println(ts[i].getChName());
//      System.out.println(ts[i].getEnName());
//      for (Iterator it = ts[i].getFields().iterator(); it.hasNext();){
//        DbField dbField = (DbField) it.next();
//        System.out.println(dbField.getChName());
//        System.out.println(dbField.getEnName());
//      }
//    }
//    
//    //各子句内容
//    System.out.println("============Segment SQL===========");
//    System.out.println(t.getChSelectStr());
//    System.out.println(t.getChFromStr());
//    System.out.println(t.getChWhereStr());
//    System.out.println(t.getChGroupByStr());
//    System.out.println(t.getChOrderByStr());
    
    SelectListVO[] _selectListVOArr = t.getSelectListVOArr();
    FromListVO[] _fromListVOArr = t.getFromListVOArr();
    WhereListVO[] _whereListVOArr = t.getWhereListVOArr();
    GroupByListVO[] _groupListVOArr = t.getGroupByListVOArr();
    OrderByListVO[] _orderListVOArr = t.getOrderByListVOArr();
    
//    System.out.println("============SELECT EQUEM===========");
//    for (int i = 0; i < _selectListVOArr.length; i++){
//      System.out.println(_selectListVOArr[i].getCnColumnEquElem());
//      _selectListVOArr[i].setCnFieldAlias("代号" + i);
//      _selectListVOArr[i].setFieldDataType("String");
//    }
//    t.setSelectListVOArr(_selectListVOArr);
//    
////  t.setSelectListVOArrToModel(_selectListVOArr);
//    AliasModel[] aliasModels = t.getAliasModelListVOArrByModel();
//    for (int i = 0; i < aliasModels.length; i++){
//      System.out.println(aliasModels[i].getChString());
//    }
//    
//    
//    System.out.println("============WHERE EQUEM===========");
//    for (int i = 0; i < _whereListVOArr.length; i++){
//      System.out.println(_whereListVOArr[i].getCnAllWhereStr());
//      _whereListVOArr[i].setCheckedFlag("1");
//    }
//    t.setWhereListVOArr(_whereListVOArr);
//    
//    System.out.println("============COLUNM ALIAS===========");
//    QueryModel[] aliasModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(AliasModel.class);
//    for (int i = 0; i < aliasModelArr.length; i++){
//      System.out.println(aliasModelArr[i].getChString());
//      AliasModel aliasModel = (AliasModel) aliasModelArr[i];
//      aliasModel.setEnAlias("enAlias" + i);
//    }
//    aliasModels = t.getAliasModelListVOArrByModel();
//    for (int i = 0; i < aliasModels.length; i++){
//      System.out.println(aliasModels[i].getChString());
//    }
//    _selectListVOArr = t.getSelectListVOArr();
//    
//    System.out.println("============ORDER ALIAS===========");
//    QueryModel[] orderAliasModelArr = t.getQueryModel().getModelsFromAllChildrenByClass(OrderAliasModel.class);
//    for (int i = 0; i < orderAliasModelArr.length; i++){
//      System.out.println(orderAliasModelArr[i].getChString());
//      OrderAliasModel orderAliasModel = (OrderAliasModel) orderAliasModelArr[i];
//      orderAliasModel.setEnAlias("enOrderAlias" + i);
//    }
    System.out.println("IN SQL IS: " + t.getQueryModel().getChQuery());
    System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
    System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
//    System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
//    System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//    String queryXML = t.getXmlString();
//    System.out.println("TO DB XML: " + queryXML);
    
    /*
		String queryXML2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
		 									 "<query><ch_query_string>查询 测试过渡一.出票日期 作为 出票日期, 测试过渡一.出票人代码 作为 出票人代码, 测试过渡一.机构编码 作为 机构编码, 求和(测试过渡一.汇票金额) 作为 汇票金额 来自 测试过渡一 分组 测试过渡一.机构编码, 测试过渡一.出票人代码, 测试过渡一.出票日期 排序 测试过渡一.机构编码 升序, 测试过渡一.出票人代码 升序, 测试过渡一.出票日期 升序</ch_query_string><db_info ch_name=\"测试过渡一\" en_name=\"S44021000021001490001\" flag=\"casdb3\"><db_field ch_name=\"出票人代码\" en_name=\"ACDV04\" fieldParam=\"\"/><db_field ch_name=\"机构编码\" en_name=\"ACDV08\" fieldParam=\"\"/><db_field ch_name=\"币种\" en_name=\"ACDV09\" fieldParam=\"\"/><db_field ch_name=\"汇票金额\" en_name=\"ACDV10\" fieldParam=\"\"/><db_field ch_name=\"汇票号码\" en_name=\"ACDV11\" fieldParam=\"\"/><db_field ch_name=\"出票日期\" en_name=\"ACDV12\" fieldParam=\"\"/><db_field ch_name=\"到期日期\" en_name=\"ACDV13\" fieldParam=\"\"/><db_field ch_name=\"垫款余额\" en_name=\"ACDV18\" fieldParam=\"\"/><db_field ch_name=\"承兑日期\" en_name=\"ACDV22\" fieldParam=\"\"/><db_field ch_name=\"增量标志\" en_name=\"ACDV36\" fieldParam=\"\"/></db_info><selectListEqu/><whereListEqu/><aliasListEqu><aliasListVO alias=\"出票日期\" enAlias=\"ACDV12\"/><aliasListVO alias=\"出票人代码\" enAlias=\"ACDV04\"/><aliasListVO alias=\"机构编码\" enAlias=\"ACDV08\"/><aliasListVO alias=\"汇票金额\" enAlias=\"ACDV101\"/></aliasListEqu><tableAliasListEqu/><orderAliasListEqu/></query>";
		queryXML2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
								"<query><ch_query_string>表合并 测试过渡十九, 测试过渡十八, 测试过渡十七</ch_query_string><db_info ch_name=\"测试过渡十九\" en_name=\"S00021000065001230019\" flag=\"casdb3\"><db_field ch_name=\"二级分行代码\" en_name=\"ACDV081\" fieldParam=\"\"/><db_field ch_name=\"汇票金额\" en_name=\"ACDV10\" fieldParam=\"\"/><db_field ch_name=\"汇票号码\" en_name=\"ACDV11\" fieldParam=\"\"/><db_field ch_name=\"出票日期\" en_name=\"ACDV12\" fieldParam=\"\"/></db_info><db_info ch_name=\"测试过渡十八\" en_name=\"S00021000065001230018\" flag=\"casdb3\"><db_field ch_name=\"二级分行代码\" en_name=\"ACDV081\" fieldParam=\"\"/><db_field ch_name=\"汇票金额\" en_name=\"ACDV10\" fieldParam=\"\"/><db_field ch_name=\"汇票号码\" en_name=\"ACDV11\" fieldParam=\"\"/><db_field ch_name=\"出票日期\" en_name=\"ACDV12\" fieldParam=\"\"/></db_info><db_info ch_name=\"测试过渡十七\" en_name=\"S00021000065001230017\" flag=\"casdb3\"><db_field ch_name=\"二级分行代码\" en_name=\"ACDV081\" fieldParam=\"\"/><db_field ch_name=\"汇票金额\" en_name=\"ACDV10\" fieldParam=\"\"/><db_field ch_name=\"汇票号码\" en_name=\"ACDV11\" fieldParam=\"\"/><db_field ch_name=\"出票日期\" en_name=\"ACDV12\" fieldParam=\"\"/></db_info><selectListEqu/><whereListEqu/><aliasListEqu/><tableAliasListEqu/><orderAliasListEqu/></query>";
		queryXML2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
								"<query><ch_query_string>查询 AI_通用分户帐0612.帐号 作为 帐号, AI_通用分户帐0612.科目号 作为 科目号, AI_通用分户帐0612.总帐行号 作为 总帐行号, AI_通用分户帐0612.中文名称 作为 中文名称, AI_通用分户帐0612.开户日期 作为 开户日期, AI_通用分户帐0612.帐务状态 作为 帐务状态, AI_通用分户帐0612.余额性质 作为 余额性质, AI_通用分户帐0612.当前余额 作为 当前余额, 格式化数值(取下限整数(AI_通用分户帐0612.当前余额), 0) 作为 四舍余额, round(取上限整数(AI_通用分户帐0612.当前余额), 0) 作为 五入余额 来自 AI_通用分户帐0612 条件 取绝对值(AI_通用分户帐0612.当前余额) 大于 100000000 或者 取绝对值(AI_通用分户帐0612.当前余额) &lt; 10</ch_query_string><db_info ch_name=\"AI_通用分户帐0612\" en_name=\"SIAC0612\" flag=\"casdb1\"><db_field ch_name=\"省/市代号\" en_name=\"IAC01\" fieldParam=\"\"/><db_field ch_name=\"帐号\" en_name=\"IAC02\" fieldParam=\"\"/><db_field ch_name=\"科目号\" en_name=\"IAC03\" fieldParam=\"\"/><db_field ch_name=\"总帐行号\" en_name=\"IAC04\" fieldParam=\"\"/><db_field ch_name=\"中文名称\" en_name=\"IAC05\" fieldParam=\"\"/><db_field ch_name=\"开户日期\" en_name=\"IAC06\" fieldParam=\"\"/><db_field ch_name=\"帐务状态\" en_name=\"IAC07\" fieldParam=\"\"/><db_field ch_name=\"余额性质\" en_name=\"IAC08\" fieldParam=\"\"/><db_field ch_name=\"当前余额\" en_name=\"IAC09\" fieldParam=\"\"/><db_field ch_name=\"红蓝字\" en_name=\"IAC10\" fieldParam=\"\"/><db_field ch_name=\"限额\" en_name=\"IAC11\" fieldParam=\"\"/><db_field ch_name=\"计息代码\" en_name=\"IAC12\" fieldParam=\"\"/><db_field ch_name=\"利率种类\" en_name=\"IAC13\" fieldParam=\"\"/><db_field ch_name=\"利率\" en_name=\"IAC14\" fieldParam=\"\"/><db_field ch_name=\"透支利率种类\" en_name=\"IAC15\" fieldParam=\"\"/><db_field ch_name=\"透支利率\" en_name=\"IAC16\" fieldParam=\"\"/><db_field ch_name=\"暂存结息金额\" en_name=\"IAC17\" fieldParam=\"\"/><db_field ch_name=\"借方积数\" en_name=\"IAC18\" fieldParam=\"\"/><db_field ch_name=\"借方调整积数\" en_name=\"IAC19\" fieldParam=\"\"/><db_field ch_name=\"贷方积数\" en_name=\"IAC20\" fieldParam=\"\"/><db_field ch_name=\"贷方调整积数\" en_name=\"IAC21\" fieldParam=\"\"/><db_field ch_name=\"借方利息帐号\" en_name=\"IAC22\" fieldParam=\"\"/><db_field ch_name=\"贷方利息帐号\" en_name=\"IAC23\" fieldParam=\"\"/><db_field ch_name=\"上交易日\" en_name=\"IAC24\" fieldParam=\"\"/><db_field ch_name=\"当前页号\" en_name=\"IAC25\" fieldParam=\"\"/><db_field ch_name=\"允许动帐标志\" en_name=\"IAC26\" fieldParam=\"\"/><db_field ch_name=\"销户日期\" en_name=\"IAC27\" fieldParam=\"\"/><db_field ch_name=\"上日余额\" en_name=\"IAC28\" fieldParam=\"\"/><db_field ch_name=\"上日红蓝字\" en_name=\"IAC29\" fieldParam=\"\"/><db_field ch_name=\"帐户属性\" en_name=\"IAC30\" fieldParam=\"\"/><db_field ch_name=\"月存表日期\" en_name=\"IAC31\" fieldParam=\"\"/></db_info><selectListEqu><SelectListVO fieldDataType=\"char\"/><SelectListVO fieldDataType=\"char\"/><SelectListVO fieldDataType=\"char\"/><SelectListVO fieldDataType=\"char\"/><SelectListVO fieldDataType=\"char\"/><SelectListVO fieldDataType=\"char\"/><SelectListVO fieldDataType=\"char\"/><SelectListVO fieldDataType=\"decimal\"/><SelectListVO fieldDataType=\"decimal\"/><SelectListVO fieldDataType=\"decimal\"/></selectListEqu><whereListEqu><WhereListVO checkedFlag=\"true\"/><WhereListVO checkedFlag=\"true\"/></whereListEqu><aliasListEqu><aliasListVO alias=\"帐号\" enAlias=\"IAC02\"/><aliasListVO alias=\"科目号\" enAlias=\"IAC03\"/><aliasListVO alias=\"总帐行号\" enAlias=\"IAC04\"/><aliasListVO alias=\"中文名称\" enAlias=\"IAC05\"/><aliasListVO alias=\"开户日期\" enAlias=\"IAC06\"/><aliasListVO alias=\"帐务状态\" enAlias=\"IAC07\"/><aliasListVO alias=\"余额性质\" enAlias=\"IAC08\"/><aliasListVO alias=\"当前余额\" enAlias=\"IAC09\"/><aliasListVO alias=\"四舍余额\" enAlias=\"IAC091\"/><aliasListVO alias=\"五入余额\" enAlias=\"IAC092\"/></aliasListEqu><tableAliasListEqu/><orderAliasListEqu/></query>";

		Translator t1 = new Translator();
    try{
      QueryModel m = t1.loadModelFromXML(queryXML2);
      if (t1.hasError()){
        ChWrongMessage[] msgs = t1.showWrongMsgs();
        for (int j = 0; j < msgs.length; j++){
          System.out.println("【测试错误】" + msgs[j]);
        }
        return;
      }
      t1.setAliasModelListVOArrByXML();
      t1.setTableAliasModelListVOArrByXML();
      t1.setOrderAliasModelListVOArrByXML();
      
      SelectListVO[] r_selectListVOArr = t1.getSelectListVOArr();
      FromListVO[] r_fromListVOArr = t1.getFromListVOArr();
      WhereListVO[] r_whereListVOArr = t1.getWhereListVOArr();
      GroupByListVO[] r_groupListVOArr = t1.getGroupByListVOArr();
      OrderByListVO[] r_orderListVOArr = t1.getOrderByListVOArr();
      AppDbTable[] appDbTables = t1.getInfo().getDbTableInfoToAppTableArr();
      for (int i = 0; i < appDbTables.length; i++){
      	t1.addDbTable(appDbTables[i].getTableName(), appDbTables[i].getTableEnName(), appDbTables[i].getFlag());
      	AppDbField[] appDbFieldsArr = appDbTables[i].getFields();
      	for (int j = 0; j < appDbFieldsArr.length; j++){
      		System.out.println(appDbFieldsArr[j].getChName());
      		System.out.println(appDbFieldsArr[j].getEnName());
      		t1.addDbField(appDbTables[i].getTableName(), appDbFieldsArr[j].getChName(), appDbFieldsArr[j].getEnName());
      	}
      }
      t1.updateDbTables(t1, t1.getTables());
      
      t1.setSelectListVOArr(r_selectListVOArr);
      TableAliasModel[] tableAliasModels = t1.getTableAliasModelListVOArrByModel();
      if (tableAliasModels.length > 0){
      	tableAliasModels[0].setEnAlias("CNF00000");
      }
      System.out.println(m.getChString());
      System.out.println(m.getEnString());
      System.out.println(m.getExecuteEnString("xxx"));
      System.out.println(t1.getXmlString());
    }catch (DocumentException e){
      e.printStackTrace();
    }
    */
    System.out.println("");
  }
}
