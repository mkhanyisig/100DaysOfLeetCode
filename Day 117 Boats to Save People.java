/*
     Day 117: Leetcode 881. Boats to Save People

     Time Spent: 30 mins 
     
     Personal notes: Two pointer aproach


class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
            greedy approach        
        */ 
        
        int boats=0;
        //Arrays.sort(people);
        List<Integer> ls= new ArrayList<>();
        List<Integer> remaining= new ArrayList<>();
        //List<Integer> boarded= new ArrayList<>();
        for(int p:people){
            ls.add(p);
            remaining.add(p);
            
        }
        
        for(Integer p: ls){
            System.out.println("** "+p);
            if(remaining.contains(p)){
                System.out.println("Remaining : "+Arrays.toString(remaining.toArray()));
                if(p.intValue()==limit){// max capacity
                    remaining.remove(new Integer(p.intValue()));

                }
                else if(remaining.contains(limit-p.intValue())){
                    remaining.remove(new Integer(p.intValue()));
                    remaining.remove(new Integer(limit-p.intValue()));

                }
                else{
                    remaining.remove(new Integer(p.intValue()));
                    for(int k=limit-p.intValue();k>0;k--){
                        System.out.println("k : "+k);
                        if(remaining.contains(k)){
                            //found=true;
                            remaining.remove(new Integer(k));
                            break;
                        }
                    }
                    //if(found==false){
                        //remaining.remove(new Integer(p.intValue()));
                    //}
                    

                }
                boats+=1;
            }
        }
        
        return boats;
    }
}

// Kevin Naughton Efficient

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cur = 0, res = 0, i = 0, j = people.length - 1;
        while (i <= j) {
            if (cur + people[j] <= limit) cur += people[j--];
            if (cur + people[i] <= limit) cur += people[i++];
            cur = 0;
            res++;
        }
        return res;
    }
}