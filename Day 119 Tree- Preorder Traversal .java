/*
     Day 119: Tree: Preorder Traversal

     Time Spent: 30 mins 
     
     Personal notes: Revise iterative BFS and DFS problems
*/


public static void preOrder(Node root) {

        String res="";

        if(root==null){
            System.out.println(res);
        }

        Stack<Node> q= new Stack<Node>();

        q.add(root);

        while(!q.isEmpty()){
            Node n=q.pop();
            
            res+=Integer.toString(n.data) +" ";

            if(n.right!=null){
                q.add(n.right);
            }
            if(n.left!=null){
                q.add(n.left);
            }    
        }

        System.out.println(res);

}