package emailapp;

public class EmailApp {

	public static void main(String[] args) {
		Email em1=new Email("Uzma","Sulthana");
		/*em1.setAlternateEmail("js@gmail.com");
		System.out.println(em1.getAlternateEmail());*/
		String info=em1.showInfo();
		System.out.println(info);
	}

}
