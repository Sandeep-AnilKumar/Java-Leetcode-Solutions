package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    public static void main(String[] args) {
        int n = 13;
        List<Integer> result = lexicalOrder(n);
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
            dfs(i, n, res); 
        }
        return res;
    }

    public static void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;++i){
                if(10*cur+i>n)
                    return;
                dfs(10*cur+i, n, res);
            }
        }
    }
}
