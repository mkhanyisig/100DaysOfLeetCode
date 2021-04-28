/*
     Day 131: Leetcode => 690. Employee Importance

     Time Spent: 30:24 mins

     Personal notes: Use of hashmap and DFS took me a while
*/




/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        int val=0;
        Stack<Integer> subords=new Stack<Integer>();
        HashMap<Integer,Employee> map=new HashMap<>();
        for(Employee e: employees){
            if(e.id==id){
                val+=e.importance;
                for(Integer i:e.subordinates){
                    subords.push(i);
                }
            }else{
                map.put(e.id, e);
            }
        }

        while(!subords.isEmpty()){
            Integer num=subords.pop();
            val+=map.get(num).importance;

            for(Integer n:map.get(num).subordinates){
                subords.push(n);
            }
        }

        return val;
    }
}
