package booktheseat;

import java.util.Scanner;

//Main 클래스
public class Main {
   
   static String[][] seatCells = new String[16][5];
//   8줄, 4칸의 좌석을 가진 기차의 좌석표, 좌석번호와 예약여부를 나타내는 기호를 각각 출력하기 위해
//   16행, 그리고 복도칸을 한칸 비워두고 5열의 문자열 배열을 만들음.
   static Seats seat[] = new Seats[33];
//   총 32개의 좌석 객체 생성, 좌석배열의 인덱스와 실제 좌석번호를 일치시켜 가독성을 높이기 위해
//   0번째 인덱스 배열은 버리고 33개의 배열 생성함.
   static Scanner sc = new Scanner(System.in);
   
   
   
   static void printSeat() {
      int seatIndexNo = 1;
      int seatNoVar = 1;
//      홀수열에서 루프당 1씩 증가하여 좌석번호를 찍기 위한 변수와
//      짝수열에서 좌석객체 하나하나를 참조하기 위한 인덱스 역할을 할 변수 선언
      for (int i = 0; i < seatCells.length; i++) {
         for (int j = 0; j < seatCells[i].length; j++) {
            if (j == 2) {
               System.out.print("   ");
//             가운데 복도 공간
            } else if (i == 0 || i % 2 == 0) {
               System.out.printf("%3d", seatNoVar);
               seatNoVar++;
//             홀수열에서 좌석번호 출력
            } else if (i == 1 || i % 2 == 1 || j != 2) {
               if (seat[seatIndexNo].isBooked()) {
                  System.out.print(" ■■");
               } else {
                  System.out.print(" □□");
               }
               seatIndexNo++;
//             짝수열에서 각 seat객체가 booked boolean 값 리턴 평가하여 예약된 좌석은 색칠된 네모를
//             리턴하여 예약된 좌석 표현.
            }
         }
         System.out.println();
      }
      System.out.println("|빈 좌석 : □□ | \n"
            + "|예약 좌석 : ■■ |");
      System.out.println();
   }
   
   

   static void initSampleSeats() {
      //샘플좌석들. seats클래스의 생성자를 통한초기화임
      seat[5].initSample(5,1001);
      seat[8].initSample(8,1002);
      seat[12].initSample(12,1003);
      seat[19].initSample(19,1004);
      seat[20].initSample(20,1005);
      seat[30].initSample(30,1006);
   }

   
   
   static void printMenuTitle(String title) {
      if (title.equals("종료합니다.")) {
         System.out.println("-----------------------------------------");
         System.out.println("종료합니다.");
         System.out.println("-----------------------------------------");
      } else {
    	  System.out.println("-----------------------------------------");
         System.out.println(title);
         System.out.println("-----------------------------------------");
      }
   }
   

   public static void main(String[] args) {
	  CheckAndCancel checkAndCancel = new CheckAndCancel();
      BookingMethod bk = new BookingMethod();
      String menuNav;

      for (int i = 1; i < seat.length; i++) {
         seat[i] = new Seats(i,0000); // Ex2 클래스의 인스턴스를 생성하여 배열 요소에 할당
      }
      
      
      initSampleSeats();
      System.out.println(" ------------------------------");
      System.out.println("|         그린레일 예약시스템         |");
      System.out.println("|            환영합니다            |");
      System.out.println(" ------------------------------");
      
      app: while (true) {

    	  System.out.println(" ------------------ 메뉴 ------------------");
          System.out.println("| 1. 좌석 현황          | 2. 예약             |");
          System.out.println("| 3. 좌석 조회 및 예매 취소 | 4. 종료             |");
          System.out.println(" -----------------------------------------");
          System.out.println();
          System.out.println("원하시는 메뉴의 번호를 입력 바랍니다.");
          System.out.print(">");
         menuNav = sc.nextLine();
         int flag = Integer.parseInt(menuNav);
         switch (flag) {
         case 1:
            printMenuTitle("좌석현황");
            printSeat();
            break;
         case 2:
            printMenuTitle("예약");
            bk.BookSeat(seat);
            break;
         case 3:
            printMenuTitle("3. 좌석 조회 및 예매 취소");
            checkAndCancel.checkbookednum();
            //cancel();
            break;
         case 4:
            printMenuTitle("종료합니다.");
            break app;

         default:
            System.out.println("1~5 사이의 숫자를 입력하십시오.");
         }

      }
   }

}