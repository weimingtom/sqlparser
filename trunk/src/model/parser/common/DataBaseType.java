package model.parser.common;

/**
 * 数据库类型定义
 */
public class DataBaseType {
	public static final String DEFAULT_DATABASE_TYPE = DataBaseType.SYBASE_IQ_12;
	
	public static final String ORACLE8i = "ORACLE8i"; 									//ORACLE 8i
  public static final String ORACLE9i = "ORACLE9i"; 									//ORACLE 9i
  
  public static final String SYBASE_ASE_12 = "SYBASE_ASE_12"; 				//SYBASE ASE 12.5.3
  public static final String SYBASE_IQ_12 = "SYBASE_IQ_12"; 					//SYBASE IQ 12.6
  
  public static final String DB2_UDB_8x = "DB2_UDB_8x";								//DB2 UDB 8
  public static final String DB2_UDB_9x = "DB2_UDB_9x";								//DB2 UDB 9
  
  public static final String MS_SQLSERVER2000 = "MS_SQLSERVER2000"; 	//MS SQLSERVER 2000
  
  public static final String MySQL4 = "MySQL4"; 											//MySQL4.x
  public static final String MySQL5 = "MySQL5"; 											//MySQL5.x
}
