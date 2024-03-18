package sec2;
// 프로세스 제어 명령
// Thread = 프로세스(process) = 현재 컴퓨터에서 실행 중인 프로그램 작업(프로그램)
// 발생(New) => (실행대기 : Runnable) => cpu점유(실행 : run) =>(sleep) (실행대기 : Runnable) => (기동) => 종료
// 실행 => 실행대기 : sleep
// 실행대기 => 실행 : wake up(run)
public class ThreadExam1 {
	
	public static void firstThread() {
		System.out.println("첫 번째 스레드");
	}
	public static void secondaryThread() {
		for(int i = 0; i <= 10; i++) { // 0~9 카운트 작업 
			System.out.println(i);
			try {
				Thread.sleep(1000); // (쓰레드 1동안 실행 대기) 단위 ms(밀리초) => us(마이크로 초) 
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		/*
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i <= 10; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			*/
		}
	}
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() { // 실행가능한 작업	(객체는 없는 상태), 생성 => Runnable실행대기)

			@Override
			public void run() { //러너블이라고 하는 인터페이스를 활용하여 run 익명의 메서드(실행대기 -> 실행) 이용.
				firstThread();
			}
		});  // 쓰레드(실행 가능한 작업)
		
		thread1.run();
		thread1.start(); // 인터페이스에 있는 익명의 작업.
		System.out.println(thread1.getName());
		//쓰레드는 해당 작업이 완료되면 자동적으로 끝난다.
		// 쓰레드가 나오는 순서 : 미리 준비하고 있다가 1. run메서드를 실행하고 2. 이름을 불러왔다가 3. start인터페이스 작업 실행
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				secondaryThread();
			}
			
		});
		thread2.start();
		
		
	}
}
