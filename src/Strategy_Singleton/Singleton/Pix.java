package Strategy_Singleton.Singleton;

public final class Pix {

	private static Pix instance;
	private final String KEY = "48.458.121/0001-08";
	
    private Pix() {
    	super();
    }

    public static Pix getInstance() {
        if (instance == null) {
            instance = new Pix();
        }
        return instance;
    }

	public String getKEY() {
		return KEY;
	}
    
}
