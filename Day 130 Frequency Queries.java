/*
     Day 130: Hackerank => Arrays: 


     Time Spent: 33 mins 
     
     Personal notes: tough test cases I couldn't crack
*/


// Complete the freqQuery function below.
static List<Integer> freqQuery(List<List<Integer>> queries) {
	/*
	Arraylist elements
	HashMap frequencies
	
	ArrayList queries   
	*/
	
	List<Integer> arr=new ArrayList<Integer>();
	HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
	List<Integer> res=new ArrayList<Integer>(); 
	for(List<Integer> q:queries){
		if(q.get(0)==1){
			arr.add(q.get(1));
			map.put(q.get(1),map.getOrDefault(q.get(1),0)+1);
		}else if(q.get(0)==2){
			arr.remove(q.get(0));
			map.put(q.get(1),map.getOrDefault(q.get(1),1)-1);
		}else if(q.get(0)==3){
			boolean found=false;
			for(Integer k:map.keySet()){
				if(map.get(k)==q.get(1)){
					found=true;
					break;
				}
			}
			if(found==true){
				res.add(1);
				//System.out.println(1);
			}else{
				res.add(0);
				//System.out.println(0);
			}
		} 
	} 
	return res;
}


// method 2 
static HashMap<Integer, Integer> mapValue = new HashMap<Integer, Integer>();
	static HashMap<Integer, HashSet<Integer>> mapFrequency = new HashMap<Integer, HashSet<Integer>>();

	private static void handleAddRemove(Integer value, boolean isAdd) {
		Integer inMapFrequency = mapValue.get(value);
		Integer newMapFrequency = inMapFrequency == null ? 0 : inMapFrequency;
		if (isAdd) {
			newMapFrequency += 1;
		} else {
			newMapFrequency -= 1;
		}

		if ((isAdd) || (!isAdd && inMapFrequency != null && inMapFrequency > 0)) {
			mapValue.put(value, newMapFrequency);

			HashSet<Integer> mapFrequencyValues = mapFrequency.get(newMapFrequency);
			if (mapFrequencyValues != null) {
				mapFrequencyValues.add(value);
			} else {
				HashSet<Integer> newSet = new HashSet<Integer>();
				newSet.add(value);
				mapFrequency.put(newMapFrequency, newSet);
			}

			HashSet<Integer> oldMapFrequencyValues = mapFrequency.get(inMapFrequency);
			if (oldMapFrequencyValues != null) {
				oldMapFrequencyValues.remove(value);
			}
		}
	}

// Complete the freqQuery function below.
static List<Integer> freqQuery(List<List<Integer>> queries) {

	List<Integer> result = new ArrayList<Integer>();

	for (int i = 0; i < queries.size(); i++) {
		List<Integer> query = queries.get(i);
		Integer operation = query.get(0);
		Integer value = query.get(1);

		if (operation == 1) {

			handleAddRemove(value, true);

		} else if (operation == 2) {
			handleAddRemove(value, false);

		} else if (operation == 3) {
			HashSet<Integer> set = mapFrequency.get(value);
			result.add(set != null && set.size() > 0 ? 1 : 0);
		}

	}

	return result;
}
