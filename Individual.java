/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kishor_ga_wheel;


/**
 *
 * @author Kishor
 */
public class Individual {

    static int defaultGeneLength = 6;
    private byte[] genes = new byte[defaultGeneLength];
      private int geneinint = 0;
      private int fitness = 0;
        private double probi = 0;
          private double probicount = 0;
            private int actualcount = 0;
    // Cache
 //   private int fitness = 0;

    // Create a random individual
    public void generateIndividual(int seq) {
        String data=Integer.toBinaryString(seq);
      geneinint=seq;
      fitness=seq*seq;
        int rem0 = defaultGeneLength- data.length();
        for (int i = 0; i < rem0; i++) {
            data ="0"+data;
        }
        int i=0;
        for(char ca : data.toCharArray())
        {
            if(ca=='0')
            genes[i]=0;
            else
                 genes[i]=1; 
            i++;
         //   genes[i]=c.
        }
       // genes=data.tob
       // System.out.print( " "+data+ " ");
      //    for (byte b :genes) {
      //      System.out.print(b);
     //   }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }
    
    public byte getGene(int index) {
        return genes[index];
    }
   public int getGeneintint() {
        return geneinint;
    }
    public void setGene(int index, byte value) {
        genes[index] = value;
          String data="";
        for(int i=0;i<size();i++)
        {
        if(genes[i]==0)
            data=data+"0";
        else
            data=data+"1";
        
        }
        int d=binaryToInt(data);
        geneinint=d;
        fitness=d*d;
        //fitness = 0;
    }
       public void setGenevalue(byte[] value) {
        genes = value;
          String data="";
        for(int i=0;i<size();i++)
        {
        if(genes[i]==0)
            data=data+"0";
        else
            data=data+"1";
        
        }
        int d=binaryToInt(data);
        geneinint=d;
        fitness=d*d;
        //fitness = 0;
    }
public void probcount(int sum,int size)
{
probi=(double)fitness/sum;
probicount=(double)probi*size;
actualcount = (int) Math.round(probicount);
System.out.println( sum+ " " + size+" "+geneinint+ " probi "+ probi + "count "+ probicount+ " actualcount "+actualcount);
}
  public double getprobi() {
        return probi;
    }
   public double getprobicount() {
        return probicount;
    }
    public int size() {
        return genes.length;
    }
    /* Public methods */
    public int actualcount() {
        return actualcount;
    }

    public int getFitness() {
  
      String data="";
        for(int i=0;i<size();i++)
        {
        if(genes[i]==0)
            data=data+"0";
        else
            data=data+"1";
        
        }
        int d=binaryToInt(data);
        geneinint=d;
        fitness=d*d;
        return fitness;
    }


static int binaryToInt (String binary){
    char []cA = binary.toCharArray();
    int result = 0;
    for (int i = cA.length-1;i>=0;i--){
        //111 , length = 3, i = 2, 2^(3-3) + 2^(3-2)
        //                    0           1  
        if(cA[i]=='1') result+=Math.pow(2, cA.length-i-1);
    }
    return result;
}
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }

    byte[] getGenevalue() {
       return genes;
        //To change body of generated methods, choose Tools | Templates.
    }

    void setactualcount(int actualcounts) {
      actualcount=actualcounts; //To change body of generated methods, choose Tools | Templates.
    }


}
