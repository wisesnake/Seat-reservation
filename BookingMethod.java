package booktheseat;

import java.util.Random;
import java.util.Scanner;

public class BookingMethod extends Main{

   Scanner sc = new Scanner(System.in);
   Random random = new Random(); // 일련번호 랜덤 4자리 뽑기 위해 Random 클래스 선언

   void BookSeat(Seats[] seat) {
         System.out.println("몇번 좌석을 예약하시고 싶으십니까?");
         int i = sc.nextInt();
         if (seat[i].isBooked() == false) { // 빈 좌석인지 if문으로 판별.

            System.out.println("예약 가능한 좌석입니다.\n");
            // 예약자 정보 입력
            while (true) { // 전화번호를 양식에 맞게 적었는지 판별 및, 잘못 적었을 시 재입력 하도록 반복함.
//               System.out.print("전화번호 마지막 4자리: ");
               String phone = sc.nextLine();
               if(phone.length() == 4) {
                  break;
               } else {
                  System.out.println("전화번호 4자리를 입력하십시오");
               }
            }

//               예약 확인 및 일련번호 출력
            System.out.printf("\n%d번 좌석을 예약했습니다.\n", seat[i].getSeatNo());
            seat[i].setBooked(true);
//               아래는 랜덤으로 생성된 일련번호가 중복인지 아닌지 체크 후에 출력되도록 하는 코드.
            boolean run = true;
            while (run) {
               int custNo = random.nextInt(10000); // 4자리수 랜덤 일련번호 생성 및 대입
                  // 선택된 호차 안의 seat 배열을 모두 돌면서 생성된 일련번호가 중복인지 체크함.
                  if (seat[i].getBookedCustNo() == custNo) {
//                        중복일 시 break를 통해 while 문으로 돌아가 일련번호를 재생성한다.
                     break;
                  } else {
//                        중복이 아닐시 예약하려던 좌석의 일련번호를 설정 후 출력한다.
                     seat[i].setBookedCustNo(custNo);
                     run = false;
                     break;
                  }
               

            }
            System.out.printf("일련번호: %04d\n\n", seat[i].getBookedCustNo());
         } else {
            System.out.println("이미 예약된 좌석입니다.\n");
         }

   }
}