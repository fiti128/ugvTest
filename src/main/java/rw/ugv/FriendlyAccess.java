package rw.ugv;

import java.io.File;

public class FriendlyAccess {
	String friendly = "friendly";
	public static void main(String[] args) {
		File file = new File("zasranec.jpg");
		System.out.println(file.isFile());
	}
}
