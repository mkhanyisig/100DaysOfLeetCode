/*
     Day 128: Hackerank => Array Manipulation

     Time Spent: 40 mins 
     
     Personal notes: Efficient solution was not very intuitive but clever
*/

// Method 1 -> Brute Force and Prefix Algorithm
// Complete the arrayManipulation function below.
static long arrayManipulation(int n, int[][] queries) {
	int[] arr= new int[n+1];

	//for(int i=0;i<n;i++){
		//arr[i]=0;
	//}
	int max=Integer.MIN_VALUE;
	int a,b,k;
	for(int i=0;i<queries.length;i++){
		a=queries[i][0];
		b=queries[i][1];
		k=queries[i][2];

		for(int x=a;x<=b;x++){
			if(x<=n){
				arr[x]+=k;  
				System.out.println(x+"  "+arr[x]);
				max=Math.max(max, arr[x]);
			}      
		}
	}
	return max;
}


// Method 2 optimal algorithm
// Complete the arrayManipulation function below.
static long arrayManipulation(int n, int[][] queries) {
	int[] arr= new int[n];

	for(int i=0;i<n;i++){
		arr[i]=0;
	}
	long max=Integer.MIN_VALUE;
	int a,b,k;
	for(int i=0;i<queries.length;i++){
		arr[queries[i][0]-1]+=queries[i][2]; 
		if(queries[i][1]<arr.length){
			arr[queries[i][1]]-=queries[i][2];
		}      
	}
	long sum=0;
	for(int i=0;i<arr.length;i++){
		sum+=arr[i];
		max=Math.max(max,sum);
	}
	return max;
}