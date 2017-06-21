import java.io.IOException;

public class TestExec {
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		rt.exec("notepad.exe");
	}

}
