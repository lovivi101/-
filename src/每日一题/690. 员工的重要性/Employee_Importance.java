import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * 690. 员工的重要性
 * https://leetcode-cn.com/problems/employee-importance/
 * @author: hjx
 * @time: 2021年05月01日 7:53
 */
public class Employee_Importance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    int sum = 0;
    Map<Integer , Employee> emp = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            emp.put(employee.id , employee);
        }
        sumImportance(id);
        return sum ;
    }
    public void sumImportance(int id  ){
        Employee employee = emp.get(id);
        List<Integer> sub = employee.subordinates;
        sum+=employee.importance;
        if (sub.size()==0){
            return;
        }
        for (Integer integer : sub) {
            sumImportance(integer.intValue());
        }
    }
}
