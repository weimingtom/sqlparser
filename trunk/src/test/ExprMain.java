package test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import model.parser.ChWrongMessage;
import model.parser.ExprElemModel;
import model.parser.TargetExprModel;

public class ExprMain {
  public static void main(String[] args) {
  	
    String[] exprStrArr = new String[]{
  			"-1 + 1 乘 (求圆周率)", 
  			"-1 + 1 乘 PI",
  			
  			"-1 + 1 乘 求自然对数底数", 
  			"-1 + 1 乘 E",
  			
  			"-1 + 900 乘 (取绝对值(-901) + (-900))",
  			"-1 + 900 乘 (abs(-901) + (-900))",
  			
  			"求反余弦值(-9)",
  			"1 + (6/(acos(0.34)+2))",
  			
  			"4 * 900 减 90 + (7/(求反正弦值(0.24)+2) + 4)",
  			"4 * 900 减 90 + (7/(asin(0.24)+2) + 4)",
  			
  			"4 * 20 减 90 + 求反正切值(0.876) + 4)",
  			"4 * 20 减 90 + atan(0.876) + 4)",
  			
  			"-78 减 90 + 求二个数的反正切值(0.876, 0.998) + 4)",
  			"-78 减 90 + atan2(0.876, 0.998) + 4)",
  			
  			"-78 减 90 + 取上限整数(168.12) * 2",
  			"-78 减 90 + ceil(168.12) * 2",
  			
  			"900 - 123 + 求余弦值(30)*200",
  			"900 - 123 + cos(30)*200",
    		
				"900/123 + 求幂值(5)",
				"900 - 123 + exp(9)",
				
				"90 - 78 + 取下限整数(-21.23)",
				"90 - 78 + floor(-21.23)",
				
				"(90 - 78)/2 + 求自然对数(4)",
				"90 - 78 + log(4)",
				
				"(90 - 78)/2 + 求最大值(78.45, 80.5)",
				"(90 - 78)/2 + max(78.45, 80.5)",
				
				"-60/2 + 求最小值(30.5, 80.5)",
				"-60/2 + min(F, 80.5)",
				
				"求幂(3, 3)",
				"-60/2 + pow(F, G)",
				
				"-5 + 求余(5, 3)",
				"-5 + IEEEremainder(5, 3)",
				
				"100 * 取随机数()",
				"100 * random()",
				
				"100 + 取整(90.87)",
				"100 + rint(90.17)",
				
    			"100 + 四舍五入(90.87)",
    			"100 + round(90.87)",
    			
    			"87 - 90 + 求正弦值(30)",
    			"87 - 90 + sin(30)",
    			
    			"87 - 90 + 求平方根(16)",
    			"87 - 90 + sqrt(4)",
    			
    			"87 - 90 + 求正切值(90)",
    			"87 - 90 + tan(45)",
    			
    			"90 + 弧度转度数(0.523)",
    			"90 + toDegrees(0.345)",
    			
    			"90 + 度数转弧度(30)",
    			"90 + toRadians(30)"
  		};
    
    double rV = java.lang.Math.acos(-9);
    System.out.println(rV);
    
    TargetExprModel targetExprModel = new TargetExprModel();
    for (int i = 0;  i < exprStrArr.length; i++){
    	System.out.println("指标公式测试" + (i + 1) + "：");
    	//公式验证
	    targetExprModel = targetExprModel.parseTargetExpr(exprStrArr[i]);
	    if (targetExprModel.hasError()){
	      ChWrongMessage[] msgs = targetExprModel.getWrongMessages();
	      for (int j = 0; j < msgs.length; j++){
	        System.out.println("【测试错误】" + msgs[j]);
	      }
	    }else{
	    	System.out.println(targetExprModel.getExprContent());
	    	
	    	//变量赋值
	    	Map elemMap = targetExprModel.getExprElemMap();
	      int m = 0;
	      for (Iterator it = elemMap.keySet().iterator(); it.hasNext();){
	        String elemName = (String) it.next();
	        ExprElemModel exprElemModel = (ExprElemModel) elemMap.get(elemName);
	        if (!exprElemModel.isConstant()){
	          exprElemModel.setElemValue(String.valueOf(m));
	          System.out.println(elemName + " Value is: " + m);
	        }
	        m++;
	      }
	    	
	      //公式运算
	      BigDecimal rValue = targetExprModel.ExcuteTargetExpr(targetExprModel);
	      if (targetExprModel.hasError()){
	        ChWrongMessage[] msgs = targetExprModel.getWrongMessages();
	        for (int j = 0; j < msgs.length; j++){
	          System.out.println("【测试错误】" + msgs[j]);
	        }
	      }else{
	      	System.out.println("结果：" + rValue.doubleValue() + "\n");
	      }
	    }
    }
  }
}