public class _4_bitManipulation {
    static String convertToBinary(int num){
        StringBuilder ans=new StringBuilder();
        while(num>0){
            if(num%2==1)ans.append(1);
            else ans.append(0);
            num=num/2;
        }
        return ans.reverse().toString();
    }

    static void bitManipulation(int num, int i) {
        // code here
        StringBuilder binaryChar = new StringBuilder(convertToBinary(num));
        int len = binaryChar.length();
        if (binaryChar.charAt((len + 1) - i) == '0') { //settting bit
            binaryChar.setCharAt((len + 1) - i, '1');
        }
    }
}
