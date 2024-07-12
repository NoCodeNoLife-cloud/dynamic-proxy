package code;

public class RealModule implements HttpApi {
	@Override
	public String get(String url) {
		return "result";
	}
}