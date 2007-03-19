package translator.model;

public class ComapreModel extends QueryModel {

  private static final String compareStr=
    "SELECT * INTO _INTO_TABLE_NAME_ " +
    "FROM _TABLE1_ WHERE _METHOD_ (SELECT * FROM _TABLE2_ WHERE _CONDITION_)";
  private String chTable1, chTable2, intoTable, method, equation;
  
  public ComapreModel(String chTable1, String chTable2, String intoTable, String method, String equation) {
    this.chTable1=chTable1.substring(1, chTable1.length()-1);
    this.chTable2=chTable2.substring(1, chTable2.length()-1);
    this.intoTable=intoTable;
    this.method=method;
    this.equation=equation;
  }
  
  public String getEnQuery() {
    DbTable t1=(DbTable)chTableMap.get(chTable1);
    DbTable t2=(DbTable)chTableMap.get(chTable2);
    String equ=translateFieldCh2En(equation);
    return replace(
        compareStr,
        new String[]{"_INTO_TABLE_NAME_", "_TABLE1_", "_TABLE2_", "_METHOD_", "_CONDITION_"},
        new String[]{intoTable, t1.getEnName(), t2.getEnName(), method, equ});
//    return compareStr.replaceAll("_INTO_TABLE_NAME_", intoTable)
//      .replaceAll("_TABLE1_", t1.getEnName())
//      .replaceAll("_TABLE2_", t2.getEnName())
////      .replace("_T1_FIELDS_", t1.getFieldsStr())
////      .replace("_T2_FIELDS_", t2.getFieldsStr())
//      .replaceAll("_METHOD_", method)
//      .replaceAll("_CONDITION_", equ);
  }

}
