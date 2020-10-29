/*
     Day 125: Hackerank => 2D Array - DS


     Time Spent: 18 mins 
     
     Personal notes: Being thorough with basic functionality
     
*/


static int helper(int[][] arr, int i, int j){ // calc individual sum
        int sum=0;
        sum+=arr[i][j];
        sum+=arr[i][j+1];
        sum+=arr[i][j+2];
        
        sum+=arr[i+1][j+1];

        sum+=arr[i+2][j];
        sum+=arr[i+2][j+1];
        sum+=arr[i+2][j+2];

        return sum;
    }


    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int sum=Integer.MIN_VALUE;
        int num=0; 
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i+2<arr.length && j+2<arr[0].length){// hour glass can fit
                    sum=Math.max(sum,helper(arr,i,j));   
                    num+=1;           
                }
            }
        }

        System.out.println("number of glasses: "+num);

        return sum;
    }
