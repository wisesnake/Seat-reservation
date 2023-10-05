package booktheseat;

public class MainMethods extends Main{
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
		System.out.println("|빈 좌석 : □□ | \n" + "|예약 좌석 : ■■ |");
		System.out.println("메뉴로 돌아가시려면 엔터를 입력해 주십시오.");
		String fake = sc.nextLine();
		System.out.println();
	}

	static void initSampleSeats() {
		// 샘플좌석들. seats클래스의 생성자를 통한초기화임
		seat[5].initSample(5, 1001);
		seat[8].initSample(8, 1002);
		seat[12].initSample(12, 1003);
		seat[19].initSample(19, 1004);
		seat[20].initSample(20, 1005);
		seat[30].initSample(30, 1006);
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
}
