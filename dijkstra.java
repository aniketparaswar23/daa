import java.util.*;
public class dijkstra {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Scanner sc =new Scanner(System.in);
        int v=9;//sc.nextInt();
        int e=29;//sc.nextInt();
        int adjMat[][]=new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        //new int [v][v];
        // for(int i=0;i<e;i++)
        // {
        //     int v1=sc.nextInt();
        //     int v2=sc.nextInt();
        //     int weight=sc.nextInt();
        //     adjMat[v1][v2]=weight;
        // }
        System.out.println("Enter the source vertex");
        int fromV=sc.nextInt();
        int distance[]=new int[v];

        dijkstraAlgo(adjMat,distance,fromV);
        for(int i=0;i<v;i++)
        {
            System.out.println(distance[i]+" ");
        }
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;
        System.out.println("Running time: " + runningTime + " nanoseconds");

    }

    public static void dijkstraAlgo(int adjMat[][],int distance[],int fromV)
    {
        int v=adjMat.length;
        boolean visited[]=new boolean[v];
        distance[fromV]=0;
        for(int i=0;i<v;i++)
        {
            if(i==fromV)
                continue;
            distance[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<v-1;i++)
        {
            int minV=findMin(distance, visited);
            visited[minV]=true;
            for(int j=0;j<v;j++)
            {
                if(adjMat[minV][j]!=0 &&visited[j]==false && distance[minV]!=Integer.MAX_VALUE)
                {
                    int newDist=distance[minV]+adjMat[minV][j];
                    if(newDist<distance[j])
                    {
                        distance[j]=newDist;
                    }
                }
            }
        }


    }
    public static int findMin(int []distance,boolean []visited)
    {
        int minV=-1;
        for(int i=0;i<distance.length;i++)
        {
            if(visited[i]==false && (minV==-1 || distance[i]<distance[minV])){
                minV=i;
            }
        }
        return minV;
    }
    
}