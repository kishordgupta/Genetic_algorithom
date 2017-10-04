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
public class GA {

    /* GA parameters */
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 2;
    private static final boolean elitism = true;

    /* Public methods */
    
    // Evolve a population
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = pop;//new Population(pop.size(), false);
        pop.sort();
        
        // population reprod
        
        
        // Keep our best individual
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = pop.getIndividual(i-1);
            Individual indiv2 =  pop.getIndividual(i);
                 Individual newSol1 = new Individual();
          Individual newSol2 = new Individual();
          Random ran = new Random();
         int arand = ran.nextInt(indiv1.size()-1)+1;
      //  int arand =(int)Math.ceil(Math.random()*indiv1.size());
        // Loop through genes
        for (int k = 0; k < indiv1.size(); k++) {
            // Crossover
            if (arand <= k) {
                newSol1.setGene(k, indiv1.getGene(k));
                 newSol2.setGene(k, indiv2.getGene(k));
            } else {
                newSol1.setGene(k, indiv2.getGene(k));
                 newSol2.setGene(k, indiv1.getGene(k));
            }
        }
            
            newPopulation.saveIndividual(i-1, newSol1);
              newPopulation.saveIndividual(i, newSol2);
        }
            
        int arandmu =(int)Math.round(Math.random()*8);
        // Mutate population
       for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // Crossover individuals
    private static Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol1 = new Individual();
          Individual newSol2 = new Individual();
        int arand =(int)Math.round(Math.random()*indiv1.size());
        // Loop through genes
        for (int i = 0; i < indiv1.size(); i++) {
            // Crossover
            if (arand <= i) {
                newSol1.setGene(i, indiv1.getGene(i));
                 newSol2.setGene(i, indiv2.getGene(i));
            } else {
                newSol1.setGene(i, indiv2.getGene(i));
                 newSol2.setGene(i, indiv1.getGene(i));
            }
        }
        return newSol1;
    }

    // Mutate an individual
    private static void mutate(Individual indiv) {
        // Loop through genes
         
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                // Create random gene
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

 
}
