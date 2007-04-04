package test;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import model.parser.ChWrongMessage;
import model.parser.ExprElemModel;
import model.parser.TargetExprModel;

import antlr.ANTLRException;
import antlr.CommonAST;
import antlr.debug.misc.ASTFrame;

import parser.ExpressionLexer;
import parser.ExpressionParser;
import parser.ExpressionTreeParser;

public class ExprTestMain {
  public static void main(String[] args) {
    String chStr = "(-5 + A) * B";
    
    TargetExprModel targetExprModel = new TargetExprModel();
    targetExprModel = targetExprModel.parseTargetExpr(chStr);
    if (targetExprModel.hasError()){
      ChWrongMessage[] msgs = targetExprModel.getWrongMessages();
      for (int j = 0; j < msgs.length; j++){
        System.out.println(msgs[j]);
      }
      return;
    }
    
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
    BigDecimal rValue = targetExprModel.ExcuteTargetExpr(targetExprModel);
    System.out.println(rValue.doubleValue());
  }
}