/*
     Day 128: Hackerank => Arrays: Left Rotation


     Time Spent: 24 mins 
     
     Personal notes: A bit slow on logic
*/

// Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] res= new int[a.length];
        
        int pos=0;
        for(int i=0;i<a.length;i++){
            if(i-d<0){
                pos=a.length+(i-d);
            }else{
                pos=i-d;
            }
            System.out.println(pos);
            res[pos]=a[i];
            //pos-=1;
        }
        
        return res;
    }