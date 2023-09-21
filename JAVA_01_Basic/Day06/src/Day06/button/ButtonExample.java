package Day06.button;

public class ButtonExample {

	public static void main(String[] args) {
		
		//	버튼 객체 생성
		Button btnOk = new Button();
		
		class OkListener implements Button.ClickListener{

			@Override
			public void onClick() {
				System.out.println("ok 버튼을 클릭했습니다.");
				
			}
			
		}
		
		btnOk.setClickListener(new OkListener());	//	익명개체
	
		btnOk.click();
		
		Button cancel = new Button();
		
		
		class CancelListener implements Button.ClickListener{
			
			@Override
			public void onClick() {
				System.out.println("cancel 버튼을 클릭했습니다.");
				
			}
			
		}
		
		cancel.setClickListener(new CancelListener());
		
		cancel.click();
		

	}

}
