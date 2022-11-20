import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Graph graph = new Graph();
        graph.mygraph=new HashMap<>();
        int vertices=5;
        for(int i=0;i<vertices;i++){
            String v=sc.next();
            graph.mygraph.put(v,new LinkedList<>());
        }
        int edges=7;
        for(int i=0;i<edges;i++){
            String a=sc.next();
            String b=sc.next();
            int c=sc.nextInt();
            graph.mygraph.get(a).add(new Edge(b,c));
            graph.mygraph.get(b).add(new Edge(a,c));
        }
        int avgDistance=graph.calculateAverageDistanceBetweenTwoPoints("C",
                "E");
        System.out.println("the average distance between the given points: "+avgDistance);
    }
}