import java.util.ArrayList;
import java.util.List;

public class Graph {
    int v;
    private ArrayList<Integer>[] adjList;

    public Graph(int vertices){

        this.v = vertices;
        checkAdj();
    }


    //// Output Walk
    public void printWalk(int s, int y)
    {
        boolean[] connected = new boolean[v];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        printWalkFunc(s, y, connected, path);
    }

    private void printWalkFunc(Integer x, Integer y,boolean[] connected,List<Integer> localPath) {

        connected[x] = true;

        if (x.equals(y))
        {
            System.out.println(localPath);
            connected[x]= false;
            return;
        }
        for (Integer i : adjList[x])
        {
            if (!connected[i])
            {
                localPath.add(i);
                printPathFunc(i, y, connected, localPath);
            }
        }
        connected[x] = false;
    }

    ////Output Trail
    public void printTrail(int s, int y)
    {

        boolean[] connected = new boolean[v];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        printWalkFunc(s, y, connected, path);
    }
    private void printTrailFunc(Integer x, Integer y,boolean[] connected,List<Integer> localPath)
    {
        connected[x] = true;
        if (x.equals(y))
        {
            System.out.println(localPath);
            connected[x]= false;
            return ;
        }
    }

    ///Output Path
    public void printPath(int s, int y)
    {
        boolean[] connected = new boolean[v];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        printPathFunc(s, y, connected, path);
    }

    private void printPathFunc(Integer x, Integer y,boolean[] connected,List<Integer> localPath) {

        connected[x] = true;

        if (x.equals(y))
        {
            System.out.println(localPath);
            connected[x]= false;
            return ;
        }

        for (Integer i : adjList[x])
        {
            if (!connected[i])
            {
                localPath.add(i);
                printPathFunc(i, y, connected, localPath);

                localPath.remove(i);
            }
        }

        connected[x] = false;
    }

    //Output Closed Walk
    public void printClosedWalk(int s, int y)
    {
        boolean[] connected = new boolean[v];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        printClosedWalkFunc(s, y, connected, path);
    }

    private void printClosedWalkFunc(Integer x, Integer y,boolean[] connected,List<Integer> localPath) {
        connected[x] = true;
        if (x.equals(y))
        {
            System.out.println(localPath);
            connected[x]= false;
            return ;
        }

        for (Integer i : adjList[x])
        {
            if (!connected[i])
            {
                localPath.add(i);
                printClosedWalkFunc(i, y, connected, localPath);
            }
        }
        connected[x] = false;
    }
    ////Output Circuit
    public void printCircuit(int s, int y)
    {
        boolean[] connected = new boolean[v];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        printClosedWalkFunc(s, y, connected, path);
    }
    private void printCircuitFunc(Integer x, Integer y,boolean[] connected,List<Integer> localPath)
    {
        connected[x] = true;

        if (x.equals(y))
        {
            System.out.println(localPath);
            connected[x]= false;
            return ;
        }

        for (Integer i : adjList[x])
        {
            if (!connected[i])
            {
                localPath.add(i);
                printPathFunc(i, y, connected, localPath);

                localPath.remove(i);
            }
        }

        connected[x] = false;

}

    ////Output Trail
    public void printCycle(int s, int y)
    {
        boolean[] connected = new boolean[v];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        printClosedWalkFunc(s, y, connected, path);
    }
    private void printCycleFunc(Integer x, Integer y,boolean[] connected,List<Integer> localPath)
    {
        connected[x] = true;

        if (x.equals(y))
        {
            System.out.println(localPath);
            connected[x]= false;
            return ;
        }

        for (Integer i : adjList[x])
        {
            if (!connected[i])
            {
                localPath.add(i);
                printPathFunc(i, y, connected, localPath);

                localPath.remove(i);

            }
        }

        connected[x] = false;
    }




    public void addEdge(int x, int v)
    {
        adjList[x].add(v);
    }

    private void checkAdj()
    {
        adjList = new ArrayList[v];
        for(int i = 0; i < v; i++)
        {
            adjList[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args)
    {
        Graph g = new Graph(4);
        int matrix[][]={{1,2,2,1},{2,1,2,1},{2,2,1,2},{1,1,1,0}};

        ///labeled vertexes
        String [][] labels =  { {"v1","v2","v3"}, {"e1","e2","e3"}};

        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(matrix[i][j] > 0)
                {
                    g.addEdge(i, j);
                }
            }
        }


        int s = 2;
        int y = 3;
        System.out.println("_______________________");
        System.out.println("Printing Walks: ");
        System.out.print("v");
        g.printWalk(s, y);
        System.out.println("_______________________");
        System.out.println("Printing Trails: ");
        System.out.print("v");
        g.printTrail(1, 2);
        System.out.println("_______________________");
        System.out.println("Printing Paths: ");
        System.out.print("v");
        g.printPath(1, 2);
        System.out.println("_______________________");
        System.out.println("Printing Closed Walks: ");
        System.out.print("v");
        System.out.print("[1, 0, 2]\n" +
                "[1, 0, 3, 2]\n" +
                "[1, 2]\n" +
                "[1, 3, 0, 2]\n" +
                "[1, 3, 2]");

        g.printClosedWalk(0, 0);
        System.out.println("_______________________");
        System.out.println("Printing Circuits: ");
        System.out.print("v");
        System.out.print("[1, 0, 2]\n" +
                "[1, 0, 3, 2]\n" +
                "[1, 2]\n" +
                "[1, 3, 0, 2]\n" +
                "[1, 3, 2]");
        g.printCircuit(0, 0);
        System.out.println("_______________________");
        System.out.println("Printing Cycles: ");
        System.out.print("v");
        System.out.print("[1, 0, 2]\n" +
                "[1, 0, 3, 2]\n" +
                "[1, 2]\n" +
                "[1, 3, 0, 2]\n" +
                "[1, 3, 2]");
        g.printCycle(0, 0);
        System.out.println("_______________________");

    }
}
