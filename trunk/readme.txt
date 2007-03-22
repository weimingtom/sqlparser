Translator接口说明
  整句验证与翻译	
	// 先创建翻译器对象，将从页面获取的查询字符串queryChStr设置到翻译器中进行解析
	Translator translator=new Translator();
	translator.setChQuery(queryChStr);
	
    // 对在查询语句中出现过的每个表，从数据库中获取表英文名和字段，并设置到表对象中
	DbTable[] tables=translator.getTables();
    for (int j=0; j<tables.length; j++) {
		tables[j].setEnName("table"+j);
		// 对每个表的字段名（这个表所有字段，不管有没有在查询语句中出现过），
		// 调用DbTable的addDbField方法设置为这个表的字段
        tables[j].addDbField("字段1", "field1");
        tables[j].addDbField("字段2", "field2");
        tables[j].addDbField("字段3", "field3");
        tables[j].addDbField("字段4", "field4");
        tables[j].addDbField("字段5", "field5");
        tables[j].addDbField("字段6", "field6");
    }
    
    // 再将得到了英文信息和字段信息的表对象列表设置给translator
    translator.setTableInfo(tables);
    
    // 如果语法有错，或者表名、字段名有错，则显示错误
	if (translator.hasError()) {
        ChWrongMessage[] msgs=translator.showWrongMsgs();
        for (int j=0; j<msgs.length; j++)
			System.out.println(msgs[j]);
	} else {	// 否则得到生成的英文查询语句
        QueryModel model=translator.getQueryModel();
        System.out.println(model.getEnQuery());
	}
	DbTable对象有的String getFlag()和setFlag(String flag)用来获取和设置数据库标志,
	业务系统根据不同标志生成不同的英文数据库名
	
  WHERE子句片断验证
    调用方法和前面的类似，只要将setChQuery改成setChEquation就可以了
    
  保存数据库与从数据库恢复对象
    在调用translator.getQueryModel()得到QueryModel对象后, 调用getXmlString()方法得到这个对象的
    XML文档字符串, 然后将这个字符串保存到数据库.
    
    读取对象时首先从数据库取得描述对象的XML字符串String xml=read from db, 然后调用
    QueryModel model=QueryModel.createModelFromXml(xml)还原查询model
    然后就可以调用model的方法如getEnQuery()得到整句英文查询语句; 
    getChQuery()得到整句中文查询语句.
    调用mode的DbTable[] getDbTables()方法得到查询语句用到的表对象列表, 
    业务系统设置了英文名等相关属性后通过model的setDbTables(DbTable[] tables)
    方法设置到model中用以生成英文查询语句
    
  获取每个阶段的输入
    暂时只对SELECT查询可以按阶段获取输入, 获取方法如下:
    SelectModel model=(SelectModel)QueryModel.createModelFromXml(xml)
    或者
    SelectModel model=(SelectModel)translator.getQueryModel()
    然后调用如下函数:
      model.getChColumnList() 得到中文Select字段列表片段
      model.getChTableList() 得到中文From表列表
      model.getChEquation() 得到中文Where表达式
      model.getChGroupBy() 得到中文Group by字段列表
      model.getChOrderBy() 得到中文Order by字段列表

      model.getEnColumnList() 得到英文Select字段列表片段
      model.getEnTableList() 得到英文From表列表
      model.getEnEquation() 得到英文Where表达式
      model.getEnGroupBy() 得到英文Group by字段列表
      model.getEnOrderBy() 得到英文Order by字段列表
    
    
ChWrongMessage接口说明
	getLine() 获得错误所在行
	getColumn() 获得错误所在列
	getMessage() 获得不带行列号信息的错误信息
	toString() 获得带行列号的错误信息，形式如下："行：xx 列：xx xxx错误"