package seat_reservation;

public class Member extends Main{
	static int custIndex = 0;
	
	static int login() {
		boolean loginFlag = true;
		while (loginFlag) {
			boolean idfound = false;
			//회원찾았는지 여부 판별용
			
			System.out.print("id >");
			String id = sc.nextLine();

			for (int i = 0; i < cust.length; i++) {
				if (id.equals(cust[i].getId())) {
					idfound = true;
					System.out.print("pw >");
					String pw = sc.nextLine();
					int pwd = Integer.parseInt(pw);
					if (pwd == cust[i].getPwd()) {
						System.out.println("로그인 성공!");
						loginFlag = false;
						custIndex = i;
						break;
					} else {
						System.out.println("비밀번호가 일치하지 않습니다!");
						break;
					}
				}
			}
			if (idfound == false) {
				System.out.println("해당하는 회원 id가 존재하지 않습니다.");
			}
			//idfound가 false인경우 출력.
		}
		return custIndex;

	}

	public int signUp() {
		return custIndex;
	}
}
