import java.util.*;
public class Graph {
    HashMap<String,LinkedList<Edge>> mygraph;
    int totalSum;

    public int calculateAverageDistanceBetweenTwoPoints(String x, String y) {
        HashSet<Character> h=new HashSet<>();
        int totalPaths=this.countPaths(x, y,0,h);
        System.out.println("the total number of paths: "+totalPaths);
        h.clear();
        this.countTotalSum(x,  y, 0, h);
        int sumOfAllPaths=totalSum;
        h.clear();
        return sumOfAllPaths/totalPaths;
    }
    void countTotalSum(String src,String dest,int currSum,HashSet<Character> visited){
        if(visited.contains(src.charAt(0)))
            return;
        else
            visited.add(src.charAt(0));
        if(src.equals(dest)){
            this.totalSum+=currSum;
        }
        else{
            for(Edge e: mygraph.get(src)){
                countTotalSum(e.nbr, dest, currSum+e.wt,visited);
            }
        }
        visited.remove(src.charAt(0));//remove present so that it can be counted again
    }
    int countPaths(String src,String dest,int pathCount,HashSet<Character> visited){
        //if already visited then return
        if(visited.contains(src.charAt(0)))
            return pathCount;
        else
            visited.add(src.charAt(0));
        if(src.equals(dest)){
            ++pathCount;
        }
        else{
            for(Edge e: mygraph.get(src)){
                pathCount=countPaths(e.nbr, dest, pathCount,visited);
            }
        }
        visited.remove(src.charAt(0));//remove present so that it can be counted again
        return pathCount;
    }
}

class Edge{
    String nbr;
    int wt;
    Edge( String b,int c){
        this.nbr=b;
        this.wt=c;
    }
}


