public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String str = "Hello";
        StringBuilder result = new StringBuilder();
        for (int i=str.length()-1; i>=0; i--){
            System.out.println(i);
            result.append(str.charAt(i));
        }
        System.out.println(result);
    }
}