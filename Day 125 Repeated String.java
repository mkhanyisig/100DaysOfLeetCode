/*
     Day 125: Hackerank => Repeated String

     Time Spent: 30 mins 
     
     Personal notes: Long vs int conversion. Work with given test cases
     
*/


// Complete the repeatedString function below.
static long repeatedString(String s, long n) {
	int res=0;
	int lng=(int)n;

	long rem=n%s.length();

	int base=0;
	for(char c:s.toCharArray()){
		if(c=='a'){
			base+=1;
		}
	}

	int custom=0;
	for(int i=0;i<rem;i++){
		if(s.charAt(i)=='a'){
			custom+=1;
		}
	}

	System.out.println(base+" - "+custom);
	return (base*(n/s.length()))+(custom);
}
