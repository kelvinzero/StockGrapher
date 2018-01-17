package com.joshuacotes.guiplotter.plotter;

import java.io.*;
import java.util.List;

/**
 * Created by kelvinzero on 5/25/16.
 */
public class PlotterWIN {

    private String _dataFileName = "plotterdata.gnu";
    private String  _fileOutName = "plot.jpg";
    private String _title = "2D Graph";
    private String _xdata = "time";
    private String[][] _dataSet;

    public PlotterWIN(String[][] plotSet){
        _dataSet = plotSet;
    }

    public void plot(){
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(genScript());
            InputStream stdin = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stdin);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null)
                System.err.println("gnuplot:"+line);
            proc.getInputStream().close();
            proc.getOutputStream().close();
            proc.getErrorStream().close();
        } catch (Exception e) {
            System.err.println("Fail: " + e);
        }
    }


    public String[] genScript(){

        String[] _script = {"gnuplot",
                "--persist", "-e",
                "load 'plotscript.gnu'"
        };

        return _script;
    }

    public void generateDataFiles(String[][] outData) throws IOException{

        final PrintWriter fout = new PrintWriter(new File(_dataFileName));

        for(String[] row : outData){
            fout.write(row[0] + ",");
            fout.write(row[1]);
            fout.write("\n");
        }
        fout.close();
    }

    public void generateDataFiles(List<String[][]> outDataSets) throws IOException{

        PrintWriter fout;
        for(int set = 0; set < outDataSets.size(); set++){

            fout = new PrintWriter(new File(_dataFileName + set));
            String[][] thisSet = outDataSets.get(set);

            for(int setRow = 0; setRow < thisSet.length; setRow++) {

                String[] thisRow = thisSet[setRow];

                fout.write(thisRow[0] + ",");
                fout.write(thisRow[1]);
                fout.write("\n");
            }
            fout.close();
        }
    }

}
