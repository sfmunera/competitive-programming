package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2498 (11503 - Virtual Friends) */
/* SUBMISSION: 11527388 */
/* SUBMISSION TIME: 2013-03-29 15:17:08 */
/* LANGUAGE: 2 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */

public class UVa11503_VirtualFriends{

    static HashMap<String, Integer> mapNames;
    static int posNames;
    static int[] ids;
    static int[] sizes;
    static int sets;
    static int N;
    public static void init(int n)
    {
        N = n;
        sets = n;
        ids = new int[N];
        sizes = new int[N];
        for(int i=0;i<N;i++)
        {
            ids[i] = i;
            sizes[i] = 1;
        }
    }
    
    public static int root(int i)
    {
        return ids[i] == i?i: (ids[i] = root(ids[i]));
    }    
    
    public static int union(int i, int j)
    {
        int u = root(i);
        int v = root(j);
        if(u == v)return sizes[u];
        int retur = -1;
        if(sizes[u] > sizes[v])
        {
            sizes[u]+=sizes[v];
            ids[v] = u;
            retur = sizes[u];
        }else{
            sizes[v]+=sizes[u];
            ids[u] = v;
            retur = sizes[v];
        }
        return retur;
    }
    
    static int pos(String x)
    {
        if(mapNames.containsKey(x))
            return mapNames.get(x);
        else{
            mapNames.put(x, posNames++);
            return posNames-1;

        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(in.readLine());
                HashMap<Integer, Integer> x;
                
        while(tests-->0)
        {
            int n = Integer.parseInt(in.readLine());
            init(2*n);
            mapNames = new HashMap<String, Integer>();
            posNames = 0;
            for(int i=0;i<n;i++)
            {
                String[] read = in.readLine().split("[ ]+");
                int u = pos(read[0]);
                int v = pos(read[1]);
                System.out.println(union(u, v));
            }
        }
        
        in.close();
        System.exit(0);
    }
    
}