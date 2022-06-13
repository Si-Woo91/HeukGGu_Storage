package parking_lot;

/*				시간지나면 견인하조
		김시우, 문기연, 박종휘, 김강영, 박지윤
*/

import java.util.Scanner;
import java.util.regex.Pattern;

public class Payment{
   ParkingDTO dto = new ParkingDTO();
   DAO dao = new DAO();
   
   // 결제창
   // 일회권이라면 DB에서 입차시간 출차시간 받아와서 계산 필요
   
   // 정기권 메소드
   public void payment() throws AuthenException{
      Scanner sc = new Scanner(System.in);
      // 정기권이면 1, 일회권이면 2
      if(dto.getWhatDate() == 1) {
         dto.setAmount(200000);
      } else {
    	  dto.setAmount(5000);
     	 int a = (int)(dto.getMin()-30);
     	 if(a<0) {
     		 dto.setAmount(5000);
     	 } else {
     		 dto.setAmount(5000 + a/10*1000);
     	 }
     	 System.out.println(dto.getAmount()+"원");
      }
         
      // 경차일 경우 10%할인 혜택 적용
      if(dao.ent_carKinds().containsValue("경차")||dao.ent_carKinds().containsValue("1")||dto.getCarKinds().contains("경차")||dto.getCarKinds().contains("1")) {
         System.out.println("경차 할인 혜택(10%)이 적용됩니다.");
         dto.setAmount(dto.getAmount() - dto.getAmount()/10);
      }
      
      // 일반일 경우 if문에 포함되지 않고 바로 sysout 출력 
      System.out.println(dto.getAmount() + "원 입니다. 결제 방법을 선택해주세요.");
      System.out.println("1. 카드결제   2. 현금결제");
      boolean flag = true;
      while(flag) {
         try {
            String choice = sc.next();
            
            switch(Integer.parseInt(choice)) {
            case 1 : 
               System.out.println("카드를 꽂아주세요.(카드입력)");
               dto.setPayment(sc.next());
               if(dto.getPayment().equals("카드")) {
                  System.out.println("감사합니다. 결제 완료되었습니다.");
                  flag = false;
                  break;
               } else {
                  System.out.println("카드가 올바르지 않습니다. 다시 입력해주세요.");
                  continue;
               }
            case 2 :
               System.out.println("현금을 넣어주세요.(넣을 만큼 금액 입력. 최소단위 천원)");
               while(flag) {
                  // 현금 입력받아서 숫자가 맞는지 정규표현식으로 검사
                  String check = sc.next();
                  boolean ispay = Pattern.matches("(\\d{4,})", check);
                  if(ispay) {
                     // 기존에 입력받은 금액이 있다면 기존 금액에 새로 입력받은 금액을 더해준다.
                     if(dto.getPayment() != null) {
                        dto.setPayment(String.valueOf(Integer.parseInt(dto.getPayment())+Integer.parseInt(check)));
                     } else {
                        dto.setPayment(check);
                     }
                  } else {
                     System.out.println("잘못 입력하셨습니다. 올바른 금액을 입력해주세요.");
                     continue;
                  }
                  
                  System.out.println(dto.getPayment() + "원 받았습니다.");
               // 거스름돈 계산
                  int change = Integer.parseInt(dto.getPayment()) - dto.getAmount();
                  int change_count = 0;
                  int [] money = {10000, 5000, 1000, 500, 100};
                  if(dto.getAmount() == Integer.parseInt(dto.getPayment())) {
                     System.out.println("거스름돈이 없습니다. 감사합니다.");
                     flag = false;
                     break;
                  } else if(dto.getAmount() > Integer.parseInt(dto.getPayment())) {
                     System.out.println("금액이 부족합니다. 돈을 더 넣어주세요.");
                     continue;
                  } else {
                     System.out.print("거스름돈 : ");
                     for(int i = 0; i<money.length; i++){
                        change_count = change / money[i];
                        System.out.print(money[i] + "원 : " + change_count + "개\t");
                        change = change % money[i];
                     }
                     System.out.println("감사합니다.");
                     flag = false;
                     break;
                  }
               }
            }
         } catch (NumberFormatException e) {
            System.out.println("올바른 번호를 입력해주세요.");
            continue;
         } catch (Exception e) {
            System.out.println("[ERROR]알 수 없는 에러가 발생했습니다. 관리자에게 문의해주세요.");
            e.printStackTrace();
         }
      }
   }
}