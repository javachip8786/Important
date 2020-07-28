
public class leet_trees {
	
	public static class TreeNode{
		public int data;
		public TreeNode left;
		public TreeNode right;
		TreeNode(int x){
			data=x;
		}
		
		public static boolean isSameTree(TreeNode p,TreeNode q) {
			if((p==null && q!=null) || (p!=null && q==null)) {
				return false;
			}
			else if(p==null && q==null) {
				return true;
			}
			if(p.data!=q.data) {
				return false;
			}
			boolean left=isSameTree(p.left,q.left);
			boolean right=isSameTree(p.right,q.right);
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
