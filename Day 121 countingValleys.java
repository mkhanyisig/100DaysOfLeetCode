/*
     Day 121: countingValleys

     Time Spent: 30 mins 
     
     Personal notes: Valley definition
     
*/


// Method 1   (11/22 test cases)
public static int countingValleys(int steps, String path) {
        // Write your code here
        int level=0;
        int res=0;
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='U'){
                if(level<0){
                    while(level<0 && i<path.length()){  
                        if(path.charAt(i)=='U'){
                            level+=1;
                        }else{
                            level-=1;
                        }
                        i+=1;
                    }
                    res+=1;
                    
                    
                }else{
                    level+=1;
                }    
            }else if(path.charAt(i)=='D'){
                level-=1;
            }
        }
        System.out.println(res);
        return res;
    }



// Method 2
public static int countingValleys(int steps, String path) {
        // Write your code here
        int level=0;
        int res=0;
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='U'){
                level+=1;  
            }else if(path.charAt(i)=='D'){
                level-=1;
            }
            if(level==0 && path.charAt(i)=='U'){// just came to sea level
                res+=1;
            }
        }
        //System.out.println(res);
        return res;

}