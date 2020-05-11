/*
     Day 72: Leetcode 415. Add Strings
     Time Spent: 80 mins 
     
     Personal notes: I was  a bit rusty, tried to use suggested methods
*/



class Solution {
    public String addStrings(String num1, String num2) {
        int maxlen= Math.max(num1.length(),num2.length());
        
        int idx=maxlen;
        maxlen+=1;
        char[] arr= new char[maxlen];
        
        int n1=num1.length()-1;
        int n2=num2.length()-1;
        int carry=0;
        int na=-1;
        int nb=-1;
        System.out.println(na+"   "+nb);
        char val='x';
        int sum=-1;
        
        while(n1>=0 || n2>=0){
            if(n1>=0 && n2>=0){
                System.out.println("* n1 + n2");
                System.out.println(n1+"    "+n2);
                na=Character.getNumericValue(num1.charAt(n1)); 
                nb=Character.getNumericValue(num2.charAt(n2));
                
                System.out.println(na+"   "+nb);
                
                if(na+nb+carry>9){
                    System.out.println("carry");
                    sum=(na+nb+carry)-10;
                    carry=1;
                }
                else{
                    sum=(na+nb+carry);
                    carry=0;
                }
                
                val=(char) (sum+'0');
                System.out.println("Val input: "+val+"   actual :"+sum);
                arr[idx] =val;
                //carry=0;
                n1-=1;
                n2-=1;
            }
            else if(n1>=0){
                System.out.println("* n1");
                na=Character.getNumericValue(num1.charAt(n1)); 
                if(na+carry>9){
                    System.out.println("carry");
                    sum=(na+carry)-10;
                    carry=1;
                }
                else{
                    sum=(na+carry);
                    carry=0;
                }
                
                val=(char) (sum+'0');
                System.out.println("Val input: "+val+"   actual :"+sum+" na:"+na+"  carry:"+carry);
                arr[idx] =val;
                //carry=0;
                n1-=1;
                
            }
            else if(n2>=0){
                System.out.println("* n2");
                nb=Character.getNumericValue(num2.charAt(n2)); 
                if(nb+carry>9){
                    System.out.println("carry");
                    sum=(nb+carry)-10;
                    carry=1;
                }
                else{
                    sum=(nb+carry);
                    carry=0;
                }
                
                val=(char) (sum+'0');
                System.out.println("Val input: "+val+"   actual :"+sum);
                arr[idx] =val;
                //carry=0;
                
                n2-=1;
            }
            else{
                
            }
            idx-=1;
        }
        System.out.println("Raw Array:  "+Arrays.toString(arr)+"   carry:"+carry);
        if(carry>0){
            
            arr[idx]= (char) (carry+'0');
        }else{
            arr= Arrays.copyOfRange(arr, 1, arr.length);
        }
        
        
        
        String str = new String(arr);
        
        return str;   
    }
}