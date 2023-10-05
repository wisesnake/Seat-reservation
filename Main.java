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

	

	public static void main(String[] args) {
		MainMethods mM = new MainMethods();
		CheckAndCancel checkAndCancel = new CheckAndCancel();
		BookingMethod bk = new BookingMethod();
		String menuNav = "";

		for (int i = 1; i < seat.length; i++) {
			seat[i] = new Seats(i, 0000); // Ex2 클래스의 인스턴스를 생성하여 배열 요소에 할당
		}

		mM.initSampleSeats();
		System.out.println(" ------------------------------");
		System.out.println("|         그린레일 예약시스템         |");
		System.out.println("|            환영합니다            |");
		System.out.println(" ------------------------------");

		app: while (true) {

			System.out.println(" ------------------ 메뉴 ------------------");
			System.out.println("| 1. 좌석 현황           | 2. 예약             |");
			System.out.println("| 3. 좌석 조회 및 예매 취소 | 4. 종료             |");
			System.out.println(" -----------------------------------------");
			System.out.println();
			System.out.println("원하시는 메뉴의 번호를 입력 바랍니다.");
			System.out.print(">");
			int flag = 0;
			try {
				menuNav = sc.nextLine();
				flag = Integer.parseInt(menuNav);
			} catch (NumberFormatException e) {
				System.err.println("숫자를 입력해 주십시오.");
				continue app;
			}
			switch (flag) {
			case 1:
				mM.printMenuTitle("좌석현황");
				mM.printSeat();
				break;
			case 2:
				mM.printMenuTitle("예약");

				bk.BookSeat(seat);
				break;
			case 3:
				mM.printMenuTitle("3. 좌석 조회 및 예매 취소");
				checkAndCancel.checkbookednum();
				break;
			case 4:
				mM.printMenuTitle("종료합니다.");
				break app;

			default:
				System.out.println("1~5 사이의 숫자를 입력하십시오.");
			}

		}
	}

}