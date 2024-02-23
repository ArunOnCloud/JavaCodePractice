
/*

Design an inmemory sql:

1) CRUD operations:
a) able to create the table
b) insert data in table
c) read data from table (select *)
d) delete data from table

2) one select query( select *  from tablename)

Type{
}
Database{
   createtable(List<String> list,List<Type> type,String contraint);
   boolean insertIntoTable(Map<String,Object> data);

   readFromTable(String tableName);
   //deleteDataFromTable(String tableName,
}
Table {

  List<String> columns;// age,name
  Map<String,ColumnValidator> columnValidator;
  age: ColumnValidator1
  name:ColumnsValida
  Map<String,List<Object>> tableData;
  age: [10,20]
  name:["adf","second"]

  insertData(Map<String,Object> data) //key:column name value is Object  age: Arun
  readData()
  addColumn();
}

TableValidator{

  // ColumnValidator

   Map<String,ColumnValidator> validators// col

}

ColumnValidator{

ConstraintValidator contraintValidator;


boolean validate(Object obj)


}



ConstraintValidator{
  boolean validate(Object obj,Contraint contraint);

}

interface Constraint{
 boolean validate(Object obj)
}
ConstraintsGreaterThan implements Constraint{
   int number;
   boolean validate(Object data){
      return
   }

}
ContraintNull{
   boolean validate(Object data){
      return data==null;
   }
}
AlaphNumericValidator{
}

Employee
age:10,59
name:  Alphra
S
 */


public class GameBerryDesignROund {
}
