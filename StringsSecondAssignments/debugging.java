
/**
 * Write a description of debugginf here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class debugging {
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1) {
                break;
            }
            if (index >= input.length() - 3) { break; }
            String found = input.substring(index + 1, index + 4);
            System.out.println(found);
            index = input.indexOf("abc", index + 4);
        }
    }

    public void findAbc2(String input){
        int index = input.indexOf("abc");
        while (true){
            if (index == -1 || index >= input.length() - 3){
                break;
            }
            System.out.println("index " + index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc",index+3);
            System.out.println("index after updating " + index);
        }
    }
 
    public void test(){
        //findAbc("abcd");
        // findAbc2("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
        findAbc2("abcabcabcabca");
    }

    public static void main(String[] args) {
        debugging m = new debugging();
        m.test();
        // index >= 7 - 3 = 4 ✅
        // index >= 7 - 4 = 3 ❎
        // index > 7 - 3 = 4  ❎
        // index > 7 - 4 = 3  ✅
    }
}
