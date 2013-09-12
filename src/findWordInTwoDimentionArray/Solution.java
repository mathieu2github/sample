package findWordInTwoDimentionArray;

import java.util.*;
import java.io.*;
public class Solution{
        public static int flag=0,m,n,dx[]={0,0,1,-1,1,-1,-1,1};
        public static int dy[]={1,-1,0,0,1,-1,1,-1};
        public static char wrd[];
        static class S{char a;int p,x,y;
                S(){}
                S(char b,int pos,int c,int d){a=b;p=pos;x=c;y=d;}
        }
        public static LinkedList<S>vis=new LinkedList<S>();
        public static LinkedList<S>init=new LinkedList<S>();
  public static Stack<S>fc=new Stack<S>();
        public static char mat[][];
        public static void main(String args[]) throws Exception{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                m=Integer.parseInt(br.readLine());
                n=Integer.parseInt(br.readLine());
                int i,j;
    long a=System.currentTimeMillis();
                mat=new char[m][n];
    wrd=br.readLine().toCharArray();
                for(i=0;i<m;i++) mat[i]=br.readLine().toCharArray();
                for(i=0;i<m;i++) for(j=0;j<n;j++) if(mat[i][j]==wrd[0]){init.add(new S(wrd[0],0,i,j));}
                for(i=0;i<init.size();i++) {solve(init.get(i));if(flag==1) break;}
    if(flag==0) {System.out.println("NO");return;}
    for(i=0;i<n;i++) for(j=0;j<n;j++) mat[i][j]='-';
    S tp=null;
    for(;!fc.isEmpty();) {tp=fc.pop();mat[tp.x][tp.y]=tp.a;}
    for(i=0;i<m;i++) {
     for(j=0;j<n;j++) System.out.print(mat[i][j]);
     System.out.println();
    }
    System.out.println((System.currentTimeMillis()-a)+"ms");
        }
        public static void solve(S s){
   int i,j;
   if(s.p==wrd.length-1){System.out.println("YES");fc.push(s);flag=1;return;}
            for(i=0;i<8;i++) 
    if((s.x+dx[i])>0&&(s.y+dy[i])>0&&(s.x+dx[i])<m&&(s.y+dy[i])<n&&mat[s.x+dx[i]][s.y+dy[i]]==wrd[s.p+1]) 
     solve(new S(wrd[s.p+1],(s.p+1),(s.x+dx[i]),(s.y+dy[i])));
            if(s.p>=0&&s.p<wrd.length&&flag==1){fc.push(s);}
        }
}