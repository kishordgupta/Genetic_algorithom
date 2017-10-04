/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kishor_ga_wheel;

import java.util.Random;

/**
 *
 * @author Kishor
 */
public  class Population {
     public int sum;
     public double average;
     public int max;
      public int min;
     Individual[] individuals;

    /*
     * Constructors
     */
    // Create a population
    public Population(int populationSize) {
       individuals = new Individual[populationSize];
        // Initialise population
         Random ran = new Random();
            // Loop and create individuals
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();
                int a = ran.nextInt(64);
                newIndividual.generateIndividual(a);
                
                
                saveIndividual(i, newIndividual);
            }
        
    }
public  void print()
{
           for (int i = 0; i < size(); i++) {
                System.out.print(getIndividual(i).getGeneintint()+",");
            }
           System.out.println();
}
    /* Getters */
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        
        return fittest;
    }

    /* Public methods */
    // Get population size
    public int size() {
        return individuals.length;
    }
  // Save individual
    public void sort() {
         int n = individuals.length;
    Individual temp ;

   // for (int i = 0; i < n; i++) {
    //    for (int j = 1; j < (n - i); j++) {
//
    //        if (individuals[j - 1].getFitness() < individuals[j].getFitness()) {
    //            temp = individuals[j - 1];
     //           individuals[j - 1] = individuals[j];
     //           individuals[j] = temp;
     //       }
//
   //     }
  //  } 
    sum=0;max=individuals[0].getFitness();average=0;min=individuals[0].getFitness();
    for(Individual a:individuals)
    {
        if(max<a.getFitness())
            max=a.getFitness();
        if(min>a.getFitness())
            min=a.getFitness();
        sum=sum+a.getFitness();
    }
    average=sum/n;
      for(Individual a:individuals)
    {
        a.probcount(sum, size());
        
    }
    ////////////generate
     Individual[] tempindividuals =new Individual[individuals.length];
     int k=0;
       for(Individual a : individuals)
    {
      tempindividuals[k]  =new Individual();
      tempindividuals[k].setGenevalue(a.getGenevalue());
        tempindividuals[k].setactualcount(a.actualcount());
    //  System.out.println(  tempindividuals[k].getGeneintint()+" ");
      k++;
    }
     int j=0;
     System.out.println("set ");
    for(Individual a : tempindividuals)
    { 
        if(a.actualcount()>=1){ 
    for(int i=0;i<=a.actualcount();i++)
    {//System.out.print(a.getGeneintint()+" ");
        if(j<individuals.length)
        individuals[j].setGenevalue(a.getGenevalue());
        else
            break;
        j++;
    }
        }
    }
 //   individuals=tempindividuals.clone();
    
    }
    // Save individual
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}


