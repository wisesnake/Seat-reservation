package seat_reservation;

import java.util.Scanner;

public class CheckAndCancel extends Main {

	static void checkbookednum(Customer loginCust) {
		Scanner sc = new Scanner(System.in);

		System.out.println("좌석 조회 및 예매취소 페이지 입니다.");
		System.out.println("좌석 조회를 위해 예매 시 지급되었던 일련번호를 입력 부탁드립니다.");

//        예매 조회 및 취소를 위해서 예매시 지급됐던 일련번호 확인
		aa: while (true) {

			System.out.printf("%s 고객님의 예약번호 입력 > ",loginCust.getId());
			int checkbookedCustNo = sc.nextInt();
			sc.nextLine();

//            일련번호 대조하는 반복문
			boolean flag = false;
			for (int i = 1; i < seat.length; i++) {

				if (checkbookedCustNo == seat[i].getBookedCustNo()) {
					System.out.printf("예약번호는 %d이며, 예약하신 좌석은 %d번 좌석입니다.\n", seat[i].getBookedCustNo(),
							seat[i].getSeatNo());
//                    조회 일치 했을 때 좌석 취소 할지 말지 스캐너받음
					while (true) {
						System.out.println("1. 조회하신 좌석의 취소");
						System.out.println("2. 초기화면으로 돌아가기");
						System.out.print("> ");
						int select1 = sc.nextInt();
						sc.nextLine();

//                        취소하겠다고 받으면 여기로옴 
						switch (select1) {

//                        취소 진행 위해서 일련번호 다시 한번 입력 틀리면 다시 돌아옴
						case 1:
							System.out.println("취소 확인을 위하여 비밀번호를 입력 바랍니다.");
							System.out.print("> ");

							int cancelPw = sc.nextInt();
							sc.nextLine();

							if (cancelPw == loginCust.getPwd()) {
								seat[i].setBooked(false);
								System.out.println("취소 되었습니다.");
								break aa;
							} else {
								System.out.println("입력하신 비밀번호가 틀렸습니다. 초기화면으로 돌아갑니다.");
							}
							break;

//                                2번 초기화면으로 돌아감.
						case 2:
							break aa;

						default:
							System.out.println("목록 이외의 번호 입력 재입력 바람");
						}
					}
				}
			}
			if (flag == false) {
				System.out.println("입력하신 일련번호는 없는 것으로 확인됩니다. 확인 후 다시시도 부탁드립니다.");
				break;
			}
		}
	}
}
