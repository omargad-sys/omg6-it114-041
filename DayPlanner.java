public class DayPlanner {
     public static void main(String[] args) {
       int dayOfWeek = 5; // 1 = Mon, 2 = Tue, 3 = Wed...
switch(dayOfWeek) {
    case 2: System.out.println("Study Java");
    case 1:
        System.out.println("Attend Workshop");
        break;
    case 3: System.out.println("Gym Day");
		break;
    default:
        System.out.println("Rest Day");
        break;
}

    }
    
}
