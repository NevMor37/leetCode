/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_Generator;

/**
 *
 * @author mjalalitabar1
 */
public class graphEdge {
    
  private  int id; 
  private int source;
  private int destination;
  private  int weight;//distance 
  private int BW;

    public graphEdge(int id, int source, int destination, int weight, int BW) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.BW = BW;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBW() {
        return BW;
    }

    public void setBW(int BW) {
        this.BW = BW;
    }
  
   @Override
  public String toString() {
    return source + " " + destination;
  }
  
  
    
}
