import java.io.File;

public class Empty {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        File baseFile = new File("basedir");
        findEmpty(baseFile, sb);
        System.out.println(sb.toString());
    }

    private static void findEmpty(File file, StringBuilder sb) {
        File[] subFiles = file.listFiles();
        if (subFiles != null) {
            if (subFiles.length == 0) {
                sb.append(file.getName()).append(" ");
            } else {
                for (File subFile : subFiles) {
                    findEmpty(subFile, sb);
                }
            }
        }
    }

}
