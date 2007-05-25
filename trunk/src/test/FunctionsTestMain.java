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
  			"求和(AI_94传票对照表.金额)",
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
  			"求五入后的整数(123.45)",
  			"求余弦值(30)",
  			"求余切值(45)",
  			"将弧度转为度数(0.5236)",
  			"求幂值(3)",
  			"求四舍后的整数(123.45)",
  			"求自然对数(20)",
  			"求10为底的对数(50)",
  			"求余(5, 3)",
  			"求圆周率(*)",
  			"求数字的次幂值(2, 3)",
  			"将度数转为弧度(30)",
  			"求0和1间的随机数()",
  			"求0和1间的随机数(4)",
  			"取余(5, 3)",
  			"格式化数值(123.453, 2)",
  			"求值的符号(-123)",
  			"求正弦值(60)",
  			"求平方根(4)",
  			"求正切值(45)",
  			"将数值格式化(123.346, 2)",
  			"取格式化数值(123.453, 1)",
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
  			"求字符串的长度('CNF_2007')",
  			"存在于('CNF', AI_94传票对照表.省/市代号)",
  			"求两个串的声音差值('test', 'chest')",
  			"字符串插入(0, 'office', 'ladys')",
  			"将弧度转为度数(0.5236)",
  			"字符串转为小写('Case')",
  			"字符串左截('abcdefghijk', 4)",
  			"取字符串的长度('abcd efg')",
  			"求串出现位置('abc def ghijk', 'def', 2)",
  			"将字符串转为小写('Case')",
  			"去掉左空格(' abc')",
  			"求字符串的存储长度(AI_94传票对照表.省/市代号)",
  			"求第一次出现位置('%hoco%', 'chocolate')",
  			"将字符串连接('abc', 4)",
  			"字符串替换('abc def gh', 'abc', '123')",
  			"字符串连接('def', 3)",
  			"字符串右截('abcdefgh', 2)",
  			"去掉右空格('abc ')",
  			"求字符串相似度('toast', 'coast')",
  			"字符串排序('coop', 51)",
  			"求字符串声音值('Smith')",
  			"数值转字符串( 123.45)",
  			"字符串合并('abc', 'def', '12')",
  			"字符串删除替换('abcdefgh', 1, 4, 'xy')",
  			"字符串截取('abcdefgh', 1, 3)",
  			"去掉空格(' abc ')",
  			"字符串转为大写('case')",
  			"将字符串转为大写('case')"
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
  			"求日期的分量名称(month, '2007-05-01')",
  			"求日期的分量值(month, '2007-05-01')",
  			"转为日期时间('2007-01-01 12:01:20')",
  			"转为日期('2007-01-01 12:01:20')",
  			"求对应星期名称('2007-05-19')",
  			"求天数('2007-05-11 12:01:20')",
  			"求对应天('2007-05-11 12:01:20')",
  			"求对应星期值('2007-05-11 12:01:20')",
  			"求小时数('2007-05-11 12:01:20')",
  			"求对应小时('2007-05-11 12:01:20')",
  			"求分钟数('2007-05-11 12:01:20')",
  			"求对应分钟('2007-05-11 12:01:20')",
  			"求月份名称('2007-05-11 12:01:20')",
  			"求月数('2007-05-11 12:01:20')",
  			"求对应月('2007-05-11 12:01:20')",
  			"取当前日期时间(*)",
  			"求对应季度('2007-05-11 12:01:20')",
  			"求秒数('2007-05-11 12:01:20')",
  			"求对应秒('2007-05-11 12:01:20')",
  			"求当前日期(*)",
  			"求周数('2007-05-11 12:01:20')",
  			"求年数('2007-05-11 12:01:20')",
  			"求对应年('2007-05-11 12:01:20')",
  			"求日期(2007, 5, 11)",
  			"求当前日期时间()",
  			"日期相加(day, 102, '2007/05/11')",
  			"日期相减(day, '2007-01-01', '2007-05-11')"
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
  			"字符转为日期(char(10), AI_94传票对照表.日期, 120)",
  			"十六进制转为整数('0x00000100')",
  			"整数转为十六进制(120)",
  			"为日期型('2007-01-01 12:01:20')",
  			"为数值型(34.78)"
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
}
