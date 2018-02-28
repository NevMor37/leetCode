package testPackage;

import topologyGenerator.readAllFiles;

import java.util.Arrays;
import java.util.List;

public class TestCurrent {



    public static void main(String[] args){


        List<String> substrateFile = readAllFiles.substrateFileName();

        AlgoNew obj = new AlgoNew();

        int[] request = {50,15};
        obj.nodeMapping(substrateFile.get(0),request,3);

        System.out.println("Highest Reliability:"+obj.getReliability());
        System.out.println("Tree:"+ Arrays.toString(obj.getTree().toArray()));

    }
}
