public class EmergencyExit {
    public static void main(String[] args) {

        int dynamicValue = 10;
        while (dynamicValue > 0) {
            System.out.println(dynamicValue);
            dynamicValue--;
            if (dynamicValue < 5) {
                break;
            }

        }
    }
}
