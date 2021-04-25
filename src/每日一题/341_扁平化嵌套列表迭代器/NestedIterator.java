import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 题目连接：https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * @author: hjx
 * @time: 2021年03月23日 13:18
 */
public class NestedIterator implements Iterator<Integer> {


    private List<Integer> list ;
    private Iterator<Integer> iterator ;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<Integer>();
        dfs(nestedList);
        this.iterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }


    //通过深度搜索法 找出整型数据
    public void dfs(List<NestedInteger> nestedIntegers){
        for(NestedInteger nestedInteger : nestedIntegers){
            if (nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }
            else {
                dfs(nestedInteger.getList());
            }
        }
    }
}
