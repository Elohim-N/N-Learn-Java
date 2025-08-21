public abstract class User{
	private String name;
	private int id;
	public int password;
	private double balance;
	private static int commonId = 10000;
	public User(String name, int password, double balance){
		this.name = name;
		this.password = password;
		this.balance = balance;
		commonId ++;
		this.id = commonId;
	}
	public abstract String getType();
	public String getName(){
		return this.name;
	}
	public int getId(){
		return this.id;
	}
	public void saveMoney(double add_money){
		balance += add_money;
		System.out.println("存款成功,您已成功存款" + add_money + "元");
	}
	public void takeMoney(double minus_money){
		if(minus_money > balance){
			System.out.println("抱歉，您的余额不足,取款失败，请重新选择服务");
		}
		else{
			balance -= minus_money;
			System.out.println("取款成功，您已取出" + minus_money + "元");
		}
	}
	public void service(){
			System.out.println("账户名：" + name);
			System.out.println("账户ID：" + id);
			System.out.println("账户余额：" + balance);
		}
}