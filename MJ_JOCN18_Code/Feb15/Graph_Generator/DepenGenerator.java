/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_Generator;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mjalalitabar1
 */
public class DepenGenerator {
    
private ArrayList<functionnode> VNFs;

    public DepenGenerator(ArrayList<functionnode> VNFs) {
        this.VNFs = VNFs;
    }

    public ArrayList<functionnode> getVNFs() {
        return VNFs;
    }

    public void setVNFs(ArrayList<functionnode> VNFs) {
        this.VNFs = VNFs;
    }

public void randomDepGenerator(ArrayList<functionnode> funcs){ //generate random dependency for the VNFs
    
  for (int jq = 0; jq < funcs.size(); jq++) {
                ArrayList<Integer> Deplist = new ArrayList<Integer>();
                ArrayList<Integer> pool = new ArrayList<Integer>();
                for (int k1 = 0; k1 < funcs.size(); k1++) {
                    if (k1 != jq) {
                        pool.add(k1);
                    }
                }
                System.out.println("pool " + pool + " for node: " + jq);

                /////////////////////////////////////////////////////////////////////            
                int DepRand = 0;
                Random r = new Random();
                double rangeMin = 0;
                double rangeMax = 1.5;
                double randomValue1 = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

                if (randomValue1 < .5) {
                    DepRand = 0;
                } else if (randomValue1 < 1) {
                    DepRand = 1;
                } else 
                    DepRand = 2;
                
                ////////////////////////////////////////////////////////////////////   

                System.out.println("Num op possible dep: " + DepRand);
                int t = pool.size() - 1;
                for (int k2 = 0; k2 < DepRand; k2++) {
                    int t1 = pool.size() - 1;
                    Random rn = new Random();
                    int randomValue = 0 + (int) (Math.random() * (((pool.size() - 1) - 0) + 1));
                    System.out.println("random index" + randomValue);
                    if (!(pool.indexOf(pool.get(randomValue)) == -1)) {
                        System.out.println("element of the index: " + pool.get(randomValue));
                        Deplist.add(pool.get(randomValue));
                        int removedDataIndex = pool.indexOf(pool.get(randomValue));
                        pool.remove(removedDataIndex);
                        System.out.println("updated pool: " + pool);
                        System.out.println("Deplist: " + Deplist);
                    } else {
                        System.out.println("pppp");
                    }
                }
                System.out.println("Deplist " + Deplist + " For Node: jq " + jq);
                
               VNFs.get(jq).setFuncDep(Deplist);
              //  nodesFile[jq].setFuncDep(Deplist);
                //vnfs.add(nodesFile[jq]);

            }

            for (int ie = 0; ie < VNFs.size(); ie++) {
                System.out.println(" Node: " + VNFs.get(ie).getNumber() + " CPU: " + VNFs.get(ie).getReqCPU()  
                        + " dependencies: " + VNFs.get(ie).getFuncDep());
            }  
}

   


   
    
}
