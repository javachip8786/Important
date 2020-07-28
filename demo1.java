import java.util.Scanner;
public class demo1 {

	public static int ways = 0;
	public static int checker = 0;
	public static void calcWays(int x, int y, int[][] map, int n, int m, int sx, int sy) {
		if (x < sx-1 || y < sy-1) {
			checker = 0;
		}
		if (x == sx-1 && y == sy-1) {
			checker = 1;
		}
		if (x == n-1 && y == m-1 && checker == 1) {
			ways++;
		}
		
		if (x < n-1 ) {
		if (map[x+1][y] != 0) {
			calcWays(x+1,y,map,n, m,sx, sy);
		}}

		if (y< m-1) {
		if (map[x][y+1] != 0) {
			calcWays(x,y+1, map, n, m, sx, sy);
		}
	}}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int map[][] = new int[n][m];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				map[i][j] = in.nextInt();
			}
		}
		calcWays(0,0, map, n,m,x,y);
		if(map[0][0] == 0) {
			ways = 0;
		}
		System.out.println(ways);
	}



		
	}


