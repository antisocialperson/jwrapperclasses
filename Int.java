public class Int{
  
  private static int N;
  
  public Int(int a){
    N = a;
  }
  public static int intValue(){ // returns the value of this number 
    return N;
  }
  public static long longValue(){ // cast to long and return
    return (long)N;
  }
  public static double doubleValue(){ // cast to double and return
    return (double)N;
  }
  public static float floatValue(){ // cast to float and return
    return (float)N;
  }
  public static int parseInt(String s){ // convert from String to Int
    char[] chrs = s.toCharArray();
    int sm = 0;
    char zero = '0';
    for(char c:chrs){
      int temp = (int)(c-zero);
      sm = (sm*10) + temp;
    }
    return sm;
  }
  public static boolean equals(Int i){ // returns if this integer is equal to another integer i
    if(N == i.N)
      return true;
    else
      return false;
  }
  
}
