package test;

import model.parser.ChWrongMessage;
import translator.Translator;
import junit.framework.TestCase;

/**
 * 函数测试用例
 */
public class FunctionsTestMain {
	
	/**
	 * 测试用例入口
	 * @param args
	 */
	public static void main(String[] args) {
		FunctionsTestMain test = new FunctionsTestMain();
		for (int i = 0; i < args.length; i++){
			test.FunctionsTest(Integer.parseInt(args[0]));
		}
	}
	
	/**
	 * 函数测试方法
	 */
	public void FunctionsTest(int funNum) {
		if (funNum == 1)
			AggregateFunctionsTest();
		else if (funNum == 2)
			NumericFunctionsTest();
		else if (funNum == 3)
			StringFunctionsTest();
		else if (funNum == 4)
			DateTimeFunctionsTest();
		else if (funNum == 5)
			ConversionFunctionsTest();
		else if (funNum == 6)
			AnalyticalFunctionsTest();
		else if (funNum == 7)
			MiscellaneousFunctionsTest();
	}
	
	/**
	 * 聚合函数测试方法 
	 */
	public void AggregateFunctionsTest(){
  	String strHead = "查询 ";
  	String[] functionsArr = new String[]{
  			"求平均数(AI_94传票对照表.金额)", 
  			"求记录总数(*)",
  			"求记录总数(AI_94传票对照表.行号)",
  			"求最大值(AI_94传票对照表.金额)",
  			"求最小值(AI_94传票对照表.金额)",
  			"求方差(AI_94传票对照表.金额)",
  			"求总和(AI_94传票对照表.金额)",
  			"求统计方差(AI_94传票对照表.金额)"
  		};
  	String strEnd = " 来自 AI_94传票对照表";
  	Translator t = new Translator();
  	for (int i = 0; i < functionsArr.length; i++){
  		System.out.println("聚合函数测试" + (i + 1) + "：");
	  	t.setChQuery(strHead + functionsArr[i] + strEnd);
	    if (t.hasError()){
	      ChWrongMessage[] msgs = t.showWrongMsgs();
	      for (int j = 0; j < msgs.length; j++){
	        System.out.println("【测试错误】：" + msgs[j]);
	      }
	    }else{
	    	t.addDbTable("AI_94传票对照表", "CNF");
	      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
	      t.addDbField("AI_94传票对照表", "行号", "CNF02");
	      t.addDbField("AI_94传票对照表", "金额", "CNF03");
	      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
	      t.updateDbTables(t, t.getTables());
	      System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
	      System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
//	      System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
//	      System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//	      String rXML = t.getXmlString();
//	      System.out.println("TO DB XML: " + rXML);
	    }
	    System.out.println();
  	}
  }
  
	/**
	 * 数学函数测试方法
	 */
  public void NumericFunctionsTest(){
  	String strHead = "查询 ";
  	String[] functionsArr = new String[]{
  			"取绝对值(-980)", 
  			"求反余弦值(0.56)",
  			"求反正弦值(0.56)",
  			"求反正切值(0.56)",
  			"求二个数的反正切值(0.78, 0.56)",
  			"取上限整数(123.45)",
  			"求余弦值(30)",
  			"求余切值(45)",
  			"弧度转度数(0.5236)",
  			"求幂值(3)",
  			"取下限整数(123.45)",
  			"求自然对数(20)",
  			"求10为底的对数(50)",
  			"求模(5, 3)",
  			"求圆周率(*)",
  			"求幂(2, 3)",
  			"度数转弧度(30)",
  			"取随机数()",
  			"取随机数(4)",
  			"求余(5, 3)",
  			"格式化数值(123.453, 2)",
  			"求值的符号(-123)",
  			"求正弦值(60)",
  			"求平方根(4)",
  			"求正切值(45)",
  			"格式化数值3(123.346, 2)",
  			"N位置零处理(123.453, 1)",
  		};
  	String strEnd = " 来自 AI_94传票对照表";
  	Translator t = new Translator();
  	for (int i = 0; i < functionsArr.length; i++){
  		System.out.println("数学函数测试" + (i + 1) + "：");
	  	t.setChQuery(strHead + functionsArr[i] + strEnd);
	    if (t.hasError()){
	      ChWrongMessage[] msgs = t.showWrongMsgs();
	      for (int j = 0; j < msgs.length; j++){
	        System.out.println("【测试错误】：" + msgs[j]);
	      }
	    }else{
	    	t.addDbTable("AI_94传票对照表", "CNF");
	      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
	      t.addDbField("AI_94传票对照表", "行号", "CNF02");
	      t.addDbField("AI_94传票对照表", "金额", "CNF03");
	      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
	      t.updateDbTables(t, t.getTables());
	      System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
	      System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
//	      System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
//	      System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//	      String rXML = t.getXmlString();
//	      System.out.println("TO DB XML: " + rXML);
	    }
	    System.out.println();
  	}
  }
  
  /**
   * 字符串函数测试方法
   */
  public void StringFunctionsTest(){
  	String strHead = "查询 ";
  	String[] functionsArr = new String[]{
  			"求ASCII码('Z')", 
  			"求字符串的二进制长度(AI_94传票对照表.省/市代号)",
  			"求字符串的字节数(AI_94传票对照表.省/市代号)",
  			"求等值的字符(87)",
  			"求字符串长度1('CNF_2007')",
  			"存在于('CNF', AI_94传票对照表.省/市代号)",
  			"求两个串的声音差值('test', 'chest')",
  			"插入字符串(0, 'office', 'ladys')",
  			"转为小写字母1('Case')",
  			"左截字符串('abcdefghijk', 4)",
  			"求字符串长度2('abcd efg')",
  			"求串位置1('abc def ghijk', 'def', 2)",
  			"转为小写字母2('Case')",
  			"去掉左空格(' abc')",
  			"求字符串的存储长度(AI_94传票对照表.省/市代号)",
  			"求串位置2('%hoco%', 'chocolate')",
  			"字符串循环连接1('abc', 4)",
  			"替换字符串('abc def gh', 'abc', '123')",
  			"字符串循环连接2('def', 3)",
  			"右截字符串('abcdefgh', 2)",
  			"去掉右空格('abc ')",
  			"求字符串相似度('toast', 'coast')",
  			"字符串排序('coop', 51)",
  			"求字符串声音值('Smith')",
  			"填空格(10)",
  			"数值转字符串( 123.45)",
  			"字符串合并('abc', 'def', '12')",
  			"字符串删除替换('abcdefgh', 1, 4, 'xy')",
  			"字符串截取('abcdefgh', 1, 3)",
  			"去左右空格(' abc ')",
  			"转为大写字母1('case')",
  			"转为大写字母2('case')"
  		};
  	String strEnd = " 来自 AI_94传票对照表";
  	Translator t = new Translator();
  	for (int i = 0; i < functionsArr.length; i++){
  		System.out.println("字符串函数测试" + (i + 1) + "：");
	  	t.setChQuery(strHead + functionsArr[i] + strEnd);
	    if (t.hasError()){
	      ChWrongMessage[] msgs = t.showWrongMsgs();
	      for (int j = 0; j < msgs.length; j++){
	        System.out.println("【测试错误】：" + msgs[j]);
	      }
	    }else{
	    	t.addDbTable("AI_94传票对照表", "CNF");
	      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
	      t.addDbField("AI_94传票对照表", "行号", "CNF02");
	      t.addDbField("AI_94传票对照表", "金额", "CNF03");
	      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
	      t.updateDbTables(t, t.getTables());
	      System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
	      System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
//	      System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
//	      System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//	      String rXML = t.getXmlString();
//	      System.out.println("TO DB XML: " + rXML);
	    }
	    System.out.println();
  	}
  }
  
  /**
   * 日期时间函数测试方法
   */
  public void DateTimeFunctionsTest(){
  	String strHead = "查询 ";
  	String[] functionsArr = new String[]{
  			"格式化日期('2007-01-01', 'dd mm,yyyy')", 
  			"求日期分量英文名(MONTH, '2007-05-01')",
  			"求日期的分量值(month, '2007-05-01')",
  			"转为日期时间('2007-01-01 12:01:20')",
  			"转为日期('2007-01-01 12:01:20')",
  			"求星期英文名('2007-05-19')",
  			"求天数('2007-05-11 12:01:20')",
  			"求具体日期('2007-05-11 12:01:20')",
  			"求具体星期('2007-05-11 12:01:20')",
  			"求小时数('2007-05-11 12:01:20')",
  			"求具体小时('2007-05-11 12:01:20')",
  			"求分钟数('2007-05-11 12:01:20')",
  			"求具体分钟('2007-05-11 12:01:20')",
  			"求月份英文名('2007-05-11 12:01:20')",
  			"求月数('2007-05-11 12:01:20')",
  			"求具体月数('2007-05-11 12:01:20')",
  			"取当前日期时间1(*)",
  			"求具体季度('2007-05-11 12:01:20')",
  			"求秒数('2007-05-11 12:01:20')",
  			"求具体秒('2007-05-11 12:01:20')",
  			"求当前日期(*)",
  			"求周数('2007-05-11 12:01:20')",
  			"求年数('2007-05-11 12:01:20')",
  			"求具体年份('2007-05-11 12:01:20')",
  			"数值转日期(2007, 5, 11)",
  			"取当前日期时间2()",
  			"日期运算(day, 102, '2007/05/11')",
  			"求两日期差值(day, '2007-01-01', '2007-05-11')"
  		};
  	String strEnd = " 来自 AI_94传票对照表";
  	Translator t = new Translator();
  	for (int i = 0; i < functionsArr.length; i++){
  		System.out.println("日期时间函数测试" + (i + 1) + "：");
	  	t.setChQuery(strHead + functionsArr[i] + strEnd);
	    if (t.hasError()){
	      ChWrongMessage[] msgs = t.showWrongMsgs();
	      for (int j = 0; j < msgs.length; j++){
	        System.out.println("【测试错误】：" + msgs[j]);
	      }
	    }else{
	    	t.addDbTable("AI_94传票对照表", "CNF");
	      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
	      t.addDbField("AI_94传票对照表", "行号", "CNF02");
	      t.addDbField("AI_94传票对照表", "金额", "CNF03");
	      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
	      t.updateDbTables(t, t.getTables());
	      System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
	      System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
//	      System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
//	      System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//	      String rXML = t.getXmlString();
//	      System.out.println("TO DB XML: " + rXML);
	    }
	    System.out.println();
  	}
  }
  
  /**
   * 数据类型转化函数测试方法
   */
  public void ConversionFunctionsTest(){
  	String strHead = "查询 ";
  	String[] functionsArr = new String[]{
  			"数据类型转化('Surname' as char)", 
  			"数据类型转换(char(10), AI_94传票对照表.日期, 120)",
  			"十六进制转为整数('0x00000100')",
  			"整数转为十六进制(120)",
  			"是否日期型('2007-01-01 12:01:20')",
  			"是否数值型(34.78)"
  		};
  	String strEnd = " 来自 AI_94传票对照表";
  	Translator t = new Translator();
  	for (int i = 0; i < functionsArr.length; i++){
  		System.out.println("数据类型转化函数测试" + (i + 1) + "：");
	  	t.setChQuery(strHead + functionsArr[i] + strEnd);
	    if (t.hasError()){
	      ChWrongMessage[] msgs = t.showWrongMsgs();
	      for (int j = 0; j < msgs.length; j++){
	        System.out.println("【测试错误】：" + msgs[j]);
	      }
	    }else{
	    	t.addDbTable("AI_94传票对照表", "CNF");
	      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
	      t.addDbField("AI_94传票对照表", "行号", "CNF02");
	      t.addDbField("AI_94传票对照表", "金额", "CNF03");
	      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
	      t.addDbField("AI_94传票对照表", "日期", "CNF05");
	      t.updateDbTables(t, t.getTables());
	      System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
	      System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
//	      System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
//	      System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//	      String rXML = t.getXmlString();
//	      System.out.println("TO DB XML: " + rXML);
	    }
	    System.out.println();
  	}
  }
  
  /**
   * Analytical函数测试方法
   */
  public void AnalyticalFunctionsTest(){
  	String strHead = "查询 ";
  	String[] functionsArr = new String[]{
  			"dense_rank()", 
  			"ntile(20)",
  			"percent_rank()",
  			"percentile_count(AI_94传票对照表.金额)",
  			"percentile_desc(230+900)",
  			"rank()"
  		};
  	String strEnd = " 来自 AI_94传票对照表";
  	Translator t = new Translator();
  	for (int i = 0; i < functionsArr.length; i++){
  		System.out.println("Analytical Functions 测试" + (i + 1) + "：");
	  	t.setChQuery(strHead + functionsArr[i] + strEnd);
	    if (t.hasError()){
	      ChWrongMessage[] msgs = t.showWrongMsgs();
	      for (int j = 0; j < msgs.length; j++){
	        System.out.println("【测试错误】：" + msgs[j]);
	      }
	    }else{
	    	t.addDbTable("AI_94传票对照表", "CNF");
	      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
	      t.addDbField("AI_94传票对照表", "行号", "CNF02");
	      t.addDbField("AI_94传票对照表", "金额", "CNF03");
	      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
	      t.addDbField("AI_94传票对照表", "日期", "CNF05");
	      t.updateDbTables(t, t.getTables());
	      System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
	      System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
//	      System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
//	      System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//	      String rXML = t.getXmlString();
//	      System.out.println("TO DB XML: " + rXML);
	    }
	    System.out.println();
  	}
  }
  
  /**
   * Analytical函数测试方法
   */
  public void MiscellaneousFunctionsTest(){
  	String strHead = "查询 ";
  	String[] functionsArr = new String[]{
  			"ARGN( 6, 1,2,3,4,5,6 )", 
  			"COALESCE( NULL, 34, 13, 0 )",
  			"IFNULL( NULL, -66 )",
  			"ISNULL( NULL ,-66, 55, 45, NULL, 16 )",
  			"ISNULL( AI_94传票对照表.金额, 90 )",
  			"NULLIF( 'a', 'b' )",
  			"NUMBER ( * )",
  		};
  	String strEnd = " 来自 AI_94传票对照表";
  	Translator t = new Translator();
  	for (int i = 0; i < functionsArr.length; i++){
  		System.out.println("Analytical Functions 测试" + (i + 1) + "：");
	  	t.setChQuery(strHead + functionsArr[i] + strEnd);
	    if (t.hasError()){
	      ChWrongMessage[] msgs = t.showWrongMsgs();
	      for (int j = 0; j < msgs.length; j++){
	        System.out.println("【测试错误】：" + msgs[j]);
	      }
	    }else{
	    	t.addDbTable("AI_94传票对照表", "CNF");
	      t.addDbField("AI_94传票对照表", "省/市代号", "CNF01");
	      t.addDbField("AI_94传票对照表", "行号", "CNF02");
	      t.addDbField("AI_94传票对照表", "金额", "CNF03");
	      t.addDbField("AI_94传票对照表", "货币码", "CNF04");
	      t.addDbField("AI_94传票对照表", "日期", "CNF05");
	      t.updateDbTables(t, t.getTables());
	      System.out.println("CN SQL IS: " + t.getQueryModel().getChString());
	      System.out.println("EN SQL IS: " + t.getQueryModel().getEnString());
//	      System.out.println("EMPTY EXE SQL IS: " + t.getQueryModel().getEmptyExecuteEnString("S001"));
//	      System.out.println("EXE SQL IS: " + t.getQueryModel().getExecuteEnString("S001"));
//	      String rXML = t.getXmlString();
//	      System.out.println("TO DB XML: " + rXML);
	    }
	    System.out.println();
  	}
  }
}
