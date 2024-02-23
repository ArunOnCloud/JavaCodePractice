
import java.util.*;
import java.util.stream.Collectors;

public class SalesforceTopoSortProblem {

    /*
    In order to launch an application, we load smaller modules.These modules usually have dependencies on other modules.

Print the order in which the application should load the modules given the dependency list between the modules.
Let's say there are 4 modules to be loaded A, B, C & D

A -> B, C, E
B -> C, D
C → D

Assume you have these two functions available
List<String> getModulesList() - Returns the list of modules to be loaded //[A, B, C, D]
List<String> getDependencyList(String moduleName) - Returns the list of modules on which this module is depedent on


     */
    public static void main(String[] args) {
        SalesforceTopoSortProblem salesforceTopoSortProblem = new SalesforceTopoSortProblem();
        salesforceTopoSortProblem.buildGraph();
        salesforceTopoSortProblem.topoSort();

    }
    Map<String,List<String> > graph=new HashMap<>();
    void buildGraph(){
        graph.put("A",List.of("B","C","E"));
        graph.put("B",List.of("C","D"));
        graph.put("C",List.of("D"));
        graph.put("D",List.of());
        graph.put("E",List.of());
    }

    void topoSort(){

        List<String> modules= getModulesList();

        Map<String, Set<String>> g = new HashMap<>();
        for(String module: modules){
            Set<String> dependency = new HashSet<>();
            dependency.addAll(getDependencyList(module));
            g.put(module,dependency);
        }

        Set<String> vis= new HashSet<>();
        Set<String> rec= new HashSet<>();
        Stack<String> result = new Stack<>();
        util(g,modules.get(0),vis,rec,result);
        while(result.size() >0){
            System.out.println(result.pop());
        }

    }
    void util( Map<String, Set<String>> g, String v,Set<String> vis,Set<String> rec,Stack<String> res){
        if(vis.contains(v) || rec.contains(v)){
            return;
        }
        rec.add(v);

        for(String e: g.get(v)){
            if( !rec.contains(e)){
                util(g,e,vis,rec,res);
            }
        }
        res.add(v);
        vis.add(v);
        rec.remove(v);
    }



    List<String> getModulesList(){

        return graph.entrySet().stream().map((entry->{
            return entry.getKey();
        })).collect(Collectors.toList());
    }



    List<String> getDependencyList(String moduleName){

        return graph.get(moduleName);
    }
}
