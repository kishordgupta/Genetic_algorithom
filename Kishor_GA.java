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
public class Kishor_GA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Population myPop = new Population(20);
          int generationCount = 0;
        while (generationCount<20) {
            generationCount++;
            myPop.print();
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness() + " average " + myPop.average + " sum " + myPop.sum + " max " + myPop.max );
            myPop = GA.evolvePopulation(myPop);
        }
    }
    
}
