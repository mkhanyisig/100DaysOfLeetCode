/*
     Day 52: Leetcode 54. Spiral Matrix
     Time Spent: 71 mins 
     
     Personal notes: debugging this took a while
*/





class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> arr = new ArrayList<Integer>();
     
    if(matrix.length==0){
        return arr;
    }    
       
    int top=0;
    int bottom=matrix.length-1;
    int right=matrix[0].length-1;
    int left=0;
    
    if(matrix[0].length==1){ // r *1 (column matrix)
        for(int i=0;i<matrix.length;i++){
          arr.add(matrix[i][0]); 
        }
        return arr;
    }
    
    if(matrix.length==1 ){ // 1 *c (row matrix)
      for(int i=0;i<matrix[0].length;i++){
          arr.add(matrix[0][i]);
          
       }
       return arr;
    }
    int sz=(matrix.length*matrix[0].length);
        
    System.out.println(top+"   "+left+"   "+bottom+"   "+right);
    System.out.println((matrix.length*matrix[0].length)+"  arr size: "+arr.size());
    
    while(top<=bottom && right>=left){
        System.out.println(top+"   "+left+"   "+bottom+"   "+right);
        /*
        if(bottom-top==1 && right-left==1){
            System.out.println("**case last square");
            arr.add(matrix[top][left]);
            arr.add(matrix[top][right]);
            arr.add(matrix[bottom][right]);
            arr.add(matrix[bottom][left]);
        }
        else if(top==bottom && left ==right){
            System.out.println("**case RC");
            arr.add(matrix[top][left]);
        }
        else if(top!=bottom && left ==right){ // column
            System.out.println("**case col");
            for(int i=top;i<=bottom;i++){
                arr.add(matrix[i][left]);
            }    
        }
        else if(top==bottom && left !=right){ // row
            System.out.println("**case row");
            for(int i=left;i<=right;i++){
                arr.add(matrix[top][i]);
            }    
        }
        else{
            // do nothing
        }
        */
        if(arr.size()>=(matrix.length*matrix[0].length)){
            break;
        }
        
         // first row
        for(int i=left ;i<=right && arr.size()<sz;i++){
          arr.add(matrix[top][i]);
        }  
        top+=1;
            
        // last column
        for(int j=top;j<=bottom && arr.size()<sz; j++){
            arr.add(matrix[j][right]);
        }
        right-=1;
   
        // bottom row
        for(int i=right ;i>=left && arr.size()<sz;i--){
            arr.add(matrix[bottom][i]);
        }  
        bottom-=1;
        // first column
        for(int j=bottom;j>=top && arr.size()<sz; j--){
          arr.add(matrix[j][left]);
        }
        left+=1;
        
        System.out.println("End: "+top+"   "+left+"   "+bottom+"   "+right);
        System.out.println("End :"+(matrix.length*matrix[0].length)+"  arr size: "+arr.size());
    }
    
    
    return arr;
  }
     
}