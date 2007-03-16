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
  WHERE子句片断验证
  	调用方法和前面的类似，只要将setChQuery改成setChEquation就可以了
ChWrongMessage接口说明
	getLine() 获得错误所在行
	getColumn() 获得错误所在列
	getMessage() 获得不带行列号信息的错误信息
	toString() 获得带行列号的错误信息，形式如下："行：xx 列：xx xxx错误"