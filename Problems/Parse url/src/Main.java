import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String query = input.split("\\?")[1];
        String[] params = query.split("&");

        String password = "";

        for (String param : params) {
            String[] value = param.split("=");
            System.out.printf("%s : %s\n", value[0],
                    value.length == 2 ? value[1] : "not found");
            if (value[0].equals("pass")) {
                password = value[1];
            }
        }

        if (!"".equals(password)) {
            System.out.println("password : " + password);
        }

    }
}