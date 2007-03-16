package translator.model;

public class UnionModel extends QueryModel {
  private static final String unionStr=
    "CREATE TABLE _INTO_TABLE_NAME_ (_FIELDS_);" +
    "INSERT INTO _INTO_TABLE_NAME_ (_FIELDS_) " +
    "SELECT _FIELDS_ FROM _TABLE1_ UNION ALL " +
    "SELECT _FIELDS_ FROM _TABLE2_";
  private String chTable1, chTable2, chIntoTable;
  
  public UnionModel(String t1, String t2, String into) {
    this.chTable1=t1;
    this.chTable2=t2;
    this.chIntoTable=into;
  }
  
  public String getEnQuery() {
    DbTable t1=(DbTable)chTableMap.get(chTable1);
    DbTable t2=(DbTable)chTableMap.get(chTable2);
//    DbTable into=(DbTable)chTableMap.get(chIntoTable);

    return replace(
        unionStr,
        new String[]{"_INTO_TABLE_NAME_", "_FIELDS_", "_TABLE1_", "_TABLE2_"},
        new String[]{chIntoTable, t1.getFieldsEnStr(), t1.getEnName(), t2.getEnName()});
//    return unionStr.replaceAll("_INTO_TABLE_NAME_", chIntoTable)
//      .replaceAll("_FIELDS_", t1.getFieldsEnStr())
//      .replaceAll("_TABLE1_", t1.getEnName())
//      .replaceAll("_TABLE2_", t2.getEnName());
  }
  
}
