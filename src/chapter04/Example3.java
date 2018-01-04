package chapter04;
/*
 * 测试胡定义异常类能否正常使用
 */

public class Example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player() ;
		try {
			player.play(16);
		} catch (NoThisSongException e) {//利用play去测试我们写的NoThisSongException异常类是否能够正常工作
			// TODO: handle exception
			System.out.println("捕获的异常信息为: "+e.getMessage());
		}
	}

}


class NoThisSongException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoThisSongException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoThisSongException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}

class Player{
	
	//构造函数
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	//播放器
	void play(int index) throws NoThisSongException {//表示播放歌曲的索引
		if (index > 10) {
			throw new NoThisSongException("您播放的歌曲不存在"); 
		}
		
		else {
			System.out.println("正在播放歌曲,啦啦啦");
		}
	}
	
}
