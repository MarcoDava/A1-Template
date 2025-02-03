package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    private String CanonizedPath="";

    public void addPath(String value) {
        CanonizedPath = CanonizedPath + value;
    }

    public void deletePath() {
        if (CanonizedPath != null && CanonizedPath.length() > 0) {
            CanonizedPath = CanonizedPath.substring(0, CanonizedPath.length() - 1);
        }
    }

    public String getCanonizedPath() {
        return CanonizedPath;
    }

    public String getFactorizedPath(){
        String FactorizedPath="";
        String target="";
        int repeats=0;
        for(int i=0;i<CanonizedPath.length();i++){
            if(target.equals(CanonizedPath.substring(i,i+1))){
                repeats++;
            }
            else{
                if(!target.equals("")){
                    FactorizedPath+=repeats+""+target;
                }
                target=CanonizedPath.substring(i,i+1);
                repeats=1;
            }
        }
        FactorizedPath+=repeats+""+target;
        return FactorizedPath;
    }
}