/*
     Day 6: Leetcode 299. Bulls and Cows
     Time Spent: 91 mins
     
     
     Personal notes: Checking cows and ensuring no repeats when debugging took me the longest time. 
     
     */



class Solution {
    public String getHint(String secret, String guess) {
        int b=0;
        int c=0;
        
        String ret = "";
        
        char[] chars=secret.toCharArray();
        char[] charg=guess.toCharArray();
        
        // check bulls
        for(int i=0;i<guess.length();i++){
            if((secret.charAt(i)==guess.charAt(i)) && secret.contains(Character.toString(guess.charAt(i)))) {
                b+=1;
                
                
                int y=secret.indexOf(guess.charAt(i));
                System.out.println("y :"+y+"      *  "+guess.charAt(i));
                secret=secret.substring(0,y)+'x'+secret.substring(y+1); 
                guess=guess.substring(0,i)+'y'+guess.substring(i+1); 
                
            }
            
        }
        System.out.println("After Bull: "+"    secret: "+secret+"   guess: "+guess);
        // check cows
        for(int i=0;i<guess.length();i++){
            if (secret.contains(Character.toString(guess.charAt(i)))){
                c+=1;
                System.out.println(guess.charAt(i) + "    secret: "+secret+"   guess: "+guess);
                
                //secret=secret.substring(0,i)+'x'+secret.substring(i+1); 
                int y=secret.indexOf(guess.charAt(i));
                //System.out.println("y :"+y+"      *  "+guess.charAt(i));
                secret=secret.substring(0,y)+'x'+secret.substring(y+1); 
                guess=guess.substring(0,i)+'y'+guess.substring(i+1); 
            }
        }
        System.out.println("After Cow: "+"    secret: "+secret+"   guess: "+guess);
        
        
        
        
        
        ret+= Integer.toString(b);
        ret+="A";
        ret+= Integer.toString(c);
        ret+="B";
        
        return ret;
       
    }
}
