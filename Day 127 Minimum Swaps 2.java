/*
     Day 125: Hackerank => Minimum Swaps 2

     Time Spent: 14 mins 
     
     Personal notes: subtle mistakes caught debugging
     
*/

// Complete the minimumSwaps function below.
static int minimumSwaps(int[] arr) {
	int num=0;
	for(int i=0;i<arr.length;i++){
		if(arr[i]==i+1){
			continue;
		}else{
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]==i+1){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					num+=1;
					break;
				}
			}
		}

	}
	return num;
}