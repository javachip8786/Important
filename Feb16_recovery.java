
public class Feb16_recovery {
	public static int paths(int tx,int ty,int bx,int by,int sum) {
		
		if(tx==bx || ty==by) {
			return sum+=1;
		}
		else if(tx==bx) {
			return paths(tx,ty+1,bx,by,sum+1);
		}
		else if(ty==by) {
			return paths(tx+1,ty,bx,by,sum+1);
		}
		else {
			int h=paths(tx,ty+1,bx,by,sum+1);
			int u=paths(tx+1,ty,bx,by,sum+1);
			return sum;
		}
	}

	public static void main(String[] args) {
		int result=paths(0,0,2,2,0);
		System.out.print(result);

	}

}
