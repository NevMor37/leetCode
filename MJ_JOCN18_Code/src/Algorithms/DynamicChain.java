/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Graph_Generator.Vertex;
import Graph_Generator.functionnode;
import Graph_Generator.graphEdge;
import Graph_Reader.*;
import com.sun.istack.internal.FinalArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class DynamicChain {
    
 ArrayList<Vertex> Vertices;
 ArrayList<graphEdge> Edges;
 ArrayList<functionnode> VNFs;
 int bw;
 String filename;


    public int getBw() {
        return bw;
    }

    public void setBw(int bw) {
        this.bw = bw;
    }
 
 
 ArrayList<functionnode> ParentList=new ArrayList<functionnode>();
 ArrayList<functionnode> ChildList=new ArrayList<functionnode>();

    public ArrayList<functionnode> getParentList() {
        return ParentList;
    }

    public void setParentList(ArrayList<functionnode> ParentList) {
        this.ParentList = ParentList;
    }

    public ArrayList<functionnode> getChildList() {
        return ChildList;
    }

    public void setChildList(ArrayList<functionnode> ChildList) {
        this.ChildList = ChildList;
    }
 

    public DynamicChain(ArrayList<Vertex> Vertices, ArrayList<graphEdge> Edges, ArrayList<functionnode> VNFs, String file, int BW) {
        this.Vertices = Vertices;
        this.Edges = Edges;
        this.VNFs = VNFs;
        this.bw=BW;
        this.filename=file;
        
    }

    public ArrayList<Vertex> getVertices() {
        return Vertices;
    }

    public void setVertices(ArrayList<Vertex> Vertices) {
        this.Vertices = Vertices;
    }

    public ArrayList<graphEdge> getEdges() {
        return Edges;
    }

    public void setEdges(ArrayList<graphEdge> Edges) {
        this.Edges = Edges;
    }

    public ArrayList<functionnode> getVNFs() {
        return VNFs;
    }

    public void setVNFs(ArrayList<functionnode> VNFs) {
        this.VNFs = VNFs;
    }
    
 
 //////////////////////////////////////////////////////
      public int rankCalculatornode(int node){
          
            //Calculating the rand for each node in the depen graph
            functionnode entry=null;
            functionnode exit=null;
            int node_rank=0;
            ArrayList<Integer> Dependents;                      
            requestVNFs req=new requestVNFs(filename);
                              //  requestVNFs req=new requestVNFs();

            Dependents= req.getDependents(node);
            
          //  System.out.println("In rank calculator for node: "+ node+ " the dependents are: "+ Dependents);
                                    
            if(Dependents.isEmpty()){//If no dependent, the rank is equal to the CPU
                   node_rank=VNFs.get(node).getReqCPU();
               }                   
            int sum_of_rank_successors=0;                       
            Integer [] helpMax=new Integer[Dependents.size()];
            for (int k=0;k<Dependents.size();k++){
            sum_of_rank_successors=sum_of_rank_successors+rankCalculatornode(Dependents.get(k));
            helpMax[k]=sum_of_rank_successors;
            } 
            node_rank=VNFs.get(node).getReqCPU()+sum_of_rank_successors;              
        return node_rank;            
        }
      
      
 /////////////////////////////////////////////////
  public int rankCalculatornodeUpWard(int node){
          //  System.out.println("************************************Calculating the Upward rank***************************************");

           // System.out.println("For node:  " + node);      //Calculating the rand for each node in the depen graph           
            int node_rank=0;
            ArrayList<Integer> ChildDC;           
            requestVNFs req=new requestVNFs(filename);
            ChildDC= req.getDependents(node);                                  
            if(ChildDC.isEmpty()){//If no dependent, the rank is equal to the CPU
                   node_rank=VNFs.get(node).getReqCPU();
               }  
            else{           
            int sum_of_rank_successors=0;                       
            ArrayList<Integer> helpMaxDCUpward=new ArrayList<Integer>();
            for (int k=0;k<ChildDC.size();k++){
            int t=0;   
          //  System.out.println("Calcuing the rank for dependent: " + ChildDC.get(k));
            t=rankCalculatornodeUpWard(ChildDC.get(k));
            helpMaxDCUpward.add(t);// we need this arraylist because at the end we need the dependent with highest weight
            } 
          //  System.out.println("The ranks for all dependents before sort: " + helpMaxDCUpward);
            Collections.sort(helpMaxDCUpward); //low to high: ascending order
           // System.out.println("The ranks for all dependents after sort: " + helpMaxDCUpward);
          //  System.out.println("The highest rank between dependents: " + helpMaxDCUpward.get(helpMaxDCUpward.size()-1));
            node_rank=helpMaxDCUpward.get(helpMaxDCUpward.size()-1)+ VNFs.get(node).getReqCPU();
            }
        //    System.out.println("Final Upward rank for node:" + node + " is: " + node_rank);
        //  System.out.println("***************************************************************************");

           
        return node_rank;            
        }     
      
 //////////////////////////////////////////////////
//      
  public int rankCalculatornodeDownWard(int node){ //the new ranking approach
          System.out.println("******************************Calculating the DownWard rank**********************" ); 
          System.out.println("for node: " + node);
            //Calculating the rand for each node in the depen graph
            functionnode entry=null;
            functionnode exit=null;
            int node_rank=0;
            ArrayList<Integer> ParentsDC;                      
            requestVNFs req=new requestVNFs(filename);             
            ParentsDC= req.getParents(node);
            
          //  System.out.println("In rank calculator for node: "+ node+ " the dependents are: "+ Dependents);
                                    
            if(ParentsDC.isEmpty()){//If no dependent, the rank is equal to the CPU
                   node_rank=0;
                   System.out.println("No parents for node: " + node);
               }  
            else{
            System.out.println("The list of parents: " + ParentsDC );
            int sum_of_rank_successors=0;                       
            //Integer [] helpMax=new Integer[ParentsDC.size()];
            ArrayList<Integer> helpMaxDC=new ArrayList<Integer>();

            for (int k=0;k<ParentsDC.size();k++){
                int t=0;
                
            t=rankCalculatornodeDownWard(ParentsDC.get(k))+ VNFs.get(ParentsDC.get(k)).getReqCPU();
            helpMaxDC.add(t);
           
            } 
            System.out.println("helpMaxDC" + helpMaxDC);
            Collections.sort(helpMaxDC);
             System.out.println("helpMaxDC" + helpMaxDC);
            node_rank=helpMaxDC.get(helpMaxDC.size()-1);
            System.out.println("node_rank:" + node_rank);
            }
            System.out.println("node_rank:" + node_rank);
        return node_rank;            
        }
  //////////////////////////////////////////////////////     
      public ArrayList<functionnode>  priorityList (){   //First set the weight for each VNF then sort the nodes based on weight and add it PL
          //PL is sorted from the highest weight to the lowest weight 
        //  System.out.println("^^^^^^^^^^^^^^^^^^^In priorityList^^^^^^^^^^^^^^^^^^^^^^^^");
          ArrayList<functionnode> PL=new ArrayList<functionnode>();
          for (int i = 0; i < VNFs.size(); i++) {
            //int weightDown=rankCalculatornodeDownWard(VNFs.get(i).getNumber());
            //System.out.println("DownWard Rank: " + weightDown + " for node:  " + VNFs.get(i).getNumber());            
            int weightUp=rankCalculatornodeUpWard(VNFs.get(i).getNumber());
        //    System.out.println("Calculated Upward rank: " + weightUp + " for node:  " + VNFs.get(i).getNumber());
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
           // System.out.println("Final weight: DownWard+ Upward: " + (weightDown+ weightUp));
           // System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            VNFs.get(i).setWeight(weightUp);
           // VNFs.get(i).setWeight(weightDown+ weightUp);
          //  System.out.println("Weight for VNF: " + VNFs.get(i).getNumber() + " is: " + VNFs.get(i).getWeight()); 
            PL.add(VNFs.get(i));
        }        
          Collections.sort(PL);   
          
//          PL.add(VNFs.get(1));
//          PL.add(VNFs.get(0));
//          PL.add(VNFs.get(3));
//          PL.add(VNFs.get(5));
//          PL.add(VNFs.get(4));
//          PL.add(VNFs.get(2));
          
           for (int i = 0; i < PL.size(); i++) {           
            System.out.println("Weight for VNF: after sort testing " + PL.get(i).getNumber() + " the weight: " + PL.get(i).getWeight());            
            }
          return PL;
      } 
   //////////////////////////////////////////////////////     
   public ArrayList<functionnode>  updatePriorityList (ArrayList<functionnode>  PL, functionnode toRemoveNode){ 
       //Get a  list and and a node. Remove the node from the PL
       
    ArrayList<functionnode> PLupdate=new ArrayList<functionnode>();  
    PLupdate=PL;
       for (int i = 0; i < PLupdate.size(); i++) {
         if (PLupdate.get(i).getNumber() == toRemoveNode.getNumber()) {
                            PLupdate.remove(i);
        }   
       }
  
     return  PLupdate;
   }   
   ////////////////////////////////////////////////////
    public ArrayList<Integer>  updateList (ArrayList<Integer>  PL, int toRemoveNode){  //Get the priority list and and a node. Remove the node from the PL
       
    ArrayList<Integer> PLupdate=new ArrayList<Integer>();  
    PLupdate=PL;
       for (int i = 0; i < PLupdate.size(); i++) {
         if (PLupdate.get(i) == toRemoveNode) {
                            PLupdate.remove(i);
        }   
       }
  
     return  PLupdate;
   }
  //////////////////////////////////////////////////////  
    
    
 public getFunction  getNextNodeFirstGroup(findShortestPath SP,TreeMap<Integer, ArrayList<Integer>> treemap, ArrayList<functionnode> elementsOfGroup,int BW, Vertex head, Vertex tail,boolean flagTop){
     ArrayList<getFunction> getFunc = new ArrayList<getFunction>();
    ArrayList<Integer> returnedFromSPNewH=new ArrayList<Integer>();
    ArrayList<Integer> returnedFromSPNewT=new ArrayList<Integer>();
    ArrayList<Integer> returnedFromSPNewHead=new ArrayList<Integer>();
    ArrayList<Integer> returnedFromSPNewTail=new ArrayList<Integer>();
    ArrayList<Integer> returnedFromSPNewFinal=new ArrayList<Integer>();
    functionnode nextNode=new functionnode();
 
     for (int i = 0; i < elementsOfGroup.size(); i++) {
        int currentVNF;
        functionnode currentVNFNode=new functionnode();
        currentVNF=elementsOfGroup.get(i).getNumber();
         currentVNFNode=elementsOfGroup.get(i);
        ArrayList<Integer> VerticesCurrentVNF=new ArrayList<Integer>();
        VerticesCurrentVNF=treemap.get(currentVNF);
        
        if( VerticesCurrentVNF==null ) {
            VerticesCurrentVNF=new ArrayList<Integer>();
        }
        if (VerticesCurrentVNF.isEmpty() ) {
            flagTop=false;
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Request is rejected because there is no substrate candidate for node: nextNode "  );
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        
         if(!VerticesCurrentVNF.isEmpty() && VerticesCurrentVNF!=null){

        
        ArrayList<Vertex> VerticesCurrentVNF_Vertex=new ArrayList<Vertex>();
         for (int j = 0; j < VerticesCurrentVNF.size(); j++) {
         VerticesCurrentVNF_Vertex.add(Vertices.get(VerticesCurrentVNF.get(j)));          
         }
         
         
      if (tail==null){
         System.out.println("tail is null");
  
       returnedFromSPNewH=SP.findShortest(VerticesCurrentVNF_Vertex, head, BW);
       if (returnedFromSPNewH == null) {
                                returnedFromSPNewH = new ArrayList<Integer> ();
                            }
        if(returnedFromSPNewH.isEmpty()){
                 System.out.println("################################################Request is rejected: list to check is empty: no path is found: flex New Child #######################################");
                  flagTop = false;              
                }     
        if (returnedFromSPNewH != null &&!returnedFromSPNewH.isEmpty() && flagTop) { //Distance from Head is available
         getFunc.add(new getFunction(returnedFromSPNewH, currentVNFNode));   

        }
         }
       
        else{
          
              System.out.println("tailllllll");
          returnedFromSPNewH=SP.findShortest(VerticesCurrentVNF_Vertex, head, BW);
       if (returnedFromSPNewH == null) {
                                returnedFromSPNewH = new ArrayList<Integer> ();
                            }
        if(returnedFromSPNewH.isEmpty()){
                 System.out.println("################################################Request is rejected: list to check is empty: no path is found: flex New Child #######################################");
                  flagTop = false;              
                }     
        if (returnedFromSPNewH != null &&!returnedFromSPNewH.isEmpty() && flagTop) { //Distance from Head is available
         getFunc.add(new getFunction(returnedFromSPNewH, currentVNFNode));   

        }
          
          
          //////////////////////////
        
       returnedFromSPNewT=SP.findShortest(VerticesCurrentVNF_Vertex, tail, BW);
       if (returnedFromSPNewT == null) {
                                returnedFromSPNewT = new ArrayList<Integer> ();
                            }
        if(returnedFromSPNewT.isEmpty()){
                 System.out.println("################################################Request is rejected: list to check is empty: no path is found: flex New Child #######################################");
                  flagTop = false;              
                }

        if (returnedFromSPNewT != null &&!returnedFromSPNewT.isEmpty() && flagTop) {//Distance from Tail is available
            getFunc.add(new getFunction(returnedFromSPNewT, currentVNFNode));     
         }
        
        }
     }   
     

    //ArrayList<Integer> returnedFromSPNewFinal=new ArrayList<Integer>();
   // functionnode nextNode=new functionnode();
 
     
     // Now we have the getFunc which has the path for all the current nodes from head and tail. We want to choose the minimum
     int minDistance=100;
     for (int iu = 0; iu < getFunc.size(); iu++) {
         getFunction currentPair=getFunc.get(iu);
          System.out.println("Pair that is returnedeeeeee: " + " for the VNF: " + currentPair.getCurrentNode().getNumber() + " the list: " + currentPair.getReturnSPHop());
         if (currentPair.getReturnSPHop().size()<minDistance){
             minDistance=currentPair.getReturnSPHop().size();
             nextNode=currentPair.getCurrentNode();
             returnedFromSPNewFinal=currentPair.getReturnSPHop();            
         }
          

     }
     
        //  tail=Vertices.get(returnedFromSPNewFinal.get(returnedFromSPNewFinal.size()-1));

     }
   
     
  System.out.println("Final pair that is returned: " + " for the VNF: " + nextNode.getNumber() + " the list: " + returnedFromSPNewFinal);
  
   
    return (new getFunction(returnedFromSPNewFinal, nextNode)); 
  
 }
   
  /////////////////////////////////////////
 
 public getFunction  getNextNodeOtherGroups(findShortestPath SP,TreeMap<Integer, ArrayList<Integer>> treemap, ArrayList<functionnode> elementsOfGroup,int BW, Vertex tail,boolean flagTop){
     ArrayList<getFunction> getFunc = new ArrayList<getFunction>();
    ArrayList<Integer> returnedFromSPNewT=new ArrayList<Integer>();
    ArrayList<Integer> returnedFromSPNewHead=new ArrayList<Integer>();
    ArrayList<Integer> returnedFromSPNewTail=new ArrayList<Integer>();
    ArrayList<Integer> returnedFromSPNewFinal=new ArrayList<Integer>();
    functionnode nextNode=new functionnode();
     for (int i = 0; i < elementsOfGroup.size(); i++) {
        int currentVNF;
        functionnode currentVNFNode=new functionnode();
        currentVNF=elementsOfGroup.get(i).getNumber();
        currentVNFNode=elementsOfGroup.get(i);
        ArrayList<Integer> VerticesCurrentVNF=new ArrayList<Integer>();
        VerticesCurrentVNF=treemap.get(currentVNF);
        
        if( VerticesCurrentVNF==null ) {
            VerticesCurrentVNF=new ArrayList<Integer>();
        }
        if (VerticesCurrentVNF.isEmpty() ) {
            flagTop=false;
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Request is rejected because there is no substrate candidate for node: nextNode "  );
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        
         if(!VerticesCurrentVNF.isEmpty() && VerticesCurrentVNF!=null){

        
        ArrayList<Vertex> VerticesCurrentVNF_Vertex=new ArrayList<Vertex>();
         for (int j = 0; j < VerticesCurrentVNF.size(); j++) {
         VerticesCurrentVNF_Vertex.add(Vertices.get(VerticesCurrentVNF.get(j)));          
         }

       returnedFromSPNewT=SP.findShortest(VerticesCurrentVNF_Vertex, tail, BW);
       if (returnedFromSPNewT == null) {
                                returnedFromSPNewT = new ArrayList<Integer> ();
                            }
        if(returnedFromSPNewT.isEmpty()){
                 System.out.println("################################################Request is rejected: list to check is empty: no path is found: flex New Child #######################################");
                  flagTop = false;              
                }
        if (returnedFromSPNewT != null &&!returnedFromSPNewT.isEmpty() && flagTop) {//Distance from Tail is available
            getFunc.add(new getFunction(returnedFromSPNewT, currentVNFNode));     
         }
     }   
     }

     // Now we have the getFunc which has the path for all the current nodes from head and tail. We want to choose the minimum
     int minDistance=100;
     for (int i = 0; i < getFunc.size(); i++) {
         getFunction currentPair=getFunc.get(i);
         if (currentPair.getReturnSPHop().size()<minDistance){
             minDistance=currentPair.getReturnSPHop().size();
             nextNode=currentPair.getCurrentNode();
             returnedFromSPNewFinal=currentPair.getReturnSPHop();            
         }
  
         
         System.out.println("Final pair that is returned: " + " for the VNF: " + nextNode.getNumber() + " the list: " + returnedFromSPNewFinal);
     }
  
    return (new getFunction(returnedFromSPNewFinal, nextNode)); 
  
 }
 
 
 
 /////////////////////////////////////////
    
public functionnode  getNextNode(findShortestPath SP,  TreeMap<Integer, ArrayList<Integer>> treemapBackup,
Vertex firstVertex,ArrayList<functionnode> PL, ArrayList<functionnode> ParentList, ArrayList<functionnode> ChildList ){
    System.out.println("*********************In getNextNode function*****************************");
   for (int i = 0; i < ChildList.size(); i++) {           
            System.out.println("Child List at the beg of the getNextNode function  " +
                    ChildList.get(i).getNumber());           
        }   
       System.out.println("****************************************************");
      
         for (int i = 0; i < ParentList.size(); i++) {           
            System.out.println("ParentList list at the beg of the getNextNode function " +
                    ParentList.get(i).getNumber());           
        }   

        for (int i = 0; i < PL.size(); i++) {            
                System.out.println("PL test at the beg of nextNode : " + PL.get(i).getNumber());          
               }
boolean flagback=true;        
functionnode nextNode=new functionnode();
functionnode nextNodeFinal=new functionnode();
functionnode nextNodeFinalParent=new functionnode();
Vertex finalDestination2 = null;
int dist=0;
int minDistance1 = 99999; //for parent
int minDistance2 = 99999;
if(ChildList.isEmpty()){
    System.out.println("No node in Child list" );
    }  
else{
   for (int i = 0; i < ChildList.size(); i++) {
System.out.println("Current element in Child list****: "+ ChildList.get(i).getNumber()); 
ArrayList<Integer> candListNextNodeNew=new ArrayList<Integer>();       
ArrayList<Integer> returnedFromSPNew=new ArrayList<Integer>();
System.out.println("treemapBackup " + treemapBackup);
System.out.println("ChildList.get(i).getNumber() " + ChildList.get(i).getNumber());
candListNextNodeNew=treemapBackup.get(ChildList.get(i).getNumber());
if( candListNextNodeNew==null ) {
            candListNextNodeNew=new ArrayList<Integer>();
        }
if (candListNextNodeNew.isEmpty() ) {
            flagback=false;
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Request is rejected because there is no substrate candidate for node: nextNode "  );
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
 if(!candListNextNodeNew.isEmpty() && candListNextNodeNew!=null ){
     
     System.out.println("candListNextNodeNew " + candListNextNodeNew);
     ArrayList<Vertex> candListNextNodeVerticesNew=new ArrayList<Vertex>();
     for (int j = 0; j < candListNextNodeNew.size(); j++) {         
         int t=candListNextNodeNew.get(j);
         candListNextNodeVerticesNew.add(Vertices.get(t));
     }
     
     for (int j = 0; j < candListNextNodeVerticesNew.size(); j++) {
         
         System.out.println("candListNextNodeVerticesNew333 : " + candListNextNodeVerticesNew.get(j).getNumber());
         
     }   
returnedFromSPNew= SP.findShortest(candListNextNodeVerticesNew,firstVertex, bw);
if (returnedFromSPNew == null) {
                                returnedFromSPNew = new ArrayList<Integer> ();
                            }
if(returnedFromSPNew.isEmpty()){
         System.out.println("################################################Request is rejected: list to check is empty: no path is found: flex New Child #######################################");
          flagback = false;              
        }
if (returnedFromSPNew != null &&!returnedFromSPNew.isEmpty() && flagback) {
dist= returnedFromSPNew.size()-1;
if (dist < minDistance2) {
                minDistance2 = dist;
                nextNodeFinal= ChildList.get(i);
            }


        System.out.println("returnedFromSPNew " + returnedFromSPNew + " with dist:  " + dist + " for nextNodeFinal: " + nextNodeFinal.getNumber());
        
    }
    
     System.out.println("The lowest distance is new: " + minDistance2 + "from the source: "+ nextNodeFinal.getNumber() );
    
    
     System.out.println("Done here");
    }
     System.out.println("***********************************************");
     
    }
 }
 
 /////////////////////////////////////////////////////////////Now for the parent List************************************************************************
 //If similar candidates for the element of the child list and the parent list then tie is broken randomly. 

int dist1 = 0;
 if(ParentList.isEmpty()){   
        System.out.println("No node in Parent list ");
    }  
    else{
     
    for (int i = 0; i < ParentList.size(); i++) {
System.out.println("Current elements in Parent listEEEEEEE: "+ ParentList.get(i).getNumber()); 
ArrayList<Integer> candListNextNodeNew=new ArrayList<Integer>();
       
ArrayList<Integer> returnedFromSPNew=new ArrayList<Integer>();
candListNextNodeNew=treemapBackup.get(ParentList.get(i).getNumber());
      //  System.out.println("treemap.get(ParentList.get(i).getNumber()) : "  + candListNextNodeNew + " treemapBackup : " + treemapBackup);

if( candListNextNodeNew==null ) {
            candListNextNodeNew=new ArrayList<Integer>();
        }


if (candListNextNodeNew.isEmpty() ) {
            flagback=false;
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Request is rejected because there is no substrate candidate for node: nextNode "  );
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }


 if(!candListNextNodeNew.isEmpty() && candListNextNodeNew!=null ){

     ArrayList<Vertex> candListNextNodeVerticesNew=new ArrayList<Vertex>();
     
     for (int j = 0; j < candListNextNodeNew.size(); j++) {
         
         int g=candListNextNodeNew.get(j);
         candListNextNodeVerticesNew.add(Vertices.get(g));
     }


returnedFromSPNew= SP.findShortest(candListNextNodeVerticesNew,firstVertex, bw);
if (returnedFromSPNew == null || returnedFromSPNew.isEmpty()) {
                                returnedFromSPNew = new ArrayList<Integer> ();
                            }

if( returnedFromSPNew.isEmpty()){
         System.out.println("################################################Request is rejected: list to check is empty: no path is found: flex New#######################################");
          flagback = false;              
        }



if (returnedFromSPNew != null &&!returnedFromSPNew.isEmpty() && flagback) {
dist1= returnedFromSPNew.size()-1;
if (dist1 < minDistance1) {
                minDistance1 = dist1;
                nextNodeFinalParent = ParentList.get(i);
            }


        System.out.println("returnedFromSPNew " + returnedFromSPNew + " with dist:  " + dist1 + " for nextNodeFinal: " + nextNodeFinalParent.getNumber());
        
    }
    
     System.out.println("Final: The lowest distance is new: " + minDistance1 + "from the source: "+ nextNodeFinalParent.getNumber() );
    
    
     System.out.println("Done here in Parent");
    }
     System.out.println("***********************************************");
     
    }
 }
 ////////////////////////////////////////////////////////////////////////////////// Final comparision to get the next node
     if (ParentList.isEmpty() && ChildList.isEmpty()) {                 
         nextNode=PL.get(0); //from priority list 
         

         System.out.println(" Next node is chosen from priority list: " + nextNode.getNumber() ); 
     }
     else{
        if ((minDistance1<minDistance2)) {
           nextNode= nextNodeFinalParent; //from parent list
           System.out.println(" Next node is chosen from Parent list: " + nextNode.getNumber() );
           
            System.out.println("minDistance1: " + minDistance1 + " minDistance2: " + minDistance2);

        }
        else if ((minDistance2<minDistance1) ) {
            nextNode=nextNodeFinal; //from child list
            System.out.println(" Next node is chosen from Child list: " + nextNode.getNumber() );  
                        System.out.println("minDistance1: " + minDistance1 + " minDistance2: " + minDistance2);

        }
     }
     if (minDistance2==minDistance1  && (minDistance1!=99999) && (minDistance2!=99999) ){
         System.out.println("They are equal");
         nextNode= nextNodeFinalParent;
     }
         
   System.out.println("Before returning "+ "minDistance1: " + minDistance1 + " minDistance2: " + minDistance2);

      return nextNode;
    }

    
    public void getMappingCand ( ArrayList <Vertex> toCheck){
        
       // int bwTotalFinal=99999;
        Vertex testBack=new Vertex();
        
        for (int i = 0; i < toCheck.size(); i++) {
            
            Vertex test=toCheck.get(i);
             int bwTotal=0;
            int val=0;
            for (int j = 0; j < Edges.size(); j++) {
     
                if (Edges.get(j).getSource()==test.getNumber() || Edges.get(j).getDestination()==test.getNumber()){
                    
                    bwTotal+=Edges.get(j).getBW();
                }
                
                val=bwTotal*test.getOfferedCPU();
 
            }
           
            System.out.println("node name: " + test.getNumber() + "result " +bwTotal ); 
        }
        
        
    }
    
    
    public ArrayList<ArrayList<functionnode>> groupCreator(ArrayList<functionnode> priorityListNodes) {
         
        requestVNFs req=new requestVNFs(filename);
        for (functionnode n : priorityListNodes) {
        ArrayList<Integer> dependentsOfCurrentNode;           
        dependentsOfCurrentNode= req.getDependents(n.getNumber());
        System.out.print("---node " + n.getNumber() + ":");
        System.out.println(dependentsOfCurrentNode);
        }
        System.out.println("**********************************");
        ArrayList<ArrayList<functionnode>> allgroups = new ArrayList<ArrayList<functionnode>>();
        ArrayList<functionnode> group_0 = new ArrayList<functionnode>();
        functionnode firstNode = priorityListNodes.get(0);
        group_0.add(firstNode);
        allgroups.add(group_0);
        functionnode removed = priorityListNodes.remove(0);
        for (functionnode e : priorityListNodes) {
            boolean has_dependency = false;
            ArrayList<functionnode> last_group = allgroups.get(allgroups.size() - 1);
            for (functionnode n : last_group) {
            ArrayList<Integer> dependentsOfCurrentGroupElement;           
            dependentsOfCurrentGroupElement= req.getDependents(n.getNumber());                   
                if (!(dependentsOfCurrentGroupElement.isEmpty())) {
                    if (dependentsOfCurrentGroupElement.contains(e.getNumber())) {
                        has_dependency = true;
                    }
                }
            }
            if (has_dependency == true) {
                ArrayList<functionnode> new_group = new ArrayList<functionnode>();
                new_group.add(e);
                allgroups.add(new_group);

            } else {
                allgroups.get(allgroups.size() - 1).add(e);
            }
        }
        return allgroups;
    }
    
    public int mapping(){   
    Vertex head_0=new Vertex();
    Vertex tail_0=null;
    boolean flagTop = true;
   int finalCostDC=0;
   ArrayList<functionnode> ParentList=new ArrayList<functionnode>();
   ArrayList<functionnode> ChildList=new ArrayList<functionnode>();
   findShortestPath SP=new findShortestPath(Vertices, Edges,VNFs);
   ArrayList<functionnode> ParentListback=new ArrayList<functionnode>();
   ArrayList<functionnode> ChildListback=new ArrayList<functionnode>();
   ArrayList<functionnode> PL=new ArrayList<functionnode>();

   ArrayList<Integer> PLNew=new ArrayList<Integer>();
    ArrayList<functionnode> PLNewBack=new ArrayList<functionnode>();

   ArrayList<functionnode> SFC=new ArrayList<functionnode>();
   ArrayList<Integer> usedSub=new ArrayList<Integer>();
   ArrayList<OriginalMap> originalRelation = new ArrayList<OriginalMap>();     
   PL=priorityList();

   System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
   System.out.println("Sorted VNFs based ascending order of the weghits");
    for (int i = 0; i < PL.size(); i++) {            
            System.out.println("Priority list element:" + PL.get(i).getNumber());
            
        } 
    ArrayList<ArrayList<functionnode>> groups; 
    ArrayList<ArrayList<functionnode>> chains=new  ArrayList<ArrayList<functionnode>>() ; 
 
 
    
    
   groups = groupCreator(PL);
  // chains=groups;
 
   PL=new ArrayList<functionnode>();
   
   PL=priorityList();
               System.out.println("Priority list after creating the groups");

   for (int i = 0; i < PL.size(); i++) {            
            System.out.println("PL element:" + PL.get(i).getNumber());
            
        }
   
   
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < groups.get(i).size(); j++) {  
                
                System.out.println("Group: " + i + " Current element: " + groups.get(i).get(j).getNumber() );              
            }
            System.out.println("**********************************");           
        }  
     
    TreeMap<Integer, ArrayList<Integer>> treemap;

    treemap= SP.generateCandidateList(PL);  
 
    
    System.out.println("*****************************************************");
    System.out.println("*****************************************************");
   Set<Integer> keys = treemap.keySet();//defined to provide an access to the functionodes
    for (Integer r : keys) {
         if (treemap.get(r).isEmpty()){                
                System.out.println("***********************No candidate for this functionality: flex ***********************************");
                flagTop=false;
            }    }
    System.out.println("*****************************************************");    
        
        
    functionnode firstVNF=null;
    //firstVNF=PL.get(0);
    firstVNF=groups.get(0).get(0);
   // ChildList.add(firstVNF);//add it into child list: starts here   
    System.out.println("********************************************Start mapping: ************************************************");
    System.out.println("First VNF to be mapped is VNF: " + firstVNF.getNumber());  
    requestVNFs netReq=new requestVNFs(filename); 
    //Map 𝑉1 to the substrate candidate with enough CPU
   Vertex firstVertex=null;
   int first;
   if (!flagTop==false){
    ArrayList<Integer> subCands=new ArrayList<Integer>();
    subCands=treemap.get(firstVNF.getNumber());
       System.out.println("subCands " + subCands);
    int lastCand=subCands.get(subCands.size()-1);
    first=lastCand;
   System.out.println("first substrate candidate that is used for mapping the first VNF: "+ first);
   firstVertex= Vertices.get(first);
   System.out.println("*****************************************************");
   SP.removeVNF(treemap, firstVNF, firstVertex);//In this function we set the relation as well
   usedSub.add(firstVertex.getNumber());
   System.out.println("*****************************************************First node Mapped!****************************************************"); 
   //Add children of 𝑉1 to the child list if its parent is not in the child list
   for (int i = 0; i < PL.size(); i++) {           
            System.out.println("PL List before removing the first VNF : " + PL.get(i).getNumber());          
       } 
   updatePriorityList(PL, firstVNF);  //remove first vnf from priority list
   
    System.out.println("*******************************************");
        for (int i = 0; i < PL.size(); i++) {            
        System.out.println("PL List after removing the first VNF  : " + PL.get(i).getNumber());          
       }

        SFC.add(firstVNF);
        
        head_0=firstVertex;
        groups.get(0).remove(0);
        ArrayList<functionnode>ch=new ArrayList<functionnode>();
        ch.add(firstVNF); //add the mapped VNF to the ch for g0
        chains.add(ch);
        System.out.println("************Groups after removing the first element**********************");  
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < groups.get(i).size(); j++) {  
                
                System.out.println("Group: " + i + " Current element: " + groups.get(i).get(j).getNumber() );              
            }
            System.out.println("**********************************");           
        } 
        System.out.println("*****************************************************Start Mapping the rest of the nodes****************************************************");
    }
   else{
       
       System.out.println("Request rejected at the very first node");
       
       finalCostDC=0;
   }  
   ///Starting the groups:
   getFunction selectedVNF;
   getFunction selectedVNF_g1;
   getFunction selectedVNF_rest;
   functionnode currentNode = null;
   Vertex lastTail=new  Vertex();
    int groupSizeOrg=groups.get(1).size();
   for (int k = 0; k < groups.size(); k++) {
   System.out.print("......................................starting group: " + k + "....................................................");
   System.out.println(); 
    while (groups.get(k).size() > 0 && flagTop) {      
        if (k==0){ //For the elements of the group 0, the mapping is different:
        
          if (usedSub.size()==1){
              
           selectedVNF=getNextNodeOtherGroups(SP, treemap, groups.get(0),bw, head_0,flagTop); //After this function we know which node is mapped next and we have its SP
           tail_0=Vertices.get(selectedVNF.getReturnSPHop().get((selectedVNF.getReturnSPHop()).size()-1)); ;
          }  
        //For each element in group 0 get the  distance from head and tail            
         
          else{
               selectedVNF=getNextNodeFirstGroup(SP, treemap, groups.get(0),bw, head_0,tail_0,flagTop);
              
          }     
        
         //SP.updateEdgeBandwidth(selectedVNF.getReturnSPHop(), bw); //Update the bw on the links of the returned path 
         functionnode removeVNF;
         Vertex removeVertexNode;
         
         removeVNF=selectedVNF.getCurrentNode();
         removeVertexNode=Vertices.get(selectedVNF.getReturnSPHop().get((selectedVNF.getReturnSPHop()).size()-1));  
         int tempCost=0;
         tempCost= SP.updateEdgeBandwidth(selectedVNF.getReturnSPHop(), bw); //Update the BW of the links on the returned path
         finalCostDC+=tempCost;
         SP.removeVNF(treemap, removeVNF, removeVertexNode);//In this function we set the relation as well,update treemap,update CPU
            System.out.println("removeVertexNode.getNumber() "+ removeVertexNode.getNumber());
         usedSub.add(removeVertexNode.getNumber()); 
         SFC.add(removeVNF);
          // Now remove the element from group
         
             for (int i = 0; i < groups.get(0).size(); i++) {
                 System.out.println("groups 0: before " + groups.get(0).get(i).getNumber());
             }
         updatePriorityList(groups.get(0),removeVNF);
         for (int i = 0; i < groups.get(0).size(); i++) {
                 System.out.println("groups 0: after " + groups.get(0).get(i).getNumber());
             }
        

        }        
      
        
        
        else if (k==1 &&(groups.get(1).size()==groupSizeOrg)){ //For the very first element of this group we find the SP to the both head and tail of the group 0    
        
         selectedVNF_g1=getNextNodeFirstGroup(SP, treemap, groups.get(1),bw, getNodeVer(usedSub.get(0)),getNodeVer(usedSub.get(usedSub.size()-1)),flagTop); //After this function we know which node is mapped next and we have its SP
         functionnode removeVNFGroup1first;
         Vertex removeVertexNodeGroup1First;
         removeVNFGroup1first=selectedVNF_g1.getCurrentNode();
        removeVertexNodeGroup1First=Vertices.get(selectedVNF_g1.getReturnSPHop().get((selectedVNF_g1.getReturnSPHop()).size()-1)); 
         lastTail=removeVertexNodeGroup1First;
         int tempCostG1=0;
         tempCostG1= SP.updateEdgeBandwidth(selectedVNF_g1.getReturnSPHop(), bw); //Update the BW of the links on the returned path
         finalCostDC+=tempCostG1;
         SP.removeVNF(treemap, removeVNFGroup1first, removeVertexNodeGroup1First);//In this function we set the relation as well,update treemap,update CPU
         usedSub.add(removeVertexNodeGroup1First.getNumber()); 
         SFC.add(removeVNFGroup1first);
          // Now remove the element from group
         updatePriorityList(groups.get(1),removeVNFGroup1first);
        }       
      else{
            System.out.println("lastTail "+ lastTail) ; 
            //Rest of the elements, starting group1, element 1, No we just get the distance to the updated tail          
          selectedVNF_rest=getNextNodeOtherGroups(SP, treemap, groups.get(k),bw, lastTail,flagTop); 
          functionnode removeVNFRest;
          Vertex removeVertexNodeRest;
          removeVNFRest=selectedVNF_rest.getCurrentNode();
          int t=selectedVNF_rest.getReturnSPHop().size();    
          removeVertexNodeRest=getNodeVer(t-1);
          lastTail=removeVertexNodeRest;
          int tempCostRest=0;
          tempCostRest= SP.updateEdgeBandwidth(selectedVNF_rest.getReturnSPHop(), bw); //Update the BW of the links on the returned path
          finalCostDC+=tempCostRest;
          SP.removeVNF(treemap, removeVNFRest, removeVertexNodeRest);//In this function we set the relation as well,update treemap,update CPU
          usedSub.add(removeVertexNodeRest.getNumber());
          SFC.add(removeVNFRest);
          // Now remove the element from group
            updatePriorityList(groups.get(1),removeVNFRest);          
      }
        
    }  
       
   }
   
   
    
        
    return  finalCostDC;
    
    
    }
    
    public boolean parentPresentInList(ArrayList<functionnode> listToCheck, int toCheck){//a node is in a list or not
        boolean check=false;
        for (int i = 0; i < listToCheck.size(); i++) {
            if (listToCheck.get(i).getNumber()==toCheck) {
                check=true;
            }
        }
        
        return check;
    }
    
   public ArrayList<functionnode> listCheckList( ArrayList<Integer> listToCheck
   ,    ArrayList<functionnode> ChildList, ArrayList<functionnode> PL, functionnode grandChild ){
       //To check if elements of the list are presented in another list
       //First one for loop to get the elements of temp
       
       boolean checkOrg=false;
       for (int i = 0; i < listToCheck.size(); i++) {
           if (parentPresentInList(ChildList, listToCheck.get(i))){
               checkOrg=true;
               }   
       }
       
       if (checkOrg==false){ //none of the parents are in the child list
         //now the grandChild can be added to the child list
           ChildList.add(grandChild);
           
       }      
       else { //at list one parent is in the child list
           System.out.println("Parent of the grandchild is in the childList");          
       }
                      
        return ChildList;
    }
    
   
    public Vertex getNodeVer(int number){
        Vertex helpVer=new Vertex();
        for (int i = 0; i < Vertices.size(); i++) {
            
            if (Vertices.get(i).getNumber()==number){
                
                helpVer=Vertices.get(i);
            }
            
        }
        
        return helpVer;
    }
     
}
