import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuarksInterview {

    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("e1",1000);
        map.put("e2",2000);
        map.put("e3",6000);
        map.put("e4",3000);
        map.put("e5",8000);
        // 2nd highest salary
        /*

         two em can have same salary
         */

        for(var e :map.entrySet()){

        }

        List<Integer> list = (List<Integer>) map.entrySet().stream().mapToInt((a)->a.getValue()).sorted();
        list.get(1);


    }

/*
    Employee{

       String name;
       Department deaprtmet;
    }

    put ,
    patch

    save persist merge
    Employee
    employeeId ,empName

    1, sandeep,
    2,sandeep,
    3 sandeep,
    4 sandeep
    5 man
    6 man
    delete from Employee where
     dup emp


    select id from employee e group by empName order by Max(empId)

    select e1.eId from Employee e1
     join Employee e2 on e1.empName=e2.empName

    group by e.empName,

    select
    select



 */
}
//class Employee
