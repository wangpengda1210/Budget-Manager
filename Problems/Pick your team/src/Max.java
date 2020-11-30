import java.io.File;

public class Max {

    static String maxFile = "";
    static int max = 0;

    public static void main(String[] args) {
        File baseFile = new File("basedir");
        File[] subFiles = baseFile.listFiles();
        for (File subFile : subFiles) {
            File[] subsub = subFile.listFiles();
            if (subsub != null) {
                if (subsub.length > max) {
                    max = subsub.length;
                    maxFile = subFile.getName();
                }
            }
        }
        System.out.println(maxFile + " " + max);
    }

}
